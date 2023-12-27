package br.com.attornatus.pessoaendereco.endereco.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.attornatus.pessoaendereco.endereco.application.api.EnderecoAlteracaoStatusRequest;
import br.com.attornatus.pessoaendereco.endereco.application.api.EnderecoRequest;
import br.com.attornatus.pessoaendereco.endereco.application.service.EnderecoRepository;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Endereco {
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "idEndereco", updatable = false, unique = true, nullable = false)
	@JsonIgnore
	private UUID idEndereco;
	@NotNull
	@Column(columnDefinition = "uuid", name = "idPessoaResidente", nullable = false)
	@JsonIgnore
	private UUID idPessoaResidente;
	@Column(columnDefinition = "uuid", name = "idPessoaBuscaEnderecoPrincipal")
	@JsonIgnore
	private UUID idPessoaBuscaEnderecoPrincipal;
	@NotBlank
	private String logradouro;
	@NotBlank
	private String cep;
	@NotBlank
	private String numero;
	@NotBlank
	private String cidade;
	@Enumerated(EnumType.STRING)
	private StatusResidencia statusResidencia;
	@JsonIgnore
	private LocalDateTime dataHoraCadastro;
	@JsonIgnore
	private LocalDateTime dataHoraDaUltimaAlteracao;

	public Endereco(UUID idPessoa, @Valid EnderecoRequest enderecoRequest) {
		this.idPessoaResidente = idPessoa;
		this.logradouro = enderecoRequest.getLogradouro();
		this.cep = enderecoRequest.getCep();
		this.numero = enderecoRequest.getNumero();
		this.cidade = enderecoRequest.getCidade();
//		this.statusResidencia = defineStatusResidencia();
		this.dataHoraCadastro = LocalDateTime.now();
		this.idPessoaBuscaEnderecoPrincipal = idPessoa;
	}
	
	public void altera(EnderecoAlteracaoStatusRequest enderecoAlteracaoStatusRequest) {
		this.statusResidencia = enderecoAlteracaoStatusRequest.getStatusResidencia();
		this.dataHoraDaUltimaAlteracao = LocalDateTime.now();
	}
	
	public Endereco salvarEndereco(Endereco endereco) {
        if (endereco.getStatusResidencia() == StatusResidencia.PRINCIPAL) {
            desmarcarEnderecosPrincipais(endereco);
        }
        return enderecoRepository.salvaEndereco(endereco);
    }
	
    private void desmarcarEnderecosPrincipais(Endereco endereco) {
        enderecoRepository
            .findAllByPessoaIdAndStatusResidenciaAndIdNot(
                endereco.getIdPessoaResidente(),
                StatusResidencia.PRINCIPAL,
                endereco.getId()
            )
            .forEach(e -> e.setStatusResidencia(StatusResidencia.SECUNDARIO));
    }

}
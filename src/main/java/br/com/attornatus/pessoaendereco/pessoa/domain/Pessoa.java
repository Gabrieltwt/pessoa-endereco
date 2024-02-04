package br.com.attornatus.pessoaendereco.pessoa.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.attornatus.pessoaendereco.endereco.domain.Endereco;
import br.com.attornatus.pessoaendereco.endereco.domain.StatusResidencia;
import br.com.attornatus.pessoaendereco.pessoa.application.api.request.CriaPessoaRequest;
import br.com.attornatus.pessoaendereco.pessoa.application.api.request.PessoaAlteracaoRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
@Builder
@Setter
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "idPessoa", updatable = false, unique = true, nullable = false)
	private UUID idPessoa;
	@NotBlank
	private String nomeCompleto;
	@NotNull
	private LocalDate dataNascimento;
	@NotNull
	private Boolean aceitaTermos;
	@OneToMany(mappedBy = "pessoa", cascade = {CascadeType.ALL})
	private List<Endereco> enderecos;

	private LocalDateTime dataHoraCadastro;
	private LocalDateTime dataHoraDaUltimaAlteracao;

	public Pessoa(CriaPessoaRequest pessoaRequest) {
		this.nomeCompleto = pessoaRequest.getNomeCompleto();
		this.dataNascimento = pessoaRequest.getDataNascimento();
		this.aceitaTermos = pessoaRequest.getAceitaTermos();
		this.dataHoraCadastro = LocalDateTime.now();
		//Crio endereco
		Endereco novoEndereco = new Endereco(pessoaRequest.getEndereco());
		//Marco como Principal
		novoEndereco.setStatusResidencia(StatusResidencia.PRINCIPAL);
		//Crio um alista vazia
		this.enderecos = new ArrayList<>();
		//Adiciono na lista de enderecos 
		this.enderecos.add(novoEndereco);
		
	}

	public void altera(PessoaAlteracaoRequest pessoaAlteracaoRequest) {
		this.nomeCompleto = pessoaAlteracaoRequest.getNomeCompleto();
		this.dataNascimento = pessoaAlteracaoRequest.getDataNascimento();
		this.aceitaTermos = pessoaAlteracaoRequest.getAceitaTermos();
		this.dataHoraDaUltimaAlteracao = LocalDateTime.now();
	}
}
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.attornatus.pessoaendereco.endereco.application.api.EnderecoAlteracaoStatusRequest;
import br.com.attornatus.pessoaendereco.endereco.application.api.EnderecoRequest;
import br.com.attornatus.pessoaendereco.endereco.application.service.EnderecoRepository;
import br.com.attornatus.pessoaendereco.pessoa.domain.Pessoa;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
public class Endereco {
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "idEndereco", updatable = false, unique = true, nullable = false)
	@JsonIgnore
	private UUID idEndereco;
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
	
	@ManyToOne
	@JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa")
	private Pessoa pessoa;

	public Endereco(@Valid EnderecoRequest enderecoRequest) {
		this.logradouro = enderecoRequest.getLogradouro();
		this.cep = enderecoRequest.getCep();
		this.numero = enderecoRequest.getNumero();
		this.cidade = enderecoRequest.getCidade();
//		this.statusResidencia = defineStatusResidencia();
		this.dataHoraCadastro = LocalDateTime.now();
	}
	
	public void altera(EnderecoAlteracaoStatusRequest enderecoAlteracaoStatusRequest) {
		this.statusResidencia = enderecoAlteracaoStatusRequest.getStatusResidencia();
		this.dataHoraDaUltimaAlteracao = LocalDateTime.now();
	}
}
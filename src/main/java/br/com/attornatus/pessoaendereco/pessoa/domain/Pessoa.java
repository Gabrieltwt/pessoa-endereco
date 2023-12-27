package br.com.attornatus.pessoaendereco.pessoa.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaAlteracaoRequest;
import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaRequest;
import lombok.*;

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

	private LocalDateTime dataHoraCadastro;
	private LocalDateTime dataHoraDaUltimaAlteracao;

	public Pessoa(PessoaRequest pessoaRequest) {
		this.nomeCompleto = pessoaRequest.getNomeCompleto();
		this.dataNascimento = pessoaRequest.getDataNascimento();
		this.aceitaTermos = pessoaRequest.getAceitaTermos();
		this.dataHoraCadastro = LocalDateTime.now();
	}

	public void altera(PessoaAlteracaoRequest pessoaAlteracaoRequest) {
		this.nomeCompleto = pessoaAlteracaoRequest.getNomeCompleto();
		this.dataNascimento = pessoaAlteracaoRequest.getDataNascimento();
		this.aceitaTermos = pessoaAlteracaoRequest.getAceitaTermos();
		this.dataHoraDaUltimaAlteracao = LocalDateTime.now();
	}
}
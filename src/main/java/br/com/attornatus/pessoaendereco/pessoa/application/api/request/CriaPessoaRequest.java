package br.com.attornatus.pessoaendereco.pessoa.application.api.request;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.attornatus.pessoaendereco.endereco.application.api.EnderecoRequest;
import lombok.Value;

@Value
public class CriaPessoaRequest {
	@NotBlank
	private String nomeCompleto;
	@NotNull
	private LocalDate dataNascimento;
	@NotNull
	private Boolean aceitaTermos;
	@NotNull
	private EnderecoRequest endereco;
}

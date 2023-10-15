package br.com.attornatus.pessoaendereco.pessoa.application.api;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import lombok.Value;

@Value
public class PessoaRequest {
	private String nome;
	@NotNull
	private LocalDate dataNascimento;
	@NotNull
	private Boolean aceitaTermos;
}

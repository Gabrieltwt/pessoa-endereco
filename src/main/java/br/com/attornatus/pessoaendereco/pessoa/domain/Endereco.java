package br.com.attornatus.pessoaendereco.pessoa.domain;

import jakarta.validation.constraints.NotBlank;

public class Endereco {
	@NotBlank
	private String cep;
	@NotBlank
	private String logradouro;
	@NotBlank
	private String numero;
	@NotBlank
	private String cidade;

}

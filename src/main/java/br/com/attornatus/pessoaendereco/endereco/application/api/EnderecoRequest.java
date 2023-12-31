package br.com.attornatus.pessoaendereco.endereco.application.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.attornatus.pessoaendereco.endereco.domain.StatusResidencia;
import lombok.Value;

@Value
public class EnderecoRequest {
	@NotBlank
	private String logradouro;
	@NotBlank
	private String cep;
	@NotBlank
	private String numero;
	@NotBlank
	private String cidade;
	@NotNull
	private StatusResidencia statusResidencia;
}
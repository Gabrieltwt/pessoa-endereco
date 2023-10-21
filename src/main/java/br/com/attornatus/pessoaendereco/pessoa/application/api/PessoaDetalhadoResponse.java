package br.com.attornatus.pessoaendereco.pessoa.application.api;

import java.time.LocalDateTime;
import java.util.UUID;

public class PessoaDetalhadoResponse {
	private UUID idPessoa;
	private String nomeCompleto;
	private Boolean aceitaTermos;
	private LocalDateTime dataHoraCadastro;
}

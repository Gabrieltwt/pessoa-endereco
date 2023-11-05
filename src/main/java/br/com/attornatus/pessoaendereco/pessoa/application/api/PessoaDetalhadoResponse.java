package br.com.attornatus.pessoaendereco.pessoa.application.api;

import java.time.LocalDateTime;

import br.com.attornatus.pessoaendereco.pessoa.domain.Pessoa;
import lombok.Getter;

@Getter
public class PessoaDetalhadoResponse {
	private String nomeCompleto;
	private Boolean aceitaTermos;
	private LocalDateTime dataHoraCadastro;

	public PessoaDetalhadoResponse(Pessoa pessoa) {
		this.nomeCompleto = pessoa.getNomeCompleto();
		this.aceitaTermos = pessoa.getAceitaTermos();
		this.dataHoraCadastro = pessoa.getDataHoraCadastro();
	}
}

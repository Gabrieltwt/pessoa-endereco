package br.com.attornatus.pessoaendereco.pessoa.application.api;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.attornatus.pessoaendereco.pessoa.domain.Pessoa;
import lombok.Value;

@Value
public class PessoaDetalhadoResponse {
	private UUID idPessoa;
	private String nomeCompleto;
	private Boolean aceitaTermos;
	private LocalDateTime dataHoraCadastro;

	public PessoaDetalhadoResponse(Pessoa pessoa) {
		this.idPessoa = pessoa.getIdPessoa();
		this.nomeCompleto = pessoa.getNomeCompleto();
		this.aceitaTermos = pessoa.getAceitaTermos();
		this.dataHoraCadastro = pessoa.getDataHoraCadastro();
	}
}

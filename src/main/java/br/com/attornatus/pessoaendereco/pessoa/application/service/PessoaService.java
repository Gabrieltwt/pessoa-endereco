package br.com.attornatus.pessoaendereco.pessoa.application.service;

import java.util.List;
import java.util.UUID;

import br.com.attornatus.pessoaendereco.pessoa.application.api.request.PessoaAlteracaoRequest;
import br.com.attornatus.pessoaendereco.pessoa.application.api.request.CriaPessoaRequest;
import br.com.attornatus.pessoaendereco.pessoa.application.api.response.PessoaDetalhadoResponse;
import br.com.attornatus.pessoaendereco.pessoa.application.api.response.PessoaListResponse;
import br.com.attornatus.pessoaendereco.pessoa.application.api.response.PessoaResponse;

public interface PessoaService {
	PessoaResponse criaPessoa(CriaPessoaRequest pessoaRequest);
	List<PessoaListResponse> buscaTodasPessoas();
	void patchAlteraPessoa(UUID idPessoa, PessoaAlteracaoRequest pessoaAlteracaoRequest);
	PessoaDetalhadoResponse buscaPessoaAtravesId(UUID idPessoa);
}
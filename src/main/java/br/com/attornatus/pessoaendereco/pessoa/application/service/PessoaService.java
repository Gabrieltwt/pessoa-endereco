package br.com.attornatus.pessoaendereco.pessoa.application.service;

import java.util.List;
import java.util.UUID;

import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaAlteracaoRequest;
import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaDetalhadoResponse;
import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaListResponse;
import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaRequest;
import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaResponse;

public interface PessoaService {
	PessoaResponse criaPessoa(PessoaRequest pessoaRequest);
	List<PessoaListResponse> buscaTodasPessoas();
//	PessoaDetalhadoResponse buscaPessoaAtravesId(UUID idPessoa);
	void patchAlteraPessoa(UUID idPessoa, PessoaAlteracaoRequest pessoaAlteracaoRequest);
	PessoaDetalhadoResponse buscaPessoaAtravesIdPrincipal(UUID idPessoa);
}
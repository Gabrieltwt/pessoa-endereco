package br.com.attornatus.pessoaendereco.pessoa.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.pessoaendereco.pessoa.application.api.request.PessoaAlteracaoRequest;
import br.com.attornatus.pessoaendereco.pessoa.application.api.request.CriaPessoaRequest;
import br.com.attornatus.pessoaendereco.pessoa.application.api.response.PessoaDetalhadoResponse;
import br.com.attornatus.pessoaendereco.pessoa.application.api.response.PessoaListResponse;
import br.com.attornatus.pessoaendereco.pessoa.application.api.response.PessoaResponse;
import br.com.attornatus.pessoaendereco.pessoa.application.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PessoaController implements PessoaAPI {
	private final PessoaService pessoaService;

	@Override
	public PessoaResponse postPessoa(CriaPessoaRequest pessoaRequest) {
		log.info("[inicia] PessoaController - postPessoa");
		PessoaResponse pessoaCriada = pessoaService.criaPessoa(pessoaRequest);
		log.info("[finaliza] PessoaController - postPessoa");
		return pessoaCriada;
	}

	@Override
	public List<PessoaListResponse> getTodasPessoas() {
		log.info("[inicia] PessoaController - getTodasPessoas");
		List<PessoaListResponse> pessoas = pessoaService.buscaTodasPessoas();
		log.info("[finaliza] PessoaController - getTodasPessoas");
		return pessoas;
	}

	@Override
	public void patchAlteraPessoa(UUID idPessoa, @Valid PessoaAlteracaoRequest pessoaAlteracaoRequest) {
		log.info("[inicia] PessoaController - patchAlteraPessoa");
		log.info("[idPessoa] {}", idPessoa);
		pessoaService.patchAlteraPessoa(idPessoa,pessoaAlteracaoRequest);
		log.info("[finaliza] PessoaController - patchAlteraPessoa");
	}

	@Override
	public PessoaDetalhadoResponse getPessoaAtravesId(UUID idPessoa) {
		log.info("[inicia] PessoaController - getPessoaAtravesId");
		PessoaDetalhadoResponse pessoaDetalhado = pessoaService.buscaPessoaAtravesId(idPessoa);
		log.info("[finaliza] PessoaController - getPessoaAtravesId");
		return pessoaDetalhado;
	}

}

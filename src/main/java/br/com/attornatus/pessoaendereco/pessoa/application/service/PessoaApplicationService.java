package br.com.attornatus.pessoaendereco.pessoa.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.attornatus.pessoaendereco.endereco.application.service.EnderecoRepository;
import br.com.attornatus.pessoaendereco.endereco.domain.Endereco;
import br.com.attornatus.pessoaendereco.endereco.domain.StatusResidencia;
import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaAlteracaoRequest;
import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaDetalhadoResponse;
import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaListResponse;
import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaRequest;
import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaResponse;
import br.com.attornatus.pessoaendereco.pessoa.application.repository.PessoaRepository;
import br.com.attornatus.pessoaendereco.pessoa.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class PessoaApplicationService implements PessoaService {
	private final PessoaRepository pessoaRepository;
	private final EnderecoRepository enderecoRepository;
	
	@Override
	public PessoaResponse criaPessoa(PessoaRequest pessoaRequest) {
		log.info("[inicia] PessoaApplicationService - criaPessoa");
		Pessoa pessoa = pessoaRepository.salva(new Pessoa(pessoaRequest));
		log.info("[finaliza] PessoaApplicationService - criaPessoa");
		return PessoaResponse.builder().idPessoa(pessoa.getIdPessoa()).build();
	}

	@Override
	public List<PessoaListResponse> buscaTodasPessoas() {
		log.info("[inicia] PessoaApplicationService - buscaTodasPessoas");
		List<Pessoa> pessoas = pessoaRepository.buscaTodasPessoas();
		log.info("[finaliza] PessoaApplicationService - buscaTodasPessoas");
		return PessoaListResponse.converte(pessoas);
	}

//	@Override
//	public PessoaDetalhadoResponse buscaPessoaAtravesId(UUID idPessoa) {
//	    log.info("[inicia] PessoaApplicationService - buscaPessoaAtravesId");
//	    Pessoa pessoa = pessoaRepository.buscaPessoaAtravesId(idPessoa);
//	    log.info("[finaliza] PessoaApplicationService - buscaPessoaAtravesId");
//	    return new PessoaDetalhadoResponse(pessoa);
//	}
	
	@Override
	public PessoaDetalhadoResponse buscaPessoaAtravesIdPrincipal(UUID idPessoa) {
		log.info("[inicia] PessoaApplicationService - buscaPessoaAtravesId");
		Pessoa pessoa = pessoaRepository.buscaPessoaAtravesId(idPessoa);
		Endereco enderecoPrincipal = enderecoRepository.buscaEnderecoPrincipal(idPessoa, StatusResidencia.PRINCIPAL);
		log.info("[finaliza] PessoaApplicationService - buscaPessoaAtravesId");
		return new PessoaDetalhadoResponse(pessoa, enderecoPrincipal);
	}

	@Override
	public void patchAlteraPessoa(UUID idPessoa, PessoaAlteracaoRequest pessoaAlteracaoRequest) {
		log.info("[inicia] PessoaApplicationService - patchAlteraPessoa");
		Pessoa pessoa = pessoaRepository.buscaPessoaAtravesId(idPessoa);
		pessoa.altera(pessoaAlteracaoRequest);
		pessoaRepository.salva(pessoa);
		log.info("[inicia] PessoaApplicationService - patchAlteraPessoa");
	}
}

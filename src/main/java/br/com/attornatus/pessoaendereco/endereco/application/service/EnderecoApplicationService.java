package br.com.attornatus.pessoaendereco.endereco.application.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.com.attornatus.pessoaendereco.endereco.application.api.EnderecoAlteracaoStatusRequest;
import br.com.attornatus.pessoaendereco.endereco.application.api.EnderecoPessoaListResponse;
import br.com.attornatus.pessoaendereco.endereco.application.api.EnderecoRequest;
import br.com.attornatus.pessoaendereco.endereco.application.api.EnderecoResponse;
import br.com.attornatus.pessoaendereco.endereco.domain.Endereco;
import br.com.attornatus.pessoaendereco.pessoa.application.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class EnderecoApplicationService implements EnderecoService {
	private final PessoaRepository pessoaRepository;
	private final EnderecoRepository enderecoRepository;

	@Override
	public EnderecoResponse criaEndereco(UUID idPessoa, @Valid EnderecoRequest enderecoRequest) {
		log.info("[inicia] EnderecoApplicationService - criaEndereco");
		pessoaRepository.buscaPessoaAtravesId(idPessoa);
		Endereco endereco = enderecoRepository.salvaEndereco(new Endereco(idPessoa, enderecoRequest));
		log.info("[finaliza] EnderecoApplicationService - criaEndereco");
		return new EnderecoResponse(endereco.getIdEndereco());
	}

	@Override
	public List<EnderecoPessoaListResponse> buscaEnderecosDaPessoaComId(UUID idPessoa) {
		log.info("[inicia] EnderecoApplicationService - buscaEnderecosDaPessoaComId");
		pessoaRepository.buscaPessoaAtravesId(idPessoa);
		List<Endereco> enderecosDaPessoa = enderecoRepository.buscaEnderecosDaPessoaComId(idPessoa);
		log.info("[finaliza] EnderecoApplicationService - buscaEnderecosDaPessoaComId");
		return EnderecoPessoaListResponse.converte(enderecosDaPessoa);
	}

	@Override
	public void alteraEnderecoDaPessoaComId(UUID idPessoa, UUID idEndereco,
			EnderecoAlteracaoStatusRequest enderecoAlteracaoStatusRequest) {
		log.info("[inicia] EnderecoApplicationService - alteraEnderecoDaPessoaComId");
		pessoaRepository.buscaPessoaAtravesId(idPessoa);
		Endereco endereco = enderecoRepository.buscaEnderecoPeloId(idEndereco);
		endereco.altera(enderecoAlteracaoStatusRequest);
		enderecoRepository.salvaEndereco(endereco);
		log.info("[finaliza] EnderecoApplicationService - alteraEnderecoDaPessoaComId");
	}
}

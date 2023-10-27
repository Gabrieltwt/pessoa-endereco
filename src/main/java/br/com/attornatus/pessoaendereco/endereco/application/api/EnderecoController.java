package br.com.attornatus.pessoaendereco.endereco.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.pessoaendereco.endereco.application.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class EnderecoController implements EnderecoAPI {
	private final EnderecoService enderecoService;

	@Override
	public EnderecoResponse postendereco(UUID idPessoa, @Valid EnderecoRequest enderecoRequest) {
		log.info("[inicia] EnderecoController - postendereco");
		log.info("[idPessoa] {}", idPessoa);
		EnderecoResponse endereco = enderecoService.criaEndereco(idPessoa, enderecoRequest);
		log.info("[finaliza] EnderecoController - postendereco");
		return endereco;
	}

	@Override
	public List<EnderecoPessoaListResponse> getEnderecosDaPessoa(UUID idPessoa) {
		log.info("[inicia] EnderecoController - getEnderecosDaPessoa");
		log.info("[idPessoa] {}", idPessoa);
		List<EnderecoPessoaListResponse> enderecosDaPessoa = enderecoService.buscaEnderecosDaPessoaComId(idPessoa);
		log.info("[finaliza] EnderecoController - getEnderecosDaPessoa");
		return enderecosDaPessoa;
	}
}

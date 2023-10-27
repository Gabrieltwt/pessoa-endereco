package br.com.attornatus.pessoaendereco.endereco.application.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import br.com.attornatus.pessoaendereco.endereco.application.api.EnderecoPessoaListResponse;
import br.com.attornatus.pessoaendereco.endereco.application.api.EnderecoRequest;
import br.com.attornatus.pessoaendereco.endereco.application.api.EnderecoResponse;

public interface EnderecoService {
	EnderecoResponse criaEndereco(UUID idPessoa, @Valid EnderecoRequest enderecoRequest);
	List<EnderecoPessoaListResponse> buscaEnderecosDaPessoaComId(UUID idPessoa);

}

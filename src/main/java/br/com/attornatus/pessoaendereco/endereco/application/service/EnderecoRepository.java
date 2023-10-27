package br.com.attornatus.pessoaendereco.endereco.application.service;

import java.util.List;
import java.util.UUID;

import br.com.attornatus.pessoaendereco.endereco.domain.Endereco;

public interface EnderecoRepository {
	Endereco salvaEndereco(Endereco endereco);
	List<Endereco> buscaEnderecosDaPessoaComId(UUID idPessoa);
}

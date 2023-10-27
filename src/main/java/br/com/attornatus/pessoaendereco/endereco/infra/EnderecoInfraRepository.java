package br.com.attornatus.pessoaendereco.endereco.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.attornatus.pessoaendereco.endereco.application.service.EnderecoRepository;
import br.com.attornatus.pessoaendereco.endereco.domain.Endereco;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class EnderecoInfraRepository implements EnderecoRepository {
	private final EnderecoSpringDataJPARepository enderecoSpringDataJPARepository;
	
	@Override
	public Endereco salvaEndereco(Endereco endereco) {
		log.info("[inicia] EnderecoInfraRepository - salvaEndereco");
		enderecoSpringDataJPARepository.save(endereco);
		log.info("[finaliza] EnderecoInfraRepository - salvaEndereco");
		return endereco;
	}

	@Override
	public List<Endereco> buscaEnderecosDaPessoaComId(UUID idPessoa) {
		log.info("[inicia] EnderecoInfraRepository - buscaEnderecosDaPessoaComId");
		log.info("[finaliza] EnderecoInfraRepository - buscaEnderecosDaPessoaComId");
		return null;
	}

}

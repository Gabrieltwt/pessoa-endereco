package br.com.attornatus.pessoaendereco.endereco.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.attornatus.pessoaendereco.endereco.application.service.EnderecoRepository;
import br.com.attornatus.pessoaendereco.endereco.domain.Endereco;
import br.com.attornatus.pessoaendereco.endereco.domain.StatusResidencia;
import br.com.attornatus.pessoaendereco.handler.APIException;
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
		var enderecos = enderecoSpringDataJPARepository.findByIdPessoaResidente(idPessoa);
		log.info("[finaliza] EnderecoInfraRepository - buscaEnderecosDaPessoaComId");
		return enderecos;
	}
	
	@Override
	public Endereco buscaEnderecoPeloId(UUID idEndereco) {
		log.info("[start] EnderecoInfraRepository - buscaEnderecoPeloId");
		var endereco = enderecoSpringDataJPARepository.findById(idEndereco)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Endereço não encontrado para o IdEndereço = " + idEndereco));
		log.info("[finish] EnderecoInfraRepository - buscaEnderecoPeloId");
		return endereco;
	}

	@Override
	public Endereco buscaEnderecoPrincipal(UUID idPessoa, StatusResidencia principal) {
		log.info("[inicia] EnderecoInfraRepository - buscaEnderecoPrincipal");
		var endereco = enderecoSpringDataJPARepository.findByIdPessoaBuscaEnderecoPrincipal(idPessoa);
		log.info("[finaliza] EnderecoInfraRepository - buscaEnderecoPrincipal");
		return endereco;
	}
}

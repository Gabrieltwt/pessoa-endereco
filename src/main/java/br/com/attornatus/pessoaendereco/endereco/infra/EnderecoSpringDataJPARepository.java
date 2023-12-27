package br.com.attornatus.pessoaendereco.endereco.infra;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.attornatus.pessoaendereco.endereco.domain.Endereco;
import br.com.attornatus.pessoaendereco.endereco.domain.StatusResidencia;

public interface EnderecoSpringDataJPARepository extends JpaRepository<Endereco, UUID> {
	List<Endereco> findByIdPessoaResidente(UUID idPessoaResidente);
    Optional<Endereco> findByIdPessoaResidenteAndStatusResidencia(UUID idPessoaResidente, StatusResidencia statusResidencia);
}
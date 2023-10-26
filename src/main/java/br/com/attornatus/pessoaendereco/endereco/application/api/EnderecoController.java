package br.com.attornatus.pessoaendereco.endereco.application.api;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class EnderecoController implements EnderecoAPI {

	@Override
	public EnderecoResponse postendereco(UUID idPessoa, @Valid EnderecoRequest enderecoRequest) {
		log.info("[inicia] EnderecoController - postendereco");
		log.info("[idPessoa] {}", idPessoa);
		log.info("[finaliza] EnderecoController - postendereco");
		return null;
	}
}

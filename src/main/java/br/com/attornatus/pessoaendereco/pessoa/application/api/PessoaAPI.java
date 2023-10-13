package br.com.attornatus.pessoaendereco.pessoa.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/pessoa")
public interface PessoaAPI {
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	PessoaResponse postPessoa(@RequestBody PessoaRequest pessoaRequest);
}

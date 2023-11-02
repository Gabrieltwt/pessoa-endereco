package br.com.attornatus.pessoaendereco.endereco.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/pessoa/{idPessoa}/endereco")
public interface EnderecoAPI {
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	EnderecoResponse postEndereco(@PathVariable UUID idPessoa, @Valid @RequestBody EnderecoRequest enderecoRequest);

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<EnderecoPessoaListResponse> getEnderecosDaPessoa(@PathVariable UUID idPessoa);

	@PatchMapping(value = "/{idEndereco}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void patchStatusResidencia(@PathVariable UUID idPessoa, @PathVariable UUID idEndereco,
			@Valid @RequestBody EnderecoAlteracaoStatusRequest enderecoAlteracaoStatusRequest);
}

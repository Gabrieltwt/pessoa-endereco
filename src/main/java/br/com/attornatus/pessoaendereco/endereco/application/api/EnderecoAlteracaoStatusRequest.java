package br.com.attornatus.pessoaendereco.endereco.application.api;

import javax.validation.constraints.NotNull;

import br.com.attornatus.pessoaendereco.endereco.domain.StatusResidencia;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnderecoAlteracaoStatusRequest {
	@NotNull
	private StatusResidencia statusResidencia;
}

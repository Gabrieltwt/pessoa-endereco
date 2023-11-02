package br.com.attornatus.pessoaendereco.endereco.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.attornatus.pessoaendereco.endereco.domain.Endereco;
import br.com.attornatus.pessoaendereco.endereco.domain.StatusResidencia;
import lombok.Getter;

@Getter
public class EnderecoPessoaListResponse {
	private UUID idEndereco;
	private String logradouro;
	private String cep;
	private String numero;
	private String cidade;
	private StatusResidencia statusResidencia;

	public static List<EnderecoPessoaListResponse> converte(List<Endereco> enderecosDaPessoa) {
		return enderecosDaPessoa.stream()
				.map(EnderecoPessoaListResponse::new)
				.collect(Collectors.toList());
	}

	public EnderecoPessoaListResponse(Endereco endereco) {
		this.idEndereco = endereco.getIdEndereco();
		this.logradouro = endereco.getLogradouro();
		this.cep = endereco.getCep();
		this.numero = endereco.getNumero();
		this.cidade = endereco.getCidade();
		this.statusResidencia = endereco.getStatusResidencia();
	}
}

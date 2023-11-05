package br.com.attornatus.pessoaendereco.endereco.application.api;

import br.com.attornatus.pessoaendereco.endereco.domain.Endereco;
import br.com.attornatus.pessoaendereco.endereco.domain.StatusResidencia;
import lombok.Getter;

@Getter
public class EnderecoDetalhadoResponse {
	private String logradouro;
    private String cep;
    private String numero;
    private String cidade;
    private StatusResidencia statusResidencia;

    public EnderecoDetalhadoResponse(Endereco endereco) {
    	this.logradouro = endereco.getLogradouro();
    	this.cep = endereco.getCep();
    	this.numero = endereco.getNumero();
    	this.cidade = endereco.getCidade();
    	this.statusResidencia = endereco.getStatusResidencia();
    }
}


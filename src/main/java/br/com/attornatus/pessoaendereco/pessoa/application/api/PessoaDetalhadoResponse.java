package br.com.attornatus.pessoaendereco.pessoa.application.api;

import java.time.LocalDateTime;

import br.com.attornatus.pessoaendereco.endereco.domain.Endereco;
import br.com.attornatus.pessoaendereco.pessoa.domain.Pessoa;
import lombok.Getter;

@Getter
public class PessoaDetalhadoResponse {
    private String nomeCompleto;
    private Boolean aceitaTermos;
    private LocalDateTime dataHoraCadastro;
    private Endereco enderecoPrincipal;

    public PessoaDetalhadoResponse(Pessoa pessoa, Endereco enderecoPrincipal) {
        this.nomeCompleto = pessoa.getNomeCompleto();
        this.aceitaTermos = pessoa.getAceitaTermos();
        this.dataHoraCadastro = pessoa.getDataHoraCadastro();
        this.enderecoPrincipal = enderecoPrincipal;
    }

    public PessoaDetalhadoResponse(Pessoa pessoa) {
        this.nomeCompleto = pessoa.getNomeCompleto();
        this.aceitaTermos = pessoa.getAceitaTermos();
        this.dataHoraCadastro = pessoa.getDataHoraCadastro();
    }
}
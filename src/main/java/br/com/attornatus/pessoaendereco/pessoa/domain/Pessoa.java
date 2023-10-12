package br.com.attornatus.pessoaendereco.pessoa.domain;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "idPessoa", updatable = false, unique = true, nullable = false)
	private UUID idPessoa;
	@NotBlank
	private String nome;
	@NotNull
	private LocalDate dataNascimento;
	@NotBlank
	private Endereco endereco;
	
	public Pessoa(@NotBlank String nome, @NotNull LocalDate dataNascimento, @NotBlank Endereco endereco) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
	}

	
}

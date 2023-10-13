package br.com.attornatus.pessoaendereco.pessoa.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;

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
	@NotNull
	private Boolean aceitaTermos;
	
	private LocalDateTime dataHoraCadastro;
	private LocalDateTime dataHoraUltimaAlteracao;

	public Pessoa(UUID idPessoa, @NotBlank String nome, @NotNull LocalDate dataNascimento,
			@NotNull Boolean aceitaTermos) {
		this.idPessoa = UUID.randomUUID();
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.aceitaTermos = aceitaTermos;
		this.dataHoraCadastro = LocalDateTime.now();
	}
	
	
}

//package br.com.attornatus.pessoaendereco.pessoa.domain;
//
//import java.util.UUID;
//
//import org.springframework.data.annotation.Id;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.validation.constraints.NotBlank;
//import lombok.AccessLevel;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//@NoArgsConstructor(access = AccessLevel.PRIVATE)
//@Getter
//@Entity
//public class Pessoa {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(columnDefinition = "uuid", name = "idCliente", updatable = false, unique = true, nullable = false)
//	private UUID idCliente;
//	@NotBlank
//	private String nomeCompleto;
//
//}

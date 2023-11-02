package br.com.attornatus.pessoaendereco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class PessoaEnderecoApplication {
	
	@GetMapping
	public String getHomeTeste() {
		return "Pessoa Endereco - API Home";
	}

	public static void main(String[] args) {
		SpringApplication.run(PessoaEnderecoApplication.class, args);
	}

}

package br.com.attornatus.pessoaendereco.pessoa.application.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaRequest;
import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaResponse;
import br.com.attornatus.pessoaendereco.pessoa.application.repository.PessoaRepository;
import br.com.attornatus.pessoaendereco.pessoa.domain.Pessoa;

@ExtendWith(MockitoExtension.class)
class PessoaApplicationServiceTest {

	@InjectMocks
	private PessoaApplicationService pessoaApplicationService;
	
	@Mock
	private PessoaRepository pessoaRepository;
	
	 @BeforeEach
	    public void setUp() {
	        MockitoAnnotations.initMocks(this); // Inicializa os mocks

	        // Configurar o comportamento do repositório de acordo com o cenário de teste
	    }
	
	@Test
    public void testCriaPessoa() {
		// Preparação
	    PessoaRequest request = getPessoaRequest();
	    Pessoa pessoa = new Pessoa(request);
	    pessoa.setIdPessoa(UUID.randomUUID()); // Defina um ID de pessoa válido
	    when(pessoaRepository.salva(any())).thenReturn(pessoa);
        // Execução
        PessoaResponse response = pessoaApplicationService.criaPessoa(request);

        // Verificação
        assertNotNull(response);
        assertEquals(PessoaResponse.class, response.getClass());
        assertNotNull(response.getIdPessoa()); // Certifique-se de que o ID da pessoa não seja nulo
    }
	
	public PessoaRequest getPessoaRequest() {
		PessoaRequest request = new PessoaRequest("Gabriel Cunha", true);
		return request;
	}
}

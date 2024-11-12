package br.com.todolist.projeto;

import br.com.todolist.projeto.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProjetoTodoApplicationTests {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateTodoSucess() {
		var todo1 = new Todo("todo 1", "desc todo 1", false, 1);

		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(todo1)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.lenght()").isEqualTo(1)
				.jsonPath("$[0].nome").isEqualTo(todo1.getNome())
				.jsonPath("$[0].descricao").isEqualTo(todo1.getDescricao())
				.jsonPath("$[0].realizacao").isEqualTo(todo1.isRealizacao())
				.jsonPath("$[0].prioridade").isEqualTo(todo1.getPrioridade());

	}

	@Test
	void testCreateTodoFailure() {
		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(
						new Todo("", "", false, 0))
				.exchange()
				.expectStatus().isBadRequest();
	}
}

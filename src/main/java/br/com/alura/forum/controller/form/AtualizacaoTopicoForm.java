package br.com.alura.forum.controller.form;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.TopicoRepository;

public class AtualizacaoTopicoForm {

	@NotEmpty
	@Size(min = 3, max = 20)
	private String titulo;

	@NotEmpty
	@Size(min = 10)
	private String mensagem;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Topico atualizar(Long id, TopicoRepository topicoRepository) {
		Optional<Topico> optional = topicoRepository.findById(id);
		
		if (optional.isPresent()) {
			var topico = optional.get();
			topico.setTitulo(titulo);
			topico.setMensagem(mensagem);
			return topico;
		}
		
		return null;
	}

}

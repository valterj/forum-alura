package br.com.alura.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.TopicoDomainRepository;

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

	public Topico atualizar(Long id, TopicoDomainRepository topicoRepository) {
		Topico topico = topicoRepository.get(id);
		topico.setTitulo(titulo);
		topico.setMensagem(mensagem);
		return topico;
	}

}

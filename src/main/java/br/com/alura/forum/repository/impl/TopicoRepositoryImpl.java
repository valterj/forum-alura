package br.com.alura.forum.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.exception.TopicoNaoEncontradoException;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.TopicoDomainRepository;

public interface TopicoRepositoryImpl extends TopicoDomainRepository, JpaRepository<Topico, Long> {

	@Override
	default Topico get(Long id) {
		return findById(id).orElseThrow(TopicoNaoEncontradoException::new);
	}
	
}

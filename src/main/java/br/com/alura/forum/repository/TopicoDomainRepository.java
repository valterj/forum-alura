package br.com.alura.forum.repository;

import java.util.List;

import br.com.alura.forum.modelo.Topico;

public interface TopicoDomainRepository {

	List<Topico> findAll();
	
	List<Topico> findByCursoNome(String nomeCurso);

	void save(Topico topico);

	Topico get(Long id);

	void deleteById(Long id);

}

package br.com.alura.forum.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = NOT_FOUND)
public class TopicoNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = -1020320761402971829L;

}

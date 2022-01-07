package br.com.alura.forum.config.validacao;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.alura.forum.exception.EntidadeNaoEncontradaException;

@RestControllerAdvice
public class ErroDeValidacaoHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@ResponseStatus(code = BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroDeFormularioDto> handle(MethodArgumentNotValidException exception) {
		List<ErroDeFormularioDto> erros = new ArrayList<>();
		
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		
		fieldErrors.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErroDeFormularioDto erro = new ErroDeFormularioDto(e.getField(), mensagem);
			erros.add(erro);
		});
			
		return erros;
	}
	
	@ResponseStatus(code = NOT_FOUND)
	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public MensagemSimplificada handle(EntidadeNaoEncontradaException exception) {
		return new MensagemSimplificada("Entidade não encontrada.");
	}
	
	class MensagemSimplificada {
		private String mensagem;

		public MensagemSimplificada(String mensagem) {
			super();
			this.mensagem = mensagem;
		}
		
		public String getMensagem() {
			return this.mensagem;
		}
	}

}

package com.locadora.exception.handler;

import com.locadora.exception.ExceptionResponse;
import com.locadora.exception.RecursoJaExiste;
import com.locadora.exception.RecursoNaoEncontrado;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(RecursoNaoEncontrado.class)
	public ResponseEntity<Object> handleEntidadeNaoEncontrada(RecursoNaoEncontrado ex, WebRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;

		ExceptionResponse response = new ExceptionResponse();
		response.setStatus(status.value());
		response.setMensagem(ex.getMessage());
		response.setDataHora(OffsetDateTime.now());

		return handleExceptionInternal(ex, response, new HttpHeaders(), status, request);
	}

	@ExceptionHandler(RecursoJaExiste.class)
	public ResponseEntity<Object> handleNegocio(RecursoJaExiste ex, WebRequest request) {
		HttpStatus status = HttpStatus.CONFLICT;

		ExceptionResponse response = new ExceptionResponse();
		response.setStatus(status.value());
		response.setMensagem(ex.getMessage());
		response.setDataHora(OffsetDateTime.now());

		return handleExceptionInternal(ex, response, new HttpHeaders(), status, request);
	}

	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		List<ExceptionResponse.Campo> campos = ex.getBindingResult()
				.getAllErrors()
				.stream()
				.map(error -> {
					String nome = ((FieldError) error).getField();
					String mensagem = error.getDefaultMessage();
					ExceptionResponse.Campo campo
							= new ExceptionResponse.Campo();
					campo.setMensagem(mensagem);
					campo.setNome(nome);
					return campo;
				})
				.collect(Collectors.toList());

		ExceptionResponse response = new ExceptionResponse();
		response.setDataHora(OffsetDateTime.now());
		response.setStatus(status.value());
		response.setMensagem("campos invalidos");
		response.setCampos(campos);

		return super.handleExceptionInternal(ex, response, headers, status, request);
	}

}

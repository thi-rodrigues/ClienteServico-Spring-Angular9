package com.br.project.clienteservico.exception;

public class UsuarioCadastradoException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UsuarioCadastradoException(String login) {
		super("Usuario já cadastrado para o login " + login);
	}
}

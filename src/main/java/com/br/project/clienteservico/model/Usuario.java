package com.br.project.clienteservico.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true, name = "login")
	@NotEmpty(message = "{campo.login.obrigatorio}")
	private String username;
	
	@Column(name = "senha")
	@NotEmpty(message = "{campo.senha.obrigatorio}")
	private String password;
}

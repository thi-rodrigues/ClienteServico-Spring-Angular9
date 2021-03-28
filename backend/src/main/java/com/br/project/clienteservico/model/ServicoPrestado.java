package com.br.project.clienteservico.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicoPrestado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 150)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@Column
	private BigDecimal valor;
	
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;

	public ServicoPrestado(ServicoPrestado servicoPrestato) {
	}
	
	public ServicoPrestado(String descricao, Cliente cliente, BigDecimal valor, LocalDate data) {
		this.descricao = descricao;
		this.cliente = cliente;
		this.valor = valor;
		this.data = data;
	}
	
}

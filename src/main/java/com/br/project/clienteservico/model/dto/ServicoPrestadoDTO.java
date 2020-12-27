package com.br.project.clienteservico.model.dto;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import com.br.project.clienteservico.model.ServicoPrestado;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ServicoPrestadoDTO {

	private String descricao;
	private BigDecimal valor;
	private String data;
	private Integer idCliente;
	
	public ServicoPrestadoDTO(ServicoPrestado servicoPrestado) {
		descricao = servicoPrestado.getDescricao();
		valor = servicoPrestado.getValor();
		data = servicoPrestado.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		idCliente = servicoPrestado.getCliente().getId();
	}
	
}

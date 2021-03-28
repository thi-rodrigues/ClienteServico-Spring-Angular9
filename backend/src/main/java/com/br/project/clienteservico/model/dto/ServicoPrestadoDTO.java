package com.br.project.clienteservico.model.dto;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.br.project.clienteservico.model.ServicoPrestado;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ServicoPrestadoDTO {

	@NotEmpty(message = "{campo.descricao.obrigatorio}")
	private String descricao;
	
	@NotNull(message = "{campo.valor.obrigatorio}")
	private BigDecimal valor;
	
	@NotEmpty(message = "{campo.data.obrigatorio}")
	private String data;
	
	@NotNull(message = "{campo.idCliente.obrigatorio}")
	private Integer idCliente;
	
	public ServicoPrestadoDTO(ServicoPrestado servicoPrestado) {
		descricao = servicoPrestado.getDescricao();
		valor = servicoPrestado.getValor();
		data = servicoPrestado.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		idCliente = servicoPrestado.getCliente().getId();
	}
	
}

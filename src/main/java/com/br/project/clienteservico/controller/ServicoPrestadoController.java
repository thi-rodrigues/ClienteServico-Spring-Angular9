package com.br.project.clienteservico.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.br.project.clienteservico.model.Cliente;
import com.br.project.clienteservico.model.ServicoPrestado;
import com.br.project.clienteservico.model.dto.ServicoPrestadoDTO;
import com.br.project.clienteservico.repository.ClienteRepository;
import com.br.project.clienteservico.repository.ServicoPrestadoRepository;

@RestController
@RequestMapping("/servicos-prestados")
public class ServicoPrestadoController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ServicoPrestadoRepository servicoPrestadoRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO dto) {
		LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		Cliente cliente = clienteRepository.findById(dto.getIdCliente())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente inexistente"));
		
		ServicoPrestado servicoPrestado = new ServicoPrestado(dto.getDescricao(), cliente, dto.getValor(), data);
		
		return servicoPrestadoRepository.save(servicoPrestado);
	}
	
	@GetMapping
	public List<ServicoPrestado> pesquisar(@RequestParam(value = "nome", required = false, defaultValue="") String nome,
											@RequestParam(value = "mes", required = false) Integer mes){
		return servicoPrestadoRepository.findByNomeClienteAndMes("%" + nome + "%", mes);
	}
	
}

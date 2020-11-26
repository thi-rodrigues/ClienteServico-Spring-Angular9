package com.br.project.clienteservico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.br.project.clienteservico.model.Cliente;
import com.br.project.clienteservico.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salvar(@RequestBody Cliente cliente) {
		return clienteService.salvar(cliente);
	}
	
	@GetMapping
	public List<Cliente> clientes(){
		return clienteService.buscarClientes();
	}
	
	@GetMapping("/{id}")
	public Cliente buscarPorId(@PathVariable Integer id) {
		return clienteService.buscarPorId(id)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarPorId(@PathVariable Integer id) {
		buscarPorId(id);
		clienteService.deletarPorId(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Cliente atualizar(@PathVariable Integer id, @RequestBody Cliente clienteAtualizado) {
		buscarPorId(id);
		clienteAtualizado.setId(id);
		
		return clienteService.salvar(clienteAtualizado);
	}
	
}

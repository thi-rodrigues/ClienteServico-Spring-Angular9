package com.br.project.clienteservico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.project.clienteservico.model.Cliente;
import com.br.project.clienteservico.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Transactional(readOnly = true)
	public List<Cliente> buscarClientes(){
		return clienteRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Optional<Cliente> buscarPorId(Integer id) {
		return clienteRepository.findById(id);
	}
	
	public void deletarPorId(Integer id) {
		buscarPorId(id);
		clienteRepository.deleteById(id);
	}

	public Cliente atualizar( Integer id, Cliente clienteAtualizado) {
		buscarPorId(id);
		clienteAtualizado.setId(id);
		
		return clienteRepository.save(clienteAtualizado);
	}
}

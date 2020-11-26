package com.br.project.clienteservico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.project.clienteservico.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer>{

}

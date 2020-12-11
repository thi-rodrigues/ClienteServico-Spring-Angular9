import { Injectable } from '@angular/core';
import { Cliente } from './clientes/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  constructor() { }

  getClientes() : Cliente {
    let cliente : Cliente = new Cliente();
    cliente.nome = 'Thiago';
    cliente.cpf = '060.060.773-96';
    return cliente;
  }
}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Cliente } from './clientes/cliente';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  constructor( private http: HttpClient ) { 
  }

  salvar( cliente: Cliente): Observable<Cliente>{
    return this.http.post<Cliente>('http://localhost:8080/clientes', cliente);
  }

  getClientes() : Cliente {
    let cliente : Cliente = new Cliente();
    cliente.nome = 'Thiago';
    cliente.cpf = '123.456.789-10';
    return cliente;
  }
}

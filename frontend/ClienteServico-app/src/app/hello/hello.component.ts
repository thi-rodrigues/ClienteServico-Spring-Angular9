import { Component } from '@angular/core';

@Component({
    selector: 'hello',
    templateUrl: './hello.component.html'
})
export class HelloComponent {

    nome: string;
    clientes: Cliente[];

    constructor(){
        this.nome = 'Thiago';
        let cliente1 = new Cliente('Amália', 22);
        let cliente2 = new Cliente('João A.', 20)
        let cliente3 = new Cliente('Brenda', 27)

        this.clientes = [cliente1, cliente2, cliente3]
    }
}

class Cliente {
    constructor(
        public nome: string,
        public idade: number
    ){}
}
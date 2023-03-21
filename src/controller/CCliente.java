/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Cliente;

/**
 *
 * @author 182010049
 */
public class CCliente {//Vai se controlar toda a classe cliente.
    ArrayList<Cliente> clientes =  new ArrayList<>(); //Criando uma lista cliente da classe cliente.
    int idCliente = 1;//Ao inicializar o projeto já com 1.
    
    /**
     * geraID gerencia a gereção de id's autoincrement para Cliente.
     * @return 
     */
    public int geraID() {//Autoincremetou o id que já está em 1.
        return this.idCliente++;
    }
            
    /**
     * addCliente adiciona um cliente na lista clientes.
     * @param c 
     */
    public void addCliente(Cliente c) {//Método para adicionar cliente 
        this.clientes.add(c);
    }
    
    /**
     * getClientes retorna a lista de clientes.
     * @return 
     */
    public ArrayList<Cliente> getClientes() {//ArrayList tipa (int, string.)
        return this.clientes;//This faz referência a propria classe...
    }
    
    /**
     * removeCliente remove Cliente da lista de clientes.
     * @param c 
     */
    public void removeCliente(Cliente c) {//void uma ação não tem retorno
        this.clientes.remove(c);
    }
    
    /**
     * mockClientes inicializa aplicação com clientes.
     */
    public void mockClientes() {
        Cliente c1 = new Cliente();
        c1.setIdCliente(this.geraID());
        c1.setNomeCliente("Valentina Marques");
        c1.setCpf("96174272060");
        c1.setEndereco("Rua das Oliveiras");
        c1.setTelefone("51993183147");
        this.addCliente(c1);
        
        Cliente c2 = new Cliente();//sem problema de chamar geraID de novo vai somar mais 1 é a função dele.
        c2.setIdCliente(this.geraID());
        c2.setNomeCliente("Miguel Andrade");
        c2.setCpf("83182674005");
        c2.setEndereco("Rua das Flores");
        c2.setTelefone("51985480799");
        this.addCliente(c2);
    }
     /**
      * getClienteCPF pesquisa cliente pelo CPF e retorna o cliente e caso não encontre retorna nulo
      * podendo cadastrar.
      * @param cpf
      * @return 
      */
   public Cliente getClienteCPF(String cpf) { //Método para chamar um Cliente específico.
       Cliente c = null; //Inicializa como nulo.
       for (Cliente cliente : clientes) {
           if(cliente.getCpf().equals(cpf)) {
               c = cliente;
               break;
           }
       }//Percorre a lista de clientes e comparar os valores se o cpf é igual ao que está na lista.
       
       return c;
   }
    
}//fim classe controller

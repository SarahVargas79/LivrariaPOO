
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *Alt + Shift + F (indentação)
 * @author 182010049
 */
public class Cliente {// local onde niguém acessa, por isso private.
    private int idCliente;
    private String nomeCliente;
    private String cpf;
    private String cnpj;
    private String endereco;
    private String telefone;

    /**
     * Alt + Insert
     * Construtor vazio
     */
    public Cliente() {
    }

    public Cliente(int idCliente, String nomeCliente, String cpf, String cnpj, String endereco, String telefone) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    /**
 * Métodos Acessores
 * @return 
 */
    public int getIdCliente() {//get retornando informação, puxa informação do idCliente.
        return idCliente;
    }

    public void setIdCliente(int idCliente) {//set valor no atributo.
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override //subescrevedo o método to.String, método padrão java.
    public String toString() { //para imprimir recupera informações.
        return "\nCliente{" + "idCliente=" + idCliente + ", nomeCliente=" + nomeCliente + ", cpf=" + cpf + ", cnpj=" + cnpj + ", endereco=" + endereco + ", telefone=" + telefone + '}';
    }
    
    
    
}

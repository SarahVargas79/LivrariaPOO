/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;



/**
 *
 * @author 182010049
 */
public class VendaLivro {
    private int idVendaLivro;
    private Cliente idCliente;
    private ArrayList<Livro> livros;
    private float subTotal;
    private LocalDate dataVenda;

    public VendaLivro() {
    }

    public VendaLivro(int idVendaLivro, Cliente idCliente, ArrayList<Livro> livros, float subTotal, LocalDate dataVenda) {
        this.idVendaLivro = idVendaLivro;
        this.idCliente = idCliente;
        this.livros = livros;
        this.subTotal = subTotal;
        this.dataVenda = dataVenda;
    }

    public int getIdVendaLivro() {
        return idVendaLivro;
    }

    public void setIdVendaLivro(int idVendaLivro) {
        this.idVendaLivro = idVendaLivro;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    @Override
    public String toString() {
        return "VendaLivro{" + "idVendaLivro=" + idVendaLivro + ", idCliente=" + idCliente + ", livros=" + livros + ", subTotal=" + subTotal + ", dataVenda=" + dataVenda.format(DateTimeFormatter.ofPattern("d/M/y")) + '}';
    }

    
}

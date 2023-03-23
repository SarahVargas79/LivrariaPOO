/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import livrariapoo.LivrariaPOO;
import model.Livro;
import model.VendaLivro;

/**
 *
 * @author 182010049
 */
public class CVendaLivro {
    ArrayList<VendaLivro> vendaLivros =  new ArrayList<>(); 
    int idVendaLivro = 1;
    
    public int geraID() {
        return this.idVendaLivro++;
    }
            
    
    public void addVendaLivro(VendaLivro vl) {
        this.vendaLivros.add(vl);
    }
    
    public ArrayList<VendaLivro> getVendaLivros() {
        return this.vendaLivros;
    }
    
    public void removeVendaLivros(VendaLivro vl) {//void uma ação não tem retorno
        this.vendaLivros.remove(vl);
    }
    
    public void mockVendaLivros() {
        VendaLivro vl1 = new VendaLivro();
        vl1.setIdVendaLivro(this.geraID());
        vl1.setIdCliente(LivrariaPOO.cadCliente.getClienteCPF("96174272060")); 
        ArrayList<Livro> livros1 = new ArrayList<>();
        livros1.add(LivrariaPOO.cadLivro.getLivroISBN("9788845292613"));
        livros1.add(LivrariaPOO.cadLivro.getLivroISBN("9780316033411"));
        vl1.setLivros(livros1);
        vl1.setSubTotal((float)40.00);
        vl1.setDataVenda(LocalDate.parse("2022-03-13"));
        this.addVendaLivro(vl1);
        
    }
     
}//fim classe controller

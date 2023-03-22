/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.util.ArrayList;
import model.Editora;

/**
 *
 * @author 182010049
 */
public class CEditora {
    ArrayList<Editora> editoras =  new ArrayList<>(); 
    int idEditora = 1;
    
    public int geraID() {
        return this.idEditora++;
    }
            
    
    public void addEditora(Editora e ) {
        this.editoras.add(e);
    }
    
    public ArrayList<Editora> getEditoras() {
        return this.editoras;
    }
    
    public void removeEditoras(Editora e) {//void uma ação não tem retorno
        this.editoras.remove(e);
    }
    
    public void mockEditoras() {
        Editora e1 = new Editora();
        e1.setIdEditora(this.geraID());
        e1.setNomeEditora("Saraiva");
        e1.setCnpj("12345678000100");
        e1.setEndereco("Rua Marechal 215");
        e1.setTelefone("5130632789");
        e1.setGerente("Roberto Santos");
        this.addEditora(e1);
        
        Editora e2 = new Editora();
        e2.setIdEditora(this.geraID());
        e2.setNomeEditora("Companhia da Letras");
        e2.setCnpj("14424678000200");
        e2.setEndereco("Rua das Flores");
        e2.setTelefone("5131258974");
        e2.setGerente("Luís Nunes");
        this.addEditora(e2);
    }
     /**
      * getClienteCNPJ pesquisa editora pelo CNPJ e retorna o cliente e caso não encontre retorna nulo
      * podendo cadastrar.
      * @param cnpj
      * @return 
      */
   public Editora getEditoraCNPJ(String cnpj) { //Método para chamar uma Editora específico.
       Editora e = null; //Inicializa como nulo.
       for (Editora editora : editoras) {
           if(editora.getCnpj().equals(cnpj)) {
               e = editora;
               break;
           }
       }//Percorre a lista de clientes e comparar os valores se o cnpj é igual ao que está na lista.
       
       return e;
   }
}//fim classe controller
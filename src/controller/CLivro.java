/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import livrariapoo.LivrariaPOO;
import model.Livro;

/**
 *
 * @author 182010049
 */
public class CLivro {

    ArrayList<Livro> livros = new ArrayList<>();
    int idLivro = 1;

    public int geraID() {
        return this.idLivro++;
    }

    public void addLivro(Livro li) {
        this.livros.add(li);
    }

    public ArrayList<Livro> getLivros() {
        return this.livros;
    }

    public void removeLivros(Livro li) {//void uma ação não tem retorno
        this.livros.remove(li);
    }

    public void mockLivros() {
       
        Livro li1 = new Livro();
        li1.setIdLivro(this.geraID());
        li1.setTitulo("Senhor do Anéis");
        li1.setAutor("J. R. R. Tolkien");
        li1.setAssunto("Aventura e Fantasia");
        li1.setIsbn("9788845292613");
        li1.setEstoque(8);
        li1.setPreco((float) 36.30);
        li1.setIdEditora(LivrariaPOO.cadEditora.getEditoraCNPJ("11392757000194"));//espera um objeto editora - chamar construtor
        this.addLivro(li1);

        Livro li2 = new Livro();
        li2.setIdLivro(this.geraID());
        li2.setTitulo("Crepúsculo");
        li2.setAutor("Stephenie Meyer");
        li2.setAssunto("Fantasia e Romance");
        li2.setIsbn("9780316033411");
        li2.setEstoque(10);
        li2.setPreco((float) 44.90);
        li2.setIdEditora(LivrariaPOO.cadEditora.getEditoraCNPJ("55264968000117"));
        this.addLivro(li2);
    }

    /**
     * getClienteISBN pesquisa livro pelo ISBN e retorna o livro e caso não
     * encontre retorna nulo podendo cadastrar.
     *
     * @param isbn
     * @return
     */
    public Livro getLivroISBN(String isbn) {
        Livro li = null; //Inicializa como nulo.
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                li = livro;
                break;
            }
        }//Percorre a lista de clientes e comparar os valores se o isbn é igual ao que está na lista.

        return li;
    }

    public boolean atualizaEstoqueLivro(String isbn) {
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                if (livro.getEstoque()>0) {
                    livro.setEstoque(livro.getEstoque()- 1);
                    return true;
                }
                break;
            }
        }
        return false;
    }
}//fim classe controller

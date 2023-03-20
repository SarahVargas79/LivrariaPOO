/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livrariapoo;

import controller.CCliente;
import controller.CEditora;
import controller.CLivro;
import controller.CVendaLivro;
import java.util.Scanner;
import static livrariapoo.LivrariaPOO.leiaNumInt;
import model.Cliente;
import util.Validadores;

/**
 *
 * @author 182010049
 */
public class LivrariaPOO {

    public static CCliente cadCliente = new CCliente();
    public static CEditora cadEditora = new CEditora();
    public static CLivro cadLivro = new CLivro();
    public static CVendaLivro cadVendaLivro = new CVendaLivro();
    public static Scanner leia = new Scanner(System.in);

    public static int leiaNumInt() {//dois scanner para não crachar a aplicação
        Scanner leiaNum = new Scanner(System.in);
        int num = 99; //valor inválido
        try {//try como um "TENTAR EXECUTAR UM TRECHO DE CÓDIGO", se não executar esse trecho vai se para o cath onde as chamadas exceções (erros) são tratadas, se não ele é ignorado.
            return leiaNum.nextInt();
        } catch (Exception e) {//O bloco try diz "que tal código pode gerar exceção(erro)" e o bloco catch faz o "tratamento  para essa exceção(erro)".
            System.out.println("Tente novamente!");
            leiaNumInt();
        }
        return num;
    }

    public static void menuP() {
        System.out.println("\n.:Livraria:.");
        System.out.println("1 - Ger.Clientes");
        System.out.println("2 - Ger.Editoras");
        System.out.println("3 - Ger.Livros");
        System.out.println("4 - Venda Livro");
        System.out.println("0 - sair");
        System.out.println("Escolha uma opção:");
    }

    public static void subMenu(int op) {
        String tpCad = null;
        switch (op) {
            case 1:
                tpCad = "Cliente";
                break;
            case 2:
                tpCad = "Editora";
                break;
            case 3:
                tpCad = "Livro";
                break;
        }
        System.out.println("\nGer." + tpCad + ":.");
        System.out.println("1 - Cadastrar" + tpCad);
        System.out.println("2 - Editar" + tpCad);
        System.out.println("3 - Listar" + tpCad + "s");
        System.out.println("1 - Deletar" + tpCad);
        System.out.println("0 - Voltar");
        System.out.println("Escolha uma opção:");
    }

    public static void cadastrarCliente() {
        int idCliente;
        String nomeCliente;
        String cpf;
        String cnpj = null;
        String endereco;
        String telefone;

        System.out.println("-- Cadastro de Cliente --");
        System.out.print("\nInforme o CPF: ");
        boolean cpfIs;
        int opCPF;
        do {
            cpf = leia.nextLine();
            cpfIs = Validadores.isCPF(cpf);
            if(!cpfIs) {
                System.out.println("CPF inválido, \nDeseja tentar novamente? 1 - Sim | 2 - Não");
                opCPF = leiaNumInt();
                if (opCPF == 1) {
                    System.out.print("\nInforme o CPF: ");
                }else if (opCPF == 2) {
                    System.out.println("\nCadastro cancelado pelo usuário!");
                    break;
               }
            }
        } while (!cpfIs);
        if (cadCliente.getClienteCPF(cpf) != null) {
            System.out.println("Cliente já cadastrado!");
        }else{
            System.out.print("\nInforme o nome: ");
            nomeCliente = leia.nextLine();
            System.out.print("\nInforme o endereço: ");
            endereco = leia.nextLine();
            System.out.print("\nInforme o telefone: ");
            telefone = leia.nextLine();
            idCliente = cadCliente.geraID();
            Cliente cli = new Cliente(idCliente, nomeCliente, cpf, cnpj, endereco, telefone);
            cadCliente.addCliente(cli);
            System.out.println("Cliente cadastrado com sucesso!");
        }
    }//fim cadastrar cliente

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {//A main dispara a chamada.
        // TODO code application logic here

        //CCliente ccli = new CCliente();
        //Chamando mock. 
        cadCliente.mockClientes();
        cadEditora.mockEditoras();
        cadLivro.mockLivros();
        cadVendaLivro.mockVendaLivros();

        int opM;

        do {
            menuP();
            opM = leiaNumInt();
            switch (opM) {
                case 1:
                case 2:
                case 3:

                    int opSM;

                    do {
                        subMenu(opM);
                        opSM = leiaNumInt();
                        switch (opSM) {
                            case 1:
                                System.out.println("\n-- Cadastrar --\n");
                                //usar opM para definir qual cadastro
                                cadastrarCliente();
                                break;
                            case 2:
                                System.out.println("\n-- Editar --\n");
                                break;
                            case 3:
                                System.out.println("\n-- Listar --\n");
                                System.out.println(cadCliente.getClientes().toString());
                                break;
                            case 4:
                                System.out.println("\n-- Deletar --\n");
                                break;
                            case 0:
                                System.out.println("\n-- Menu Principal --");
                                break;
                            default:
                                System.out.println("Opção inválida, tente novamente!");
                                break;
                        }

                    } while (opSM != 0);//subMenu
                    break;
                case 4:
                    System.out.println("-- Venda Livro --");
                    break;
                case 0:
                    System.out.println("Aplicação encerrada pelo usuário!!");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");
                    break;
            }
        } while (opM != 0);//fim sistema

    }

}

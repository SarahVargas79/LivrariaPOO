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
import model.Editora;
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

    public static int leiaNumInt() {//Dois scanner para não crachar a aplicação.
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
        System.out.println("Escolha uma opção: ");
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
        System.out.println("4 - Deletar" + tpCad);
        System.out.println("0 - Voltar");
        System.out.println("Escolha uma opção: ");
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
            if (!cpfIs) {
                System.out.println("CPF inválido, \nDeseja tentar novamente? 1 - Sim | 2 - Não");
                opCPF = leiaNumInt();
                if (opCPF == 1) {
                    System.out.print("\nInforme o CPF: ");
                } else if (opCPF == 2) {
                    System.out.println("\nCadastro cancelado pelo usuário!");
                    break;
                }

            } else if (cadCliente.getClienteCPF(cpf) != null) {
                System.out.println("\nCliente já cadastrado!");
            } else {
                System.out.print("\nInforme o nome: ");
                nomeCliente = leia.nextLine();
                System.out.print("\nInforme o endereço: ");
                endereco = leia.nextLine();
                System.out.print("\nInforme o telefone: ");
                telefone = leia.nextLine();
                idCliente = cadCliente.geraID();
                Cliente cli = new Cliente(idCliente, nomeCliente, cpf, cnpj, endereco, telefone);
                cadCliente.addCliente(cli);
                System.out.println("\nCliente cadastrado com sucesso!");
            }
        } while (!cpfIs);

    }//fim cadastrar cliente

    private static void editarCliente() {
        System.out.println("-- Editar Cliente --");
        System.out.print("\nInforme o CPF: ");
        String cpf = leia.nextLine();
        if (Validadores.isCPF(cpf)) {
            Cliente cli = cadCliente.getClienteCPF(cpf);
            if (cli != null) {
                System.out.println("1 - Nome:\t" + cli.getNomeCliente());
                System.out.println("2 - End.:\t" + cli.getEndereco());
                System.out.println("3 - Fone:\t" + cli.getTelefone());
                System.out.println("4 - Todos os campos acima?");
                System.out.print("Qual campo deseja alterar? \nDigite aqui sua opção: ");
                int opEditar = leiaNumInt();

                if (opEditar == 1 || opEditar == 4) {// "||" pipe significa "ou"
                    System.out.print("\nInforme o nome: ");
                    cli.setNomeCliente(leia.nextLine());
                }
                if (opEditar == 2 || opEditar == 4) {
                    System.out.print("\nInforme o endereço: ");
                    cli.setEndereco(leia.nextLine());
                }
                if (opEditar == 3 || opEditar == 4) {
                    System.out.print("\nInforme o telefone: ");
                    cli.setTelefone(leia.nextLine());
                }
                if (opEditar < 1 || opEditar > 4) {
                    System.out.println("\nOpção inválida");
                }
                /*
                switch (opEditar) {
                    case 1:
                        System.out.print("\nInforme o nome: ");
                        cli.setNomeCliente(leia.nextLine());
                        break;
                    case 2:
                        System.out.print("\nInforme o endereço: ");
                        cli.setEndereco(leia.nextLine());
                        break;
                    case 3:
                        System.out.print("\nInforme o telefone: ");
                        cli.setTelefone(leia.nextLine());
                        break;
                    case 4:
                        System.out.print("\nInforme todos os campos abaixo: ");
                        System.out.print("\nInforme o nome: ");
                        cli.setNomeCliente(leia.nextLine());
                        System.out.print("\nInforme o endereço: ");
                        cli.setEndereco(leia.nextLine());
                        System.out.print("\nInforme o telefone: ");
                        cli.setTelefone(leia.nextLine());
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
                 */
                System.out.println("\nCliente:\n" + cli.toString());
            } else {
                System.out.println("\nCliente não cadastrado!");
            }
        } else {
            System.out.println("\nCPF inválido!");
        }
    }//fim editar cliente

    public static void imprimirListaCliente() {
        System.out.println("-- Lista de Clientes --");
        for (Cliente cli : cadCliente.getClientes()) {
            System.out.println("\n---");
            System.out.println("Nome:\t" + cli.getNomeCliente());//\t faz tabulação
            System.out.println("CPF:\t" + cli.getCpf());
            System.out.println("End.:\t" + cli.getEndereco());
            System.out.println("Fone:\t" + cli.getTelefone());
        }
    }//fim imprimir lista de cliente

    public static void deletarCliente() {
        System.out.println("-- Deletar Cliente --");
        System.out.print("\nInforme o CPF:");
        String cpf = leia.next();
        if (Validadores.isCPF(cpf)) {
            Cliente cli = cadCliente.getClienteCPF(cpf);
            if (cli != null) {
                cadCliente.removeCliente(cli);
                System.out.println("\nCliente deletado com sucesso!");
            } else {
                System.out.println("\nCliente não consta na base de dados!");
            }
        } else {
            System.out.println("\nCPF inválido!");
        }
    }//fim deletar cliente

    public static void cadastrarEditora() {
        int idEditora;
        String nomeEditora;
        String cnpj;
        String endereco;
        String telefone;
        String gerente;

        System.out.println("-- Registrar Editora --");
        System.out.print("\nDigite o CNPJ: ");
        boolean cnpjIs;
        int opCNPJ;
        do {
            cnpj = leia.nextLine();
            cnpjIs = Validadores.isCNPJ(cnpj);
            if (!cnpjIs) {
                System.out.println("CNPJ inválido, \nDeseja tentar novamente? 1 - Sim | 2 - Não");
                opCNPJ = leiaNumInt();
                if (opCNPJ == 1) {
                    System.out.print("\nDigite o CNPJ: ");
                } else if (opCNPJ == 2) {
                    System.out.println("\nRegistro cancelado pelo usuário!");
                    break;
                }
            } else if (cadEditora.getEditoraCNPJ(cnpj) != null) {
                System.out.println("\nEditora já cadastrada!");
            } else {
                System.out.print("\nInforme o nome: ");
                nomeEditora = leia.nextLine();
                System.out.print("\nInforme o endereço: ");
                endereco = leia.nextLine();
                System.out.print("\nInforme o telefone: ");
                telefone = leia.nextLine();
                System.out.print("\nInforme o nome do gerente: ");
                gerente = leia.nextLine();
                idEditora = cadEditora.geraID();
                Editora ed = new Editora(idEditora, nomeEditora, cnpj, endereco, telefone, gerente);
                cadEditora.addEditora(ed);
                System.out.println("\nEditora cadastrada com sucesso!");
            }
        } while (!cnpjIs);

    }//fim cadastro editora

    private static void editarEditora() {
        System.out.println("-- Edição de Editora --");
        System.out.print("\nDigite o CNPJ: ");
        String cnpj = leia.nextLine();
        if (Validadores.isCNPJ(cnpj)) {
            Editora ed = cadEditora.getEditoraCNPJ(cnpj);
            if (ed != null) {
                System.out.println("\n");
                System.out.println("1 - Nome:    \t" + ed.getNomeEditora());
                System.out.println("2 - Endereço:\t" + ed.getEndereco());
                System.out.println("3 - Telefone:\t" + ed.getTelefone());
                System.out.println("4 - Gerente: \t" + ed.getGerente());
                System.out.println("5 - Todos os campos acima? ");
                System.out.println("\nQual campo deseja alterar? \nDigite aqui sua opção:");
                int opEditar = leiaNumInt();
                if (opEditar == 1 || opEditar == 5) {
                    System.out.print("\nInforme o nome: ");
                    ed.setNomeEditora(leia.nextLine());
                }
                if (opEditar == 2 || opEditar == 5) {
                    System.out.print("\nInforme o endereço: ");
                    ed.setEndereco(leia.nextLine());
                }
                if (opEditar == 3 || opEditar == 5) {
                    System.out.print("\nInforme o telefone: ");
                    ed.setTelefone(leia.nextLine());
                }
                if (opEditar == 4 || opEditar == 5) {
                    System.out.print("\nInforme o nome do gerente: ");
                    ed.setGerente(leia.nextLine());
                }
                if (opEditar < 1 || opEditar > 5) {
                    System.out.print("\nOpção inválida\n");
                }

                System.out.println("\nEditora:\n" + ed.toString());
            } else {
                System.out.println("\nEditora não cadastrada!");
            }
        } else {
            System.out.println("\nCNPJ inválido");
        }
    }//fim editar editora

    private static void imprimirListaEditora() {
        System.out.println("-- Lista de Editoras --");
        for (Editora ed : cadEditora.getEditoras()) {
            System.out.println("\n---");
            System.out.println("Nome:    \t" + ed.getNomeEditora());
            System.out.println("CNPJ:    \t" + ed.getCnpj());
            System.out.println("Endereço:\t" + ed.getEndereco());
            System.out.println("Telefone:\t" + ed.getTelefone());
            System.out.println("Gerente: \t" + ed.getGerente());
        }
    }//fim imprimir lista de editora

    private static void deletarEditora() {
        System.out.println("-- Deletar Editora --");
        System.out.print("\nDigite o CNPJ: ");
        String cnpj = leia.next();
        if (Validadores.isCNPJ(cnpj)) {
            Editora ed = cadEditora.getEditoraCNPJ(cnpj);
            if (ed != null) {
                cadEditora.removeEditoras(ed);
                System.out.println("\nEditora deletada com sucesso!");
            } else {
                System.out.println("\nEditora não consta na base de dados!");
            }
        } else {
            System.out.println("\nCNPJ inválido");
        }
    }//fim deletar editora

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
                                if (opM == 1) {
                                    cadastrarCliente();
                                } else if (opM == 2) {
                                    cadastrarEditora();
                                }
                                break;
                            case 2:
                                System.out.println("\n-- Editar --\n");
                                if (opM == 1) {
                                    editarCliente();
                                } else if (opM == 2) {
                                    editarEditora();
                                }
                                break;
                            case 3:
                                System.out.println("\n-- Listar --\n");
                                if (opM == 1) {
                                    imprimirListaCliente();
                                } else if (opM == 2) {
                                    imprimirListaEditora();
                                }
                                break;
                            case 4:
                                System.out.println("\n-- Deletar --\n");
                                if (opM == 1) {
                                    deletarCliente();
                                } else if (opM == 2) {
                                    deletarEditora();
                                }

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

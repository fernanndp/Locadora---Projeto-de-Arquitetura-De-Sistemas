import ClassesAbstratas.Filme;
import ClassesBase.Cliente;
import ClassesControladoras.LocadoraController;

import java.util.Scanner;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        LocadoraController locadoraController = new LocadoraController();
        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar filme");
            System.out.println("2. Cadastrar cliente");
            System.out.println("3. Locar filme");
            System.out.println("4. Devolver filme");
            System.out.println("5. Mostrar filmes cadastrados");
            System.out.println("6. Mostrar clientes cadastrados");
            System.out.println("7. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: // Cadastrar filme
                    System.out.print("Título do filme: ");
                    String tituloFilme = scanner.nextLine();
                    System.out.print("Gênero do filme: ");
                    String generoFilme = scanner.nextLine();
                    System.out.print("Formato do filme (DVD/Blu-ray): ");
                    String formatoFilme = scanner.nextLine();
                    locadoraController.cadastrarFilme(tituloFilme, generoFilme, formatoFilme);
                    break;

                case 2: // Cadastrar cliente
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Documento do cliente: ");
                    String documentoCliente = scanner.nextLine();
                    locadoraController.cadastrarCliente(nomeCliente, documentoCliente);
                    break;

                case 3: // Locar filme
                    System.out.print("Documento do cliente: ");
                    String docClienteLocacao = scanner.nextLine();
                    System.out.print("Título do filme: ");
                    String tituloFilmeLocacao = scanner.nextLine();
                    locadoraController.locarFilme(docClienteLocacao, tituloFilmeLocacao);
                    break;

                case 4: // Devolver filme
                    System.out.print("Documento do cliente: ");
                    String docClienteDevolucao = scanner.nextLine();
                    System.out.print("Título do filme: ");
                    String tituloFilmeDevolucao = scanner.nextLine();
                    locadoraController.devolverFilme(docClienteDevolucao, tituloFilmeDevolucao);
                    break;

                case 5: // Mostrar filmes cadastrados
                    List<Filme> filmes = locadoraController.getFilmeService().getFilmes();
                    System.out.println("Filmes cadastrados:");
                    for (Filme filme : filmes) {
                        System.out.println("Título: " + filme.getTitulo() +
                                ", Gênero: " + filme.getGenero() +
                                ", Formato: " + filme.getFormato() +
                                ", Disponível: " + filme.isDisponivel());
                    }
                    break;

                case 6: // Mostrar clientes cadastrados
                    List<Cliente> clientes = locadoraController.getClienteService().getClientes();
                    System.out.println("Clientes cadastrados:");
                    for (Cliente cliente : clientes) {
                        System.out.println("Nome: " + cliente.getNome() +
                                ", Documento: " + cliente.getDocumento());
                    }
                    break;

                case 7: // Sair
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}

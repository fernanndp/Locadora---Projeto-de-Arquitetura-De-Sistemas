package ClassesControladoras;

import ClasseIndireta.ServicoLocacao;
import ClassesAbstratas.Filme;
import ClassesBase.Cliente;
import ClassesBase.Locacao;
import ClassesFilha.FilmeBluRay;
import ClassesFilha.FilmeDVD;
import ClassesService.ClienteService;
import ClassesService.FilmeService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class LocadoraController {
    private FilmeService filmeService;
    private ClienteService clienteService;
    private List<Locacao> locacoes;
    private ServicoLocacao servicoLocacao;

    public LocadoraController() {
        this.filmeService = new FilmeService();
        this.clienteService = new ClienteService();
        this.locacoes = new ArrayList<>();
        this.servicoLocacao = new ServicoLocacao(this);
    }

    public void cadastrarFilme(String titulo, String genero, String formato) {
        Filme filme = criarFilme(titulo, genero, formato);
        filmeService.adicionarFilme(filme);
    }

    private Filme criarFilme(String titulo, String genero, String formato) {
        if (formato.equalsIgnoreCase("DVD")) {
            return new FilmeDVD(titulo, genero);
        } else if (formato.equalsIgnoreCase("Blu-ray")) {
            return new FilmeBluRay(titulo, genero);
        } else {
            throw new IllegalArgumentException("Formato desconhecido.");
        }
    }

    public void cadastrarCliente(String nome, String documento) {
        Cliente cliente = new Cliente(nome, documento);
        clienteService.adicionarCliente(cliente);
    }

    public void locarFilme(String documentoCliente, String tituloFilme) {
        servicoLocacao.realizarLocacao(documentoCliente, tituloFilme);
    }

    public void devolverFilme(String documentoCliente, String tituloFilme) {
        servicoLocacao.realizarDevolucao(documentoCliente, tituloFilme);
    }

    public void mostrarFilmes() {
        List<Filme> filmes = filmeService.getFilmes();
        System.out.println("Filmes cadastrados:");
        for (Filme filme : filmes) {
            System.out.println("Título: " + filme.getTitulo() +
                    ", Gênero: " + filme.getGenero() +
                    ", Formato: " + filme.getFormato() +
                    ", Disponível: " + filme.isDisponivel());
        }
    }

    public void mostrarClientes() {
        List<Cliente> clientes = clienteService.getClientes();
        System.out.println("Clientes cadastrados:");
        for (Cliente cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome() +
                    ", Documento: " + cliente.getDocumento());
        }
    }

    public List<Locacao> getLocacoes() {
        return locacoes;
    }

    // Métodos de acesso para testes
    public FilmeService getFilmeService() {
        return filmeService;
    }

    public ClienteService getClienteService() {
        return clienteService;
    }
}

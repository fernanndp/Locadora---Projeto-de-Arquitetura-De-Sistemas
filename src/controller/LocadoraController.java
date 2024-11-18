package controller;

import service.LocacaoService;
import model.Filme;
import model.Cliente;
import model.Locacao;
import model.FilmeBluRay;
import model.FilmeDVD;
import service.ClienteService;
import service.FilmeService;

import java.util.ArrayList;
import java.util.List;


public class LocadoraController {
    private FilmeService filmeService;
    private ClienteService clienteService;
    private List<Locacao> locacoes;
    private LocacaoService locacaoService;

    public LocadoraController() {
        this.filmeService = new FilmeService();
        this.clienteService = new ClienteService();
        this.locacoes = new ArrayList<>();
        this.locacaoService = new LocacaoService(this);
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
        locacaoService.realizarLocacao(documentoCliente, tituloFilme);
    }

    public void devolverFilme(String documentoCliente, String tituloFilme) {
        locacaoService.realizarDevolucao(documentoCliente, tituloFilme);
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
    public FilmeService getFilmeService() {
        return filmeService;
    }

    public ClienteService getClienteService() {
        return clienteService;
    }
}

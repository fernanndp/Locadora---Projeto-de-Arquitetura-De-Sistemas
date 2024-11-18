package service;

import model.Filme;
import model.Cliente;
import model.Locacao;
import controller.LocadoraController;

import java.time.LocalDate;

public class LocacaoService {
    private LocadoraController locadoraController;

    public LocacaoService(LocadoraController locadoraController) {
        this.locadoraController = locadoraController;
    }

    public void realizarLocacao(String documentoCliente, String tituloFilme) {
        Cliente cliente = locadoraController.getClienteService().buscarCliente(documentoCliente);
        Filme filme = locadoraController.getFilmeService().buscarFilme(tituloFilme);

        if (cliente != null && filme != null) {
            if (filme.isDisponivel()) {
                Locacao locacao = new Locacao(cliente, filme, LocalDate.now());
                locadoraController.getLocacoes().add(locacao);
                filme.setDisponivel(false);
                System.out.println("Filme '" + tituloFilme + "' locado com sucesso para o cliente '" + cliente.getNome() + "'.");
            } else {
                System.out.println("O filme '" + tituloFilme + "' não está disponível.");
            }
        } else {
            if (cliente == null) {
                System.out.println("Cliente com o documento '" + documentoCliente + "' não encontrado.");
            }
            if (filme == null) {
                System.out.println("Filme com o título '" + tituloFilme + "' não encontrado.");
            }
        }
    }

    public void realizarDevolucao(String documentoCliente, String tituloFilme) {
        Locacao locacao = locadoraController.getLocacoes().stream()
                .filter(l -> l.getCliente().getDocumento().equals(documentoCliente) &&
                        l.getFilme().getTitulo().equals(tituloFilme) &&
                        l.getDataDevolucao() == null)
                .findFirst().orElse(null);

        if (locacao != null) {
            locacao.setDataDevolucao(LocalDate.now());
            locacao.getFilme().setDisponivel(true);
            System.out.println("Filme '" + tituloFilme + "' devolvido com sucesso por '" + locacao.getCliente().getNome() + "'.");
        } else {
            System.out.println("Não foi possível encontrar a locação para o filme '" + tituloFilme + "' e o cliente '" + documentoCliente + "'.");
        }
    }
}

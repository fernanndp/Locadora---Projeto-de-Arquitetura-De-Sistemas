package service;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;


public class ClienteService {
    private List<Cliente> clientes;

    public ClienteService() {
        this.clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarCliente(String documento) {
        return clientes.stream()
                .filter(c -> c.getDocumento().equals(documento))
                .findFirst().orElse(null);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}

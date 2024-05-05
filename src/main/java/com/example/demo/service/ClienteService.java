package com.example.demo.service;

import com.example.demo.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

@Service
public class ClienteService {

    private static Long proximoId = 1L;

    private List<Cliente> clientes = new ArrayList<>();

    //POST CLIENTE
    public Cliente criarCliente(Cliente cliente) {
      for (Cliente c : clientes){
          if (c.getCpf().equals(cliente.getCpf())){
              throw new IllegalArgumentException("Já existe um cliente cadastrado com este CPF.");
          }
      }
        cliente.setId(proximoId++);
        clientes.add(cliente);
      return cliente;
    }

    //GETID CLIENTE

    public Cliente obterClientePorId(Long id) {
        //Regra para verificar o ID do cliente
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    //GETALL CLIENTE

    public List<Cliente> obterTodosClientes(){
        return clientes;
    }

    //PUT CLIENTE

    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                // Atualiza apenas os campos que foram alterados
                if (clienteAtualizado.getNome() != null) {
                    cliente.setNome(clienteAtualizado.getNome());
                }
                if (clienteAtualizado.getCpf() != null) {
                    cliente.setCpf(clienteAtualizado.getCpf());
                }
                if (clienteAtualizado.getTelefone() != null) {
                    cliente.setTelefone(clienteAtualizado.getTelefone());
                }
                if (clienteAtualizado.getSexo() != null) {
                    cliente.setSexo(clienteAtualizado.getSexo());
                }
                if (clienteAtualizado.getEndereco() != null) {
                    cliente.setEndereco(clienteAtualizado.getEndereco());
                }
                return cliente;
            }
        }
        return null;
    }

    //DELETE CLIENTE

    public boolean deletarClientePorId(Long id) {
        Iterator<Cliente> iterator = clientes.iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getId().equals(id)) {
                // Remove o cliente da lista
                iterator.remove();
                // Retorna true se o cliente foi deletado com sucesso
                return true;
            }
        }
        return false;
    }

    //SE APRESENTAR

    public String SeApresentarPorId(Long id) {
        Cliente cliente = obterClientePorId(id);
        if (cliente != null) {
            return "Olá meu nome é: " + cliente.getNome();
        } else {
            return "Cliente não encontrado com o ID: " + id;
        }
    }
}

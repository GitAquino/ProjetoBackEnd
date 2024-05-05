package com.example.demo.service;

import com.example.demo.model.Vendedor;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

@Service
public class VendedorService {

    private static Long proximoId = 1L;
    private List<Vendedor> vendedores = new ArrayList<>();

    //POST Vendedor
    public Vendedor criarVendedor(Vendedor vendedor) {
        for (Vendedor c : vendedores){
            if (c.getCpf().equals(vendedor.getCpf())){
                throw new IllegalArgumentException("Já existe um Vendedor cadastrado com este CPF.");
            }
        }
        vendedor.setId(proximoId++);
        vendedores.add(vendedor);
        return vendedor;
    }

    //GETID Vendedor

    public Vendedor obterVendedorPorId(Long id) {
        //Regra para verificar o ID do Vendedor
        for (Vendedor Vendedor : vendedores) {
            if (Vendedor.getId().equals(id)) {
                return Vendedor;
            }
        }
        return null;
    }

    //GETALL Vendedor

    public List<Vendedor> obterTodosVendedores(){
        return vendedores;
    }

    //PUT Vendedor

    public Vendedor atualizarVendedor(Long id, Vendedor VendedorAtualizado) {
        for (Vendedor Vendedor : vendedores) {
            if (Vendedor.getId().equals(id)) {
                if (VendedorAtualizado.getNome() != null) {
                    Vendedor.setNome(VendedorAtualizado.getNome());
                }
                if (VendedorAtualizado.getCpf() != null) {
                    Vendedor.setCpf(VendedorAtualizado.getCpf());
                }
                if (VendedorAtualizado.getTelefone() != null) {
                    Vendedor.setTelefone(VendedorAtualizado.getTelefone());
                }
                if (VendedorAtualizado.getSexo() != null) {
                    Vendedor.setSexo(VendedorAtualizado.getSexo());
                }
                if (VendedorAtualizado.getEndereco() != null) {
                    Vendedor.setEndereco(VendedorAtualizado.getEndereco());
                }
                return Vendedor;
            }
        }
        return null;
    }

    //DELETE Vendedor

    public boolean deletarVendedorPorId(Long id) {
        Iterator<Vendedor> iterator = vendedores.iterator();
        while (iterator.hasNext()) {
            Vendedor Vendedor = iterator.next();
            if (Vendedor.getId().equals(id)) {
                // Remove o Vendedor da lista
                iterator.remove();
                // Retorna true se o Vendedor foi deletado com sucesso
                return true;
            }
        }
        // Retorna false se o Vendedor não foi encontrado
        return false;
    }

    public String SeApresentarPorId(Long id) {
        Vendedor vendedor = obterVendedorPorId(id);
        if (vendedor != null) {
            return "Olá meu nome é: " + vendedor.getNome();
        } else {
            return "Vendedor não encontrado com o ID: " + id;
        }
    }
}

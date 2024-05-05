package com.example.demo.model;

public class Cliente extends Pessoa {

    private Long id;
    private Endereco endereco;

    public Cliente(String nome, String cpf, String telefone, char sexo, Endereco endereco){
        super (nome, cpf, telefone, sexo);
        if (cpf == null || cpf.length() != 11) {
            throw new IllegalArgumentException("O CPF deve ter exatamente 11 dígitos.");
        }
        if (sexo != 'M' && sexo != 'F') {
            throw new IllegalArgumentException("O sexo deve ser 'M' para masculino ou 'F' para feminino.");
        }
        if (endereco == null || endereco.getRua() == null || endereco.getNumero() == null || endereco.getBairro() == null || endereco.getCidade() == null || endereco.getComplemento() == null) {
            throw new IllegalArgumentException("Todos os atributos do endereço são obrigatórios.");
        }

        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


}

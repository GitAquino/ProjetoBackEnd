package com.example.demo.model;

public class Pessoa {

    //#region Atributos
    private String nome;
    private String cpf;
    private String telefone;
    private char sexo;

    public Pessoa(String nome, String cpf, String telefone, char sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.sexo = sexo;
    }
    //#endregion

    //#region Getters e Setters

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Character getSexo() {
        return sexo;
    }
    public void setSexo(Character sexo) {
        if (sexo != 'M' && sexo != 'F') {
            throw new IllegalArgumentException("O sexo deve ser 'M' para masculino ou 'F' para feminino.");
        }
        this.sexo = sexo;
    }

    //endregion
}

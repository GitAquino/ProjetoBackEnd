package com.example.demo.model;

public class Endereco {

    //#region Atributos
    private Long id;
    private String rua;
    private Long numero;
    private String bairro;
    private String cidade;
    private String complemento;
    //#endregion

    //#region Getters e Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }

    public Long getNumero(){
        return numero;
    }
    public void setNumero(Long numero){
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    //#endregion
}

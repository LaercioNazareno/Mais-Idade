package com.maisIdade.model;

public class Pdf {

    private String link;
    private String nome;
    private String tipo;
    private int id;

    public Pdf(String nome, String tipo, String url ) {
        this.link = url;
        this.nome = nome;
        this.tipo = tipo;
    }

    public Pdf() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString(){
        return getNome();
    }
}

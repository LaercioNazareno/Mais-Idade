package com.maisIdade.model;

public class Video {

    private String nome;
    private String tipo;
    private String url;
    private int id;

    public Video(String nome, String tipo, String url) {
        this.nome = nome;
        this.tipo = tipo;
        this.url = url.split("/")[3];
    }

    public Video() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

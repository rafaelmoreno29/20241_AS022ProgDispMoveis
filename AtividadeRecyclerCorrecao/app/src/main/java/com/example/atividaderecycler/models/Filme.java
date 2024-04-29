package com.example.atividaderecycler.models;

public class Filme {
    private String titulo;
    private String ano;
    private String diretor;
    private int imagem;
    private String sinopse;

    public Filme(String titulo, String ano, String diretor,String sinopse, int imagem) {
        this.titulo = titulo;
        this.ano = ano;
        this.diretor = diretor;
        this.imagem = imagem;
        this.sinopse = sinopse;
    }

    public Filme() {
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}

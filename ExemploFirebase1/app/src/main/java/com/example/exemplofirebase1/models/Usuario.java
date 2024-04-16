package com.example.exemplofirebase1.models;

import java.util.ArrayList;

public class Usuario {
    private String id;
    private String nome;

    private String sobrenome;
    private String foto;
    private int anoNascimento;

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    private static ArrayList<Usuario> usuarios;
    public static ArrayList<Usuario> getUsuarios(){
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("1","José da Silva"));
        usuarios.add(new Usuario("2","Maria das Dores"));
        usuarios.add(new Usuario("3","Gabriel das Botas"));
        return usuarios;
    }

    public Usuario() {
    }

    public Usuario(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

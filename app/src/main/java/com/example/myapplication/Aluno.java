package com.example.myapplication;


public class Aluno {
    private String nome;
    private String cidade;
    private static int pontuacao;
    public Aluno(){

    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
    public static int getPontos(){
        return pontuacao;
    }
    public static void incrementarpontos(int pontos){
        pontuacao+=10;
    }


}

package br.com.nuclea.imdb.pessoa;

public class Diretor {
    private int id;
    private String nome;
    private String estilo;
    private static int contador;

    public Diretor(String nome, String estilo) {
        this.nome = nome;
        this.estilo = estilo;
        this.id = ++contador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEstilo(String estilo){
        this.estilo = estilo;
    }

    public String getEstilo(){
        return this.estilo;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return
                this.id + " | " + this.nome + " | " + this.estilo;
    }
}

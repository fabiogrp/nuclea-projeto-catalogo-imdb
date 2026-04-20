package br.com.nuclea.imdb.filme;

import java.util.ArrayList;
import java.util.List;


public class Filme {

    private String nomeFilme;
    private String descricaoFilme;
    private double orcamentoFilme;
    private String dataLancamento;
    // private Diretor diretorFilme;
    // private List<Ator> atoresFilmeList;

   /* public Filme() {
        this.atoresFilmeList = new ArrayList<>();
    }
*/
    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getDescricaoFilme() {
        return descricaoFilme;
    }

    public void setDescricaoFilme(String descricaoFilme) {
        this.descricaoFilme = descricaoFilme;
    }

    public double getOrcamentoFilme() {
        return orcamentoFilme;
    }

    public void setOrcamentoFilme(double orcamentoFilme) {
        this.orcamentoFilme = orcamentoFilme;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
/*
    public Diretor getDiretorFilme() {
        return diretorFilme;
    }

    public void setDiretorFilme(Diretor diretorFilme) {
        this.diretorFilme = diretorFilme;
    }

    public Ator getAtorFilme() {
        return atorFilme;
    }

    public void setAtorFilme(Ator atorFilme) {
        atoresFilmeList.add(atorFilme);
    }

    public void listaAtoresFilme() {
        for(Ator ator : atoresFilmeList) {
            System.out.println(ator);
        }*/

        @java.lang.Override
        public java.lang.String toString() {
            return "Filme{" +
                    "nomeFilme='" + nomeFilme + '\'' +
                    ", descricaoFilme='" + descricaoFilme + '\'' +
                    ", orcamentoFilme=" + orcamentoFilme +
                    ", dataLancamento='" + dataLancamento + '\'' +
                    ", diretorFilme=" +
                    ", atorFilme=" +
                    '}';
        }
    }
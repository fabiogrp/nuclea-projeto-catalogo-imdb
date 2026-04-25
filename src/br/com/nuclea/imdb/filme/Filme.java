package br.com.nuclea.imdb.filme;

import br.com.nuclea.imdb.pessoa.Diretor;
import br.com.nuclea.imdb.pessoa.Pessoa;

import br.com.nuclea.imdb.pessoa.Ator;
import br.com.nuclea.imdb.service.AtorService;
import br.com.nuclea.imdb.repository.AtorMock;
import java.util.ArrayList;
import java.util.List;


public class Filme {

    private int id;
    private static int contador;
    private String nomeFilme;
    private String descricaoFilme;
    private double orcamentoFilme;
    private String dataLancamento;
    private Diretor diretorFilme;
    private List<Pessoa> atoresFilmeList;


    public Filme(String nomeFilme, String descricaoFilme, double orcamentoFilme, String dataLancamento) {
        this.id = ++contador;
        this.nomeFilme = nomeFilme;
        this.descricaoFilme = descricaoFilme;
        this.orcamentoFilme = orcamentoFilme;
        this.dataLancamento = dataLancamento;
        this.atoresFilmeList = new ArrayList<>();
    }

    public Filme() {
        this.atoresFilmeList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

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

    public String getDiretorFilme() {
        if (diretorFilme == null) {
            return "Não há diretor escalado para esse filme.";
        }

        return diretorFilme.toString();
    }

    public void setDiretorFilme(Diretor diretorFilme) {
        this.diretorFilme = diretorFilme;
        System.out.println("Diretor(a) " + diretorFilme.getNome() + " adicionado ao elenco de " + this.nomeFilme);
    }

    public String getAtores() {
        if (atoresFilmeList == null || atoresFilmeList.isEmpty()) {
            return "Não há atores escalados para esse filme.";
        }

        StringBuilder nomes = new StringBuilder();
        for (int i = 0; i < atoresFilmeList.size(); i++) {
            nomes.append(atoresFilmeList.get(i).getNome());
            if (i < atoresFilmeList.size() - 1) {
                nomes.append(", ");
            }
        }
        return nomes.toString();
    }

    public void setAtorFilme(Ator atorFilme) {
        atoresFilmeList.add(atorFilme);
    }


        @java.lang.Override
        public java.lang.String toString() {
            return "Filme{" +
                    "nomeFilme='" + nomeFilme + '\'' +
                    ", descricaoFilme='" + descricaoFilme + '\'' +
                    ", orcamentoFilme=" + orcamentoFilme +
                    ", dataLancamento='" + dataLancamento + '\'' +
                    ", diretorFilme=" + getDiretorFilme() +
                    ", atorFilme=" + getAtores() +
                    '}';
        }
    }
package br.com.nuclea.imdb.filme;

import br.com.nuclea.imdb.pessoa.Ator;
import br.com.nuclea.imdb.service.AtorService;
import br.com.nuclea.imdb.repository.AtorMock;
import java.util.ArrayList;
import java.util.List;

public class Filme {

    private String nomeFilme;
    private String descricaoFilme;
    private double orcamentoFilme;
    private String dataLancamento;
    // private Diretor diretorFilme;
    private List<Ator> atoresFilmeList;

    public Filme() {
        this.atoresFilmeList = new ArrayList<>();
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
/*
    public Diretor getDiretorFilme() {
        return diretorFilme;
    }

    public void setDiretorFilme(Diretor diretorFilme) {
        this.diretorFilme = diretorFilme;
    }*/

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

    public void adicionarAtor(Ator ator) {
        if (ator != null) {
            this.atoresFilmeList.add(ator);
            System.out.println("Ator " + ator.getNome() + " adicionado ao elenco de " + this.nomeFilme);
        }
    }

        @java.lang.Override
        public java.lang.String toString() {
            return "Filme{" +
                    "nomeFilme='" + nomeFilme + '\'' +
                    ", descricaoFilme='" + descricaoFilme + '\'' +
                    ", orcamentoFilme=" + orcamentoFilme +
                    ", dataLancamento='" + dataLancamento + '\'' +
                    ", diretorFilme=" +
                    ", atorFilme=" + getAtores() +
                    '}';
        }
    }
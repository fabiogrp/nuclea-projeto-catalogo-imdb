package br.com.nuclea.imdb.service;


import br.com.nuclea.imdb.pessoa.Diretor;

import java.util.Scanner;

public class DiretorService {

    public Diretor cadastrarDiretor(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o nome do diretor: ");
        String nomeDiretor = scanner.nextLine();

        System.out.print("Informe o estilo do diretor: ");
        String estiloDiretor = scanner.nextLine();

        //scanner.close();

        return new Diretor(nomeDiretor, estiloDiretor);

        //return novoDiretor;
    }

    public void listarDiretor(){
        if(MenuService.diretorList.size() == 0){
            System.out.println("\nNenhum Diretor cadastrado.\n");
            return;
        }
        System.out.println(" + Lista de Diretores");
        System.out.println("------------------------------");
        for (Diretor diretor : MenuService.diretorList) {
/*            System.out.println(" + Lista de Diretores");
            System.out.println("------------------------------");*/
            System.out.println(diretor.getId() + " | "  + diretor.getNome() + " | " + diretor.getEstilo());
            System.out.println("------------------------------");
        }

    }
}

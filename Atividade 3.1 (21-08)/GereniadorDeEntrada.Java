//esse gerenciador de entrada é uma camada que conversa com o user, e uam tentativa minha de fazer isso ;)

import java.util.InputMismatchException;
import java.util.Scanner;

public class GerenciadorDeEntrada {

    private Scanner sc;

    public GerenciadorDeEntrada(Scanner sc) {
        this.sc = sc;
    }
    public void imprimirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
    public void imprimirMensagemSQuebra(String mensagem) {
        System.out.print(mensagem);
    }
    public String lerLinha(String prompt) {
        imprimirMensagemSQuebra(prompt);
        return sc.nextLine();
    }

    public int lerInteiro(String prompt) {
        int valor = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            imprimirMensagemSQuebra(prompt);
            try {

                valor = sc.nextInt();
                entradaValida = true;

                //esse iput aqui é pra verificar se é numero
            } catch (InputMismatchException e) {

                imprimirMensagem("Entrada inválidaaaa, faz o seguinte digite um número inteiro aí.");
                sc.next();
            }
        }
        return valor;
    }
}

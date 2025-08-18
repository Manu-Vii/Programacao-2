//Atividade 2, 2025-08-18
//Emanuele Vitória de Jesus Lima


import java.util.ArrayList;
import java.util.InputMismatchException; // Importções
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


//Essa aqui é a mais importante, ela valida os dados de entrada e usa as outras classes para resolver o problema
public class Aplicacoes {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        //Cria lista e armazena nela.
        List<Contribuinte> listaContribuintes = new ArrayList<>();

        System.out.print("-.-.-.-Entre com o número de contribuintes: ");
        int n = 0;
        boolean entradaValida = false;
        //garantia de numero valido
        while (!entradaValida) {
            try {
                n = sc.nextInt();
                entradaValida = true;
            } catch (InputMismatchException e) { //função para se um erro acontecer o bloco 'catch' ser executado
                System.out.println("Entrada inválida em. Por favor, digite um número inteiro.");
                sc.next(); // Limpa o buffer do scanner para evitar loop infinitooo
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println("Dados do contribuinte #" + i + ":");

            char tipo = ' ';
            entradaValida = false;
            //garantir que o tipo de contribuinte seja 'f' ou 'j'
            while (!entradaValida) {
                System.out.print("Pessoa física ou jurídica (f/j)? ");
                String tipoString = sc.next();
                //Verifica se o usuário digitou apenas um caractere
                if (tipoString.length() == 1 && (tipoString.charAt(0) == 'f' || tipoString.charAt(0) == 'j')) {
                    tipo = tipoString.charAt(0);
                    entradaValida = true;
                } else {
                    System.out.println("Entrada inválida. Digite 'f' para pessoa física ou 'j' para pessoa jurídica (e presta mais atenção).");
                }
            }
            sc.nextLine();

            System.out.print("Nome: ");
            String nome = sc.nextLine();

            double rendaAnual = 0.0;
            entradaValida = false;
            //garantir que a renda anual seja um valor numérico
            while (!entradaValida) {
                try {
                    System.out.print("Renda anual: ");
                    rendaAnual = sc.nextDouble();
                    entradaValida = true;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida...poxa. Por favor, digite um valor numérico.");
                    sc.next();
                }
            }

            if (tipo == 'f') {
                double gastosSaude = 0.0;
                entradaValida = false;
                //para garantir que os gastos de saúde sejam um valor numérico
                while (!entradaValida) {
                    try {
                        System.out.print("Gastos com saúde: ");
                        gastosSaude = sc.nextDouble();
                        entradaValida = true;
                    } catch (InputMismatchException e) {
                        // tradução literal, significa "Exceção de Tipo de Entrada Incompatível"
                        // O Java usa esse nome quando você tenta ler um tipo de dado como um número
                        // e o usuário digita algo diferente uma letra por exemplo
                        //  o nome técnico do erro que o Scanner lança.
                        System.out.println("Entrada inválidaaaa. já deu né. Por favor, digite um valor numérico.");
                        sc.next();  // lê apenas uma única palavra ou um único caractere, até encontrar um espaço, quebra de linha
                    }
                }

                listaContribuintes.add(new PessoaFisica(nome, rendaAnual, gastosSaude));
            } else if (tipo == 'j') {
                int numeroFuncionarios = 0;
                entradaValida = false;
                //garantir que o número de funcionários seja um valor inteiro
                while (!entradaValida) {
                    try {
                        System.out.print("Número de funcionários: ");
                        numeroFuncionarios = sc.nextInt();
                        entradaValida = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida, vamos parar e digitar certo?. Por favor, digite um número inteiro.");
                        sc.next();
                    }
                }
                listaContribuintes.add(new PessoaJuridica(nome, rendaAnual, numeroFuncionarios));
            }
        }

        System.out.println("\nIMPOSTOS PAGOS:");
        double totalImpostos = 0.0;
        for (Contribuinte contribuinte : listaContribuintes) {

            double impostoPago = contribuinte.imposto();
            System.out.printf("%s: R$ %.2f\n", contribuinte.getNome(), impostoPago);
            totalImpostos += impostoPago;
        }

        System.out.printf("\nTOTAL DE IMPOSTOS: R$ %.2f\n", totalImpostos);

        sc.close(); //fiim, esse aqui fecha o objeto Scanner para liberar os recursos do sistema
    }
}

// A palavra-chave 'abstract' vem e define uma classe que não pode ser instanciada ok?
// Ela serve como um modelo para as classes que a herdam

public abstract class Contribuinte {

    // Os atributos 'nome' e 'rendaAnual' são 'private' para garantir o encapsulamento
    // Isso significa que eles só podem ser acessados ou modificados dentro desta classe
    // garantindo a proteção dos dados

    private String nome;
    private Double rendaAnual;

    // Construtor da classe. Ele é responsável por inicializar os atributos privados
    public Contribuinte(String nome, Double rendaAnual) {
        this.nome = nome;
        this.rendaAnual = rendaAnual;
    }

    // Métodos 'get' públicos para acessar o valor dos atributos privados de forma controladaaaa
    public String getNome() {
        return nome;
    }

    public Double getRendaAnual() {
        return rendaAnual;
    }

    // Este é um método abstrato. Ele não tem implementação (corpo) aqui, apenas a assinatura
    // Isso força todas as subclasses (PessoaFisica e PessoaJuridica) a implemenarem
    // seu próprio cálculo de imposto


    public abstract Double imposto();
}

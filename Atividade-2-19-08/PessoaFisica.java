// A palavra-chave 'extends' indica que esta classe herda de 'Contribuinte' viu
// recebendo seus atributos e métodos não-privados

public class PessoaFisica extends Contribuinte {

    // Atributo private específico para PessoaFisica, que não existe na classe matriarca
    private Double gastosSaude;

    // Construtor que chama o construtor da superclasse usando 'super()'
    // Ele inicializa os atributos herdados e o atributo próprio 'gastosSaude'
    public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
        super(nome, rendaAnual);
        this.gastosSaude = gastosSaude;
    }

    // Método 'get' para o atributo 'gastosSaude', permitindo acesso seguro.
    public Double getGastosSaude() {
        return gastosSaude;
    }

    // A anotação '@Override'  indica que este método está
    // sobrescrevendo o método abstrato 'imposto()' da superclasse

    @Override
    public Double imposto() {
        double impostoBruto;
        if (getRendaAnual() < 20000.00) {
            impostoBruto = getRendaAnual() * 0.15;
        } else {
            impostoBruto = getRendaAnual() * 0.25;
        }
        return impostoBruto - (gastosSaude * 0.50);
    }
}

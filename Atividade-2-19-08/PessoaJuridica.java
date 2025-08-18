// A classe PessoaJuridica herda de Contribuinte, seguindo o princípio de herançaaaa

public class PessoaJuridica extends Contribuinte {

    // Atributo 'private' específico para PessoaJuridica
    private Integer numeroFuncionarios;

    // Construtor que inicializa os atributos herdados e o próprio da classe
    public PessoaJuridica(String nome, Double rendaAnual, Integer numeroFuncionarios) {
        super(nome, rendaAnual);
        this.numeroFuncionarios = numeroFuncionarios;
    }

    // Método 'get' para o atributo 'numeroFuncionarios'.
    public Integer getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    // Sobrescrevendo o método 'imposto()' com a lógica específica para pessoa jurídica
    // A verificação do número de funcionários está encapsulada neste método

    @Override
    public Double imposto() {
        if (numeroFuncionarios > 10) {
            return getRendaAnual() * 0.14;
        } else {
            return getRendaAnual() * 0.16;
        }
    }
}

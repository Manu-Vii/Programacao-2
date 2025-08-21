// classe de dominioExcecao vai herda de RuntimeException
//tentativa de dividir tudo pelo maximo de classes possiveis

public class DominioExcecao extends RuntimeException {

    // descreve o que deu errado...
    public DominioExcecao(String msg) {
        // super(msg) chama o construtor da classe pai RuntimeException
        // e passa a mensagem de erro para ela.

        super(msg);
    }
}

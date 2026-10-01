package polimorfismo;

// Cartão de crédito: à vista não tem juros, parcelado tem 2% por parcela.
public class PagamentoCartao extends Pagamento implements Reembolsavel {

    private int parcelas;

    // SOBRECARGA de construtores: mesmo nome, parâmetros diferentes
    public PagamentoCartao(double valor) {
        super(valor);
        this.parcelas = 1; // à vista
    }

    public PagamentoCartao(double valor, int parcelas) {
        super(valor);
        this.parcelas = parcelas;
    }

    @Override
    public double calcularValorFinal() {
        if (parcelas == 1) {
            return valor;
        }
        return valor + (valor * 0.02 * parcelas); // 2% de juros por parcela
    }

    @Override
    public String getDescricao() {
        return "Cartão de crédito (" + parcelas + "x)";
    }

    @Override
    public void reembolsar() {
        System.out.println("Estorno de R$ " + String.format("%.2f", calcularValorFinal())
                + " lançado na fatura do cartão");
    }

    // método que só existe no Cartão
    public int getParcelas() {
        return parcelas;
    }
}

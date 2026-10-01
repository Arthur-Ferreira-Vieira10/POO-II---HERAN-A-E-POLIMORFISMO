package polimorfismo;

// Boleto: cobra uma taxa fixa de R$ 3,50. Não é reembolsável.
public class PagamentoBoleto extends Pagamento {

    private double taxa = 3.50;

    public PagamentoBoleto(double valor) {
        super(valor);
    }

    @Override
    public double calcularValorFinal() {
        return valor + taxa;
    }

    @Override
    public String getDescricao() {
        return "Boleto bancário (taxa de R$ 3,50)";
    }

    // método que só existe no Boleto
    public void gerarCodigoBarras() {
        System.out.println("Código de barras: 34191.79001 01043.510047 91020.150008 1 00000000"
                + String.format("%.0f", calcularValorFinal() * 100));
    }
}

package polimorfismo;

// Pix: tem 5% de desconto e pode ser reembolsado.
public class PagamentoPix extends Pagamento implements Reembolsavel {

    private String chavePix;

    public PagamentoPix(double valor, String chavePix) {
        super(valor);
        this.chavePix = chavePix;
    }

    @Override
    public double calcularValorFinal() {
        return valor * 0.95; // 5% de desconto
    }

    @Override
    public String getDescricao() {
        return "Pix (5% de desconto)";
    }

    @Override
    public void reembolsar() {
        System.out.println("Pix de R$ " + String.format("%.2f", calcularValorFinal())
                + " devolvido para a chave " + chavePix);
    }

    // método que só existe no Pix
    public void gerarQrCode() {
        System.out.println("QR Code gerado para a chave: " + chavePix);
    }
}

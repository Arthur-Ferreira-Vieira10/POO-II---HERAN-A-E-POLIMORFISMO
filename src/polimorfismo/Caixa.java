package polimorfismo;

// Caixa da loja: usa SOBRECARGA de métodos.
// Os três métodos se chamam cobrar(), mas recebem parâmetros diferentes.
// O Java escolhe qual executar de acordo com os argumentos passados.
public class Caixa {

    // cobrar(double) -> pagamento em dinheiro
    public void cobrar(double valor) {
        System.out.println("Cobrando R$ " + String.format("%.2f", valor) + " em dinheiro.");
    }

    // cobrar(double, int) -> valor dividido em parcelas
    public void cobrar(double valor, int parcelas) {
        double valorParcela = valor / parcelas;
        System.out.println("Cobrando R$ " + String.format("%.2f", valor)
                + " em " + parcelas + "x de R$ " + String.format("%.2f", valorParcela));
    }

    // cobrar(Pagamento) -> recebe qualquer tipo de pagamento
    public void cobrar(Pagamento pagamento) {
        System.out.println("Cobrando via " + pagamento.getDescricao()
                + ": R$ " + String.format("%.2f", pagamento.calcularValorFinal()));
    }
}

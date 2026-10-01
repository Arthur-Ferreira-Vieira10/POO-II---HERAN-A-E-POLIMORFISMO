package polimorfismo;

// Superclasse ABSTRATA de um sistema de pagamentos (ex.: loja virtual).
// Todo pagamento tem um valor, mas cada tipo calcula o total do seu jeito.
public abstract class Pagamento {

    protected double valor;

    public Pagamento(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    // cada subclasse é obrigada a implementar o seu cálculo
    public abstract double calcularValorFinal();

    // método com comportamento padrão, que as subclasses podem SOBRESCREVER
    public String getDescricao() {
        return "Pagamento";
    }

    public void processar() {
        System.out.println(getDescricao()
                + " | Valor: R$ " + String.format("%.2f", valor)
                + " | Total: R$ " + String.format("%.2f", calcularValorFinal()));
    }
}

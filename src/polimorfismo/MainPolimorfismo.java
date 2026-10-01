package polimorfismo;

public class MainPolimorfismo {

    public static void main(String[] args) {

        // =====================================================
        // (a) POLIMORFISMO DE INCLUSÃO (SUBTIPAGEM)
        // A variável é do tipo da SUPERCLASSE (ou interface),
        // mas o objeto guardado nela é de uma SUBCLASSE.
        // =====================================================
        System.out.println("===== (a) Polimorfismo de Inclusão =====");

        Pagamento p1 = new PagamentoPix(100.0, "loja@email.com");
        Pagamento p2 = new PagamentoCartao(100.0, 3);
        Pagamento p3 = new PagamentoBoleto(100.0);

        // um único array do tipo Pagamento guarda três "formas" diferentes
        Pagamento[] pagamentos = { p1, p2, p3 };

        for (Pagamento p : pagamentos) {
            finalizarCompra(p); // o método aceita qualquer subclasse de Pagamento
        }

        // também funciona com INTERFACE
        Reembolsavel r1 = new PagamentoPix(50.0, "cliente@email.com");
        Reembolsavel r2 = new PagamentoCartao(80.0, 2);
        r1.reembolsar();
        r2.reembolsar();

        // =====================================================
        // (b) POLIMORFISMO DE SOBRESCRITA (OVERRIDING)
        // A MESMA variável recebe objetos diferentes, e o mesmo
        // método chamado executa a versão de cada subclasse.
        // =====================================================
        System.out.println("\n===== (b) Polimorfismo de Sobrescrita =====");

        Pagamento pagamento; // uma única variável...

        pagamento = new PagamentoPix(200.0, "loja@email.com");
        System.out.println(pagamento.getDescricao() + " -> R$ "
                + String.format("%.2f", pagamento.calcularValorFinal()));

        pagamento = new PagamentoCartao(200.0, 5); // ...muda de forma
        System.out.println(pagamento.getDescricao() + " -> R$ "
                + String.format("%.2f", pagamento.calcularValorFinal()));

        pagamento = new PagamentoBoleto(200.0); // ...muda de forma de novo
        System.out.println(pagamento.getDescricao() + " -> R$ "
                + String.format("%.2f", pagamento.calcularValorFinal()));

        // =====================================================
        // (c) POLIMORFISMO DE SOBRECARGA (OVERLOADING)
        // Métodos com o MESMO nome e parâmetros DIFERENTES.
        // =====================================================
        System.out.println("\n===== (c) Polimorfismo de Sobrecarga =====");

        Caixa caixa = new Caixa();
        caixa.cobrar(59.90);                      // chama cobrar(double)
        caixa.cobrar(300.0, 3);                   // chama cobrar(double, int)
        caixa.cobrar(new PagamentoBoleto(150.0)); // chama cobrar(Pagamento)

        // sobrecarga de construtores
        PagamentoCartao aVista = new PagamentoCartao(120.0);       // 1 parâmetro
        PagamentoCartao parcelado = new PagamentoCartao(120.0, 4); // 2 parâmetros
        aVista.processar();
        parcelado.processar();

        // =====================================================
        // (d) POLIMORFISMO PARAMÉTRICO (GENERICS)
        // A mesma classe Repositorio<T> funciona com tipos diferentes.
        // =====================================================
        System.out.println("\n===== (d) Polimorfismo Paramétrico =====");

        Repositorio<Cliente> clientes = new Repositorio<>();
        clientes.adicionar(new Cliente("Maria Souza", "maria@email.com"));
        clientes.adicionar(new Cliente("João Lima", "joao@email.com"));

        Repositorio<Pagamento> historico = new Repositorio<>();
        historico.adicionar(new PagamentoPix(75.0, "maria@email.com"));
        historico.adicionar(new PagamentoCartao(430.0, 6));

        Repositorio<String> cupons = new Repositorio<>();
        cupons.adicionar("BEMVINDO10");
        cupons.adicionar("FRETEGRATIS");

        System.out.println("Clientes cadastrados: " + clientes.quantidade());
        for (Cliente c : clientes.listarTodos()) {
            System.out.println(c);
        }

        System.out.println("Pagamentos no histórico: " + historico.quantidade());
        for (Pagamento p : historico.listarTodos()) {
            p.processar();
        }

        System.out.println("Primeiro cupom: " + cupons.buscar(0));

        // clientes.adicionar("texto"); // ERRO de compilação: esse repositório só aceita Cliente

        // =====================================================
        // (e) POLIMORFISMO POR COERÇÃO (CASTING)
        // Conversão de um tipo em outro relacionado.
        // =====================================================
        System.out.println("\n===== (e) Polimorfismo por Coerção =====");

        // 1) Coerção IMPLÍCITA entre primitivos (int -> double): automática
        int quantidade = 3;
        double precoUnitario = 19.90;
        double totalItens = quantidade * precoUnitario; // quantidade vira double sozinha
        System.out.println("Implícita (int -> double): total = R$ " + String.format("%.2f", totalItens));

        // 2) Coerção EXPLÍCITA entre primitivos (double -> int): precisa do (int)
        double valorComCentavos = 149.99;
        int valorInteiro = (int) valorComCentavos; // perde as casas decimais
        System.out.println("Explícita (double -> int): " + valorComCentavos + " virou " + valorInteiro);

        // 3) UPCASTING (implícito): subclasse -> superclasse
        PagamentoPix pix = new PagamentoPix(90.0, "loja@email.com");
        Pagamento generico = pix; // não precisa de cast
        System.out.println("Upcasting: " + generico.getDescricao());
        // generico.gerarQrCode(); // ERRO: o tipo Pagamento não conhece gerarQrCode()

        // 4) DOWNCASTING (explícito): superclasse -> subclasse
        // Usamos instanceof para conferir o tipo antes, senão dá ClassCastException.
        System.out.println("Downcasting:");
        for (Pagamento p : pagamentos) {
            if (p instanceof PagamentoPix) {
                PagamentoPix pagPix = (PagamentoPix) p;
                pagPix.gerarQrCode();
            } else if (p instanceof PagamentoCartao) {
                PagamentoCartao cartao = (PagamentoCartao) p;
                System.out.println("Cartão parcelado em " + cartao.getParcelas() + "x");
            } else if (p instanceof PagamentoBoleto) {
                PagamentoBoleto boleto = (PagamentoBoleto) p;
                boleto.gerarCodigoBarras();
            }
        }
    }

    // Recebe um Pagamento, mas funciona com Pix, Cartão ou Boleto
    public static void finalizarCompra(Pagamento pagamento) {
        pagamento.processar();
    }
}

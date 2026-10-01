package heranca;

// (a) Classe CONCRETA herdando de classe CONCRETA
// Ave é concreta e herda de Animal, que também é concreta.
public class Ave extends Animal {

    public Ave(String nome) {
        super(nome); // chama o construtor de Animal
    }

    // método próprio da Ave
    public void voar() {
        System.out.println(nome + " está voando.");
    }
}

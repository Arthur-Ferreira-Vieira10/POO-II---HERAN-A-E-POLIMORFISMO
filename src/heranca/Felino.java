package heranca;

// (e) Classe ABSTRATA herdando de classe ABSTRATA
// Felino é abstrata e herda de Mamifero, que também é abstrata.
// Ela NÃO precisa implementar amamentar(), pois continua abstrata.
public abstract class Felino extends Mamifero {

    public Felino(String nome) {
        super(nome);
    }

    // novo método abstrato: todo felino concreto vai ter que implementar
    public abstract void cacar();

    // método comum a todos os felinos (já vem pronto)
    public void afiarGarras() {
        System.out.println(nome + " está afiando as garras.");
    }
}

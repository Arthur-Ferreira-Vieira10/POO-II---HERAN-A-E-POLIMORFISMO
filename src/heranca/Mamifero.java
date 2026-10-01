package heranca;

// (d) Classe ABSTRATA herdando de classe CONCRETA
// Mamifero é abstrata e herda de Animal, que é concreta.
// Não é possível fazer: new Mamifero("...")
public abstract class Mamifero extends Animal {

    public Mamifero(String nome) {
        super(nome);
    }

    // obrigatório implementar nas subclasses concretas
    public abstract void amamentar();
}

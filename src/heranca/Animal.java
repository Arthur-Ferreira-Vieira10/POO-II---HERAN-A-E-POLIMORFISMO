package heranca;

// Classe CONCRETA: pode ser instanciada diretamente (new Animal(...))
// É a classe base (superclasse) de toda a hierarquia.
public class Animal {

    protected String nome;

    public Animal(String nome) {
        this.nome = nome;
    }

    public void emitirSom() {
        System.out.println(nome + ": Som de animal...");
    }

    public String getNome() {
        return nome;
    }
}

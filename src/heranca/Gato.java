package heranca;

// (c) Classe CONCRETA implementando interface
// Gato implementa a interface Domestico, então precisa ter brincar() e alimentar().
// (Gato também é um exemplo do caso (b), pois herda de Felino, que é abstrata.)
public class Gato extends Felino implements Domestico {

    public Gato(String nome) {
        super(nome);
    }

    // métodos obrigatórios da herança (Mamifero e Felino)
    @Override
    public void amamentar() {
        System.out.println("A gata está amamentando os filhotes de " + nome + ".");
    }

    @Override
    public void cacar() {
        System.out.println(nome + " está caçando um rato.");
    }

    // métodos obrigatórios da interface Domestico
    @Override
    public void brincar() {
        System.out.println(nome + " está brincando com um novelo de lã.");
    }

    @Override
    public void alimentar() {
        System.out.println(nome + " está comendo ração de gato.");
    }
}

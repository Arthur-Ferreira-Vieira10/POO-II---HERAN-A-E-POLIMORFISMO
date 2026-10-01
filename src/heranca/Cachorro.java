package heranca;

// Cachorro herda de Mamifero (abstrata) e implementa Adestravel.
// Como Adestravel herda de Domestico (caso f), o Cachorro precisa
// implementar os métodos das DUAS interfaces:
// brincar(), alimentar() e obedecerComando().
public class Cachorro extends Mamifero implements Adestravel {

    public Cachorro(String nome) {
        super(nome);
    }

    @Override
    public void amamentar() {
        System.out.println("A cadela está amamentando os filhotes de " + nome + ".");
    }

    @Override
    public void brincar() {
        System.out.println(nome + " está buscando a bolinha.");
    }

    @Override
    public void alimentar() {
        System.out.println(nome + " está comendo ração de cachorro.");
    }

    @Override
    public void obedecerComando(String comando) {
        System.out.println(nome + " obedeceu o comando: " + comando);
    }
}

package heranca;

// (b) Classe CONCRETA herdando de classe ABSTRATA
// Leao é concreta e herda de Felino (abstrata).
// Por isso é OBRIGADO a implementar todos os métodos abstratos:
// amamentar() (vem de Mamifero) e cacar() (vem de Felino).
public class Leao extends Felino {

    public Leao(String nome) {
        super(nome);
    }

    @Override
    public void amamentar() {
        System.out.println("A leoa está amamentando os filhotes de " + nome + ".");
    }

    @Override
    public void cacar() {
        System.out.println(nome + " está caçando uma zebra.");
    }
}

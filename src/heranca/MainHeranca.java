package heranca;

public class MainHeranca {

    public static void main(String[] args) {

        // (a) Classe concreta herdando de classe concreta
        System.out.println("===== (a) Concreta herdando de concreta =====");
        Ave ave = new Ave("Papagaio");
        ave.emitirSom(); // método herdado de Animal
        ave.voar();      // método próprio de Ave

        // (b) Classe concreta herdando de classe abstrata
        System.out.println("\n===== (b) Concreta herdando de abstrata =====");
        Leao leao = new Leao("Simba");
        leao.emitirSom();   // herdado de Animal
        leao.amamentar();   // implementado em Leao (era abstrato em Mamifero)
        leao.cacar();       // implementado em Leao (era abstrato em Felino)
        leao.afiarGarras(); // herdado pronto de Felino

        // (c) Classe concreta implementando interface
        System.out.println("\n===== (c) Concreta implementando interface =====");
        Gato gato = new Gato("Frajola");
        gato.brincar();
        gato.alimentar();

        // (d) Classe abstrata herdando de classe concreta
        System.out.println("\n===== (d) Abstrata herdando de concreta =====");
        // Mamifero m = new Mamifero("Teste"); // ERRO: classe abstrata não pode ser instanciada
        System.out.println("Mamifero é abstrata e herda de Animal (concreta).");
        System.out.println("Ela só é usada através das subclasses, como Leao, Gato e Cachorro.");

        // (e) Classe abstrata herdando de classe abstrata
        System.out.println("\n===== (e) Abstrata herdando de abstrata =====");
        // Felino f = new Felino("Teste"); // ERRO: classe abstrata não pode ser instanciada
        System.out.println("Felino é abstrata e herda de Mamifero (abstrata).");
        gato.afiarGarras(); // método que veio pronto de Felino

        // (f) Interface herdando de interface
        System.out.println("\n===== (f) Interface herdando de interface =====");
        Cachorro cachorro = new Cachorro("Rex");
        cachorro.brincar();                // veio de Domestico
        cachorro.alimentar();              // veio de Domestico
        cachorro.obedecerComando("Senta!"); // veio de Adestravel
    }
}

package heranca;

// (f) Interface herdando de interface
// Adestravel herda os métodos de Domestico (brincar e alimentar)
// e adiciona um novo: obedecerComando().
// Obs.: uma interface pode herdar de VÁRIAS interfaces, ex.:
// public interface Adestravel extends Domestico, OutraInterface { }
public interface Adestravel extends Domestico {

    void obedecerComando(String comando);
}

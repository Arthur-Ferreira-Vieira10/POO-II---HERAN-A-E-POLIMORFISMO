package polimorfismo;

import java.util.ArrayList;
import java.util.List;

// Classe GENÉRICA: o <T> é um "tipo coringa".
// Quando criar o repositório, você diz qual tipo ele vai guardar:
// Repositorio<Cliente>, Repositorio<Pagamento>, Repositorio<String>...
// A mesma classe funciona para qualquer tipo (polimorfismo paramétrico).
public class Repositorio<T> {

    private List<T> itens = new ArrayList<>();

    public void adicionar(T item) {
        itens.add(item);
    }

    public T buscar(int posicao) {
        return itens.get(posicao);
    }

    public List<T> listarTodos() {
        return itens;
    }

    public int quantidade() {
        return itens.size();
    }
}

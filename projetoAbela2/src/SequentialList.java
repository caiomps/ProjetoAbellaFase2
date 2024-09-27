public class SequentialList {

    private Book[] livros;
    private int tamanho;


    public SequentialList(int capacidadeInicial) {
        this.livros = new Book[capacidadeInicial];
        this.tamanho = 0;
    }

    //TODO Método para adicionar um livro à lista
    public void adicionar(Book livro) {
        if (tamanho == livros.length) {
            aumentarCapacidade();
        }
        livros[tamanho] = livro;
        tamanho++;
    }

    //TODO Método para remover um livro da lista (pelo índice)
    public void remover(int index) {
        if (index >= 0 && index < tamanho) {
            for (int i = index; i < tamanho - 1; i++) {
                livros[i] = livros[i + 1];
            }
            livros[tamanho - 1] = null;
            tamanho--;
            System.out.println("Livro removido com sucesso.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    // Método auxiliar para buscar o índice de um livro pelo título
    public int buscar(String titulo) {
        for (int i = 0; i < tamanho; i++) {
            if (livros[i].getTitle().equals(titulo)) {
                return i;
            }
        }
        return -1;
    }

    public Book getLivro(int index) {
        if (index >= 0 && index < tamanho) {
            return livros[index];
        } else {
            throw new IndexOutOfBoundsException("Índice inválido: " + index);
        }
    }

    //TODO Método auxiliar para aumentar a capacidade da lista
    private void aumentarCapacidade() {
        int novaCapacidade = livros.length * 2;
        Book[] novoArray = new Book[novaCapacidade];
        for (int i = 0; i < livros.length; i++) {
            novoArray[i] = livros[i];
        }
        livros = novoArray;
    }

    //TODO Método para imprimir os livros da lista
    public void mostrarLista() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println(livros[i]);
        }
    }

    //TODO Método para ordenar a lista por título e autor
    public void ordenarPorTituloEAutor() {
        boolean trocou;
        for (int i = 0; i < tamanho - 1; i++) {
            trocou = false;
            for (int j = 0; j < tamanho - i - 1; j++) {
                // Comparar títulos dos livros
                if (livros[j].getTitle().compareToIgnoreCase(livros[j + 1].getTitle()) > 0) {
                    trocarLivros(j, j + 1);
                    trocou = true;
                }
                // Se os títulos forem iguais, comparar os autores
                else if (livros[j].getTitle().equalsIgnoreCase(livros[j + 1].getTitle()) &&
                        livros[j].getAuthor().compareToIgnoreCase(livros[j + 1].getAuthor()) > 0) {
                    trocarLivros(j, j + 1);
                    trocou = true;
                }
            }
            if (!trocou) break;
        }
    }

    //TODO Método auxiliar para trocar dois livros de posição
    private void trocarLivros(int i, int j) {
        Book temp = livros[i];
        livros[i] = livros[j];
        livros[j] = temp;
    }
}
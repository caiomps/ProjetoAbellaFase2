public class BinarySearchTree {

    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    //TODO Método para adicionar um livro à árvore
    public void adicionar(Book livro) {
        root = adicionarRecursivo(root, livro);
    }

    private TreeNode adicionarRecursivo(TreeNode current, Book livro) {
        if (current == null) {
            return new TreeNode(livro);
        }

        if (livro.getTitle().compareTo(current.livro.getTitle()) < 0) {
            current.left = adicionarRecursivo(current.left, livro);
        } else if (livro.getTitle().compareTo(current.livro.getTitle()) > 0) {
            current.right = adicionarRecursivo(current.right, livro);
        }

        return current;
    }

    //TODO Método para buscar um livro pelo título
    public Book buscar(String title) {
        return buscarRecursivo(root, title);
    }

    private Book buscarRecursivo(TreeNode current, String title) {
        if (current == null) {
            return null; // Livro não encontrado
        }

        if (title.equals(current.livro.getTitle())) {
            return current.livro;
        }

        return title.compareTo(current.livro.getTitle()) < 0
                ? buscarRecursivo(current.left, title)
                : buscarRecursivo(current.right, title);
    }

    // TODO para mostrar todos os livros (em ordem crescente)
    public void mostrarLivros() {
        mostrarLivrosRecursivo(root);
    }

    private void mostrarLivrosRecursivo(TreeNode node) {
        if (node != null) {
            mostrarLivrosRecursivo(node.left);
            System.out.println(node.livro);
            mostrarLivrosRecursivo(node.right);
        }
    }
}
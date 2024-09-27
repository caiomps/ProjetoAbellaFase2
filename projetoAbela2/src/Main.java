import java.time.LocalDateTime;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOpções:");
            System.out.println("1. Adicionar livro");
            System.out.println("2. Mostrar lista de livros");
            System.out.println("3. Buscar livro pelo título");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do autor: ");
                    String author = scanner.nextLine();

                    System.out.print("Digite o título do livro: ");
                    String title = scanner.nextLine();

                    LocalDateTime creationDate = LocalDateTime.now();
                    System.out.print("Digite o ano de lançamento (yyyy): ");
                    int year = scanner.nextInt();
                    System.out.print("Digite o mês de lançamento (mm): ");
                    int month = scanner.nextInt();
                    System.out.print("Digite o dia de lançamento (dd): ");
                    int day = scanner.nextInt();
                    LocalDateTime yearOfRelease = LocalDateTime.of(year, month, day, 0, 0);

                    Book livro = new Book(author, title, creationDate, yearOfRelease);
                    tree.adicionar(livro);
                    System.out.println("Livro adicionado com sucesso!");
                    break;


                case 2:
                    System.out.println("Lista de livros:");
                    tree.mostrarLivros();
                    break;

                case 3:
                    System.out.print("Digite o título do livro a ser buscado: ");
                    String titulo = scanner.nextLine();
                    Book encontrado = tree.buscar(titulo);
                    if (encontrado != null) {
                        System.out.println("Livro encontrado com sucesso!");
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }
}
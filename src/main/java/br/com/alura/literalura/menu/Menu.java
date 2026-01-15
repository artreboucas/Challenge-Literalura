package br.com.alura.literalura.menu;

import br.com.alura.literalura.repository.AutorRepository;
import br.com.alura.literalura.repository.LivroRepository;
import br.com.alura.literalura.service.LivroService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Menu implements CommandLineRunner {

    private final LivroService livroService;
    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;

    public Menu(LivroService livroService,
                LivroRepository livroRepository,
                AutorRepository autorRepository) {
        this.livroService = livroService;
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                1 - Buscar livro pelo título
                2 - Listar livros registrados
                3 - Listar autores
                4 - Listar autores vivos em determinado ano
                5 - Listar livros por idioma
                0 - Sair
            """);

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Título: ");
                    livroService.buscarESalvarLivro(scanner.nextLine());
                }
                case 2 -> livroRepository.findAll().forEach(System.out::println);
                case 3 -> autorRepository.findAll().forEach(System.out::println);
                case 4 -> {
                    System.out.print("Ano: ");
                    autorRepository.buscarAutoresVivosNoAno(scanner.nextInt())
                            .forEach(System.out::println);
                }
                case 5 -> {
                    System.out.print("Idioma (PT, EN, FR, ES): ");
                    livroRepository.findByIdiomaIgnoreCase(scanner.nextLine())
                            .forEach(System.out::println);
                }
                case 0 -> System.exit(0);
            }
        }
    }
}

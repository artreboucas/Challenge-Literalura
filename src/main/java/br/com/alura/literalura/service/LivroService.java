package br.com.alura.literalura.service;

import br.com.alura.literalura.dto.GutendexAuthor;
import br.com.alura.literalura.dto.GutendexBook;
import br.com.alura.literalura.model.Autor;
import br.com.alura.literalura.model.Livro;
import br.com.alura.literalura.repository.AutorRepository;
import br.com.alura.literalura.repository.LivroRepository;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;
    private final GutendexService gutendexService;

    public LivroService(LivroRepository livroRepository,
                        AutorRepository autorRepository,
                        GutendexService gutendexService) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
        this.gutendexService = gutendexService;
    }

    public void buscarESalvarLivro(String titulo) {
        GutendexBook book = gutendexService.buscarLivro(titulo);
        if (book == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        GutendexAuthor autorApi = book.authors().get(0);

        Autor autor = new Autor();
        autor.setNome(autorApi.name());
        autor.setAnoNascimento(autorApi.birth_year());
        autor.setAnoFalecimento(autorApi.death_year());
        autorRepository.save(autor);

        Livro livro = new Livro();
        livro.setTitulo(book.title());
        livro.setIdioma(book.languages().get(0));
        livro.setDownloads(book.download_count());
        livro.setAutor(autor);

        livroRepository.save(livro);
    }
}

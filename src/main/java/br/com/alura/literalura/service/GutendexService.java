package br.com.alura.literalura.service;

import br.com.alura.literalura.dto.GutendexBook;
import br.com.alura.literalura.dto.GutendexResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GutendexService {

    private final RestTemplate restTemplate = new RestTemplate();

    public GutendexBook buscarLivro(String titulo) {
        String url = "https://gutendex.com/books/?search=" + titulo.replace(" ", "%20");
        GutendexResponse response =
                restTemplate.getForObject(url, GutendexResponse.class);

        return response.results().isEmpty() ? null : response.results().get(0);
    }
}

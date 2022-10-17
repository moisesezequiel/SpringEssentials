package academy.devdojo.client;

import academy.devdojo.domain.Anime;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class SpringClient {
    public static void main(String[] args) {
        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/animes/30", Anime.class);
        System.out.println(entity);


        Anime obj = new RestTemplate().getForObject("http://localhost:8080/animes/{id}", Anime.class,11);
        System.out.println(obj);

        Anime[] animes = new RestTemplate().getForObject("http://localhost:8080/animes/all", Anime[].class);
        System.out.println("Animes");
        System.out.println(Arrays.toString(animes));


        ResponseEntity<List<Anime>> exchange = new RestTemplate().exchange("http://localhost:8080/animes/all", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Anime>>() {});

        System.out.println("Exchange");
        System.out.println(exchange.getBody());
    }
}

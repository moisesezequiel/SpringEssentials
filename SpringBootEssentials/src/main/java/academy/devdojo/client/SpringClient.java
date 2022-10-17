package academy.devdojo.client;

import academy.devdojo.domain.Anime;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SpringClient {
    public static void main(String[] args) {
        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/animes/30", Anime.class);
        System.out.println(entity);


        Anime obj = new RestTemplate().getForObject("http://localhost:8080/animes/{id}", Anime.class,11);
        System.out.println(obj);
    }
}

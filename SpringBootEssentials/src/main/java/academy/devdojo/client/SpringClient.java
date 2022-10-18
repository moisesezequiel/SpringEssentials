package academy.devdojo.client;

import academy.devdojo.domain.Anime;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class SpringClient {
    public static void main(String[] args) {
        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/animes/31", Anime.class);
        System.out.println(entity);


        Anime obj = new RestTemplate().getForObject("http://localhost:8080/animes/{id}", Anime.class,11);
        System.out.println(obj);

        Anime[] animes = new RestTemplate().getForObject("http://localhost:8080/animes/all", Anime[].class);
        System.out.println("Animes");
        System.out.println(Arrays.toString(animes));

        //Metodo de Get para busca de toda listagem
        ResponseEntity<List<Anime>> exchange = new RestTemplate().exchange("http://localhost:8080/animes/all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Anime>>() {});
        System.out.println("Exchange");
        System.out.println(exchange.getBody());

        //METODO POST
//        Anime dota = Anime.builder().name("dota").build();
//        Anime save = new RestTemplate().postForObject("http://localhost:8080/animes/",dota, Anime.class);
//        System.out.println("Anime salvo");
//        System.out.println(save);

        //METODO POST Exchange
        Anime samurai = Anime.builder().name("Goku").build();
        ResponseEntity<Anime> save = new RestTemplate().exchange("http://localhost:8080/animes/",
                HttpMethod.POST,new HttpEntity<>(samurai,createadJsonHeader())
                ,Anime.class);

            System.out.println("Anime salvo");
            System.out.println(save);


        //METODO PUT Exchange
        Anime atualizado = save.getBody();
        atualizado.setName("Tokio");
        ResponseEntity<Void> update = new RestTemplate().exchange("http://localhost:8080/animes/",
                HttpMethod.PUT
                ,new HttpEntity<>(atualizado)
                ,Void.class);

        System.out.println("Anime ATUALIZADO");
        System.out.println(update);


        //METODO PUT Exchange
        ResponseEntity<Void> delete = new RestTemplate().exchange("http://localhost:8080/animes/{id}",
                HttpMethod.DELETE
                ,null
                , Void.class
                ,atualizado.getId());

        System.out.println("Anime DELETADO");
        System.out.println(delete);

    }

    private static HttpHeaders createadJsonHeader(){ //usar dentro do httpEntity
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth("Token");
        return  headers;

    }
}

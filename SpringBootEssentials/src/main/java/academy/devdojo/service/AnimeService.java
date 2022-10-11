package academy.devdojo.service;

import academy.devdojo.domain.Anime;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnimeService {

    //private final AnimeRepository animeRepository

    public List<Anime> listAll(){
        return List.of(new Anime(1,"Berserk"), new Anime(2,"Pokemon"),new Anime(3,"Boku no hero"));
    }
}

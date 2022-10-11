package academy.devdojo.service;

import academy.devdojo.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnimeService {

    private List<Anime> animes = List.of(new Anime(1L,"Berserk"), new Anime(2L,"Pokemon"));
    //private final AnimeRepository animeRepository

    public List<Anime> listAll(){
        return animes;
    }

    public Anime findById(Long id){
        return animes.stream().filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Anime not Found"));
        //retorna um possivel anime com base no id que foi passado ou lanca uma requisao de anime nao encontrado

    }
}

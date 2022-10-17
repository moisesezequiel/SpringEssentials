package academy.devdojo.service;

import academy.devdojo.domain.Anime;
import academy.devdojo.dto.AnimePostRequestBody;
import academy.devdojo.dto.AnimePutRequestBody;
import academy.devdojo.exception.AnimeException;
import academy.devdojo.mapper.AnimeMapper;
import academy.devdojo.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {


    private final AnimeRepository animeRepository;

    public Page<Anime> listAll(Pageable pageable){
        return animeRepository.findAll(pageable);
    }

    public List<Anime> findByName(String name){
        return animeRepository.findByName(name);
    }

    public Anime findByIdOrThrowBadRequestException(Long id){
        return animeRepository.findById(id).orElseThrow(() -> new AnimeException("Anime not Found"));
        //retorna um possivel anime com base no id que foi passado ou lanca uma requisao de anime nao encontrado

    }
@Transactional
    public Anime save(AnimePostRequestBody animePostRequestBody) {
        ;
        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostRequestBody));
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {

       Anime savedAnime= findByIdOrThrowBadRequestException(animePutRequestBody.getId());

        Anime anime =AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
        anime.setId(savedAnime.getId());

        animeRepository.save(anime);

    }
}

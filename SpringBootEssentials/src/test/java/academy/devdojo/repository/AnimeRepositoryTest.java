package academy.devdojo.repository;

import academy.devdojo.domain.Anime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("Teste for repository Anime")
class AnimeRepositoryTest {

    @Autowired
    AnimeRepository animeRepository;

    @Test
    @DisplayName("Save Anime when sucessfull")
    void save_PersistAnime_WhereSucessfull(){
        Anime animeToBeCreated = createdAnime();
        Anime animeSaved = this.animeRepository.save(animeToBeCreated);
        Assertions.assertThat(animeSaved).isNotNull();
        Assertions.assertThat(animeSaved.getId()).isNotNull();
        Assertions.assertThat(animeSaved.getName()).isEqualTo(animeToBeCreated.getName());
        //Assertions com AssertJ
    }


    @Test
    @DisplayName("Save Update when sucessfull")
    void save_UpdateAnime_WhereSucessfull(){
        Anime animeToBeCreated = createdAnime();
        Anime animeSaved = this.animeRepository.save(animeToBeCreated);
        animeSaved.setName("Overlord");

        Anime animeUpdated = this.animeRepository.save(animeSaved);
        Assertions.assertThat(animeUpdated).isNotNull();
        Assertions.assertThat(animeUpdated.getId()).isNotNull();
        Assertions.assertThat(animeUpdated.getName()).isEqualTo(animeToBeCreated.getName());
    }

    @Test
    @DisplayName("Delete Anime")
    void delete_Anime(){
        Anime animeToBeCreated = createdAnime();
        Anime animeSaved = this.animeRepository.save(animeToBeCreated);
        this.animeRepository.delete(animeSaved);

        Optional<Anime> animeOptional = this.animeRepository.findById(animeSaved.getId());


        Assertions.assertThat(animeOptional).isEmpty();

    }

    @Test
    @DisplayName("find  by name  Anime")
    void findByName_Anime(){
        Anime animeToBeCreated = createdAnime();
        Anime animeSaved = this.animeRepository.save(animeToBeCreated);
        String name = animeSaved.getName();
        List<Anime> names = this.animeRepository.findByName(name);
        Assertions.assertThat(names).isNotEmpty().contains(animeSaved);
    }

    @Test
    @DisplayName("Anime not found by name")
    void findByNamButNotFoundAnime(){
        List<Anime> names = this.animeRepository.findByName("sasjiajis");
        Assertions.assertThat(names).isEmpty();
    }




    private Anime createdAnime(){
        return Anime.builder().name("Ichigo").build();
    }
}
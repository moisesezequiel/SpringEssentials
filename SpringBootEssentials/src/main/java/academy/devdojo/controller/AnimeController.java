package academy.devdojo.controller;

import academy.devdojo.domain.Anime;
import academy.devdojo.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("animes")
@Log4j2
@AllArgsConstructor
public class AnimeController {
     private DateUtil dateUtil;
    //  @Autowired  NJECAO DE DEPENDENCIA nao indicado, indicado mesmo iniciar no construtor
   // private DateUtil dateUtil; I

    @GetMapping(path="list")
    public List<Anime> list(){
        log.info(dateUtil.formatLocalDate(LocalDateTime.now()));
        return List.of(new Anime("Berserk"), new Anime("Pokemon"),new Anime("Boku no hero"));
    }
    
}

package academy.devdojo.controller;

import academy.devdojo.domain.Anime;
import academy.devdojo.service.AnimeService;
import academy.devdojo.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private AnimeService animeService;
    //  @Autowired  NJECAO DE DEPENDENCIA nao indicado, indicado mesmo iniciar no construtor
   // private DateUtil dateUtil; I

    @GetMapping
    public ResponseEntity<List<Anime>> list(){
        log.info(dateUtil.formatLocalDate(LocalDateTime.now()));
      //  return  new ResponseEntity<>(animeService.listAll(), HttpStatus.OK) ;
        return   ResponseEntity.ok(animeService.listAll()) ;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity <Anime> findById(@PathVariable long id){
        return   ResponseEntity.ok(animeService.findById(id)) ;
    }
    
}

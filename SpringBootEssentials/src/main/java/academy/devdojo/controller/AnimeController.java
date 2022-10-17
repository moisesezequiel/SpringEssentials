package academy.devdojo.controller;

import academy.devdojo.domain.Anime;
import academy.devdojo.dto.AnimePostRequestBody;
import academy.devdojo.dto.AnimePutRequestBody;
import academy.devdojo.service.AnimeService;
import academy.devdojo.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("animes")
@Log4j2
@AllArgsConstructor
public class AnimeController {
     private DateUtil dateUtil;
    @Autowired
    private AnimeService animeService;

	//  @Autowired  NJECAO DE DEPENDENCIA nao indicado, indicado mesmo iniciar no construtor
   // private DateUtil dateUtil; I

    @GetMapping
    public ResponseEntity<Page<Anime>> list(Pageable pageable){
      //  log.info(dateUtil.formatLocalDate(LocalDateTime.now()));
      //  return  new ResponseEntity<>(animeService.listAll(), HttpStatus.OK) ;
        return   ResponseEntity.ok(animeService.listAll(pageable)) ;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity <Anime> findById(@PathVariable long id){
        return   ResponseEntity.ok(animeService.findByIdOrThrowBadRequestException(id)) ;
    }

    @GetMapping(path = "/find")
    public ResponseEntity <List<Anime>> findByName(@RequestParam String name){//http://localhost:8080/animes/find?name=cod
        return   ResponseEntity.ok(animeService.findByName(name)) ;
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED) opcional aqui ou como parametro dentro do retorno
    public ResponseEntity<Anime>save(@RequestBody  @Valid    AnimePostRequestBody animePostRequestBody){
        return new ResponseEntity<>(animeService.save(animePostRequestBody),HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    //deletando nao e necessario retorno
    public ResponseEntity <Void> delete(@PathVariable long id){
        animeService.delete(id);
        return  new  ResponseEntity<>(HttpStatus.NO_CONTENT) ;
    }//Response so declarando no content

    @PutMapping
    public ResponseEntity <Void> replace(@RequestBody AnimePutRequestBody animePutRequestBody){
        animeService.replace(animePutRequestBody);
        return  new  ResponseEntity<>(HttpStatus.NO_CONTENT) ;
    }
}

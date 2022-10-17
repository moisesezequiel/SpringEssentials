package academy.devdojo.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AnimePostRequestBody {

    @NotEmpty(message = "Anime naão pode ter o nome vazio")
    @NotNull(message = "Anime não pode ser null")
    private String name;
}

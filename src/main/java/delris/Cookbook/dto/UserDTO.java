package delris.Cookbook.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import delris.Cookbook.entities.Recipe;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @JsonProperty("id")
    private long userId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("nickname")
    private String nickname;
    @JsonProperty("recipeList")
    private List<RecipeDTO> recipeList;
}

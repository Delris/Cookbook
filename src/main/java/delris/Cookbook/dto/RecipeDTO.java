package delris.Cookbook.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import delris.Cookbook.entities.Formula;
import delris.Cookbook.entities.Ingredient;
import delris.Cookbook.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDTO {
    @JsonProperty("id")
    private long recipeId;
    @JsonProperty("ingredients")
    private List<IngredientDTO> ingredients;
    @JsonProperty("formula")
    private FormulaDTO formula;
    @JsonProperty("userId")
    private long userId;
}

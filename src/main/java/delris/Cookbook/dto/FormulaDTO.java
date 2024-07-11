package delris.Cookbook.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import delris.Cookbook.entities.Recipe;
import delris.Cookbook.entities.RecipeStep;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FormulaDTO {
    @JsonProperty("id")
    private long formulaId;
    @JsonProperty("recipe")
    private Recipe recipe;
    @JsonProperty("recipeSteps")
    private List<RecipeStep> recipeSteps;
}

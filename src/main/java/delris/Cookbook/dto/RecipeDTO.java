package delris.Cookbook.dto;

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
    int id;
    List<IngredientDTO> listOfIngredients;
    FormulaDTO formulaDTO;
}

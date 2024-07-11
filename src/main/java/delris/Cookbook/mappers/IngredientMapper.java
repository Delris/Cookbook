package delris.Cookbook.mappers;

import delris.Cookbook.dto.IngredientDTO;
import delris.Cookbook.dto.RecipeDTO;
import delris.Cookbook.entities.Ingredient;
import delris.Cookbook.entities.Recipe;
import org.mapstruct.Mapper;

import java.util.List;

public interface IngredientMapper {
    Ingredient toIngredient(IngredientDTO ingredientDTO);
    IngredientDTO toIngredientDTO(Ingredient ingredient);
    List<IngredientDTO> toIngredientDTOs(List<Ingredient> ingretientsList);
    List<Ingredient> toIngredients(List<IngredientDTO> ingredientDTOList);
}

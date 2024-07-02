package delris.Cookbook.mappers;


import delris.Cookbook.dto.RecipeDTO;
import delris.Cookbook.entities.Recipe;
import delris.Cookbook.entities.User;
import delris.Cookbook.repositories.UserRepository;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecipeMapper {
    Recipe toRecipe(RecipeDTO recipeDTO);
    RecipeDTO toRecipeDTO(Recipe recipe);
    List<RecipeDTO> toRecipeDTOs(List<Recipe> recipeList);
    List<Recipe> toRecipes(List<RecipeDTO> recipeDTOList);
}

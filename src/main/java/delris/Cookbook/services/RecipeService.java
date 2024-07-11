package delris.Cookbook.services;

import delris.Cookbook.dto.RecipeDTO;
import delris.Cookbook.entities.Recipe;
import delris.Cookbook.mappers.FormulaMapper;
import delris.Cookbook.mappers.IngredientMapper;
import delris.Cookbook.mappers.RecipeMapper;
import delris.Cookbook.repositories.FormulaRepository;
import delris.Cookbook.repositories.IngredientRepository;
import delris.Cookbook.repositories.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;

    public List<RecipeDTO> findAll(){
       return recipeMapper.toRecipeDTOs(recipeRepository.findAll());
    }

    public RecipeDTO findById(Long id){
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if(recipe.isPresent()) {
            return recipeMapper.toRecipeDTO(recipe.get());
        }else{
            return new RecipeDTO();
        }
    }

    public RecipeDTO findByName(String name){
        Optional<Recipe> recipe = recipeRepository.findByName(name);
        if (recipe.isPresent()){
            return recipeMapper.toRecipeDTO(recipe.get());
        }
        return new RecipeDTO();
    }
    public List<RecipeDTO> find50MostRecentEntries(){
        Optional<List<Recipe>> recipeList = recipeRepository.find50MostRecentEntries();
        if(recipeList.isPresent()){
            return recipeMapper.toRecipeDTOs(recipeList.get());
        }else{
            return List.of();
        }
    }

    public List<RecipeDTO> findAllByUser(){
        return List.of();
    }

    public RecipeDTO createRecipe(RecipeDTO recipeDTO){
        Recipe recipe = recipeMapper.toRecipe(recipeDTO);
        Recipe createdRecipe = recipeRepository.save(recipe);

        return recipeMapper.toRecipeDTO(createdRecipe);
    }
}

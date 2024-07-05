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


@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;

    public List<RecipeDTO> findAll(){
       return recipeMapper.toRecipeDTOs(recipeRepository.findAll());
    }

    public RecipeDTO findById(Long id){
        if(recipeRepository.findById(id).isPresent()) {
            return recipeMapper.toRecipeDTO(recipeRepository.findById(id).get());
        }else{
            return new RecipeDTO();
        }
    }

    public RecipeDTO findByName(String name){
        if(recipeRepository.findByName(name).isPresent()){
            return recipeMapper.toRecipeDTO(recipeRepository.findByName(name).get());
        }else{
            return new RecipeDTO();
        }
    }
    public List<RecipeDTO> find50MostRecentEntries(){
        if(recipeRepository.find50MostRecentEntries().isPresent()){
            return recipeMapper.toRecipeDTOs(recipeRepository.find50MostRecentEntries().get());
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

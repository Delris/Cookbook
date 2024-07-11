package delris.Cookbook.services;

import delris.Cookbook.dto.IngredientDTO;
import delris.Cookbook.dto.RecipeDTO;
import delris.Cookbook.entities.Ingredient;
import delris.Cookbook.entities.Recipe;
import delris.Cookbook.mappers.FormulaMapper;
import delris.Cookbook.mappers.IngredientMapper;
import delris.Cookbook.mappers.RecipeMapper;
import delris.Cookbook.repositories.FormulaRepository;
import delris.Cookbook.repositories.IngredientRepository;
import delris.Cookbook.repositories.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IngredientService {
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;
    private final FormulaRepository formulaRepository;
    private final IngredientMapper ingredientMapper;
    private final FormulaMapper formulaMapper;
    private final RecipeMapper recipeMapper;

    public List<IngredientDTO> findAll(){
        return ingredientMapper.toIngredientDTOs(ingredientRepository.findAll());
    }
    public IngredientDTO findById(Long id){
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        if(ingredient.isPresent()) {
            return ingredientMapper.toIngredientDTO(ingredient.get());
        }else{
            return new IngredientDTO();
        }
    }
    public IngredientDTO createIngredient(IngredientDTO ingredientDTO){
        Ingredient ingredient = ingredientMapper.toIngredient(ingredientDTO);
        Ingredient createdIngredient = ingredientRepository.save(ingredient);
        return ingredientMapper.toIngredientDTO(createdIngredient);
    }
    public List<IngredientDTO> createIngredientsList(List<IngredientDTO> ingredientDTOList){
        List<Ingredient> ingredients = ingredientMapper.toIngredients(ingredientDTOList);
        List<Ingredient> createdIngredients = new ArrayList<>();
        for(Ingredient ingredient : ingredients){
            createdIngredients.add(ingredientRepository.save(ingredient));
        }
        return ingredientMapper.toIngredientDTOs(createdIngredients);
    }

}

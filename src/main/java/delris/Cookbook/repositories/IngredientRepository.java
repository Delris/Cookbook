package delris.Cookbook.repositories;

import delris.Cookbook.dto.IngredientDTO;
import delris.Cookbook.enums.QuantityUnit;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientRepository {
    List<IngredientDTO> ingredientDTOList = new ArrayList<>();

    public List<IngredientDTO> findAll(){
        return ingredientDTOList;
    }

    public List<IngredientDTO> findIngredientsForRecipe(){
        return ingredientDTOList;
    }

    @PostConstruct
    private void init(){
        ingredientDTOList.add(new IngredientDTO(1, 1, "bacon", 500, QuantityUnit.GRAMS));
        ingredientDTOList.add(new IngredientDTO(2, 1, "eggs", 2, QuantityUnit.PIECE));
    }
}

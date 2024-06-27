package delris.Cookbook.repositories;

import delris.Cookbook.dto.FormulaDTO;
import delris.Cookbook.dto.RecipeDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RecipeRepository {
    private List<RecipeDTO> list = new ArrayList<>();
    FormulaRepository formulaRepository;
    IngredientRepository ingredientRepository;
    RecipeRepository(FormulaRepository formulaRepository, IngredientRepository ingredientRepository){
        this.formulaRepository = formulaRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public List<RecipeDTO> findAll(){
        return list;
    }

    @PostConstruct
    private void init(){
        list.add(new RecipeDTO(1, ingredientRepository.findAll(), formulaRepository.findFormula()));
    }
}

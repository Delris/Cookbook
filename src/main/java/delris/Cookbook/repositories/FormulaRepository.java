package delris.Cookbook.repositories;

import delris.Cookbook.dto.FormulaDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FormulaRepository {
    private FormulaDTO formulaDTO = new FormulaDTO();

    public FormulaDTO findFormula(){
        return formulaDTO;
    }

    @PostConstruct
    private void init(){
       formulaDTO.setRecipeSteps(List.of("Cube the bacon", "Put bacon in cold pan and turn on medium heat", "When bacon is sizzling crack eggs and pour them in the pan", "Stir constantly until consistency matches your taste", "DONE"));

    }
}

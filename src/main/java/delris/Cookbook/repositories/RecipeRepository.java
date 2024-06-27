package delris.Cookbook.repositories;

import delris.Cookbook.dto.RecipeDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecipeRepository {
    private List<RecipeDTO> list;

    List<RecipeDTO> findAll(){
        return list;
    }

    @PostConstruct
    private void init(){

    }
}

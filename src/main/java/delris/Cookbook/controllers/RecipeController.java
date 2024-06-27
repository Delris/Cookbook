package delris.Cookbook.controllers;


import delris.Cookbook.dto.RecipeDTO;
import delris.Cookbook.repositories.RecipeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecipeController {
    private final RecipeRepository recipeRepository;

    public RecipeController(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }


    @GetMapping("/recipes")
    List<RecipeDTO> findAll(){
        return recipeRepository.findAll();
    }
}

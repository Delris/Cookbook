package delris.Cookbook.controllers;


import delris.Cookbook.dto.RecipeDTO;
import delris.Cookbook.entities.Recipe;
import delris.Cookbook.services.RecipeService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService){
        this.recipeService = recipeService;
    }


    @GetMapping("/recipes/all")
    public ResponseEntity<List<RecipeDTO>> findAll(){
        return ResponseEntity.ok(recipeService.findAll());
    }

    @GetMapping("/recipe/{id}")
    public ResponseEntity<RecipeDTO> findById(@PathVariable("id") Long id){
            return ResponseEntity.ok(recipeService.findById(id));
    }
    @PostMapping("/recipe")
    public ResponseEntity<RecipeDTO> createRecipe(@RequestBody RecipeDTO recipeDTO){
        RecipeDTO createdRecipeDTO = recipeService.createRecipe(recipeDTO);
        return ResponseEntity.created(URI.create("/api/recipe" + createdRecipeDTO.getRecipeId())).body(createdRecipeDTO);
    }
}

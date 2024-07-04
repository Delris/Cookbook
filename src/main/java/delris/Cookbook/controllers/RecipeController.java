package delris.Cookbook.controllers;


import delris.Cookbook.dto.RecipeDTO;
import delris.Cookbook.security.AccessConstants;
import delris.Cookbook.services.RecipeService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping("/recipes/{id}")
    public ResponseEntity<RecipeDTO> findById(@PathVariable("id") Long id){
            return ResponseEntity.ok(recipeService.findById(id));
    }

    @GetMapping("/recipes/name")
    public ResponseEntity<RecipeDTO> findByName(@Param("name") String name){
        return ResponseEntity.ok(recipeService.findByName(name));
    }

    @PreAuthorize(AccessConstants.permitAllRoles)
    @PostMapping("/recipe")
    public ResponseEntity<RecipeDTO> createRecipe(@RequestBody RecipeDTO recipeDTO){
        RecipeDTO createdRecipeDTO = recipeService.createRecipe(recipeDTO);
        return ResponseEntity.created(URI.create("/api/recipe" + createdRecipeDTO.getRecipeId())).body(createdRecipeDTO);
    }
}

package delris.Cookbook.controllers;


import delris.Cookbook.dto.RecipeDTO;
import delris.Cookbook.security.AccessConstants;
import delris.Cookbook.services.RecipeService;
import delris.Cookbook.services.UserService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RecipeController {
    private final RecipeService recipeService;
    private final UserService userService;
    private final Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    public RecipeController(RecipeService recipeService, UserService userService){
        this.recipeService = recipeService;
        this.userService = userService;
    }

    @GetMapping("/recipes")
    public ResponseEntity<List<RecipeDTO>> find50MostRecentEntries(){
        return ResponseEntity.ok(recipeService.find50MostRecentEntries());
    }

    @PreAuthorize(AccessConstants.permitAdmin)
    @GetMapping("/recipes/all")
    public ResponseEntity<List<RecipeDTO>> findAll(){
        return ResponseEntity.ok(recipeService.findAll());
    }

    @PreAuthorize(AccessConstants.permitAllRoles)
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
        recipeDTO.setUserId(userService.findByUsername(auth.getPrincipal().toString()).getUserId());
        RecipeDTO createdRecipeDTO = recipeService.createRecipe(recipeDTO);
        return ResponseEntity.created(URI.create("/api/recipe" + createdRecipeDTO.getRecipeId())).body(createdRecipeDTO);
    }
}

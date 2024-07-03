package delris.Cookbook.mappers;

import delris.Cookbook.dto.FormulaDTO;
import delris.Cookbook.dto.IngredientDTO;
import delris.Cookbook.dto.RecipeDTO;
import delris.Cookbook.entities.Formula;
import delris.Cookbook.entities.Ingredient;
import delris.Cookbook.entities.Recipe;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-03T15:25:50+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class RecipeMapperImpl implements RecipeMapper {

    @Override
    public Recipe toRecipe(RecipeDTO recipeDTO) {
        if ( recipeDTO == null ) {
            return null;
        }

        Recipe recipe = new Recipe();

        recipe.setRecipeId( recipeDTO.getRecipeId() );
        recipe.setIngredients( ingredientDTOListToIngredientList( recipeDTO.getIngredients() ) );
        recipe.setFormula( formulaDTOToFormula( recipeDTO.getFormula() ) );

        return recipe;
    }

    @Override
    public RecipeDTO toRecipeDTO(Recipe recipe) {
        if ( recipe == null ) {
            return null;
        }

        RecipeDTO recipeDTO = new RecipeDTO();

        recipeDTO.setRecipeId( recipe.getRecipeId() );
        recipeDTO.setIngredients( ingredientListToIngredientDTOList( recipe.getIngredients() ) );
        recipeDTO.setFormula( formulaToFormulaDTO( recipe.getFormula() ) );

        return recipeDTO;
    }

    @Override
    public List<RecipeDTO> toRecipeDTOs(List<Recipe> recipeList) {
        if ( recipeList == null ) {
            return null;
        }

        List<RecipeDTO> list = new ArrayList<RecipeDTO>( recipeList.size() );
        for ( Recipe recipe : recipeList ) {
            list.add( toRecipeDTO( recipe ) );
        }

        return list;
    }

    @Override
    public List<Recipe> toRecipes(List<RecipeDTO> recipeDTOList) {
        if ( recipeDTOList == null ) {
            return null;
        }

        List<Recipe> list = new ArrayList<Recipe>( recipeDTOList.size() );
        for ( RecipeDTO recipeDTO : recipeDTOList ) {
            list.add( toRecipe( recipeDTO ) );
        }

        return list;
    }

    protected Ingredient ingredientDTOToIngredient(IngredientDTO ingredientDTO) {
        if ( ingredientDTO == null ) {
            return null;
        }

        Ingredient ingredient = new Ingredient();

        ingredient.setName( ingredientDTO.getName() );
        ingredient.setQuantity( ingredientDTO.getQuantity() );
        ingredient.setQuantityUnit( ingredientDTO.getQuantityUnit() );

        return ingredient;
    }

    protected List<Ingredient> ingredientDTOListToIngredientList(List<IngredientDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Ingredient> list1 = new ArrayList<Ingredient>( list.size() );
        for ( IngredientDTO ingredientDTO : list ) {
            list1.add( ingredientDTOToIngredient( ingredientDTO ) );
        }

        return list1;
    }

    protected Formula formulaDTOToFormula(FormulaDTO formulaDTO) {
        if ( formulaDTO == null ) {
            return null;
        }

        Formula formula = new Formula();

        formula.setFormulaId( formulaDTO.getFormulaId() );
        List<String> list = formulaDTO.getRecipeSteps();
        if ( list != null ) {
            formula.setRecipeSteps( new ArrayList<String>( list ) );
        }
        formula.setRecipe( formulaDTO.getRecipe() );

        return formula;
    }

    protected IngredientDTO ingredientToIngredientDTO(Ingredient ingredient) {
        if ( ingredient == null ) {
            return null;
        }

        IngredientDTO ingredientDTO = new IngredientDTO();

        ingredientDTO.setName( ingredient.getName() );
        ingredientDTO.setQuantity( ingredient.getQuantity() );
        ingredientDTO.setQuantityUnit( ingredient.getQuantityUnit() );

        return ingredientDTO;
    }

    protected List<IngredientDTO> ingredientListToIngredientDTOList(List<Ingredient> list) {
        if ( list == null ) {
            return null;
        }

        List<IngredientDTO> list1 = new ArrayList<IngredientDTO>( list.size() );
        for ( Ingredient ingredient : list ) {
            list1.add( ingredientToIngredientDTO( ingredient ) );
        }

        return list1;
    }

    protected FormulaDTO formulaToFormulaDTO(Formula formula) {
        if ( formula == null ) {
            return null;
        }

        FormulaDTO formulaDTO = new FormulaDTO();

        formulaDTO.setFormulaId( formula.getFormulaId() );
        formulaDTO.setRecipe( formula.getRecipe() );
        List<String> list = formula.getRecipeSteps();
        if ( list != null ) {
            formulaDTO.setRecipeSteps( new ArrayList<String>( list ) );
        }

        return formulaDTO;
    }
}

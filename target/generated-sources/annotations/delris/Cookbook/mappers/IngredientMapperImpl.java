package delris.Cookbook.mappers;

import delris.Cookbook.dto.IngredientDTO;
import delris.Cookbook.entities.Ingredient;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-04T13:11:27+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class IngredientMapperImpl implements IngredientMapper {

    @Override
    public Ingredient toIngredient(IngredientDTO ingredientDTO) {
        if ( ingredientDTO == null ) {
            return null;
        }

        Ingredient ingredient = new Ingredient();

        ingredient.setName( ingredientDTO.getName() );
        ingredient.setQuantity( ingredientDTO.getQuantity() );
        ingredient.setQuantityUnit( ingredientDTO.getQuantityUnit() );

        return ingredient;
    }

    @Override
    public IngredientDTO toIngredientDTO(Ingredient ingredient) {
        if ( ingredient == null ) {
            return null;
        }

        IngredientDTO ingredientDTO = new IngredientDTO();

        ingredientDTO.setName( ingredient.getName() );
        ingredientDTO.setQuantity( ingredient.getQuantity() );
        ingredientDTO.setQuantityUnit( ingredient.getQuantityUnit() );

        return ingredientDTO;
    }

    @Override
    public List<IngredientDTO> toIngredientDTOs(List<Ingredient> ingretientsList) {
        if ( ingretientsList == null ) {
            return null;
        }

        List<IngredientDTO> list = new ArrayList<IngredientDTO>( ingretientsList.size() );
        for ( Ingredient ingredient : ingretientsList ) {
            list.add( toIngredientDTO( ingredient ) );
        }

        return list;
    }

    @Override
    public List<Ingredient> toIngredients(List<IngredientDTO> ingredientDTOList) {
        if ( ingredientDTOList == null ) {
            return null;
        }

        List<Ingredient> list = new ArrayList<Ingredient>( ingredientDTOList.size() );
        for ( IngredientDTO ingredientDTO : ingredientDTOList ) {
            list.add( toIngredient( ingredientDTO ) );
        }

        return list;
    }
}

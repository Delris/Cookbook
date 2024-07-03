package delris.Cookbook.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import delris.Cookbook.entities.Recipe;
import delris.Cookbook.enums.EQuantityUnit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDTO {
    @JsonProperty("id")
    private long ingretientId;
    @JsonProperty("recipe")
    private Recipe recipe;
    @JsonProperty("name")
    private String name;
    @JsonProperty("quantity")
    private double quantity;
    @JsonProperty("unit")
    private EQuantityUnit quantityUnit;
}

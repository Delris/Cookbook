package delris.Cookbook.dto;

import delris.Cookbook.enums.QuantityUnit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDTO {
    int id;
    String name;
    double quantity;
    QuantityUnit quantityUnit;
}

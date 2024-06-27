package delris.Cookbook.enums;

import lombok.Getter;
import lombok.Setter;

import java.util.stream.Stream;

@Getter
public enum QuantityUnit {
    GRAMS("g"),
    KILOGRAMS("kg"),
    MILLILITERS("ml"),
    LITERS("l"),
    CUPS("cups"),
    TABLESPOONS("tbsp"),
    TEASPOONS("tsp"),
    PIECE("pcs");

    private final String unitOfQuantity;

    QuantityUnit(String unitOfQuantity){
        this.unitOfQuantity = unitOfQuantity;
    }

    public static Stream<QuantityUnit> stream() {
        return Stream.of(QuantityUnit.values());
    }

}

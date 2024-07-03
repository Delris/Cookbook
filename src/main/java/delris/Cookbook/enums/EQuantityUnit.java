package delris.Cookbook.enums;

import lombok.Getter;
import lombok.Setter;

import java.util.stream.Stream;

@Getter
public enum EQuantityUnit {
    GRAMS("g"),
    KILOGRAMS("kg"),
    MILLILITERS("ml"),
    LITERS("l"),
    CUPS("cups"),
    TABLESPOONS("tbsp"),
    TEASPOONS("tsp"),
    PIECE("pcs");

    private final String unitOfQuantity;

    EQuantityUnit(String unitOfQuantity){
        this.unitOfQuantity = unitOfQuantity;
    }

    public static Stream<EQuantityUnit> stream() {
        return Stream.of(EQuantityUnit.values());
    }

}

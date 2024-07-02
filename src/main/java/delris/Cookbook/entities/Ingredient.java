package delris.Cookbook.entities;

import delris.Cookbook.enums.QuantityUnit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ingredientId;
    @ManyToMany(mappedBy = "ingredients")
    private List<Recipe> recipes;
    private String name;
    private double quantity;
    private QuantityUnit quantityUnit;
}

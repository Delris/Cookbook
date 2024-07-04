package delris.Cookbook.entities;

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
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long recipeId;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "recipe_ingredients",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<Ingredient> ingredients;
    @OneToOne
    @JoinColumn(name = "formula_Id")
    private Formula formula;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

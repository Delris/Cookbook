package delris.Cookbook.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "formula")
public class Formula {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long formulaId;
    @OneToMany
    private List<RecipeStep> recipeSteps;
    @OneToOne
    @JoinColumn(name = "recipe_Id")
    private Recipe recipe;

}

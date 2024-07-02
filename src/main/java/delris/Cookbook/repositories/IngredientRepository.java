package delris.Cookbook.repositories;

import delris.Cookbook.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}

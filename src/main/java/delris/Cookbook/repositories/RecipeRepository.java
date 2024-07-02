package delris.Cookbook.repositories;

import delris.Cookbook.entities.Formula;
import delris.Cookbook.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}

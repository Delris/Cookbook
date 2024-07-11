package delris.Cookbook.repositories;

import delris.Cookbook.entities.Formula;
import delris.Cookbook.entities.Recipe;
import org.hibernate.annotations.processing.SQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    String find50MostRecentEntries = "SELECT * FROM recipe ORDER BY created FETCH FIRST 50 ROWS ONLY";



    public Optional<Recipe> findByName(String name);

    @Query(value = find50MostRecentEntries, nativeQuery = true)
    public Optional<List<Recipe>> find50MostRecentEntries();

}

package delris.Cookbook.repositories;

import delris.Cookbook.entities.Formula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface FormulaRepository extends JpaRepository<Formula, Long> {

}

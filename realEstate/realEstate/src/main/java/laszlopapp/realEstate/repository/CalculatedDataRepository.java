package laszlopapp.realEstate.repository;
import laszlopapp.realEstate.model.CalculationResultLog;
import org.springframework.data.repository.CrudRepository;

public interface CalculatedDataRepository extends CrudRepository<CalculationResultLog, Long> {
}

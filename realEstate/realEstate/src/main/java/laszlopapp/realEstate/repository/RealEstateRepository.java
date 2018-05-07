package laszlopapp.realEstate.repository;
import laszlopapp.realEstate.model.RealEstate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface RealEstateRepository extends CrudRepository<RealEstate, Long> {

    @Query(value = "SELECT * FROM realestate.real_estate", nativeQuery = true)
    List<RealEstate> listAll();
}

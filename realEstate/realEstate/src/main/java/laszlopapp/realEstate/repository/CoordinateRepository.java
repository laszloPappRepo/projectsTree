package laszlopapp.realEstate.repository;
import laszlopapp.realEstate.model.RealEstate;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoordinateRepository extends CrudRepository<RealEstate,Long> {

    List<RealEstate> findAllByLatitude(Double latitude);
    List<RealEstate> findAllByLongitude(Double longitude);
}

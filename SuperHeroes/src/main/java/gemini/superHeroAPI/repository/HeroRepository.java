package gemini.superHeroAPI.repository;

import gemini.superHeroAPI.model.HeroResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HeroRepository extends CrudRepository<HeroResponse, Long> {
    @Query(value = "SELECT * FROM superhero.hero_response", nativeQuery = true)
    List<HeroResponse> listAll();
}

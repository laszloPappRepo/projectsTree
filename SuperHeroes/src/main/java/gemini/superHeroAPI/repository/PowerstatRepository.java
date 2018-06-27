package gemini.superHeroAPI.repository;

import gemini.superHeroAPI.model.Powerstats;
import org.springframework.data.repository.CrudRepository;

public interface PowerstatRepository extends CrudRepository<Powerstats, Long> {
}

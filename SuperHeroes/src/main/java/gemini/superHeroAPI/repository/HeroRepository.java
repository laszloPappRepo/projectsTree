package gemini.superHeroAPI.repository;

import gemini.superHeroAPI.modell.HeroResponse;
import org.springframework.data.repository.CrudRepository;

public interface HeroRepository extends CrudRepository<HeroResponse, Long> {
}

package gemini.superHeroAPI.repository;

import gemini.superHeroAPI.model.HeroResponse;
import org.springframework.data.repository.CrudRepository;

public interface HeroRepository extends CrudRepository<HeroResponse, Long> {
}

package gemini.superHeroAPI.repository;

import gemini.superHeroAPI.model.Biography;
import org.springframework.data.repository.CrudRepository;

public interface BiographyRepository extends CrudRepository<Biography, Long> {
}

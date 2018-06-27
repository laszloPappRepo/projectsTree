package gemini.superHeroAPI.repository;

import gemini.superHeroAPI.model.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, Long> {
}

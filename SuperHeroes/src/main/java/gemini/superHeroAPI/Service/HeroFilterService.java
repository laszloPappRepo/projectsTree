package gemini.superHeroAPI.Service;
import gemini.superHeroAPI.model.HeroResponse;
import gemini.superHeroAPI.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("HeroFilterService")
public class HeroFilterService {

    @Autowired
    private HeroRepository heroRepository;

    public HeroResponse findLeagueMemberByName(String name) {
        if (heroRepository.listAll().size() > 0) {
            for (int i = 0; i < heroRepository.listAll().size(); i++) {
                if (heroRepository.listAll().get(i).getName().equals(name)) {
                    return heroRepository.listAll().get(i);
                }
            }
        }
        return null;
    }
}

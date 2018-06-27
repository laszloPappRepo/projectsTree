package gemini.superHeroAPI.Service;
import gemini.superHeroAPI.model.HeroResponse;
import org.springframework.stereotype.Service;
import retrofit2.Call;

@Service
public final class SuperHeroApiService {

    private HeroApiService heroApiService;

    public HeroResponse getHeroResponseFromSuperHeroAPIByID(Long id) throws Exception {
        heroApiService = HeroApiService.retrofit.create(HeroApiService.class);
        Call<HeroResponse> call = heroApiService.getHeroByID(id);
        return call.execute().body();
    }

    public HeroResponse getHeroResponseFromSuperHeroAPIByName(String name) throws Exception {
        heroApiService = HeroApiService.retrofit.create(HeroApiService.class);
        Call<HeroResponse> call = heroApiService.getHeroByName(name);
        return call.execute().body();
    }
}


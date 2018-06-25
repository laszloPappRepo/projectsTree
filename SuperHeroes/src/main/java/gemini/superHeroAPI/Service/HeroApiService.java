package gemini.superHeroAPI.Service;

import gemini.superHeroAPI.model.HeroResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HeroApiService {

    String apiURL = "http://superheroapi.com/api/1798381083516711/";

    @GET("{id}")
    Call<HeroResponse> getHeroByID(@Path("id") Long id);

    @GET("search/{name}")
    Call<HeroResponse> getHeroByName(@Path("name") String name);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(apiURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
}

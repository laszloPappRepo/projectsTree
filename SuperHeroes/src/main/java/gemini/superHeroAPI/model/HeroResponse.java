package gemini.superHeroAPI.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashMap;

@Entity
public class HeroResponse {

    private String response;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private HashMap<PowerStats, Integer> powerStats;
    private HashMap<Biography, String> biography;
    private HashMap<Appearance, String> appearance;
    private HashMap<Work, String> work;
    private HashMap<Connections, String> connections;
    private String image;

    public HeroResponse() {
    }

    public HeroResponse(String response, Long id, String name, HashMap<PowerStats, Integer> powerStats,
                        HashMap<Biography, String> biography, HashMap<Appearance, String> appearance,
                        HashMap<Work, String> work, HashMap<Connections, String> connections, String image) {
        this.response = response;
        this.id = id;
        this.name = name;
        this.powerStats = powerStats;
        this.biography = biography;
        this.appearance = appearance;
        this.work = work;
        this.connections = connections;
        this.image = image;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<PowerStats, Integer> getPowerStats() {
        return powerStats;
    }

    public void setPowerStats(HashMap<PowerStats, Integer> powerStats) {
        this.powerStats = powerStats;
    }

    public HashMap<Biography, String> getBiography() {
        return biography;
    }

    public void setBiography(HashMap<Biography, String> biography) {
        this.biography = biography;
    }

    public HashMap<Appearance, String> getAppearance() {
        return appearance;
    }

    public void setAppearance(HashMap<Appearance, String> appearance) {
        this.appearance = appearance;
    }

    public HashMap<Work, String> getWork() {
        return work;
    }

    public void setWork(HashMap<Work, String> work) {
        this.work = work;
    }

    public HashMap<Connections, String> getConnections() {
        return connections;
    }

    public void setConnections(HashMap<Connections, String> connections) {
        this.connections = connections;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

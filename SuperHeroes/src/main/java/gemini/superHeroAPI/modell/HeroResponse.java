package gemini.superHeroAPI.modell;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HeroResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    public HeroResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

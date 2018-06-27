package gemini.superHeroAPI.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Entity;
import javax.persistence.Id;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "occupation",
        "base"
})

@Entity
public class Work {

    @Id
    private Long id;

    @JsonProperty("occupation")
    private String occupation;
    @JsonProperty("base")
    private String base;

    @JsonProperty("occupation")
    public String getOccupation() {
        return occupation;
    }

    @JsonProperty("base")
    public String getBase() {
        return base;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
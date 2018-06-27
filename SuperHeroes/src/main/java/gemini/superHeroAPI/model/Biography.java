package gemini.superHeroAPI.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "full-name",
        "alter-egos",
        "aliases",
        "place-of-birth",
        "first-appearance",
        "publisher",
        "alignment"
})

@Entity
public class Biography {

    @Id
    private Long id;

    @JsonProperty("full-name")
    public String fullName;
    @JsonProperty("alter-egos")
    public String alteregos;
    @ElementCollection
    @JsonProperty("aliases")
    private List<String> aliases = null;
    @JsonProperty("place-of-birth")
    public String birth;
    @JsonProperty("first-appearance")
    public String appearance;
    @JsonProperty("publisher")
    private String publisher;
    @JsonProperty("alignment")
    private String alignment;

    @JsonProperty("full-name")
    public String getFullName() {
        return fullName;
    }

    @JsonProperty("alter-egos")
    public String getAlterEgos() {
        return alteregos;
    }

    @JsonProperty("aliases")
    public List<String> getAliases() {
        return aliases;
    }

    @JsonProperty("place-of-birth")
    public String getPlaceOfBirth() {
        return birth;
    }

    @JsonProperty("first-appearance")
    public String getFirstAppearance() {
        return appearance;
    }

    @JsonProperty("publisher")
    public String getPublisher() {
        return publisher;
    }

    @JsonProperty("alignment")
    public String getAlignment() {
        return alignment;
    }

    public Long getId() {
        return id;
    }

    public String getFullname() {
        return fullName;
    }

    public String getAlteregos() {
        return alteregos;
    }

    public String getBirth() {
        return birth;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
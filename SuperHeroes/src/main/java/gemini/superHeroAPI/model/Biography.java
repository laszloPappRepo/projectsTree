package gemini.superHeroAPI.model;
import com.fasterxml.jackson.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class Biography {

    @JsonProperty("full-name")
    private String fullName;
    @JsonProperty("alter-egos")
    private String alterEgos;
    @JsonProperty("aliases")
    private List<String> aliases = null;
    @JsonProperty("place-of-birth")
    private String placeOfBirth;
    @JsonProperty("first-appearance")
    private String firstAppearance;
    @JsonProperty("publisher")
    private String publisher;
    @JsonProperty("alignment")
    private String alignment;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("full-name")
    public String getFullName() {
        return fullName;
    }

    @JsonProperty("full-name")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @JsonProperty("alter-egos")
    public String getAlterEgos() {
        return alterEgos;
    }

    @JsonProperty("alter-egos")
    public void setAlterEgos(String alterEgos) {
        this.alterEgos = alterEgos;
    }

    @JsonProperty("aliases")
    public List<String> getAliases() {
        return aliases;
    }

    @JsonProperty("aliases")
    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    @JsonProperty("place-of-birth")
    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    @JsonProperty("place-of-birth")
    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    @JsonProperty("first-appearance")
    public String getFirstAppearance() {
        return firstAppearance;
    }

    @JsonProperty("first-appearance")
    public void setFirstAppearance(String firstAppearance) {
        this.firstAppearance = firstAppearance;
    }

    @JsonProperty("publisher")
    public String getPublisher() {
        return publisher;
    }

    @JsonProperty("publisher")
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @JsonProperty("alignment")
    public String getAlignment() {
        return alignment;
    }

    @JsonProperty("alignment")
    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
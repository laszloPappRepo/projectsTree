package gemini.superHeroAPI.model;
import com.fasterxml.jackson.annotation.*;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "occupation",
        "base"
})

public class Work {

    @JsonProperty("occupation")
    private String occupation;
    @JsonProperty("base")
    private String base;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("occupation")
    public String getOccupation() {
        return occupation;
    }

    @JsonProperty("occupation")
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @JsonProperty("base")
    public String getBase() {
        return base;
    }

    @JsonProperty("base")
    public void setBase(String base) {
        this.base = base;
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
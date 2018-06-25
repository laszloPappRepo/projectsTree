package gemini.superHeroAPI.model;
import com.fasterxml.jackson.annotation.*;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "group-affiliation",
        "relatives"
})

public class Connections {

    @JsonProperty("group-affiliation")
    private String groupAffiliation;
    @JsonProperty("relatives")
    private String relatives;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("group-affiliation")
    public String getGroupAffiliation() {
        return groupAffiliation;
    }

    @JsonProperty("group-affiliation")
    public void setGroupAffiliation(String groupAffiliation) {
        this.groupAffiliation = groupAffiliation;
    }

    @JsonProperty("relatives")
    public String getRelatives() {
        return relatives;
    }

    @JsonProperty("relatives")
    public void setRelatives(String relatives) {
        this.relatives = relatives;
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
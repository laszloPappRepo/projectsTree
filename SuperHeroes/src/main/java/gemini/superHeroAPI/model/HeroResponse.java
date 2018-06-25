package gemini.superHeroAPI.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "response",
        "id",
        "name",
        "powerstats",
        "biography",
        "appearance",
        "work",
        "connections",
        "image"
})
@Entity
public class HeroResponse implements Serializable {

    @JsonProperty("response")
    private String response;
    @Id
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @Transient
    @JsonProperty("powerstats")
    private PowerStats powerstats;
    @Transient
    @JsonProperty("biography")
    private Biography biography;
    @Transient
    @JsonProperty("appearance")
    private Appearance appearance;
    @Transient
    @JsonProperty("work")
    private Work work;
    @Transient
    @JsonProperty("connections")
    private Connections connections;
    @Transient
    @JsonProperty("image")
    private Image image;
    @Transient
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("response")
    public String getResponse() {
        return response;
    }

    @JsonProperty("response")
    public void setResponse(String response) {
        this.response = response;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("powerstats")
    public PowerStats getPowerstats() {
        return powerstats;
    }

    @JsonProperty("powerstats")
    public void setPowerstats(PowerStats powerstats) {
        this.powerstats = powerstats;
    }

    @JsonProperty("biography")
    public Biography getBiography() {
        return biography;
    }

    @JsonProperty("biography")
    public void setBiography(Biography biography) {
        this.biography = biography;
    }

    @JsonProperty("appearance")
    public Appearance getAppearance() {
        return appearance;
    }

    @JsonProperty("appearance")
    public void setAppearance(Appearance appearance) {
        this.appearance = appearance;
    }

    @JsonProperty("work")
    public Work getWork() {
        return work;
    }

    @JsonProperty("work")
    public void setWork(Work work) {
        this.work = work;
    }

    @JsonProperty("connections")
    public Connections getConnections() {
        return connections;
    }

    @JsonProperty("connections")
    public void setConnections(Connections connections) {
        this.connections = connections;
    }

    @JsonProperty("image")
    public Image getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(Image image) {
        this.image = image;
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
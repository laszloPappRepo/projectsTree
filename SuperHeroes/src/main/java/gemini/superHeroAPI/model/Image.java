package gemini.superHeroAPI.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Entity;
import javax.persistence.Id;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "url"
})

@Entity
public class Image {

    @Id
    private Long id;

    @JsonProperty("url")
    private String url;

    @JsonProperty("url")
    public String getUrl() {
            return url;
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

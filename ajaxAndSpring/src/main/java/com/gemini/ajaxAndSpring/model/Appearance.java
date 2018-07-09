package com.gemini.ajaxAndSpring.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "gender",
        "race",
        "height",
        "weight",
        "eye-color",
        "hair-color"
})

@Entity
public class Appearance {

    @Id
    private Long id;

    @JsonProperty("gender")
    private String gender;
    @JsonProperty("race")
    private String race;
    @ElementCollection
    @JsonProperty("height")
    private List<String> height = null;
    @ElementCollection
    @JsonProperty("weight")
    private List<String> weight = null;
    @JsonProperty("eye-color")
    public String eyeColor;
    @JsonProperty("hair-color")
    public String hairColor;

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("race")
    public String getRace() {
        return race;
    }

    @JsonProperty("height")
    public List<String> getHeight() {
        return height;
    }

    @JsonProperty("weight")
    public List<String> getWeight() {
        return weight;
    }

    @JsonProperty("eye-color")
    public String getEyeColor() {
        return eyeColor;
    }

    @JsonProperty("hair-color")
    public String getHairColor() {
        return hairColor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
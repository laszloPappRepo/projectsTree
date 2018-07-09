package com.gemini.ajaxAndSpring.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.persistence.Entity;
import javax.persistence.Id;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "intelligence",
        "strength",
        "speed",
        "durability",
        "power",
        "combat"
})

@Entity
public class Powerstats {

    @Id
    private Long id;

    @JsonProperty("intelligence")
    private String intelligence;
    @JsonProperty("strength")
    private String strength;
    @JsonProperty("speed")
    private String speed;
    @JsonProperty("durability")
    private String durability;
    @JsonProperty("power")
    private String power;
    @JsonProperty("combat")
    private String combat;

    @JsonProperty("intelligence")
    public String getIntelligence() {
        return intelligence;
    }

    @JsonProperty("strength")
    public String getStrength() {
        return strength;
    }

    @JsonProperty("speed")
    public String getSpeed() {
        return speed;
    }

    @JsonProperty("durability")
    public String getDurability() {
        return durability;
    }

    @JsonProperty("power")
    public String getPower() {
        return power;
    }

    @JsonProperty("combat")
    public String getCombat() {
        return combat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
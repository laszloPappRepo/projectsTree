package com.gemini.ajaxAndSpring.model;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "group-affiliation",
        "relatives"
})

@Entity
public class Connections implements Serializable {

    @Id
    private Long id;

    @JsonProperty("group-affiliation")
    public String groupAffiliation;
    @JsonProperty("relatives")
    @Type(type="text")
    public String relatives;
    @Transient
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();
    private final static long serialVersionUID = 6472756285688919808L;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
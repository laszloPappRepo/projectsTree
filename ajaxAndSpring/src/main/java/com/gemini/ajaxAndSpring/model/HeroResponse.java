package com.gemini.ajaxAndSpring.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.io.Serializable;

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
        private Long id;
        @JsonProperty("name")
        private String name;

        @ManyToOne
        @JsonProperty("powerstats")
        private Powerstats powerstats;
        @ManyToOne
        @JsonProperty("biography")
        private Biography biography;
        @ManyToOne
        @JsonProperty("appearance")
        private Appearance appearance;
        @ManyToOne
        @JsonProperty("work")
        private Work work;
        @ManyToOne
        @JsonProperty("connections")
        private Connections connections;
        @ManyToOne
        @JsonProperty("image")
        private Image image;


        @JsonProperty("response")
        public String getResponse() {
            return response;
        }

        @JsonProperty("id")
        public Long getId() {
            return id;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("powerstats")
        public Powerstats getPowerstats() {
            return powerstats;
        }

        @JsonProperty("biography")
        public Biography getBiography() {
            return biography;
        }

        @JsonProperty("appearance")
        public Appearance getAppearance() {
            return appearance;
        }

        @JsonProperty("work")
        public Work getWork() {
            return work;
        }

        @JsonProperty("connections")
        public Connections getConnections() {
            return connections;
        }

        @JsonProperty("image")
        public Image getImage() {
            return image;
        }

        public void setId(Long id) {
                this.id = id;
        }

        @Override
        public String toString() {
                return "HeroResponse{" +
                        "response='" + response + '\'' +
                        ", id=" + id +
                        ", name='" + name + '\'' +
                        ", powerstats=" + powerstats +
                        ", biography=" + biography +
                        ", appearance=" + appearance +
                        ", work=" + work +
                        ", connections=" + connections +
                        ", image=" + image +
                        '}';
        }
}
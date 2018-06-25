package gemini.superHeroAPI.model;
import com.fasterxml.jackson.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "gender",
            "race",
            "height",
            "weight",
            "eye-color",
            "hair-color"
    })
    public class Appearance {

        @JsonProperty("gender")
        private String gender;
        @JsonProperty("race")
        private String race;
        @JsonProperty("height")
        private List<String> height = null;
        @JsonProperty("weight")
        private List<String> weight = null;
        @JsonProperty("eye-color")
        private String eyeColor;
        @JsonProperty("hair-color")
        private String hairColor;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonProperty("gender")
        public String getGender() {
            return gender;
        }

        @JsonProperty("gender")
        public void setGender(String gender) {
            this.gender = gender;
        }

        @JsonProperty("race")
        public String getRace() {
            return race;
        }

        @JsonProperty("race")
        public void setRace(String race) {
            this.race = race;
        }

        @JsonProperty("height")
        public List<String> getHeight() {
            return height;
        }

        @JsonProperty("height")
        public void setHeight(List<String> height) {
            this.height = height;
        }

        @JsonProperty("weight")
        public List<String> getWeight() {
            return weight;
        }

        @JsonProperty("weight")
        public void setWeight(List<String> weight) {
            this.weight = weight;
        }

        @JsonProperty("eye-color")
        public String getEyeColor() {
            return eyeColor;
        }

        @JsonProperty("eye-color")
        public void setEyeColor(String eyeColor) {
            this.eyeColor = eyeColor;
        }

        @JsonProperty("hair-color")
        public String getHairColor() {
            return hairColor;
        }

        @JsonProperty("hair-color")
        public void setHairColor(String hairColor) {
            this.hairColor = hairColor;
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

package gemini.superHeroAPI.model;

import java.util.List;

public class Connections {

     List<String> groupAffiliation;
     List<String> relatives;

    public Connections() {
    }

    public Connections(List<String> groupAffiliation, List<String> relatives) {
        this.groupAffiliation = groupAffiliation;
        this.relatives = relatives;
    }

    public List<String> getGroupAffiliation() {
        return groupAffiliation;
    }

    public void setGroupAffiliation(List<String> groupAffiliation) {
        this.groupAffiliation = groupAffiliation;
    }

    public List<String> getRelatives() {
        return relatives;
    }

    public void setRelatives(List<String> relatives) {
        this.relatives = relatives;
    }
}

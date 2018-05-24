package gemini.superHeroAPI.model;

import java.util.List;

public class Work {

    List<String> occupation;
    List<String> base;

    public Work() {
    }

    public Work(List<String> occupation, List<String> base) {
        this.occupation = occupation;
        this.base = base;
    }

    public List<String> getOccupation() {
        return occupation;
    }

    public void setOccupation(List<String> occupation) {
        this.occupation = occupation;
    }

    public List<String> getBase() {
        return base;
    }

    public void setBase(List<String> base) {
        this.base = base;
    }
}

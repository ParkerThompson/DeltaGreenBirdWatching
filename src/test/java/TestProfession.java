import com.dgbirdwatching.entities.Skill;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class TestProfession {
    private String name;
    private String description;
    private int numOptionalSkills;
    private int bonds;
    private Map<String, Skill> defaultSkills;
    private Map<String, Skill> exclusiveSkills = new HashMap<>();
    private Map<String, Skill> optionalSkills;

    public TestProfession(String name, String description, int numOptionalSkills, int bonds,
                          Map<String, Skill> defaultSkills,
                          Map<String, Skill> exclusiveSkills, Map<String, Skill> optionalSkills) {
        this.name = name;
        this.description = description;
        this.numOptionalSkills = numOptionalSkills;
        this.bonds = bonds;
        this.defaultSkills = defaultSkills;
        this.exclusiveSkills = exclusiveSkills;
        this.optionalSkills = optionalSkills;
    }

    public TestProfession(String name, String description, int numOptionalSkills, int bonds,
                          Map<String, Skill> defaultSkills, Map<String, Skill> optionalSkills) {
        this.name = name;
        this.description = description;
        this.numOptionalSkills = numOptionalSkills;
        this.bonds = bonds;
        this.defaultSkills = defaultSkills;
        this.optionalSkills = optionalSkills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumOptionalSkills() {
        return numOptionalSkills;
    }

    public void setNumOptionalSkills(int numOptionalSkills) {
        this.numOptionalSkills = numOptionalSkills;
    }

    public int getBonds() {
        return bonds;
    }

    public void setBonds(int bonds) {
        this.bonds = bonds;
    }

    public Map<String, Skill> getDefaultSkills() {
        return defaultSkills;
    }

    public void setDefaultSkills(Map<String, Skill> defaultSkills) {
        this.defaultSkills = defaultSkills;
    }

    public Map<String, Skill> getExclusiveSkills() {
        return exclusiveSkills;
    }

    public void setExclusiveSkills(Map<String, Skill> exclusiveSkills) {
        this.exclusiveSkills = exclusiveSkills;
    }

    public Map<String, Skill> getOptionalSkills() {
        return optionalSkills;
    }

    public void setOptionalSkills(Map<String, Skill> optionalSkills) {
        this.optionalSkills = optionalSkills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestProfession that = (TestProfession) o;
        return numOptionalSkills == that.numOptionalSkills && bonds == that.bonds && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(defaultSkills, that.defaultSkills) && Objects.equals(exclusiveSkills, that.exclusiveSkills) && Objects.equals(optionalSkills, that.optionalSkills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, numOptionalSkills, bonds, defaultSkills, exclusiveSkills, optionalSkills);
    }

    @Override
    public String toString() {
        return "TestProfession{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", numOptionalSkills=" + numOptionalSkills +
                ", bonds=" + bonds +
                ", defaultSkills=" + defaultSkills +
                ", exclusiveSkills=" + exclusiveSkills +
                ", optionalSkills=" + optionalSkills +
                '}';
    }
}

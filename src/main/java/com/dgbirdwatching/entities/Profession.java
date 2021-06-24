package com.dgbirdwatching.entities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.List;

public class Profession {
    private String name;
    private String description;
    private int numOptionalSkills;
    private int bonds;
    private List<Employer> employers;
    private List<Weapon> weapons;
    private List<String> education;
    private List<String> equipment;
    private List<Skill> defaultSkills;
    private List<Skill> optionalSkills;


    public Profession() {
    }

    public Profession(String name, String description, int numOptionalSkills, int bonds, List<Employer> employers, List<String> equipment, List<Skill> defaultSkills, List<Skill> optionalSkills) {
        this.name = name;
        this.description = description;
        this.numOptionalSkills = numOptionalSkills;
        this.bonds = bonds;
        this.employers = employers;
        this.equipment = equipment;
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

    public List<String> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<String> equipment) {
        this.equipment = equipment;
    }

    public List<Employer> getEmployers() {
        return employers;
    }

    public void setEmployers(List<Employer> employers) {
        this.employers = employers;
    }

    public List<Skill> getDefaultSkills() {
        return defaultSkills;
    }

    public void setDefaultSkills(List<Skill> defaultSkills) {
        this.defaultSkills = defaultSkills;
    }

    public List<Skill> getOptionalSkills() {
        return optionalSkills;
    }

    public void setOptionalSkills(List<Skill> optionalSkills) {
        this.optionalSkills = optionalSkills;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public List<String> getEducation() {
        return education;
    }

    public void setEducation(List<String> education) {
        this.education = education;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profession)) return false;
        Profession that = (Profession) o;
        return numOptionalSkills == that.numOptionalSkills &&
                bonds == that.bonds &&
                Objects.equal(name, that.name) &&
                Objects.equal(description, that.description) &&
                Objects.equal(employers, that.employers) &&
                Objects.equal(weapons, that.weapons) &&
                Objects.equal(education, that.education) &&
                Objects.equal(equipment, that.equipment) &&
                Objects.equal(defaultSkills, that.defaultSkills) &&
                Objects.equal(optionalSkills, that.optionalSkills);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, description, numOptionalSkills, bonds, employers, weapons, education, equipment, defaultSkills, optionalSkills);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("description", description)
                .add("numOptionalSkills", numOptionalSkills)
                .add("bonds", bonds)
                .add("employers", employers)
                .add("weapons", weapons)
                .add("education", education)
                .add("equipment", equipment)
                .add("defaultSkills", defaultSkills)
                .add("optionalSkills", optionalSkills)
                .toString();
    }
}


/*
{"anthropologist"

{"description"
 "You study humanity. You’re concerned with the patterns that emerge over time, across land masses, cultures, and language groups. You might be a number cruncher, a field worker trudging through the jungle, a consultant in a war zone, or a think-tank analyst sifting myth from history in studies of the Tcho-Tcho peoples.", "skillText"
 "Choose any two of these that you don’t already have
", "numOptionalSkills"
 2, "stats"
["INT"], "bonds"
 4, "employers"
 ["universities", "historyMuseums"], "education"
 ["Masters in Anthropology","PHD in Anthropology"], "weapons"
 [{"key"
 "pepper_spray_can","name"
"Pepper Spray Can"}], "equipment"
 ["Smartphone","Laptop"], "defaultSkills"
 [{"name"
"anthropology", "value"
50, "exclusive"
 "archeology"},{"name"
"foreign-language", "value"
 40},{"name"
"history", "value"
40},{"name"
"occult", "value"
40},{"name"
"persuade", "value"
40}], "optionalSkills"
 [{"name"
"anthropology", "value"
50},{"name"
"archeology", "value"
50},{"name"
"humint", "value"
50},{"name"
"navigate", "value"
50},{"name"
"ride", "value"
50},{"name"
"search", "value"
60},{"name"
"survival", "value"
50}]},

 */
package com.dgbirdwatching.entities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class Bond {
    private static final String GENDER_MALE = "Male";
    private static final String GENDER_FEMALE = "Female";
    private static final String GENDER_ANY = "Any";
    private static final String GENERATION_OLDER = "Older";
    private static final String GENERATION_SAME = "Same";
    private static final String GENERATION_YOUNGER = "Younger";

    private String name;
    private String gender;
    private String isFamily;
    private String generation;

    public Bond() {
    }

    public Bond(String name, String gender, String isFamily) {
        this.name = name;
        this.gender = gender;
        this.isFamily = isFamily;
    }

    public Bond(String name, String gender, String isFamily, String generation) {
        this.name = name;
        this.gender = gender;
        this.isFamily = isFamily;
        this.generation = generation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIsFamily() {
        return isFamily;
    }

    public void setIsFamily(String isFamily) {
        this.isFamily = isFamily;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bond)) return false;
        Bond bond = (Bond) o;
        return Objects.equal(name, bond.name) &&
                Objects.equal(gender, bond.gender) &&
                Objects.equal(isFamily, bond.isFamily) &&
                Objects.equal(generation, bond.generation);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, gender, isFamily, generation);
    }

    @Override
    public String toString() {
        MoreObjects.ToStringHelper out = MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("gender", gender)
                .add("isFamily", isFamily);
        if(generation != null) {
            out.add("generation", generation);
        }
        return out.toString();
    }
}

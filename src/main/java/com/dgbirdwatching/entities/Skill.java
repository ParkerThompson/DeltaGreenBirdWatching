package com.dgbirdwatching.entities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.List;

public class Skill {
    private String name;
    private List<String> randomInputs;
    private int baseValue;
    private int professionBase;
    private Skill exclusive;
    private String input;

    public Skill(String name, int baseValue) {
        this.name = name;
        this.baseValue = baseValue;
    }

    public Skill(String name, int baseValue, List<String> randomInputs) {
        this.name = name;
        this.randomInputs = randomInputs;
        this.baseValue = baseValue;
    }

    public Skill() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRandomInputs() {
        return randomInputs;
    }

    public void setRandomInputs(List<String> randomInputs) {
        this.randomInputs = randomInputs;
    }

    public int getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(int baseValue) {
        this.baseValue = baseValue;
    }

    public int getProfessionBase() {
        return professionBase;
    }

    public void setProfessionBase(int professionBase) {
        this.professionBase = professionBase;
    }

    public Skill getExclusive() {
        return exclusive;
    }

    public void setExclusive(Skill exclusive) {
        this.exclusive = exclusive;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Skill)) return false;
        Skill skill = (Skill) o;
        return baseValue == skill.baseValue &&
                professionBase == skill.professionBase &&
                Objects.equal(name, skill.name) &&
                Objects.equal(randomInputs, skill.randomInputs) &&
                Objects.equal(exclusive, skill.exclusive) &&
                Objects.equal(input, skill.input);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, randomInputs, baseValue, professionBase, exclusive, input);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("randomInputs", randomInputs)
                .add("baseValue", baseValue)
                .add("professionBase", professionBase)
                .add("exclusive", exclusive)
                .add("input", input)
                .toString();
    }
}

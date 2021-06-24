package com.dgbirdwatching.entities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class Employer {
    private String name;
    private String adverb;

    public Employer(String name, String adverb) {
        this.name = name;
        this.adverb = adverb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdverb() {
        return adverb;
    }

    public void setAdverb(String adverb) {
        this.adverb = adverb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employer)) return false;
        Employer employer = (Employer) o;
        return Objects.equal(name, employer.name) &&
                Objects.equal(adverb, employer.adverb);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, adverb);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("adverb", adverb)
                .toString();
    }
}

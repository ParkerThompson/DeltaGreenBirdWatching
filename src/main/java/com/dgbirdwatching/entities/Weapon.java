package com.dgbirdwatching.entities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class Weapon {
    private String ammoCapacity;
    private String damage;
    private String killRadius;
    private String skill;
    private String range;
    private String uses;
    private String armorPiercing;
    private String expense;
    private String radius;
    private String weaponName;
    private String friendlyName;
    private String lethality;

    public Weapon(String ammoCapacity, String damage, String killRadius, String skill, String range, String uses,
                  String armorPiercing, String expense, String radius, String weaponName, String friendlyName,
                  String lethality) {
        this.ammoCapacity = ammoCapacity;
        this.damage = damage;
        this.killRadius = killRadius;
        this.skill = skill;
        this.range = range;
        this.uses = uses;
        this.armorPiercing = armorPiercing;
        this.expense = expense;
        this.radius = radius;
        this.weaponName = weaponName;
        this.friendlyName = friendlyName;
        this.lethality = lethality;
    }

    public String getAmmoCapacity() {
        return ammoCapacity;
    }

    public void setAmmoCapacity(String ammoCapacity) {
        this.ammoCapacity = ammoCapacity;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getKillRadius() {
        return killRadius;
    }

    public void setKillRadius(String killRadius) {
        this.killRadius = killRadius;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getUses() {
        return uses;
    }

    public void setUses(String uses) {
        this.uses = uses;
    }

    public String getArmorPiercing() {
        return armorPiercing;
    }

    public void setArmorPiercing(String armorPiercing) {
        this.armorPiercing = armorPiercing;
    }

    public String getExpense() {
        return expense;
    }

    public void setExpense(String expense) {
        this.expense = expense;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getLethality() {
        return lethality;
    }

    public void setLethality(String lethality) {
        this.lethality = lethality;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weapon)) return false;
        Weapon weapon = (Weapon) o;
        return Objects.equal(ammoCapacity, weapon.ammoCapacity) &&
                Objects.equal(damage, weapon.damage) &&
                Objects.equal(killRadius, weapon.killRadius) &&
                Objects.equal(skill, weapon.skill) &&
                Objects.equal(range, weapon.range) &&
                Objects.equal(uses, weapon.uses) &&
                Objects.equal(armorPiercing, weapon.armorPiercing) &&
                Objects.equal(expense, weapon.expense) &&
                Objects.equal(radius, weapon.radius) &&
                Objects.equal(weaponName, weapon.weaponName) &&
                Objects.equal(friendlyName, weapon.friendlyName) &&
                Objects.equal(lethality, weapon.lethality);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ammoCapacity, damage, killRadius, skill, range, uses, armorPiercing, expense, radius,
                weaponName, friendlyName, lethality);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("ammoCapacity", ammoCapacity)
                .add("damage", damage)
                .add("killRadius", killRadius)
                .add("skill", skill)
                .add("range", range)
                .add("uses", uses)
                .add("armorPiercing", armorPiercing)
                .add("expense", expense)
                .add("radius", radius)
                .add("weaponName", weaponName)
                .add("friendlyName", friendlyName)
                .add("lethality", lethality)
                .toString();
    }
}

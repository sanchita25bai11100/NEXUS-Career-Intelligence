package com.nexus.model;

public class Skill {

    private String name;
    private String category;
    private int proficiency;

    public Skill(String name, String category, int proficiency) {
        this.name = name;
        this.category = category;
        this.proficiency = proficiency;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getProficiency() {
        return proficiency;
    }

    public void setProficiency(int proficiency) {
        if (proficiency < 1 || proficiency > 5) {
            throw new IllegalArgumentException(
                "Proficiency must be between 1 and 5."
            );
        }

        this.proficiency = proficiency;
    }

    @Override
    public String toString() {
        return name + " (" + category + ", proficiency: "
                + proficiency + "/5)";
    }
}
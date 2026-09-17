package com.nexus.model;

import java.util.ArrayList;
import java.util.List;

public class Career {

    private int careerId;
    private String name;
    private String description;
    private List<Skill> requiredSkills;

    public Career(int careerId, String name, String description) {
        this.careerId = careerId;
        this.name = name;
        this.description = description;
        this.requiredSkills = new ArrayList<>();
    }

    public void addRequiredSkill(Skill skill) {
        if (skill == null) {
            throw new IllegalArgumentException("Required skill cannot be null.");
        }

        requiredSkills.add(skill);
    }

    public int getCareerId() {
        return careerId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Skill> getRequiredSkills() {
        return new ArrayList<>(requiredSkills);
    }

    @Override
    public String toString() {
        return "Career{" +
                "careerId=" + careerId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", requiredSkills=" + requiredSkills +
                '}';
    }
}
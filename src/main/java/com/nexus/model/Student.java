package com.nexus.model;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private int studentId;
    private String name;
    private String program;
    private List<Skill> skills;

    public Student(int studentId, String name, String program) {
        this.studentId = studentId;
        this.name = name;
        this.program = program;
        this.skills = new ArrayList<>();
    }

    public void addSkill(Skill skill) {
        if (skill == null) {
            throw new IllegalArgumentException("Skill cannot be null.");
        }

        skills.add(skill);
    }

    public void removeSkill(String skillName) {
        skills.removeIf(skill ->
                skill.getName().equalsIgnoreCase(skillName));
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getProgram() {
        return program;
    }

    public List<Skill> getSkills() {
        return new ArrayList<>(skills);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", program='" + program + '\'' +
                ", skills=" + skills +
                '}';
    }
}
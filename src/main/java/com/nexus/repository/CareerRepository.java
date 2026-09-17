package com.nexus.repository;

import com.nexus.model.Career;
import com.nexus.model.Skill;

import java.util.ArrayList;
import java.util.List;

public class CareerRepository {

    private final List<Career> careers;

    public CareerRepository() {
        careers = new ArrayList<>();
        loadSampleCareers();
    }

    private void loadSampleCareers() {

        Skill java = new Skill("Java", "Programming", 1);
        Skill sql = new Skill("SQL", "Database", 1);
        Skill git = new Skill("Git", "Version Control", 1);
        Skill dataStructures =
                new Skill("Data Structures", "Computer Science", 1);
        Skill oop =
                new Skill("OOP", "Programming", 1);

        Career javaDeveloper = new Career(
                1,
                "Java Developer",
                "Develops applications using Java and object-oriented programming."
        );

        javaDeveloper.addRequiredSkill(java);
        javaDeveloper.addRequiredSkill(sql);
        javaDeveloper.addRequiredSkill(git);
        javaDeveloper.addRequiredSkill(dataStructures);
        javaDeveloper.addRequiredSkill(oop);

        careers.add(javaDeveloper);
    }

    public List<Career> getAllCareers() {
        return new ArrayList<>(careers);
    }

    public Career findById(int id) {
        for (Career career : careers) {
            if (career.getCareerId() == id) {
                return career;
            }
        }

        return null;
    }
}
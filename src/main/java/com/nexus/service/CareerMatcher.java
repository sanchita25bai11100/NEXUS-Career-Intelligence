package com.nexus.service;

import com.nexus.model.Career;
import com.nexus.model.Skill;
import com.nexus.model.Student;

import java.util.ArrayList;
import java.util.List;

public class CareerMatcher {

    public double calculateCompatibility(Student student, Career career) {
        if (student == null || career == null) {
            throw new IllegalArgumentException(
                    "Student and career cannot be null."
            );
        }

        List<Skill> requiredSkills = career.getRequiredSkills();

        if (requiredSkills.isEmpty()) {
            return 0.0;
        }

        int matchingSkills = 0;

        for (Skill required : requiredSkills) {
            if (hasSkill(student, required.getName())) {
                matchingSkills++;
            }
        }

        return (matchingSkills * 100.0) / requiredSkills.size();
    }

    public List<Skill> getMatchingSkills(Student student, Career career) {
        List<Skill> matchingSkills = new ArrayList<>();

        if (student == null || career == null) {
            throw new IllegalArgumentException(
                    "Student and career cannot be null."
            );
        }

        for (Skill required : career.getRequiredSkills()) {
            if (hasSkill(student, required.getName())) {
                matchingSkills.add(required);
            }
        }

        return matchingSkills;
    }

    private boolean hasSkill(Student student, String skillName) {
        for (Skill skill : student.getSkills()) {
            if (skill.getName().equalsIgnoreCase(skillName)) {
                return true;
            }
        }

        return false;
    }
}
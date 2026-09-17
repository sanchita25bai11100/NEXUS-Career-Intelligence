package com.nexus.service;

import com.nexus.model.Career;
import com.nexus.model.Skill;
import com.nexus.model.Student;

import java.util.ArrayList;
import java.util.List;

public class SkillGapAnalyzer {

    public List<Skill> findSkillGaps(Student student, Career career) {
        if (student == null || career == null) {
            throw new IllegalArgumentException(
                    "Student and career cannot be null."
            );
        }

        List<Skill> gaps = new ArrayList<>();

        for (Skill required : career.getRequiredSkills()) {
            if (!hasSkill(student, required.getName())) {
                gaps.add(required);
            }
        }

        return gaps;
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

package com.nexus.service;

import com.nexus.model.Career;
import com.nexus.model.Skill;
import com.nexus.model.Student;

import java.util.ArrayList;
import java.util.List;

public class RecommendationService {

    private final SkillGapAnalyzer skillGapAnalyzer;

    public RecommendationService() {
        this.skillGapAnalyzer = new SkillGapAnalyzer();
    }

    public List<String> generateRecommendations(
            Student student,
            Career career) {

        if (student == null || career == null) {
            throw new IllegalArgumentException(
                    "Student and career cannot be null."
            );
        }

        List<String> recommendations = new ArrayList<>();
        List<Skill> gaps =
                skillGapAnalyzer.findSkillGaps(student, career);

        if (gaps.isEmpty()) {
            recommendations.add(
                    "You have all the required skills for this career."
            );
            recommendations.add(
                    "Consider building projects to strengthen your profile."
            );
            return recommendations;
        }

        for (Skill skill : gaps) {
            recommendations.add(
                    "Learn or improve: " + skill.getName()
            );
        }

        recommendations.add(
                "Practice the missing skills through projects and exercises."
        );

        recommendations.add(
                "Review your progress regularly and update your skill profile."
        );

        return recommendations;
    }
}
package com.nexus.service;

import com.nexus.model.Career;
import com.nexus.model.Skill;
import com.nexus.model.Student;

import java.util.List;

public class CareerAnalysis {

    private final CareerMatcher careerMatcher;
    private final SkillGapAnalyzer skillGapAnalyzer;
    private final RecommendationService recommendationService;

    public CareerAnalysis() {
        careerMatcher = new CareerMatcher();
        skillGapAnalyzer = new SkillGapAnalyzer();
        recommendationService = new RecommendationService();
    }

    public void generateReport(Student student, Career career) {

        double compatibility =
                careerMatcher.calculateCompatibility(student, career);

        List<Skill> matchingSkills =
                careerMatcher.getMatchingSkills(student, career);

        List<Skill> skillGaps =
                skillGapAnalyzer.findSkillGaps(student, career);

        List<String> recommendations =
                recommendationService.generateRecommendations(
                        student, career);

        System.out.println("\n========================================");
        System.out.println("          NEXUS CAREER REPORT           ");
        System.out.println("========================================");

        System.out.println("Student: " + student.getName());
        System.out.println("Program: " + student.getProgram());
        System.out.println("Career: " + career.getName());

        System.out.printf(
                "Compatibility: %.1f%%%n",
                compatibility
        );

        System.out.println("\nMatching Skills:");

        if (matchingSkills.isEmpty()) {
            System.out.println("- No matching skills found.");
        } else {
            for (Skill skill : matchingSkills) {
                System.out.println("- " + skill.getName());
            }
        }

        System.out.println("\nSkill Gaps:");

        if (skillGaps.isEmpty()) {
            System.out.println("- No major skill gaps identified.");
        } else {
            for (Skill skill : skillGaps) {
                System.out.println("- " + skill.getName());
            }
        }

        System.out.println("\nRecommendations:");

        for (String recommendation : recommendations) {
            System.out.println("- " + recommendation);
        }

        System.out.println("========================================");
    }
}
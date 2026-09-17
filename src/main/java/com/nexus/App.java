package com.nexus;

import com.nexus.model.Career;
import com.nexus.model.Skill;
import com.nexus.model.Student;
import com.nexus.repository.CareerRepository;
import com.nexus.service.CareerAnalysis;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("        NEXUS CAREER INTELLIGENCE       ");
        System.out.println("========================================");

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your academic program: ");
        String program = scanner.nextLine();

        Student student = new Student(1, name, program);

        System.out.println("\nAdd your skills.");
        System.out.println(
                "Available skills: Java, SQL, Git, OOP, Data Structures"
        );

        addSkillIfPresent(
                scanner,
                student,
                "Java",
                "Programming"
        );

        addSkillIfPresent(
                scanner,
                student,
                "SQL",
                "Database"
        );

        addSkillIfPresent(
                scanner,
                student,
                "Git",
                "Version Control"
        );

        addSkillIfPresent(
                scanner,
                student,
                "OOP",
                "Programming"
        );

        addSkillIfPresent(
                scanner,
                student,
                "Data Structures",
                "Computer Science"
        );

        CareerRepository careerRepository =
                new CareerRepository();

        Career career = careerRepository.findById(1);

        if (career == null) {
            System.out.println("Career could not be found.");
            scanner.close();
            return;
        }

        CareerAnalysis analysis =
                new CareerAnalysis();

        analysis.generateReport(student, career);

        scanner.close();
    }

    private static void addSkillIfPresent(
            Scanner scanner,
            Student student,
            String skillName,
            String category) {

        System.out.print(
                "Do you have " + skillName + "? (y/n): "
        );

        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("y")) {

            System.out.print(
                    "Enter your " + skillName +
                    " proficiency (1-5): "
            );

            try {

                int proficiency =
                        Integer.parseInt(scanner.nextLine());

                if (proficiency < 1 || proficiency > 5) {

                    System.out.println(
                            "Invalid proficiency. " +
                            "Skill not added."
                    );

                    return;
                }

                student.addSkill(
                        new Skill(
                                skillName,
                                category,
                                proficiency
                        )
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid number. Skill not added."
                );
            }
        }
    }
}
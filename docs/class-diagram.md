# NEXUS Class Diagram

## Overview

The class structure of NEXUS is designed using Object-Oriented Programming principles. The system separates data entities from the services responsible for processing career and skill information.

## Class Diagram

```mermaid
classDiagram

    class Student {
        -int studentId
        -String name
        -String program
        -List~Skill~ skills
        +addSkill(Skill skill)
        +removeSkill(Skill skill)
        +getSkills()
    }

    class Skill {
        -String name
        -String category
        -int proficiency
        +getName()
        +getCategory()
        +getProficiency()
    }

    class Career {
        -int careerId
        -String name
        -String description
        -List~Skill~ requiredSkills
        +addRequiredSkill(Skill skill)
        +getRequiredSkills()
    }

    class Job {
        -int jobId
        -String title
        -String company
        -List~Skill~ requiredSkills
        +getRequiredSkills()
    }

    class CareerMatcher {
        +calculateCompatibility(Student, Career) double
        +getMatchingSkills(Student, Career) List~Skill~
    }

    class SkillGapAnalyzer {
        +findSkillGaps(Student, Career) List~Skill~
    }

    class RecommendationEngine {
        +generateRecommendations(Student, Career) List~String~
    }

    class JobMatcher {
        +calculateJobMatch(Student, Job) double
        +getMissingSkills(Student, Job) List~Skill~
    }

    Student "1" --> "*" Skill : has
    Career "1" --> "*" Skill : requires
    Job "1" --> "*" Skill : requires

    CareerMatcher --> Student : analyzes
    CareerMatcher --> Career : compares

    SkillGapAnalyzer --> Student : analyzes
    SkillGapAnalyzer --> Career : checks

    RecommendationEngine --> Student : analyzes
    RecommendationEngine --> Career : uses

    JobMatcher --> Student : analyzes
    JobMatcher --> Job : compares
```

## Main Classes

### Student

Represents the student whose skills are being analyzed.

Responsibilities:

- Store student information
- Maintain the student's skill collection
- Add and remove skills
- Provide student data to analysis services

---

### Skill

Represents an individual skill.

Attributes include:

- Skill name
- Skill category
- Proficiency level

Examples:

```text
Java
Python
SQL
Data Structures
Git
```

---

### Career

Represents a career role and its required skills.

Examples:

```text
Java Developer
Data Analyst
Software Engineer
Web Developer
```

---

### Job

Represents a job opportunity or job profile containing required skills.

The Job class allows NEXUS to compare a student's profile with job requirements.

---

### CareerMatcher

Responsible for calculating the compatibility between a student's skills and a career's requirements.

---

### SkillGapAnalyzer

Responsible for identifying required skills that are missing or insufficient in the student's profile.

---

### RecommendationEngine

Responsible for generating recommendations based on career requirements and identified skill gaps.

---

### JobMatcher

Responsible for comparing a student's skills with the requirements of a job profile.

---

## Relationships

The main relationships are:

```text
Student
   |
   | has
   v
Skill

Career
   |
   | requires
   v
Skill

Job
   |
   | requires
   v
Skill

Student + Career
       |
       v
CareerMatcher
       |
       v
Compatibility

Student + Career
       |
       v
SkillGapAnalyzer
       |
       v
Skill Gaps

Skill Gaps + Career
       |
       v
RecommendationEngine
       |
       v
Recommendations
```

## Object-Oriented Design

The class structure demonstrates:

- Encapsulation through private attributes
- Abstraction through service classes
- Composition between students, careers, jobs, and skills
- Separation of data models and business logic
- Modular service-based design
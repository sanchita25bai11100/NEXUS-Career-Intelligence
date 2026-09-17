package com.nexus.repository;

import com.nexus.model.Job;
import com.nexus.model.Skill;

import java.util.ArrayList;
import java.util.List;

public class JobRepository {

    private final List<Job> jobs;

    public JobRepository() {
        jobs = new ArrayList<>();
        loadSampleJobs();
    }

    private void loadSampleJobs() {

        Skill java = new Skill("Java", "Programming", 1);
        Skill sql = new Skill("SQL", "Database", 1);
        Skill git = new Skill("Git", "Version Control", 1);
        Skill oop = new Skill("OOP", "Programming", 1);

        Job softwareDeveloper = new Job(
                1,
                "Software Developer",
                "NEXUS Technologies"
        );

        softwareDeveloper.addRequiredSkill(java);
        softwareDeveloper.addRequiredSkill(sql);
        softwareDeveloper.addRequiredSkill(git);
        softwareDeveloper.addRequiredSkill(oop);

        jobs.add(softwareDeveloper);
    }

    public List<Job> getAllJobs() {
        return new ArrayList<>(jobs);
    }

    public Job findById(int id) {
        for (Job job : jobs) {
            if (job.getJobId() == id) {
                return job;
            }
        }

        return null;
    }
}
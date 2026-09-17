package com.nexus.model;

import java.util.ArrayList;
import java.util.List;

public class Job {

    private int jobId;
    private String title;
    private String company;
    private List<Skill> requiredSkills;

    public Job(int jobId, String title, String company) {
        this.jobId = jobId;
        this.title = title;
        this.company = company;
        this.requiredSkills = new ArrayList<>();
    }

    public void addRequiredSkill(Skill skill) {
        if (skill == null) {
            throw new IllegalArgumentException("Required skill cannot be null.");
        }

        requiredSkills.add(skill);
    }

    public int getJobId() {
        return jobId;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public List<Skill> getRequiredSkills() {
        return new ArrayList<>(requiredSkills);
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", title='" + title + '\'' +
                ", company='" + company + '\'' +
                ", requiredSkills=" + requiredSkills +
                '}';
    }
}
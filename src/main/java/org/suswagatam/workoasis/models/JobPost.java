package org.suswagatam.workoasis.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "jobLists")
public class JobPost {
    private String profile;
    private String desc;
    private int exp;
    private String[] skills;

    public JobPost() {

    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "JobPost{" +
                "jobProfile='" + profile + '\'' +
                ", jobDescription='" + desc + '\'' +
                ", requiredExp=" + exp +
                ", skills=" + Arrays.toString(skills) +
                '}';
    }
}
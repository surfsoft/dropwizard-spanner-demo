package com.surfsoftconsulting.dropwizard.resource;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonRequest {

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("job_title")
    private String jobTitle;

    @JsonProperty("year_born")
    private int yearBorn;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getYearBorn() {
        return yearBorn;
    }

    public void setYearBorn(int yearBorn) {
        this.yearBorn = yearBorn;
    }
}

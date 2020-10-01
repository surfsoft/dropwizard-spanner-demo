package com.surfsoftconsulting.dropwizard.repository;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "people")
@NamedQueries(
        {
                @NamedQuery(
                        name = "com.example.helloworld.core.Person.findAll",
                        query = "SELECT p FROM Person p"
                )
        })
public class Person {
    @Id
    private UUID id;

    @Column(name = "fullName", nullable = false)
    private String fullName;

    @Column(name = "jobTitle", nullable = false)
    private String jobTitle;

    @Column(name = "yearBorn")
    private int yearBorn;

    public Person() {
    }

    public Person(String fullName, String jobTitle, int yearBorn) {
        this.id = UUID.randomUUID();
        this.fullName = fullName;
        this.jobTitle = jobTitle;
        this.yearBorn = yearBorn;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Person)) {
            return false;
        }

        Person person = (Person) o;

        return id == person.id &&
                yearBorn == person.yearBorn &&
                Objects.equals(fullName, person.fullName) &&
                Objects.equals(jobTitle, person.jobTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, jobTitle, yearBorn);
    }
}
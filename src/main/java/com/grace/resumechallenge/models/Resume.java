package com.grace.resumechallenge.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.time.LocalDate;

@Entity
public class Resume {

    @NotNull
    @Id
    private String name;

    private String email;

    private String organization;


    @NotNull
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate endDate;


    private long workdays;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }


    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public long getWorkdays() {
        return workdays;
    }

    public void setWorkdays(long workdays) {
        this.workdays = workdays;
    }
}

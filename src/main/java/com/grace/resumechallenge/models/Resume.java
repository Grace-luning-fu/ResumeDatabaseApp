package com.grace.resumechallenge.models;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Resume {


    //Should not have name as unique ID/primary key, because two persons may have the same name,
    //or the same person have worked at two organization/more than one work experience
    //if have name as @Id, the second entry of the same name will cover the first entry
    @NotNull
    @Size(min=2)
    private String name;

    //Since name and all other attributes are not fit to be the unique identifier, UUID is created as another attribute
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer uuid;

    @Email
    private String email;

    //no constrains required, since one can work freelance
    private String organization;


    @NotNull
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    //@Past doesn't work for LocalDate type, if user input a future date, Calculated WorkedDays will be negative
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    //@Past doesn't work for LocalDate data type. Works for data type--"date" though
    private LocalDate endDate;

    //This is a calculated value, no constrain define here for now
    private long workdays;


    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

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

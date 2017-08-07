package com.grace.resumechallenge.controllers;

import com.grace.resumechallenge.models.Resume;
import com.grace.resumechallenge.repositories.ResumeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.validation.Valid;

@Controller
public class MainControllers {
    @Autowired
    ResumeRepo resumeRepo;


    //Home Page
    @GetMapping("/")
    public String defaultRequest(Model model) {
        String myMessage = "welcome to the Resume Application";
        model.addAttribute("message", myMessage);
        return "welcome";
    }


    @GetMapping("/addresume")
    public String addResume(Model model) {
        model.addAttribute("newResume", new Resume());
        return "addresume";
    }

    @PostMapping("/addresume")
    public String postResume(@Valid @ModelAttribute("newResume") Resume resume, BindingResult bindingResult) {

        //if there are errors in validation constrains, prompt the user to add the resume again.
        if (bindingResult.hasErrors()) {
            return "addresume";
        }

        //Initialize a variable to store the calculated employed days
        long workdays;


        // If the user leave endDate empty, which means the user is still working,
        // get the day difference between Start date and now
        if (resume.getEndDate() == null) {
            workdays = calDateFromToday(resume.getStartDate());
        }
        //If user input a endDate, fine the date difference between Start Date and end Date
        else {
            workdays = caldatediff(resume.getStartDate(), resume.getEndDate());
        }

        //pass the calculated employed/worked days to the variable "workdays" in the Resume class
        resume.setWorkdays(workdays);

        //save the instance into database
        resumeRepo.save(resume);

        // print out the calculated workdays and double check with the value shown in HTML later
        System.out.print("1\n" + workdays);
        System.out.print("2\n" + resume.getWorkdays());

        //return result page after successful addition
        return "result";

    }

    //List all resumes in the database
    @GetMapping("/showallresume")
    public String showAllResumes(Model model) {

        Iterable<Resume> allresume = resumeRepo.findAll();
        model.addAttribute("resumes", allresume);
        return "showallresume";

    }


    // The method to calculate date difference between two dates, used in postResume method
    public long caldatediff(LocalDate date1, LocalDate date2) {

        long days = ChronoUnit.DAYS.between(date1, date2);
        return days;

    }

    //The method to calculate date difference between a date and now, used in postResume method
    public long calDateFromToday(LocalDate date1) {

        LocalDate today = LocalDate.now();
        long days = ChronoUnit.DAYS.between(date1, today);
        return days;

    }

}

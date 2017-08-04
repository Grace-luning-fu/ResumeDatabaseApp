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

import javax.validation.Valid;

@Controller
public class MainControllers {
    @Autowired
    ResumeRepo resumeRepo;

    @GetMapping("/")
    public String defaultRequest(Model model){
        String myMessage = "welcome to the Resume Application";
        model.addAttribute("message", myMessage);
        return "welcome";
    }


    @GetMapping("/addresume")
    public String addBook(Model model) {
        model.addAttribute("newResume", new Resume());
        return "addresume";
    }

    @PostMapping("/addresume")
    public String postBook(@Valid @ModelAttribute("newResume") Resume resume, BindingResult bindingResult)
    {

        if(bindingResult.hasErrors()){
            return "addresume";
        }
        resumeRepo.save(resume);
        return "result";
    }

    @GetMapping("/showallresume")
    public String showAllResumes(Model model) {

        Iterable<Resume> allresume = resumeRepo.findAll();
        model.addAttribute("resumes", allresume);
        return "showallresume";

    }

    //public Date calcualte calDateDiff()


}

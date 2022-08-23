package com.mo.teknologi2.controller;

import com.mo.teknologi2.model.Student;
import com.mo.teknologi2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping("/")
    public String getIndex (Model model) {
        model.addAttribute("studentsList", service.fetchAll());
        return "index";
    }

    @GetMapping("/add-new")
    public String addNew () {
        return "add-new";
    }

    @PostMapping ("/add-new")
    public String addNew (@ModelAttribute Student s) {
        service.addNew(s);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update (@PathVariable("id") int id, Model model){
        model.addAttribute("student", service.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String update (@ModelAttribute Student s){
        service.updateById(s);//s.getId(),
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete (@PathVariable("id") int id){
        service.delete(id);
        return "redirect:/";
    }

}

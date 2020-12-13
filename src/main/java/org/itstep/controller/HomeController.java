package org.itstep.controller;

import org.itstep.domain.entity.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String index(Model model) {
        System.out.println("index");
        model.addAttribute("title", "Simple ToDoList");
        return "index";
    }

    @PostMapping(value = "/")
    public String createTask(@ModelAttribute Task task) {
        System.out.println("createPost " + task);
        return "redirect:/";
    }


}

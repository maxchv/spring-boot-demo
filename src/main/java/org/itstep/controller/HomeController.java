package org.itstep.controller;

import org.itstep.domain.entity.Task;
import org.itstep.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    private final TaskRepository taskRepository;

    @Autowired
    public HomeController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @GetMapping(value = "/")
    public String index(Model model) {
        System.out.println("index");
        model.addAttribute("title", "Simple ToDoList");
        model.addAttribute("tasks", taskRepository.findAll());
        return "index";
    }

    @PostMapping(value = "/")
    public String createTask(@ModelAttribute Task task) {
        System.out.println("createPost " + task);
        taskRepository.save(task);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}") // /delete/1 or /delete/2 ...
    public String delete(@PathVariable Integer id) {
        taskRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Task> findByTitle(@RequestParam String title) {//?title=Title to find
        return taskRepository.findByTitle(title);
    }

}

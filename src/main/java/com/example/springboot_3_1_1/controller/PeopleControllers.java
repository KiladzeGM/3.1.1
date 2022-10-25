package com.example.springboot_3_1_1.controller;

import com.example.springboot_3_1_1.model.User;
import com.example.springboot_3_1_1.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleControllers {

    private final PeopleService peopleService;

    @Autowired
    public PeopleControllers(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public String show(Model model) {
        model.addAttribute("show", peopleService.show());
        return "show";
    }

    @GetMapping("/{id}")
    public String userShow(@PathVariable int id, Model model) {
        model.addAttribute("userShow", peopleService.userShow(id));
        return "user";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        peopleService.save(user);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("user", peopleService.userShow(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        peopleService.update(user);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        peopleService.delete(id);
        return "redirect:/people";
    }

}

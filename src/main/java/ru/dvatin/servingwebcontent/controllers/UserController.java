package ru.dvatin.servingwebcontent.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dvatin.servingwebcontent.models.User;
import ru.dvatin.servingwebcontent.servicies.UserService;

@Controller
@RequestMapping (path = "/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping (path = "/new")
    public String newUser (@ModelAttribute("user") User user) {
        return "users/new";
    }
    @PostMapping
    public @ResponseBody String addNewUser (@ModelAttribute ("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping (path = "all")
    public String getAllUsers (Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/index";
    }
    @GetMapping (path = "{id}")
    public String getUserByIndex (@PathVariable ("id") int id, Model model) {
        model.addAttribute("user", userService.getUserByID(id));
        return "users/show";
    }
    @GetMapping ("/edit/{id}")
    public String edit (Model model, @PathVariable ("id") int id) {
        model.addAttribute("user", userService.getUserByID(id));
        return "users/edit";
    }

    @PatchMapping ("/{id}")
    public String update (@ModelAttribute ("user") User user, @PathVariable("id") int id){
        userService.updateUser (id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable ("id") int id) {
        userService.removeUser(id);
        return "redirect:/users";
    }
}

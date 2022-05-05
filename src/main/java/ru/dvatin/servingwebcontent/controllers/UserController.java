package ru.dvatin.servingwebcontent.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.dvatin.servingwebcontent.models.User;
import ru.dvatin.servingwebcontent.repositories.UserRepository;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;


    @GetMapping(path = "/signup")
    public String showSignUpForm(@RequestParam User user) {
        return "add-user";
    }
    @PostMapping("/adduser")
    public String addUser(User user, BindingResult result, Model model) {
        userRepository.save(user);
        return "redirect:/index";
    }
    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("users", getAllUsers());
        return "index";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return "update-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "update-user";
        }

        userRepository.save(user);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        return "redirect:/index";
    }


    @GetMapping
    public @ResponseBody Iterable<User> getAllUsers () {
        return userRepository.findAll();
    }
}

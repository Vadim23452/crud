package ru.vadim.spring.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import ru.vadim.spring.model.User;
import ru.vadim.spring.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping()
  public String index(Model model) {
    model.addAttribute("users", userService.allUsers());
    return "users/index";
  }

  @GetMapping("/")
  public String show(@RequestParam("id") Long id, Model model) {
    model.addAttribute("user", userService.showUserById(id));
    return "users/show";
  }

  @GetMapping("/new")
  public String newUser(Model model) {
    model.addAttribute("user", new User());
    return "users/new";
  }

  @PostMapping
  public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      return "users/new";
    }

    userService.saveUser(user);
    return "redirect:/users";
  }

  @GetMapping("/edit/")
  public String edit(Model model, @RequestParam("id") Long id) {
    model.addAttribute("user", userService.showUserById(id));
    return "users/edit";
  }

  @PatchMapping("/")
  public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
      @RequestParam("id") Long id) {

    if (bindingResult.hasErrors()) {
      return "users/edit";
    }

    userService.updateUser(id, user);
    return "redirect:/users";
  }

  @DeleteMapping("/")
  public String delete(@RequestParam("id") Long id) {
    userService.deleteUser(id);
    return "redirect:/users";
  }

}
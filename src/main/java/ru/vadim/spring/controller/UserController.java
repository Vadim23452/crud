package ru.vadim.spring.controller;

//import jakarta.validation.Valid;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vadim.spring.model.User;
import ru.vadim.spring.service.UserService;


@Controller
public class UserController {

  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }


  @GetMapping("/users")
  public String allUsers(Model model) {
    //получим всех людей из дао и передади на отображение в представление
    model.addAttribute("users", userService.allUsers());

    return "users/index";
  }

  @GetMapping("/users/{id}")
  public String showUserById(@PathVariable("id") int id, Model model) {
    //получим одного человека по его id из DAO и передадим на отоброжение в представление
    model.addAttribute("user", userService.showUserById(id));

    return "users/show";
  }

  //сама создаст объект и положит в модель
  @GetMapping("/users/new")
  public String newUser(@ModelAttribute("user") User user) {
    return "users/new";
  }

  @PostMapping("/users")   ///@Valid , BindingResult bindingResult
  public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      return "users/new";
    }
    userService.saveUser(user);

    return "redirect:/users";
  }

  @GetMapping("/users/{id}/edit")
  public String editUser(Model model, @PathVariable("id") int id) {
    model.addAttribute("user", userService.showUserById(id));
    return "users/edit";
  }

  @PatchMapping("/{id}") ///@Valid, BindingResult bindingResult
  public String updateUser(@ModelAttribute("user") @Valid User user,BindingResult bindingResult, @PathVariable("id") int id) {

    if (bindingResult.hasErrors()){
      return "users/edit";
    }
    userService.updateUser(id, user);
    return "redirect:/users";
  }

  @DeleteMapping("/users/{id}")
  public String delete(@PathVariable("id") int id) {
    userService.deleteUser(id);
    return "redirect:/users";
  }
}
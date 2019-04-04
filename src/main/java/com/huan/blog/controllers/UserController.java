package com.huan.blog.controllers;

import com.huan.blog.models.User;
import com.huan.blog.service.SecurityService;
import com.huan.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private SecurityService securityService;


  // display the registration form
  @GetMapping("/register")
  public String registration(Model model) {
    return "register-form";
  }

  // create a register user
  @PostMapping("/register")
  public String registration(@ModelAttribute User userForm) {

    userService.save(userForm);

    securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirmation());

    return "redirect:/blogs";
  }

  // login the user
  @GetMapping("/login")
  public String login(Model model, String error, String logout) {
    if (error != null)
      model.addAttribute("error", "Your username and password is invalid.");

    if (logout != null)
      model.addAttribute("message", "You have been logged out successfully.");

    return "login";
  }
}

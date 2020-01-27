package com.tarsu.que.controller;

import com.tarsu.que.domain.Que;
import com.tarsu.que.domain.Role;
import com.tarsu.que.domain.User;
import com.tarsu.que.dto.QueDto;
import com.tarsu.que.repos.QueRepo;
import com.tarsu.que.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.*;

@Controller
@Transactional
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private QueRepo queRepo;

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String userList(Model model) {
        model.addAttribute("users", userService.findAll());

        return "userList";
    }

    @GetMapping("/user/{user}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @GetMapping("/user/delete/{userId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String userDeleteForm(@PathVariable(value = "userId") String userId) {
        userService.deleteUser(userId);
        return "redirect:/login";
    }

    @PostMapping("/user")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ) {
        userService.save(user, username, form);

        return "redirect:/user";
    }

    @GetMapping("/user/profile")
    public String getProfile(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());

        Collection<Que> ques = queRepo.findAllByUserId(user.getId());
        model.addAttribute("ques", ques);
        return "profile";
    }

    @PostMapping("/user/profile")
    public String updateProfile(
            @AuthenticationPrincipal User user,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String email){
        userService.updateProfile(user, username, password, email);
        return "redirect:/user/profile";
    }


    @GetMapping("/delete/{queId}")
    public String showDeleteQue(Model model,
                                @PathVariable("queId") String queId,
                                @AuthenticationPrincipal User user){

        System.out.println("Que deleted: " + queId);
        queRepo.deleteById(Long.valueOf(queId));
        model.addAttribute("ques", queRepo.findAllByUserId(user.getId()));
        return "redirect:/";
    }





}

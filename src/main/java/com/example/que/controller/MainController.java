package com.example.que.controller;

import com.example.que.domain.Que;
import com.example.que.repos.QueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private QueRepo queRepo;

    public Que getQue() {
        return que;
    }

    public void setQue(Que que) {
        this.que = que;
    }

    private Que que;

    @GetMapping("/")
    public String greeting()
    {
        return "greeting";
    }

    @GetMapping("/main")
    public String main( Model model){
        Iterable<Que> ques = queRepo.findAll();
        model.addAttribute("ques", ques);
        return "main";
    }

}

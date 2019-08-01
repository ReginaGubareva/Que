package com.tarsu.que.controller;

import com.tarsu.que.domain.Que;
import com.tarsu.que.repos.QueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model){
        Iterable<Que> ques;
        if(filter != null && !filter.isEmpty()) {
            ques = queRepo.findByQueName(filter);
        } else {
            ques = queRepo.findAll();
        }
        model.addAttribute("ques", ques);
        model.addAttribute("filter", filter);
        return "main";
    }

}

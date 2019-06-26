package com.example.que.controller;

import com.example.que.domain.Answer;
import com.example.que.domain.Que;
import com.example.que.domain.Question;
import com.example.que.repos.AnswerRepo;
import com.example.que.repos.QueRepo;
import com.example.que.repos.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller("/replyTo")
public class AnswerController {
    @Autowired
    private QueRepo queRepo;

    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private AnswerRepo answerRepo;

    private Map<Question, List<Answer>> data;

    @GetMapping("/answerQue/{que}")
    public String getQue(@PathVariable Que que, Model model){

        List<Question> questions = que.getQuestionsList();
        model.addAttribute("que", que);
        model.addAttribute("questions", questions);
        return "answerQue";
    }

    @PostMapping("/answerQue/answer")
    public String answerQue(@RequestBody String que){
        System.out.println(que);
        return "answerQue";
    }
}

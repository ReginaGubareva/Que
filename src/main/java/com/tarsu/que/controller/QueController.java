package com.tarsu.que.controller;

import com.tarsu.que.domain.*;
import com.tarsu.que.repos.AnswerRepo;
import com.tarsu.que.repos.QueRepo;
import com.tarsu.que.repos.QuestionRepo;
import com.tarsu.que.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class QueController {

    @Autowired
    private QueRepo queRepo;

    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private AnswerRepo answerRepo;

    @Autowired
    private UserRepo userRepo;


    @GetMapping("/newQue")
    public String newQueView(){
        return "newQue";
    }

    @RequestMapping(value = "/newQue", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String createQue(@RequestBody String data, @AuthenticationPrincipal User user) throws IOException {

        if(!data.contains("_csrf")){
            String json_data = data;
            User newUser = user;

            System.out.println("Json data: " + data);
            System.out.println(user.getUsername());

            String[] arrByQuestion = json_data.split("],");
            List<String> list = new ArrayList<>();

            for (String s : arrByQuestion) {
                list.add(s.replace("{", "")
                        .replace("}", "")
                        .replace("[", "")
                        .replace("]", "")
                        .replace("\"", ""));
            }

            String[] que = list.get(0).split(":");
            Que newQue = new Que(que[0], que[1], newUser);

            for (int i = 1; i < list.size(); i++) {

                String[] qa = list.get(i).split(":");
                Question newQuestion = new Question();
                newQuestion.setQuestion(qa[0]);
                newQuestion.setQue(newQue);

                List<Answer> answerList = Arrays.stream(qa[1].split(","))
                        .map(Answer::new).collect(Collectors.toList());

                answerList.forEach(answer -> answer.setQuestion(newQuestion));

                newQuestion.setAnswersList(answerList);

                for (int j = 0; j < answerList.size(); j++) {
                    answerRepo.save(answerList.get(j));
                }
                questionRepo.save(newQuestion);
                queRepo.save(newQue);
            }
        }
        return "redirect:/main";
    }



}


package com.example.que.controller;

import com.example.que.domain.Answer;
import com.example.que.domain.Que;
import com.example.que.domain.Question;
import com.example.que.repos.AnswerRepo;
import com.example.que.repos.QueRepo;
import com.example.que.repos.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class QueController {

    @Autowired
    private QueRepo queRepo;

    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private AnswerRepo answerRepo;

    @GetMapping("/newQue")
    public String newQueView(){
        return "newQue";
    }

    @RequestMapping(value = "/newQue", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String createQue(@RequestBody String data) throws IOException {
        String json = "";

        if(!data.contains("_csrf")){
            json = data;
            //System.out.println("Json: " + json);

            String[] arrByQuestion = json.split("],");
            List<String> list = new ArrayList<>();

            for (String s : arrByQuestion) {
                list.add( s.replace("{", "")
                        .replace("}", "")
                        .replace("[", "")
                        .replace("]", "")
                        .replace("\"", ""));
            }

            String[] que = list.get(0).split(":");
            Que newQue = new Que(que[0], que[1]);

            for (int i = 1; i < list.size(); i++){

                String[] qa = list.get(i).split(":");
                Question newQuestion = new Question();
                newQuestion.setQuestion(qa[0]);
                newQuestion.setQue(newQue);

                List<Answer> answerList = Arrays.stream(qa[1].split(","))
                        .map(Answer::new).collect(Collectors.toList());

                answerList.forEach(answer -> answer.setQuestion(newQuestion));

                newQuestion.setAnswersList(answerList);

                for(int j=0; j<answerList.size(); j++) {
                    answerRepo.save(answerList.get(j));
                }
                questionRepo.save(newQuestion);
                queRepo.save(newQue);
            }
        }
        return "redirect:/main";
    }
}


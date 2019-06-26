package com.example.que.controller;

import com.example.que.domain.Que;
import com.example.que.domain.Question;
import com.example.que.domain.Result;
import com.example.que.domain.ResultData;
import com.example.que.repos.ResultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller("/replyTo")
public class AnswerController {

    @Autowired
    private ResultRepo resultRepo;

    @GetMapping("/answerQue/{que}")
    public String getQue(@PathVariable Que que, Model model){

        List<Question> questions = que.getQuestionsList();
        model.addAttribute("que", que);
        model.addAttribute("questions", questions);
        return "answerQue";
    }

    @PostMapping("/answerQue/{queId}/{userId}")
    public String answerQue(@PathVariable String queId,
                            @PathVariable String userId,
                            @RequestParam("questionId") String[] questionId,
                            @RequestParam("answer") String[] answer){
        System.out.println("Que id: " + queId);
        System.out.println("User id: " + userId);
        Arrays.stream(questionId).forEach(x->System.out.print(x + " "));
        System.out.println();
        Arrays.stream(answer).forEach(x->System.out.print(x + " "));
        System.out.println();

        Result result = new Result();

        List<ResultData> resultDataList = new ArrayList<>();

        if(questionId.length != answer.length){
           return "answerError";
        }

        for(int i = 0; i < questionId.length; i++){
            ResultData resultData = new ResultData(Long.valueOf(questionId[i]), answer[i]);
            resultData.setResult(result);
            resultDataList.add(resultData);
        }

        Long queIdAsLong = Long.valueOf(queId);
        Long userIdAsLong = Long.valueOf(userId);

        result.setAnswers(resultDataList);
        result.setQueId(queIdAsLong);
        result.setUserId(userIdAsLong);
        resultRepo.save(result);

        return "redirect:/answerSaved";
    }

    @GetMapping("/answerSaved")
    public String answerSaved(){
        return "answerSaved";
    }
}

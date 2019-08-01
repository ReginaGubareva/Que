package com.tarsu.que.controller;

import com.tarsu.que.domain.Que;
import com.tarsu.que.domain.Question;
import com.tarsu.que.domain.Result;
import com.tarsu.que.domain.ResultData;
import com.tarsu.que.repos.ResultDataRepo;
import com.tarsu.que.repos.ResultRepo;
import com.googlecode.charts4j.Color;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.PieChart;
import com.googlecode.charts4j.Slice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

@Controller
public class  StatisticController{

    @Autowired
    private ResultRepo resultRepo;

    @Autowired
    private ResultDataRepo resultDataRepo;

    @GetMapping("/statisticQue/{currentQue}")
    public String statistic(@PathVariable Que currentQue, Model model){

        List<Question> questionsList= currentQue.getQuestionsList();
        Map<Question, String> results = new HashMap<>();
        List<ResultData> dataList = new ArrayList<>();
        List<String> answerList = new ArrayList<>();

        List<Result> resultList = resultRepo.findAllByQueId(currentQue.getId());
        int responses = resultList.size();

        for(Question question: questionsList){

            dataList = resultDataRepo.findAllByQuestionId(question.getId());
            answerList = dataList.stream().map(ResultData::getAnswer).collect(Collectors.toList());

            if(question.getQuestion().contains("name")){
                continue;
            }

            if(question.getQuestion().contains("old") | question.getQuestion().contains("age")){
                    for (String answer : answerList){
                        Integer x = Integer.parseInt(answer);
                            if(7 <= x & x <= 12){
                                answer = "7-12";
                            } else if (13 <= x & x <= 18){
                                answer = "13-18";
                            } else if (19 <= x & x <= 34){
                                answer = "19-34";
                            } else if (35 <= x & x < 60 ){
                                answer = "35-60";
                            } else if (x >= 60 ){
                                answer = "older then 60";
                            }
                    }
            }

            Map<String, Long> statistic = answerList.stream().collect(groupingBy(Function.identity(),Collectors.counting()));
            Map<String, Long> sortedStatistic = sortByValue(statistic);

            PieChart newPieChart = createPieChart(sortedStatistic, responses);
            results.put(question, newPieChart.toURLString());
        }

        model.addAttribute("que", currentQue);
        model.addAttribute("responses", responses);
        model.addAttribute("results", results);
        return "statisticQue";
    }



    private  Map<String, Long> sortByValue(Map<String, Long> unsortMap) {
       return  unsortMap
               .entrySet()
               .stream()
               .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
               .collect(
                       toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                               LinkedHashMap::new));

    }

    private PieChart createPieChart(Map<String, Long> statistic, int responses){

        Color[] colors = {Color.newColor("e6f2ff"),
                          Color.newColor("b3cccc"),
                          Color.newColor("80bfff"),
                          Color.newColor("00b3b3"),
                          Color.newColor("008080"),
                          Color.newColor("00264d")};

        PieChart pieChart = null;
        Object[] answers = null;
        int[] percents = null;
        Slice[] slices = null;


        if(statistic.size() > 5){

            answers =  statistic.keySet().stream().limit(6).toArray();
            percents = statistic.values().stream().mapToInt(e -> e.intValue()*100/responses).limit(6).toArray();
            slices = new Slice[answers.length];
            answers[answers.length-1] = "Others";

            int sum = 0;
            for(int i = 0; i<percents.length-1; i++ ){
                sum += percents[i];
            }
            percents[percents.length-1] = 100 - sum;


            for(int i = 0; i<slices.length; i++) {
                slices[i] = Slice.newSlice(percents[i], colors[i], percents[i]+"%", answers[i].toString());
            }
        } else {
            answers =  statistic.keySet().stream().toArray();
            percents = statistic.values().stream().mapToInt(e -> e.intValue()*100/responses).toArray();
            slices= new Slice[answers.length];
            for(int i = 0; i<slices.length; i++) {
                slices[i] = Slice.newSlice(percents[i], colors[i], percents[i]+"%", answers[i].toString());
            }
        }

        pieChart = GCharts.newPieChart(slices);
        pieChart.setSize(600, 300);
        return pieChart;
    }
}

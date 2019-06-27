$(document).ready(function(){

    var i = 0; // количество вопросов

    $('#addQuestion').click(function () {

        let question = '<div  id="' + i + '" class="qCard card border-info my-3" style="width: 50rem;" >\n' +
            '            <div class="card-body">\n' +
            '                <div class="questionNavBar form-inline mt-3" id="questionNavBar' + i + '">\n' +
            '                    <input class="form-control col-9 mr-2" type="text" name="question" id="question' + i + '">\n' +
            '                    <div class="btn-group" role="group">\n' +
            '                        <button type="button" class="btn btn-outline-info dropdown-toggle mr-2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">\n' +
            '                            Answer type\n' +
            '                        </button>\n' +
            '                        <div class="dropdown-menu mr-2" >\n' +
            '                            <button class="dropdown-item" id="answerAsText' + i + '" type="button">Text</button>\n' +
            '                            <button class="dropdown-item" id="answerAsList' + i + '" type="button">List</button>\n' +
            '                        </div>\n' +
            '                    </div>\n' +
            '                    <a href="#" role="button" class="btn btn-outline-info" id="removeQuestion' + i + '">-</a>\n' +
            '                </div>\n' +
            '            </div>\n' +
            '        </div>';


        $("#questions").append(question);

        var questionNavBar = document.getElementById("questionNavBar" + i);
        var answerAsText = document.getElementById("answerAsText" + i);
        var answerAsList = document.getElementById("answerAsList" + i);
        var removeQuestion = document.getElementById("removeQuestion" + i);
        var answerType = "";


        $(removeQuestion).click(function () {
            let questionIndex = parseInt($(this).attr('id').match(/\d+/)) + 1;

            $(this).parent().parent().parent().remove();

            for(questionIndex; questionIndex<=i; questionIndex++){
                $('#' + questionIndex).attr("id", questionIndex-1);
                $('#questionNavBar' + questionIndex).attr("id", "questionNavBar"+(questionIndex-1));
                $('#question' + questionIndex).attr("id", "question" + (questionIndex-1));
                $('#answerAsText' + questionIndex).attr("id", "answerAsText" + (questionIndex-1));
                $('#answerAsList' + questionIndex).attr("id", "answerAsList" + (questionIndex-1));
                $('#removeQuestion' + questionIndex).attr("id", "removeQuestion" + (questionIndex-1));
            }
            i--;
        });

        $(answerAsText).click(function () {
            if (answerType !== "list") {
                answerType = 'text';
                $(questionNavBar).append('<textarea id="answer" class="form-control mt-2 col-9" rows="3"></textarea>');
            }
        });

        $(answerAsList).click(function () {
            if (answerType !== "text") {
                answerType = "list";
                let answer = '<div class="input-group mt-1 col-8">\n' +
                    '  <div class="input-group-prepend">\n' +
                    '    <div class="input-group-text">\n' +
                    '      <input type="checkbox" aria-label="Checkbox for following text input">\n' +
                    '    </div>\n' +
                    '  </div>\n' +
                    '  <input id="answer" type="text" class="form-control" >\n' +
                    '</div>';
                $(questionNavBar).append(answer);
            }
        });

        i++;
    });

    $("#send").click(function () {


        var data = {};
        data[$('#queName').val()] = [ $('#queDescription').val() ] ;

        let questionCounts = document.getElementById('questions').childElementCount;
        alert("Questions count: " + questionCounts);

        for(let j = 0; j<questionCounts; j++){

            let answerList = [];
            let questionName = document.getElementById("question" + j).value.toString();

            var answers = document.getElementById("questionNavBar"+j).querySelectorAll('#answer');

            if(answers.length > 1) {
                for(let k = 0; k < answers.length; k++){
                    answerList.push(answers[k].value);
                }
            } else {
                answerList.push("text");
            }

            data[questionName] = answerList;
        }

        $.ajax({
            type: "POST",
            contentType: "application/json;charset=UTF-8",
            url: "/newQue",
            headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},
            data: JSON.stringify(data),
            dataType: 'json'
        });
    });
});
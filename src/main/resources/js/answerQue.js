$(document).ready(function () {

    $("#valid").click(function () {
        if(!isValid()){
            alert("Please fill all fields!");
            $("#answerQue").submit(function(e){
                e.preventDefault();
            });
        }else{
            // $("#answerQue").submit(function (e) {
            //     e.submit();
            // });
            document.getElementById("answerQue").submit();
        }
    });

    function isValid() {
        let isValid = true;

        let textareas = document.querySelectorAll('textarea[name="answer"]');
        for(let i = 0; i < textareas.length; i++){
            if(textareas[i].value.toString() === ''){
                isValid = false;
            }
        }

        let questions = document.querySelectorAll("#question");

        for (let i = 0; i < questions.length; i++) {

            if($(questions[i]).find('#checkbox').length !== 0){
                let checked = questions[i].querySelectorAll("input:checked").length > 0;
                if (!checked) {
                    isValid = false;
                }
            }
        }

        return isValid;
    }


    /*jQuery.fn.isValid = function(){
        let isValid = true;

        let textareas = document.querySelectorAll('textarea[name="answer"]');
        for(let i = 0; i < textareas.length; i++){
            if(textareas[i].value.toString() === ''){
                isValid = false;
            }
        }

        let questions = document.querySelectorAll("#question");

        for (let i = 0; i < questions.length; i++) {

            if($(questions[i]).find('#checkbox').length !== 0){
                let checked = questions[i].querySelectorAll("input:checked").length > 0;
                if (!checked) {
                    isValid = false;
                }
            }
        }

        if(!isValid()){
            alert("Please fill all fields!");
            $("#answerQue").submit(function(e){
                e.preventDefault();
            });
        } else {
            $("#answerQue").submit();
        }
        // return isValid;
    };*/

    $('input.custom-control-input').click(function() {
        if (!$(this).prop('checked')) {
            return;
        }
        var group = $(this).data('group');
        if (group) {
            $('input[data-group="' + group + '"]:checked').prop('checked', false);
            $(this).prop('checked', true);
        }
    });
});



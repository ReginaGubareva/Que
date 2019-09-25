$(document).ready(function () {

  $("#valid").click(function () {

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
                var checked = questions[i].querySelectorAll("input:checked").length > 0;
                if (!checked) {
                    isValid = false;
                }
            }
        }

        if(!isValid){
            alert("Please fill all fields!");
            $("#answerQue").submit(function(e){
                e.preventDefault();
            });
        } else {
            $("#answerQue").submit();
        }
    });


    /*if(!$.isValid()){
        alert("please fill all fields");
    } else {
        $("#valid").click(function () {
            alert("bla bla bla");
        });
    }


   $.isValid = function(){
        let valid = true;

        let textareas = document.querySelectorAll('textarea[name="answer"]');
        for(let i = 0; i < textareas.length; i++){
            if(textareas[i].value.toString() === ''){
                //alert("please fill all textarea fields");
                valid = false;
            }
        }
        let count = 0;
        let questions = document.querySelectorAll("#question");
        alert(questions.length.toString());

        for (let i = 0; i < questions.length; i++) {

            if($(questions[i]).find('#checkbox').length !== 0){
                var checked = questions[i].querySelectorAll("input:checked").length > 0;
                if (!checked) {
                    //alert("Please check at least one checkbox");
                    valid = false;
                }
                count++;
            }
        }
       // alert("input: "  + count.toString());
        return valid;
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
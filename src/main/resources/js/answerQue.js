$(document).ready(function () {

    function bootstrapAlert(){
        $("#alertPlaceholder").html('<div class="alert alert-danger alert-dismissible fade show" role="alert">\n' +
            '  <strong></strong>Please fill in all fields\n' +
            '  <button type="button" class="close" data-dismiss="alert" aria-label="Close">\n' +
            '    <span aria-hidden="true">&times;</span>\n' +
            '  </button>\n' +
            '</div>');
    }

    $("#valid").click(function () {
        if(!isValid()){
           bootstrapAlert();
            $("#answerQue").submit(function(e){
                e.preventDefault();
            });
        } else {
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



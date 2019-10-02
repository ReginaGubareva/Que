<#include "parts/security.ftl">
<#import "parts/common.ftl" as c>


<@c.page>

    <div class="jumbotron mx-auto"  style="width: 50rem; height: 15rem;">
        <p class="ml-5">
        <h1 class="display-4 text-left">${que.getQueName()}</h1>
        <div class="lead mt-3">${que.getQueDescription()}</div>
        <p id="countsOfQuestions">Size: ${que.getQuestionsCount()}</p>
    </div>

    <form class="mb-5" id="answerQue" method="post" action="/answerQue/${que.getId()}/${userId}" >
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>

        <#assign count = 1>

        <#list questions as question>
            <div class="card border-info mb-3 mt-3" style="width: 50rem; margin-left: auto; margin-right: auto;">
                <div class="card-body" id="question">
                    <h5><label class="breadcrumb">${count}. ${question.getQuestion()}</label></h5>
                    <#assign answersList = question.getAnswersList()>

                    <input type="hidden" id="questionId" name="questionId" value="${question.getId()}"/>

                    <#if answersList?size=1>
                        <label for="answer"></label>
                        <textarea class="form-control col-md-12" name="answer" id="answer" rows="3"></textarea>
                    <#else>
                        <#list answersList as answer>
                            <div class="checkboxContainer">
                                <label class="custom-control custom-checkbox">
                                    <input type="checkbox" id="checkbox" name="answer" class="custom-control-input" value="${answer.getAnswer()}" data-group="${question.getId()}">
                                    <span class="custom-control-indicator"></span>
                                    <span class="custom-control-label">${answer.getAnswer()}</span>
                                </label>
                            </div>
                        </#list>
                    </#if>
                </div>
            </div>
            <#assign count++>
        </#list>

        <div class="d-flex justify-content-center">
            <button type ="submit"  class="btn btn-outline-info btn-lg mb-3" id="valid">Answer</button>
        </div>
    </form>

    <script type="text/javascript" src="/js/answerQue.js"></script>
    <script src="../js/hideBottomNavbar.js"></script>
</@c.page>


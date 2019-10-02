<#import "parts/common.ftl" as c>

<@c.page>
    <div class="container mx-auto justify-align-center">

        <div class="jumbotron mx-auto mb-5"  style="width: 50rem">
            <h1 class="display-4 text-left">${que.queName}</h1>
            <div class="lead mt-3">${que.queDescription}</div>
            <p>Responses: ${responses}</p>
        </div>

        <#if responses?? && responses == 0 >
            <div class="alert alert-danger mx-auto" style="width: 50rem;">No answers for this que.</div>
        <#else>

            <#assign count = 1>

            <#list results as question, pieCharts>
                <div class="card border-info mb-3 mt-3" style="width: 50rem; margin-left: auto; margin-right: auto;">
                    <div class="card-body" id="question">
                        <h5><label class="breadcrumb">${count}. ${question.getQuestion()}</label></h5>
                        <div class="mt-3 mb-5"><img src="${pieCharts}" alt="Must be piechart here!"/></div>
                    </div>
                </div>
                <#assign count++>
            </#list>
        </#if>
    </div>

    <script src="../js/hideBottomNavbar.js"></script>
</@c.page>
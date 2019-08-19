<#import "parts/common.ftl" as c>


<@c.page>
    <div class="container mx-auto justify-align-center">
    <form action="/main" method="get" enctype="multipart/form-data" class="form-inline mb-3">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div class="row">
            <input type="text" class="form-control ml-2 col col-md-8" name="filter" value="${filter!}" placeholder="Enter name of que">
            <button class="btn btn-info ml-2 mt-2 col" type="submit">Search</button>
            <a href="/newQue" class="btn btn-info mt-2 ml-2 col" role="button">New Que</a>
        </div>
    </form>

    <ul class="list-group col-8">
        <#list ques as que>
            <li class="list-group-item d-flex justify-content-between align-items-center">
                <a href="/answerQue/${que.getId()}" methods="get">
                    <h5>${que.getQueName()}</h5><i style="color: cadetblue">${que.getQueDescription()}</i>
                </a>

                <div>
                    <a class="badge badge-info ml-1" href="/statisticQue/${que.getId()}" methods="get">Dashboard</a>
                    <span class="badge badge-info badge-pill">${que.getQuestionsCount()}</span>
                </div>
            </li>
        </#list>
    </ul>
    </div>
</@c.page>
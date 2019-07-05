<#import "parts/common.ftl" as c>


<@c.page>
    <div class="container mx-auto justify-align-center">
    <form action="/main" method="get" enctype="multipart/form-data" class="form-inline mb-3">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="text" class="form-control col-8" name="filter" value="${filter!}" placeholder="Enter name of que">
        <button class="btn btn-outline-info ml-2" type="submit">Search</button>
        <a href="/newQue" class="btn btn-outline-info ml-2" role="button">New Que</a>
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
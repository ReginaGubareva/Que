<#import "parts/common.ftl" as c>

<@c.page>

    <div class="row justify-content-center">
        <form action="/main" method="get" enctype="multipart/form-data" class="form-inline mb-3">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />


                <div id="findQue" class="input-group">
                    <input type="text" class="form-control col-12 col-sm-8" name="filter" value="${filter!}" placeholder="Enter name of que">
                    <div class="input-group-append">
                        <button class="btn btn-info" type="submit">Find</button>
                    </div>
            </div>
        </form>
    </div>


    <div class="container-fluid">
        <div class="row justify-content-center">
            <div class="col-12 col-sm-8">
                <ul class="list-group">
                    <#list ques as que>
                        <div class="card mb-2">
                            <li class="list-group-item d-flex justify-content-between">

                                <a class="mt-1 mb-1" id="queCard" href="/answerQue/${que.getId()}" methods="get">
                                    <strong>${que.getQueName()}</strong>
                                    <br>
                                    <i>${que.getQueDescription()}</i>
                                </a>


                                <div>
                                    <a class="badge badge-info ml-1" href="/statisticQue/${que.getId()}" methods="get">Dashboard</a>
                                    <span class="badge badge-info badge-pill">${que.getQuestionsCount()}</span>
                                </div>
                            </li>
                        </div>
                    </#list>
                </ul>
            </div>
        </div>
    </div>
</@c.page>


<#import "parts/common.ftl" as c>


<@c.page>
    <div>
        <form action="/main" method="get" enctype="multipart/form-data">
            <div class="row justify-content-center">
            <div class="p-1 bg-light rounded rounded-pill shadow-sm mb-4 col-12 col-sm-8">
                <div class="input-group">
                    <input type="search" name="filter" value="${filter!}" placeholder="Find your que" class="form-control border-0 bg-light">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-info" data-toggle="tooltip" data-placement="top" title="Найди нужную анкету">Find</button>
                    </div>
                </div>
            </div>
            </div>
        </form>

    <div class="container-fluid">
        <div class="row justify-content-center">
            <div class="col-12 col-sm-8">
                <ul class="list-group">
                    <#list ques as que>

                                <div class="card">
                                <a id="queCard" class="mt-1 mb-1"  href="/answerQue/${que.getId()}" methods="get">
                                    <strong>${que.getQueName()}</strong>
                                    <br>
                                    <i>${que.getQueDescription()}</i>
                                </a>

                                <div>
                                    <a class="badge badge-info ml-1" href="/statisticQue/${que.getId()}" methods="get">Dashboard</a>
                                    <span class="badge badge-info badge-pill">${que.getQuestionsCount()}</span>
                                </div>
                                </div>

<#--                        <li class="list-group-item d-flex justify-content-between">-->
<#--                            </li>-->

                    </#list>
                </ul>
            </div>
        </div>
    </div>

    </div>

</@c.page>



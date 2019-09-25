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
            <div class="col-7">
                <ul class="list-group">
                    <#list ques as que>

                        <div id="queCard" class="card mb-2 ">
                           <div class="d-flex justify-content-between">
                            <a id="queInfo" class="mt-1 mb-1 pl-3"  href="/answerQue/${que.getId()}" methods="get">
                                <strong>${que.getQueName()}</strong>
                                <br>
                                <i style="font-size: medium;">${que.getQueDescription()}</i>
                            </a>

                            <div class="d-flex align-items-center pr-3">
                                <a class="badge badge-info badge-pill mr-2" href="/statisticQue/${que.getId()}" methods="get" data-toggle="tooltip" title="view statistics">
                                    Dashboard
                                </a>
                                <span class="badge badge-info badge-pill">${que.getQuestionsCount()}</span>
                            </div>
                           </div>
                        </div>
                    </#list>
                </ul>
            </div>
        </div>
    </div>

    </div>

</@c.page>



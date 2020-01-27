<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>



    <div class="row">
        <div class="col-3">
            <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab" aria-controls="v-pills-home" aria-selected="true">Profile</a>
                <a class="nav-link" id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-profile" role="tab" aria-controls="v-pills-profile" aria-selected="false">Ques</a>
            </div>
        </div>
        <div class="col-9">
            <div class="tab-content" id="v-pills-tabContent">
                <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
                    <h5 style="color: #1BA0B6; font-size: xx-large; font-family: 'Didact Gothic', 'Catamaran', sans-serif" ><strong>${username}</strong></h5>
                    ${message!}
                    <form method="post" action="/user/profile">

                        <input type="hidden" name="_csrf" value="${_csrf.token}" />

                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label" style="color: #096967;">User Name :</label>
                            <div class="col-sm-6">
                                <input type="text" name="username" class="form-control" placeholder="User name" />
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label" style="color: #096967;">Password:</label>
                            <div class="col-sm-6">
                                <input type="password" name="password" class="form-control" placeholder="Password" />
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label" style="color: #096967;">E-mail:</label>
                            <div class="col-sm-6">
                                <input type="email" name="email" class="form-control" placeholder="some@email.com" value="${email!''}" />
                            </div>
                        </div>

                        <button class="btn btn-primary" type="submit">Save</button>
                        <a href="/user/delete/${userId}" class="btn btn-primary">Delete User</a>
                    </form>
                </div>

                <div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab">
                    <h5 style="color: #1BA0B6; font-size: xx-large; font-family: 'Didact Gothic', 'Catamaran', sans-serif" ><strong>Your Ques</strong></h5>
                    <div class="mt-3 col-7">
                        <ul class="list-group">
                            <#list ques as que>
                                <div id="queCard" class="card mb-2 ">
                                    <div class="d-flex justify-content-between">
                                        <a id="queInfo" class="mt-2 mb-1 pl-3"  href="/answerQue/${que.getId()}" methods="get">
                                            <strong>${que.getQueName()}</strong>
                                            <br>
                                            <i style="font-size: medium;">${que.getQueDescription()}</i>
                                        </a>

                                        <div class="d-flex align-items-center pr-3">
                                            <a class="badge badge-info badge-pill mr-2" href="/statisticQue/${que.getId()}" methods="get"
                                               data-toggle="tooltip" title="Here you can see statics for the Que. Statistic shows first 6 the most popular answers.">
                                                Dashboard
                                            </a>
                                            <span class="badge badge-info badge-pill">${que.getQuestionsCount()}</span>
                                        </div>
                                    </div>

                                    <a href="/delete/${que.getId()}" class="fa fa-trash mr-3 mb-2 d-flex justify-content-end" id="deleteQueButton"></a>
                                </div>
                            </#list>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <script src="../js/hideBottomNavbar.js"></script>
</@c.page>

<#import "parts/common.ftl" as c>

<@c.page true>
    <div class="greeting">
        <div class="container-fluid mx-auto">

            <img class="kit" src="/images/kit.png" alt="">
            <h1 class="display-4"><#if isRussian??>Привет<#else>Hello</#if></h1>
            <p class="lead"><#if isRussian??>Меня зовут Que. Я кит. Я буду помогать тебе создавать анкты. <#else>My name is Que. I am a Kit. I will help you to create questionaries.</#if> </p>
            <hr class="col-10 my-4">
            <p><#if isRussian??>Это приложение использует Гугл-формы в качестве примера.<#else>It uses GoogleForm as example.</#if></p>
            <div class="d-flex justify-content-center"><a href="/main" id="startButton"
                                                          class="btn btn-info"
                                                          role="button"><#if isRussian??>Начать работу<#else>Start use Que</#if></a></div>
        </div>
    </div>

</@c.page>


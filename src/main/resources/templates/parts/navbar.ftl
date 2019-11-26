<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a id="navlink" class="navbar-brand" href="/">Que</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a id="navlink" class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a id="navlink" class="nav-link" href="/main">Ques</a>
            </li>
            <li class="nav-item">
                <a id="navlink" class="nav-link" href="/newQue">Create Que</a>
            </li>
            <#if isAdmin>
                <li class="nav-item">
                    <a id="navlink" class="nav-link" href="/user">User list</a>
                </li>
            </#if>
            <#if user??>
                <li class="nav-item">
                    <a id="navlink" class="nav-link" href="/user/profile">Profile</a>
                </li>
            </#if>
        </ul>

        <div class="mt-3">
            <button id="russian" value=true>True</button>
            <button id="english" value=false>False</button>
            <#assign isRussian = document.getElementById("russian").value/>
        </div>



        <div class="navbar-text ml-3 mr-3">${name}</div>
        <#if user??><@l.logout/></#if>

    </div>
</nav>

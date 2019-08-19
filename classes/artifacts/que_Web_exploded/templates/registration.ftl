<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>

    <div class="card text-center">
        <div class="card-header">
            <ul class="nav nav-pills card-header-pills">
                <li class="nav-item">
                    <a class="nav-link active" href="/login">Sign In</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/registration">Sign Up</a>
                </li>
            </ul>
        </div>
        <div class="card-body">
            ${message!}
            <@l.login "/registration" true />
        </div>
    </div>

</@c.page>

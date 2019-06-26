<#import "parts/common.ftl" as c>


<@c.page>
    <h5><strong>User editor</strong></h5>

    <form action="/user" method="post">

        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <input type="text" name="username" value="${user.username}"/>

        <#list roles as role>
            <div>
                <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
            </div>
        </#list>

        <input type="hidden" value="${user.id}" name="userId">

        <button class="btn btn-outline-info" type="submit">Save</button>

    </form>
</@c.page>
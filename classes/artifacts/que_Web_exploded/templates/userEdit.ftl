<#import "parts/common.ftl" as c>


<@c.page>
    <h3><strong>User editor</strong></h3>

    <form action="/user" method="post">
        <div class="form-group">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <h5><strong>User: ${user.username}</strong></h5>

        <#list roles as role>
            <div class="custom-control custom-checkbox">
                <label class="custom-control-label">
                    <input type="checkbox" id="userRole" class="custom-control-input"
                           name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
            </div>
        </#list>

        <input type="hidden" value="${user.id}" name="userId">

        <button class="btn btn-outline-info" type="submit">Save</button>
        </div>
    </form>
</@c.page>
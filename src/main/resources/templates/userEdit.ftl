<#import "parts/common.ftl" as c>


<@c.page>
    <h3><strong>User editor</strong></h3>

    <form action="/user" method="post">
        <div class="form-group">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <h5><strong>Edit roles for "${user.username}"</strong></h5>

        <#list roles as role>
            <div class="checkboxContainer">
                <label class="custom-control custom-checkbox">
                    <input type="checkbox" id="checkbox" class="custom-control-input" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>
                    <span class="custom-control-indicator"></span>
                    <span class="custom-control-label">${role}</span>
                </label>
            </div>
        </#list>

            <input type="hidden" value="${user.id}" name="userId">
            <input type="hidden" value="${user.username}" name="username">

            <button class="btn btn-info mt-3" type="submit">Save</button>
        </div>
    </form>
</@c.page>
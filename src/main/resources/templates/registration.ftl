<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <div class="mb-5"><h4>Add new user</h4></div>

        <div class="mb-3"><h5 style="color: #096967;">${message?ifExists}</h5></div>
        <@l.login "/registration" true/>


</@c.page>


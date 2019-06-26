<#assign
    known = Session.SPRING_SECURITY_CONTEXT??
>
<#if known>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        userName = user.getUsername()
        userId = user.getId()
        isAdmin = user.isAdmin()
    >
<#else>
    <#assign
        userName = "unknown"
        isAdmin = false
        userId = -1
    >
</#if>
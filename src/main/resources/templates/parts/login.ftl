<#include "security.ftl">

<#macro login path isRegisterForm>

    <div class="card mx-auto text-center " style="width: 30rem">
        <div class="card-header">
            <ul class="nav nav-tabs card-header-tabs">
                <li class="nav-item">
                    <a class="nav-link <#if !isRegisterForm>active</#if>" href="/login">Sign In</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <#if isRegisterForm>active</#if>" href="/registration">Sign Up</a>
                </li>
            </ul>
        </div>
        <div class="card-body ">

            <form  action="${path}" method="post" class="">
                <div class="form-group row">
                    <div class="mx-auto col-sm-11">
                        <input type="text" name="username" value="<#if user??>${user.username}</#if>"
                               class="form-control ${(usernameError??)?string('is-invalid', '')}"
                               placeholder="User name" />
                        <#if usernameError??>
                            <div class="invalid-feedback">
                    ${usernameError}
                </div>
                        </#if>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="mx-auto col-sm-11">
                        <input type="password" name="password"
                               class="form-control ${(passwordError??)?string('is-invalid', '')}"
                               placeholder="Password" />
                        <#if passwordError??>
                            <div class="invalid-feedback">
                    ${passwordError}
                </div>
                        </#if>
                    </div>
                </div>
                <#if isRegisterForm>
                    <div class="form-group row">
                        <div class="mx-auto col-sm-11">
                            <input type="password" name="password2"
                                   class="form-control ${(password2Error??)?string('is-invalid', '')}"
                                   placeholder="Retype password" />
                            <#if password2Error??>
                                <div class="invalid-feedback">
                        ${password2Error}
                    </div>
                            </#if>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="mx-auto col-sm-11">
                            <input type="email" name="email" value="<#if user??>${user.email}</#if>"
                                   class="form-control ${(emailError??)?string('is-invalid', '')}"
                                   placeholder="some@some.com" />
                            <#if emailError??>
                                <div class="invalid-feedback">
                        ${emailError}
                    </div>
                            </#if>
                        </div>
                    </div>
                </#if>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <#--   <#if !isRegisterForm><a role="button" class="btn btn-primary" href="/registration">Sing Up</a></#if>-->
                <button class="btn btn-info col-sm-11" type="submit"><#if isRegisterForm>Sing Up<#else>Sign In</#if></button>
            </form>
        </div>
    </div>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-info" type="submit">Sign out</button>
    </form>
</#macro>
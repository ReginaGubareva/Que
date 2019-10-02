<#import "parts/common.ftl" as c>

<@c.page>
    <div class="container mx-auto justify-align-center">
        <h5 class="header"><strong>List of users</strong></h5>

        <table class="table mt-4">
            <thead>
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Role</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <#list users as user>
                <tr>
                    <td>${user.username}</td>
                    <td><#list user.roles as role>${role}<#sep>, </#list></td>
                    <td><a href="/user/${user.id}">Edit</a></td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>

    <script src="../js/hideBottomNavbar.js"></script>
</@c.page>
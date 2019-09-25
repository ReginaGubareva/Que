<#import "parts/common.ftl" as c>

<@c.page>

    <form action="/newQue" method="post" >

        <input type="hidden" name="_csrf" value="${_csrf.token}" />

        <div>
            <input type="text" id="queName" name="queName" class="form-control mb-4" placeholder="Enter name of que" style="width: 50rem;">
            <input type="text" id="queDescription" name="queDescription" class="form-control mb-3" placeholder="Enter description" style="width: 50rem;">
        </div>

        <div id="buttonBar" class="btn-group" role="group">
            <input type="button" class="btn btn-secondary" id="addQuestion"  value="+"/>
            <input type="button" class="btn btn-secondary" id="prompt" value="?"/>
        </div>

        <div class="questions mb-3" id="questions"></div>

        <div style="margin-left: 350px;">
            <button type ="submit" class="btn btn-outline-info mb-3" id="create">Create</button>
        </div>
    </form>

    <script src="/js/newQue.js"></script>

</@c.page>
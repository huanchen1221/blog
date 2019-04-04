<form action="/blogs" method="post">
    <input name="id" value="${blog.id}" type="hidden">
    Title:<br>
    <input type="text" name="title" value="${blog.title}">
    <br><br>
    Content:<br>
    <input type="text" name="content" value="${blog.content}">
    <br><br>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Submit">
</form>
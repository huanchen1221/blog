<%@ page contentType="text/html;charset=UTF-8" %>

<html xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
<!-- start of nav bar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Huan</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">Blogs <span class="sr-only">(current)</span></a>
            </li>

            <li class="nav-item active">
                <a class="nav-link" href="/blogs/new">PostBlogs <span class="sr-only">(current)</span></a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<!-- end of nav bar -->
<!-- <div>
  <h1 style="text-align:center;font-family:verdana">title</h1>
  <p>content</p>
</div> -->

<!-- page content -->
<div class="card mb-3">
    <%--<img src="McQ.jpeg" class="card-img-top" alt="">--%>
    <div class="card-body">
        <h5 class="card-title">${blogForView.title}</h5>
        <p class="card-text">${blogForView.content}</p>
        <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
        <!--controller provide value-->
    </div>
</div>

</body>

</html>

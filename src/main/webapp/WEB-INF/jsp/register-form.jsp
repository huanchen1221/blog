<form method="POST" action="/register" class="form-signin">
  <h2 class="form-heading">Sign up</h2>

  <div class="form-group">
    <input name="username" type="text" class="form-control" placeholder="Username"
           autofocus="true"/>
    <input name="password" type="password" class="form-control" placeholder="Password"/>
    <input name="passwordConfirmation" type="password" class="form-control" placeholder="password confirmation"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
    <h4 class="text-center"><a href="/register">Create an account</a></h4>
  </div>
</form>
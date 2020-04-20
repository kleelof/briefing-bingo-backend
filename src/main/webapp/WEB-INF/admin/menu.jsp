<div class="row">
  <div class="col-12">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a class="navbar-brand" href="/admin">Bingo!</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
    
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="/admin/phrases">Phrases</a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="/admin/cards">Bingo Cards</a>
          </li>
        </ul>
        <form action="/logout" class="form-inline my-2 my-lg-0" form-method="get">
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
          <button class="btn btn-outline-danger my-2 my-sm-0 btn-sm" type="submit">Logout</button>
        </form>
      </div>
    </nav>
  </div>
</div>

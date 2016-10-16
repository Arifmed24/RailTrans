<%@include file="/header.jsp"%>
  <div class="main_body">
    <section>
      <div class="body_header">
        <h1> Passenger </h1>
      </div>
    </section>
    <div class="rail_form">
    <form action="/createticket" method="post">
          <div>
                <label>Fisrt name:</label>
                <input type="text" name="first">
          </div>
          <div>
                <label>Last name:</label>
                <input type="text" name="last">
          </div>
          <div>
                <label>Birth:</label>
                <input type="text" name="birth">
          </div>
          <div class="form_submit btn-default">
                <input type="submit" value="Add">
          </div>
    </form>
    </div>
  </div>
<%@include file="/bottom.jsp"%>
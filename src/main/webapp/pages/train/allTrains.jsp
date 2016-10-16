<%@include file="/header.jsp"%>
		<div class="main_body">
			<section>
				<div class="body_header">
					<h1> Trains </h1>
				</div>
				<div class="rr_new_button">
					<div class="btn-primary">
                      <a href="/newtrain">New train</a>
					</div>
				</div>
				<div class="rr_table">
                <table>
                  <tr>
                      <th> Train </th>
                      <th> Seats </th>
                  </tr>
                  <c:forEach var="train" items="${trains}">
                  <tr>
                    <td><c:out value="${train.idTrain}" /> </td>
                    <td><c:out value="${train.seats}" /> </td>
                  </tr>
                  </c:forEach>
                </table>

                 </div>
 			</section>
 		</div>
      <%@include file="/bottom.jsp"%>
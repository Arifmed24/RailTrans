<%@include file="/header.jsp"%>
		<div class="main_body">
			<section>
				<div class="body_header">
					<h1> Stations </h1>
				</div>
				<div class="rr_new_button">
					<div class="btn-primary">
						<div class="btn-primary">
                          <a href="/newstation">New station</a>
                        </div>
					</div>
				</div>
				<div class="rr_table">
                    <table>
                          <tr>
                              <th> Station </th>
                              <th> Name </th>
                              <th> Change name </th>
                          </tr>
                          <c:forEach var="station" items="${stations}">
                          <tr>
                            <td><c:out value="${station.idStation}" /> </td>
                            <td><c:out value="${station.stationName}" /> </td>
                            <td>
                            	<div class="rr_button">
                               <form action="/updatestation" method=GET>
                                    <input type="hidden" name="idStation" value="${station.idStation}">
                                   <input class="btn-success " type="submit" value="Update">
                               </form>
                                <form action="/stationtimetable" method=GET>
                                       <input type="hidden" name="idStation" value="${station.idStation}">
                                       <input type="hidden" name="nameStation" value="${station.stationName}">
                                      <input class="btn-success " type="submit" value="Timetable">
                                  </form>
                            </div>
                           </td>
                          </tr>
                          </c:forEach>
                        </table>
                    </div>
			</section>
		</div>
     <%@include file="/bottom.jsp"%>

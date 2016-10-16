    <%@include file="/header.jsp"%>
		<div class="main_body">
			<section>
				<div class="body_header">
					<h1> Choose station and date</h1>
				</div>
			</section>
			<div class="rail_form">
                <form action="/stationtimetable" method="POST">
                     <div>
                         <label>
                         Station:
                         </label>
                         <select name="stationId">
                            <option selected value="${idStation}">${nameStation}</option>
                            <c:forEach items="${stations}" var="s">
                               <option value="${s.idStation}">${s.stationName}</option>
                            </c:forEach>
                         </select>
                     </div>
                     <div>
                        <label>
                            Date:
                        </label>
                        <input name="date" id="date" type="text" size="9">
                     </div>
                     <div class="form_submit btn-default">
                        <input type="submit" value="Get timetable " />
                     </div>
                </form>
            </div>
 		</div>
    <%@include file="/bottom.jsp"%>

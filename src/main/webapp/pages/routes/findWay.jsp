<%@include file="/header.jsp"%>
    <div class="main_body">
        <section>
            <div class="body_header">
                <h1> Find the way</h1>
            </div>
        </section>
			<div class="rail_form">
              <form action = "/findway" method="POST">
                <div>
                 <label> Station departure:</label>
                    <select name="stationDep">
                        <c:forEach items="${stations}" var="s">
                           <option value="${s.idStation}">${s.stationName}</option>
                        </c:forEach>
                    </select>
                 </div>
                 <div>
                    <label> Station arrival:</label>
                     <select name="stationArr">
                         <c:forEach items="${stations}" var="s">
                            <option value="${s.idStation}">${s.stationName}</option>
                         </c:forEach>
                     </select>
                 </div>
                 <div>
                     <label>Date departure: </label>
                     <input name="dateDep" id="date" type="text" size="9">
                 </div>
                 <div>
                     <label>Date arrival: </label>
                     <input name="dateArr" id="date"  type="text" size="9">
                 </div>
                 <div class="double-button">
                     <button name = "search" type="submit" value="ways">Find way</button>

                     <button name = "search" type="submit" value="passengers">Find passengers</button>
                    <%--<input type="submit" name="search" value="Find" />--%>
                 </div>
                  <%--<div class="form_submit btn-default">--%>
                      <%--<input type="submit" name="pas" value="Passengers of route" />--%>
                      <%--<button name = "search" type="submit" value="passengers">Find passengers</button>--%>
                  <%--</div>--%>
              </form>
            </div>
    </div>
<%@include file="/bottom.jsp"%>

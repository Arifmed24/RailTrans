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

                     <div class="form-group">
                         <label>Date departure: </label>
                         <div class="input-group date" id="datetimepicker1">
                             <input data-format="MM-dd-yyyy HH:mm:ss" type="text"  name="dateDep"/>
                             <span class="input-group-addon">
                                <span class="glyphicon-calendar glyphicon"></span>
                             </span>
                         </div>
                         <label>Date arrival: </label>
                         <div class="input-group date" id="datetimepicker2">
                             <input name="dateArr" id="date"  type="text" size="9">
                             <span class="input-group-addon">
                                    <span class="glyphicon-calendar glyphicon"></span>
                             </span>
                         </div>
                     </div>
                     <script type="text/javascript">
                         var start="<?=$date?>";
                         var date = new Date();
                         var today = new Date(date.getFullYear(), date.getMonth(), date.getDate());
                         $(function () {
                             $('#datetimepicker1').datetimepicker({language: 'ru', useSeconds: 'true', format: 'DD/MM/YYYY',defaultDate:start, pickTime: false, minDate:today});
                         });
                     </script>
                     <script type="text/javascript">
                         var start="<?=$date?>";
                         var date = new Date();
                         var today = new Date(date.getFullYear(), date.getMonth(), date.getDate());
                         $(function () {
                             $('#datetimepicker2').datetimepicker({language: 'ru', useSeconds: 'true', format: 'DD/MM/YYYY',defaultDate:start, pickTime: false, minDate:today});
                         });
                     </script>
                 </div>
                 <div class="double-button">
                     <button name = "search" type="submit" value="ways">Find way</button>
                     <c:if test="${sessionScope.user.role eq 'ADMIN'}">
                     <button name = "search" type="submit" value="passengers">Find passengers</button>
                     </c:if>
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

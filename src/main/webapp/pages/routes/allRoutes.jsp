<%@include file="/header.jsp"%>
    <div class="main_body">
        <section>
            <div class="body_header">
                <h1> Routes </h1>
            </div>

                <div class="rr_table">
                    <table>
                        <tr>
                          <th> Route </th>
                          <th> Stations </th>
                        </tr>
                       <c:forEach var="route" items="${routes}" varStatus="itemsRow">
                          <tr>
                               <td>
                               <c:out value="${route.key}" />
                               </td>
                               <td>
                              <c:out value="${route.value}" />
                               </td>
                         </tr>
                       </c:forEach>
                    </table>
                </div>
                </section>
                <div class="rail_form">
                    <form action="/findway" method="GET">
                        <div class="form_submit btn-default">
                            <input type="submit" value="Find way">
                        </div>
                    </form>
                </div>

    </div>
<%@include file="/bottom.jsp"%>
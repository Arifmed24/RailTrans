<%@include file="/header.jsp"%>
    <div class="main_body">
        <section>
            <div class="body_header">
                <h1> Update station</h1>
            </div>
        </section>
			<div class="rail_form">
                <form action="/updatestation" method="POST">
                    <div>
                    <label>Name of station</label>
                    <input type="text" name="idStation" value="${station.stationName}">
                    </div>
                    <div class="form_submit btn-default">
                    <input type="submit" value="Update">
                    </div>
                </form>
            </div>
    </div>
<%@include file="/bottom.jsp"%>
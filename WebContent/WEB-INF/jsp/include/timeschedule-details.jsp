<%@ include file="/common/taglibs.jsp"%>
<s:if test="application.timeSchedules!=null">
<h3>TIME SCHEDULE</h3>
<div>
	<div>
	    <table class="table" id="tsTable">
	       	<tr>
				<td>
					<div class="row">
						<div class="col-xs-6 col-md-6">
			                <label for="duration" class="col-xs-12">How long will your project last?</label>
			                <span class="col-xs-12"><s:property value="application.timeSchedules.duration" /></span>
			            </div>
			            
		                <div class="col-xs-6 col-md-6">
		                	<label for="startMonthYearPeriod" class="col-xs-12">When do you wish to start your project?</label>
		                    <span class="col-xs-12"><s:property value="application.timeSchedules.startMonthYearPeriod" /></span>
		                </div>
		            </div>
				</td>
			</tr>
	    </table>
	</div>
</div>
</s:if>
<%@ include file="/common/taglibs.jsp"%>

<h3>TIME SCHEDULE</h3>

	<div>
	    <table class="table" id="tsTable">
	       	<tr>
				<td>
					<div class="row">
						<div class="form-group">
							<div class="col-xs-6 col-md-6">
								<label for="duration" class="col-xs-12">How long will your project last? (in months):</label>
				                <s:textfield cssClass="form-control" id="duration" name="cdoGraduateApplication.timeSchedules.duration" value="%{cdoGraduateApplication.timeSchedules.duration}" />
				            </div>
				            
			                <div class="col-xs-6 col-md-6">
			                	<label for="startMonthYearPeriod" class="col-xs-12">When do you wish to start your project (MM/YYYY)?:</label>
			                	<s:textfield cssClass="form-control" id="startMonthYearPeriod" name="cdoGraduateApplication.timeSchedules.startMonthYearPeriod" value="%{cdoGraduateApplication.timeSchedules.startMonthYearPeriod}" />
			                </div>
		                </div>
		            </div>
				</td>
			</tr>
	    </table>
	</div>

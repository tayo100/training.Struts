<%@ include file="/common/taglibs.jsp"%>

<h3>EMPLOPYMENT HISTORY</h3>
<h4>Current Position</h4>
	<div>
	    <table class="table" id="employmentTable">
	       	<tr>
				<td>
					<div class="row">
						<div class="form-group">
							<div class="col-xs-6 col-md-6">
				                <label for="orgname" class="col-xs-12">Employing Organisation</label>
				                <s:textfield cssClass="form-control" id="orgname" name="cdoBioData.employmentHistory[0].nameOfEmployer" value="%{cdoBioData.employmentHistory[0].nameOfEmployer}" />
				            </div>
				            <div class="col-xs-6 col-md-6">
				                <label for="address" class="col-xs-12">Address of employer</label>
				                <s:textfield cssClass="form-control" id="address" name="cdoBioData.employmentHistory[0].addressOfEmployer" value="%{cdoBioData.employmentHistory[0].addressOfEmployer}" />
				            </div>
				   		</div>
			        </div>
			        
		            <div class="row">
		            	<div class="form-group">
			                <div class="col-xs-12 col-md-12">
			                	<label for="position" class="col-xs-12">Your position</label>
			                    <s:textfield cssClass="form-control" id="position" name="cdoBioData.employmentHistory[0].position" value="%{cdoBioData.employmentHistory[0].position}" />
			                </div>
		                </div>
		            </div>
		            
		            <div class="row">
		            	<div class="form-group">
			            	<div class="col-xs-6 col-md-3">
			                	<label for="startingdate" class="col-xs-12">Starting Date</label><br/>
			                    <iita:datepicker cssClass="form-control" id="startingdate" format="dd/MM/yyyy" name="cdoBioData.employmentHistory[0].startingDate" value="%{cdoBioData.employmentHistory[0].startingDate}" />
			                </div>
			            	<div class="col-xs-6 col-md-3">
			                	<label for="finishingdate" class="col-xs-12">Finishing Date</label><br/>
			                	<iita:datepicker cssClass="form-control" id="finishingdate" format="dd/MM/yyyy" name="cdoBioData.employmentHistory[0].finishingDate" value="%{cdoBioData.employmentHistory[0].finishingDate}" />
			                </div>
			                
			                <div class="col-xs-6 col-md-6">
			                	<label for="empCondition" class="col-xs-12">Type of Employment</label>
			                	<s:radio id="empCondition" value="%{cdoBioData.employmentHistory[0].empCondition}" name="cdoBioData.employmentHistory[0].empCondition" 
			                	list="@org.iita.trainingunit.applications.model.EmploymentHistory$CONDITION@values()" 
			                	listValue="%{getText('employmentHistory.empCondition.'+toString())}" />
							</div>
		                </div>
		            </div>
		            
		            <div class="row">
		                <div class="col-xs-12">
		                	<label for="responsibilites" class="col-xs-12">Your research experience, areas and responsibilities</label>
		                	<s:textarea cssClass="form-control" id="responsibilities" name="cdoBioData.employmentHistory[0].responsibilities" value="%{cdoBioData.employmentHistory[0].responsibilities}" />     
		                </div>
		            </div>
		            
		            <div class="row">
		                <div class="col-xs-6">
		                	<label for="supervisorname" class="col-xs-6">Supervisor Name</label>
		                	<s:textfield cssClass="form-control" id="supervisorname" name="cdoBioData.employmentHistory[0].supervisorName" value="%{cdoBioData.employmentHistory[0].supervisorName}" />
		                </div>
		                <div class="col-xs-6">
		                	<label for="supervisoremail" class="col-xs-6">Supervisor Email</label>
		                	<s:textfield cssClass="form-control" id="supervisoremail" name="cdoBioData.employmentHistory[0].supervisorEmail" value="%{cdoBioData.employmentHistory[0].supervisorEmail}" />
		                </div>
		            </div>
				</td>
			</tr>
	    </table>
	</div>

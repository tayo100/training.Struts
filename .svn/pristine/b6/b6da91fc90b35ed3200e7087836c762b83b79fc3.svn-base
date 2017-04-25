<%@ include file="/common/taglibs.jsp"%>

<h3>Administrative/Research Experience</h3>
<h4>Current Position</h4>
	<div>
	    <table class="table" id="adminExpTable">
	       	<tr>
				<td>
					<div class="row">
						<div class="form-group">
							<div class="col-xs-12 col-md-12">
				                <label for="orgname" class="col-xs-12">Employing Organisation</label>
				                <s:textfield cssClass="form-control" id="orgname" name="cdoSabbaticalApplication.adminExperiences.nameOfEmployer" value="%{cdoSabbaticalApplication.adminExperiences.nameOfEmployer}" />
				            </div>
				   		</div>
			        </div>
			        
		            <div class="row">
		            	<div class="form-group">
			                <div class="col-xs-12 col-md-12">
			                	<label for="position" class="col-xs-12">Your position</label>
			                    <s:textfield cssClass="form-control" id="position" name="cdoSabbaticalApplication.adminExperiences.position" value="%{cdoSabbaticalApplication.adminExperiences.position}" />
			                </div>
		                </div>
		            </div>
		            
		            <div class="row">
		            	<div class="form-group">
			            	<div class="col-xs-6 col-md-3">
			                	<label for="startingdate" class="col-xs-12">Starting Date</label><br/>
			                    <iita:datepicker cssClass="form-control" id="startingdate" format="dd/MM/yyyy" name="cdoSabbaticalApplication.adminExperiences.startingDate" value="%{cdoSabbaticalApplication.adminExperiences.startingDate}" />
			                </div>
			            	<div class="col-xs-6 col-md-3">
			                	<label for="finishingdate" class="col-xs-12">Finishing Date</label><br/>
			                	<iita:datepicker cssClass="form-control" id="finishingdate" format="dd/MM/yyyy" name="cdoSabbaticalApplication.adminExperiences.finishingDate" value="%{cdoSabbaticalApplication.adminExperiences.finishingDate}" />
			                </div>
			                
			                <div class="col-xs-6 col-md-6">
			                	<label for="empCondition" class="col-xs-12">Type of Employment</label>
			                	<s:radio id="empCondition" value="%{cdoSabbaticalApplication.adminExperiences.empCondition}" name="cdoSabbaticalApplication.adminExperiences.empCondition" 
			                	list="@org.iita.trainingunit.applications.model.AdministrativeExperience$CONDITION@values()" 
			                	listValue="%{getText('employmentHistory.empCondition.'+toString())}" />
							</div>
		                </div>
		            </div>
		            
		            <div class="row">
		                <div class="col-xs-6 col-md-6">
			               	<label for="adminResponsibility" class="col-xs-12">Do you have administrative responsibility?</label>
			               	<s:radio id="adminResponsibility" value="%{cdoSabbaticalApplication.adminExperiences.adminResponsibility}" name="cdoSabbaticalApplication.adminExperiences.adminResponsibility" 
			               	list="#{'Yes':'Yes','No':'No'}" />
						</div>
						<div class="col-xs-6 col-md-6">
			               	<label for="adminDescription" class="col-xs-12">If Yes describe</label>
			               	<s:textfield cssClass="form-control" id="adminDescription" value="%{cdoSabbaticalApplication.adminExperiences.adminDescription}" name="cdoSabbaticalApplication.adminExperiences.adminDescription" />
						</div>
		            </div>
		            
		            <div class="row">
		                <div class="col-xs-6 col-md-6">
			               	<label for="scientificResponsibility" class="col-xs-12">Do you have scientific responsibility?</label>
			               	<s:radio id="scientificResponsibility" value="%{cdoSabbaticalApplication.adminExperiences.scientificResponsibility}" name="cdoSabbaticalApplication.adminExperiences.scientificResponsibility" 
			               	list="#{'Yes':'Yes','No':'No'}" />
						</div>
						<div class="col-xs-6 col-md-6">
			               	<label for="scientificDescription" class="col-xs-12">If Yes describe</label>
			               	<s:textfield cssClass="form-control" id="scientificDescription" value="%{cdoSabbaticalApplication.adminExperiences.scientificDescription}" name="cdoSabbaticalApplication.adminExperiences.scientificDescription" />
						</div>
		            </div>
		            
		            <div class="row">
		            	<div class="form-group">
			                <div class="col-xs-12 col-md-12">
			                	<label for="experience" class="col-xs-12">Describe your research experience (publications, etc.)</label>
			                    <s:textarea cssClass="form-control" id="experience" name="cdoSabbaticalApplication.adminExperiences.experience" value="%{cdoSabbaticalApplication.adminExperiences.experience}" />
			                </div>
		                </div>
		            </div>
				</td>
			</tr>
	    </table>
	</div>

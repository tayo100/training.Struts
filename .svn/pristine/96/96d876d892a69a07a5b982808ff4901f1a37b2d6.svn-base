<%@ include file="/common/taglibs.jsp"%>

<h3>PREVIOUS EMPLOPYMENT HISTORY</h3>
<div>
<h4>Previous Positions</h4>
	<div>
	    <table id="prevemploymentTable">
		<s:iterator value="cdoBioData.previousEmploymentHistory" status="status">
			<s:set name="empIndex" value="#status.index" />
			<tr>
				<td>
					<div class="row">
						<div class="form-group">
							<div class="col-xs-12 col-md-6">
				                <label for="orgname" class="col-xs-6"><strong>Employing Organisation</strong></label>
				                <s:textfield cssClass="form-control" id="orgname" name="cdoBioData.previousEmploymentHistory[%{empIndex}].nameOfEmployer" value="%{nameOfEmployer}" />
				            </div>
				            <div class="col-xs-12 col-md-6">
				                <label for="address" class="col-xs-6"><strong>Address of employer</strong></label>
				                <s:textfield cssClass="form-control" id="address" name="cdoBioData.previousEmploymentHistory[%{empIndex}].addressOfEmployer" value="%{addressOfEmployer}" />
				            </div>
				        </div>
			        </div>
			        
		            <div class="row">
		            	<div class="form-group">
			                <div class="col-xs-12 col-md-12">
			                	<label for="position" class="col-xs-12">Your position</label>
			                    <s:textfield cssClass="form-control" id="position" name="cdoBioData.previousEmploymentHistory[%{empIndex}].position" value="%{position}" />
			                </div>
		               	</div>
		            </div>
		            
		            <div class="row">
		            	<div class="form-group">
			            	<div class="col-xs-6 col-md-3">
			                	<label for="startingdate" class="col-xs-12">Starting Date</label>
			                    <iita:datepicker cssClass="form-control" id="startingdate" format="dd/MM/yyyy" name="cdoBioData.previousEmploymentHistory[%{empIndex}].startingDate" value="%{startingDate}" />
			                </div>
			            	
			            	<div class="col-xs-6 col-md-3">
			                	<label for="finishingdate" class="col-xs-12">Finishing Date</label>
			                	<iita:datepicker cssClass="form-control" id="finishingdate" format="dd/MM/yyyy" name="cdoBioData.previousEmploymentHistory[%{empIndex}].finishingDate" value="%{finishingDate}" />
			                </div>
			                <div class="col-xs-6 col-md-6">
			                	<label for="prevempCondition%{empIndex}" class="col-xs-12">Type of Employment</label>
			                	<s:radio id="prevempCondition%{empIndex}" value="%{empCondition}" name="cdoBioData.previousEmploymentHistory[%{empIndex}].empCondition" list="@org.iita.trainingunit.applications.model.PreviousEmploymentHistory$CONDITION@values()" listValue="%{getText('employmentHistory.empCondition.'+toString())}" />
							</div>
						</div>
		            </div>
		            
		            <div class="row">
		            	<div class="form-group">
			                <div class="col-xs-12 col-md-12">
			                	<label for="responsibilites" class="col-xs-12">Your research experience, areas and responsibilities</label>
			                	<s:textarea cssClass="form-control" id="responsibilities" name="cdoBioData.previousEmploymentHistory[%{empIndex}].responsibilities" value="%{responsibilities}" />     
			                </div>
			            </div>
		            </div>
		            
		            <div class="row">
		            	<div class="form-group">
			                <div class="col-xs-6 col-md-6">
			                	<label for="supervisorname" class="col-xs-12">Supervisor Name</label>
			                	<s:textfield cssClass="form-control" id="supervisorname" name="cdoBioData.previousEmploymentHistory[%{empIndex}].supervisorName" value="%{supervisorName}" />
			                </div>
			                <div class="col-xs-6 col-md-6">
			                	<label for="supervisoremail" class="col-xs-12">Supervisor Email</label>
			                	<s:textfield cssClass="form-control" id="supervisoremail" name="cdoBioData.previousEmploymentHistory[%{empIndex}].supervisorEmail" value="%{supervisorEmail}" />
			                </div>
			             </div>
		            </div>
		            
		            <div class="row">
		            	<div class="form-group">
			                <div class="col-xs-12 col-md-12">
			                	<label for="fullPublicationDetails" class="col-xs-12">Full details of your own publications. Group them as journal publications (including manuscripts in preparation), conference papers, posters, reports and degree thesis. Start with the most recent ones for each group.</label>
			                	<s:textarea cssClass="form-control" id="fullPublicationDetails" name="cdoBioData.previousEmploymentHistory[%{empIndex}].fullPublicationDetails" value="%{fullPublicationDetails}" />     
			                </div>
		                </div>
		            </div>
		            <div class="clearfix">&nbsp;</div>
				</td>
			</tr>
		</s:iterator>
	       	<tr>
				<td>
					<div class="row">
						<div class="form-group">
							<div class="col-xs-6 col-md-6">
				                <label for="orgname" class="col-xs-12"><strong>Employing Organisation</strong></label>
				                <s:textfield cssClass="form-control" id="orgname" name="cdoBioData.previousEmploymentHistory[%{cdoBioData.previousEmploymentHistory.size}].nameOfEmployer" value="%{nameOfEmployer}" />
				            </div>
				            <div class="col-xs-6 col-md-6">
				                <label for="address" class="col-xs-12"><strong>Address of employer</strong></label>
				                <s:textfield cssClass="form-control" id="address" name="cdoBioData.previousEmploymentHistory[%{cdoBioData.previousEmploymentHistory.size}].addressOfEmployer" value="%{addressOfEmployer}" />
				            </div>
				        </div>
			        </div>
			        
		            <div class="row">
		            	<div class="form-group">
			                <div class="col-xs-12 col-md-12">
			                	<label for="position" class="col-xs-12">Your position</label>
			                    <s:textfield cssClass="form-control" id="position" name="cdoBioData.previousEmploymentHistory[%{cdoBioData.previousEmploymentHistory.size}].position" value="%{position}" />
			                </div>
		                </div>
		            </div>
		            
		            <div class="row">
		            	<div class="form-group">
			            	<div class="col-xs-6 col-md-3">
			                	<label for="startingdate" class="col-xs-12">Starting Date</label>
			                    <iita:datepicker cssClass="form-control" id="startingdate" format="dd/MM/yyyy" name="cdoBioData.previousEmploymentHistory[%{cdoBioData.previousEmploymentHistory.size}].startingDate" value="%{startingDate}" />
			                </div>
			            	
			            	<div class="col-xs-6 col-md-3">
			                	<label for="finishingdate" class="col-xs-12">Finishing Date</label>
			                	<iita:datepicker cssClass="form-control" id="finishingdate" format="dd/MM/yyyy" name="cdoBioData.previousEmploymentHistory[%{cdoBioData.previousEmploymentHistory.size}].finishingDate" value="%{finishingDate}" />
			                </div>
			                
			                <div class="col-xs-6 col-md-6">
			                	<label for="prevempCondition%{cdoBioData.previousEmploymentHistory.size}" class="col-xs-12">Type of Employment</label>
			                	<s:radio id="prevempCondition%{cdoBioData.previousEmploymentHistory.size}" value="%{empCondition}" name="cdoBioData.previousEmploymentHistory[%{cdoBioData.previousEmploymentHistory.size}].empCondition" list="@org.iita.trainingunit.applications.model.PreviousEmploymentHistory$CONDITION@values()" listValue="%{getText('employmentHistory.empCondition.'+toString())}" />
							</div>
						</div>
		            </div>
		            
		            <div class="row">
		            	<div class="form-group">
			                <div class="col-xs-12 col-md-12">
			                	<label for="responsibilites" class="col-xs-12">Your research experience, areas and responsibilities</label>
			                	<s:textarea cssClass="form-control" id="responsibilities" name="cdoBioData.previousEmploymentHistory[%{cdoBioData.previousEmploymentHistory.size}].responsibilities" value="%{responsibilities}" />     
			                </div>
		                </div>
		            </div>
		            
		            <div class="row">
		            	<div class="form-group">
			                <div class="col-xs-6 col-md-6">
			                	<label for="supervisorname" class="col-xs-12">Supervisor Name</label>
			                	<s:textfield cssClass="form-control" id="supervisorname" name="cdoBioData.previousEmploymentHistory[%{cdoBioData.previousEmploymentHistory.size}].supervisorName" value="%{supervisorName}" />
			                </div>
			                <div class="col-xs-6 col-md-6">
			                	<label for="supervisoremail" class="col-xs-12">Supervisor Email</label>
			                	<s:textfield cssClass="form-control" id="supervisoremail" name="cdoBioData.previousEmploymentHistory[%{cdoBioData.previousEmploymentHistory.size}].supervisorEmail" value="%{supervisorEmail}" />
			                </div>
			            </div>
		            </div>
		            
		            <div class="row">
		            	<div class="form-group">
			                <div class="col-xs-12">
			                	<label for="fullPublicationDetails" class="col-xs-12">Full details of your own publications. Group them as journal publications (including manuscripts in preparation), conference papers, posters, reports and degree thesis. Start with the most recent ones for each group.</label>
			                	<s:textarea cssClass="form-control" id="fullPublicationDetails" name="cdoBioData.previousEmploymentHistory[%{cdoBioData.previousEmploymentHistory.size}].fullPublicationDetails" value="%{fullPublicationDetails}" />     
			                </div>
		                </div>
		            </div>
		            <div class="clearfix">&nbsp;</div>
				</td>
			</tr>
			<tr>
				<td><a onclick="javascript: copyEmployment($($(this).parentNode.parentNode).previous(), 3, 0); return false;">More history +</a></td>
			</tr>
	    </table>
	</div>
</div>
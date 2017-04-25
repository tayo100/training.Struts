<%@ include file="/common/taglibs.jsp"%>

<h3>ADMINISTRATIVE/RESEARCH EXPERIENCE</h3>
<h4>Current Position</h4>
	<div>
	    <table class="table" id="employmentTable">
	    <colgroup>
	    	<col />
	    	<col />
	    	<col />
	    </colgroup>
	       	<tr>
				<td>
					<label for="orgname" class="col-xs-12">Employing Organisation</label>
				</td>
				<td colspan="2">            
				    <s:property value="cdoSabbaticalApplication.adminExperiences.nameOfEmployer" />
				</td>
			</tr>
			<tr>
				<td>			        
		            <label for="position" class="col-xs-12">Your position</label>
			    </td>
			    <td colspan="2">            
			        <s:property value="cdoSabbaticalApplication.adminExperiences.position" />
			    </td>
			</tr>
			<tr>
		        <td>
		        	<label for="startingdate" class="col-xs-12">Starting Date</label><br/>
			    	<iita:date format="dd/MM/yyyy" name="cdoSabbaticalApplication.adminExperiences.startingDate" />
			    </td>
			    <td>
			        <label for="finishingdate" class="col-xs-12">Finishing Date</label><br/>
			        <iita:date format="dd/MM/yyyy" name="cdoSabbaticalApplication.adminExperiences.finishingDate" />
			    </td>
			    <td>
			        <label for="empCondition" class="col-xs-12">Type of Employment</label>
			        <s:property value="cdoSabbaticalApplication.adminExperiences.empCondition" />
				</td>
			</tr>
			<tr>
			    <td colspan="3">
		            <label for="empCondition" class="col-xs-12">Do you have administrative responsibility?</label>
			        <s:property value="cdoSabbaticalApplication.adminExperiences.adminResponsibility" />
				</td>
			</tr>
			<tr>	
			    <td colspan="3">
					<label for="adminDescription" class="col-xs-12">If Yes describe</label>
			        <s:property value="cdoSabbaticalApplication.adminExperiences.adminDescription" />
		        </td>
		    </tr>
		    <tr>
			    <td colspan="3">    
		            <label for="scientificResponsibility" class="col-xs-12">Do you have scientific responsibility?</label>
			        <s:property value="cdoSabbaticalApplication.adminExperiences.scientificResponsibility" />
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<label for="scientificDescription" class="col-xs-12">If Yes describe</label>
			        <s:property value="cdoSabbaticalApplication.adminExperiences.scientificDescription" />
				</td>
			</tr>
		    <tr>
		       	<td colspan="3">
			        <label for="experience" class="col-xs-12">Describe your research experience (publications, etc.)</label>
			        <s:property value="cdoSabbaticalApplication.adminExperiences.experience" />
				</td>
			</tr>
	    </table>
	</div>

<%@ include file="/common/taglibs.jsp"%>
<s:if test="biodata.employmentHistory.size>0">
<h3>EMPLOPYMENT HISTORY</h3>
<h4>Current Position</h4>
	<div>
	    <table class="table" id="employmentTable">
	    <colgroup>
	    	<col />
	    	<col />
	    	<col />
	    	<col />
	    </colgroup>
	    	<s:iterator value="biodata.employmentHistory" status="status">
	       	<tr>
				<td colspan="2">
					<div class="col-xs-12">
					    <label for="orgname" class="col-xs-12">Employing Organisation</label>
					    <s:property value="nameOfEmployer" />
					</div>
				</td>
				<td>
					<div class="col-xs-12">
					    <label for="address" class="col-xs-12">Address of employer</label>
					    <s:property value="addressOfEmployer" />
					</div>
				 </td>
			</tr>
			<tr>
				 <td>       
			     	<div class="col-xs-12">
				    	<label for="position" class="col-xs-12">Your position</label>
				        <s:property value="position" />
				    </div>
			    </td>
			    <td>    
			        <div class="col-xs-12">
				                	<label for="startingdate" class="col-xs-12">Starting Date</label><br/>
				                    <iita:date format="dd/MM/yyyy" name="startingDate" />
				                </div>
				</td>
				<td>
				            	<div class="col-xs-12">
				                	<label for="finishingdate" class="col-xs-12">Finishing Date</label><br/>
				                	<iita:date format="dd/MM/yyyy" name="finishingDate" />
				                </div>
				</td>
				<td>                
				                <div class="col-xs-12">
				                	<label for="empCondition" class="col-xs-12">Type of Employment</label>
				                	<s:property value="empCondition" />
								</div>
			     </td>
			    </tr>
			    <tr>
			    	<td colspan="2"> 
			            <div class="row">
			                <div class="col-xs-12">
			                	<label for="responsibilites" class="col-xs-12">Your research experience, areas and responsibilities</label>
			                	<s:property value="responsibilities" />     
			                </div>
			            </div>
			         </td>
			         <td>			         
			            <div class="col-xs-12">
			                	<label for="supervisorname" class="col-xs-12">Supervisor Name</label>
			                	<s:property value="supervisorName" />
			                </div>
			         </td>
			         <td>
			                <div class="col-xs-12">
			                	<label for="supervisoremail" class="col-xs-12">Supervisor Email</label>
			                	<s:property value="supervisorEmail" />
			                </div>
				</td>
			</tr>
			</s:iterator>
	    </table>
	</div>
</s:if>
<%@ include file="/common/taglibs.jsp"%>
<s:if test="biodata.previousEmploymentHistory.size>0">
<h3>PREVIOUS EMPLOPYMENT HISTORY</h3>
<h4>Previous Position</h4>
	<div>
	    <table class="table" id="employmentTable">
	    <colgroup>
	    	<col />
	    	<col />
	    	<col />
	    	<col />
	    </colgroup>
	    <s:iterator value="biodata.previousEmploymentHistory" status="status">
	    	<tr>
				<td colspan="2">
					<div class="col-xs-12">
					     <label for="orgname" class="col-xs-12">Employing Organisation</label>
					     <s:property value="nameOfEmployer" />
					</div>
				</td>
				<td colspan="2">
					<div class="col-xs-12">
					   <label for="address" class="col-xs-12">Address of employer</label>
					   <s:property value="addressOfEmployer" />
					</div>
				</td>
			</tr>
			<tr>
				<td>
			        <div class="col-xs-12 col-md-12">
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
			                <div class="col-xs-12">
			                	<label for="responsibilites" class="col-xs-12">Your research experience, areas and responsibilities</label>
			                	<s:property value="responsibilities" />     
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
			 <tr>
			 	<td colspan="4">			            
			            <div class="col-xs-12">
				                <label class="col-xs-12">Full details of your own publications. Group them as journal publications (including manuscripts in preparation), conference papers, posters, reports and degree thesis. Start with the most recent ones for each group.</label>
				                <div class="col-xs-12">
				                	<s:property value="fullPublicationDetails" />
				                </div>
				       </div>
			     </td>
			  </tr>
		      </s:iterator>
	    </table>
	</div>
</s:if>
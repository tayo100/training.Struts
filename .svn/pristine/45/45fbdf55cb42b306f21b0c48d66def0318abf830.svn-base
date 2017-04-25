<%@ include file="/common/taglibs.jsp"%>

<h3>Milestones</h3>

	<div>
	    <table id="milestoneTable">
	    	<tr>
	    		<td>
	    			<div class="row">
	    				<div class="form-group">
			                <div class="col-xs-6 col-md-6">
			                	<label class="col-xs-12">Milestones</label>
			                </div>
			
			                
			                <div class="col-xs-3 col-md-3">
			                	<label class="col-xs-12">Starting date</label>
			                </div>
			
			                
			                <div class="col-xs-3 col-md-3">
			                	<label class="col-xs-12">Anticipated completion date </label>
			                </div>
			            </div>
		            </div>
	    		</td>
	    	</tr>
		<s:iterator value="cdoGraduateApplication.milestones" status="status">
			<s:set name="empIndex" value="#status.index" />
			<tr>
				<td>
					<div class="row">
						<div class="form-group">
							<div class="col-xs-6 col-md-6">
				                <s:textarea cssClass="form-control" id="milestone" name="cdoGraduateApplication.milestones[%{empIndex}].milestone" value="%{milestone}" />
				            </div>
				            
				            <div class="col-xs-3 col-md-3">
			                    <iita:datepicker cssClass="form-control" id="startingdate" format="dd/MM/yyyy" name="cdoGraduateApplication.milestones[%{empIndex}].startingDate" value="%{startingDate}" />
			                </div>
			            	
			            	<div class="col-xs-3 col-md-3">
			                	<iita:datepicker cssClass="form-control" id="endingdate" format="dd/MM/yyyy" name="cdoGraduateApplication.milestones[%{empIndex}].endingDate" value="%{endingDate}" />
			                </div>
		                </div>
		            </div>
		            
		            <div class="clearfix">&nbsp;</div>
				</td>
			</tr>
		</s:iterator>
		<s:if test="cdoGraduateApplication!=null">
			<s:set name="msSize" value="cdoGraduateApplication.milestones.size" />
		</s:if>
		<s:else>
			<s:set name="msSize" value="0" />
		</s:else>
	       	<tr>
				<td>
					<div class="row">
						<div class="form-group">
							<div class="col-xs-6 col-md-6">
				                <s:textarea cssClass="form-control" id="orgname" name="cdoGraduateApplication.milestones[%{msSize}].milestone" value="%{milestone}" />
				            </div>
				            
			            	<div class="col-xs-3 col-md-3">
			                    <iita:datepicker cssClass="form-control" id="startingdate" format="dd/MM/yyyy" name="cdoGraduateApplication.milestones[%{msSize}].startingDate" value="%{startingDate}" />
			                </div>
			            	
			            	<div class="col-xs-3 col-md-3">
			                	<iita:datepicker cssClass="form-control" id="endingdate" format="dd/MM/yyyy" name="cdoGraduateApplication.milestones[%{msSize}].endingDate" value="%{endingDate}" />
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
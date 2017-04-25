<%@ include file="/common/taglibs.jsp"%>
<s:if test="application.milestones.size>0">
<h3>MILESTONES</h3>
<table class="table">
			<colgroup>
				<col />
				<col />
				<col />
			</colgroup>
            <tr>
              	<td>Milestones</td>
   
               	<td>Starting date</td>

               	<td>Anticipated completion date</td>
            </tr>
			<s:iterator value="application.milestones" status="status">
                <tr>                
                	<td><s:property value="milestone" /></td>

                    <td><iita:date name="startingDate" format="dd/MM/yyyy" /></td>

                	<td><iita:date name="endingDate" format="dd/MM/yyyy" /></td>
                </tr>
        	</s:iterator>
        </table>
</s:if>
<%@ include file="/common/taglibs.jsp"%>

<div class="myapp-bar">
	My Personal Info [<a href="<s:url namespace="/applicant" action="biodata-update"/>" title="Edit profile" title="Edit Biodata">Edit Biodata</a> | <a href="<s:url namespace="/applicant" action="password-update"/>" alt="Change password" title="Change password">Change Password</a>]
</div>
<table class="table">
				<colgroup>
					<col width="200" />
					<col />
				</colgroup>
				<tr>
					<td><label>Last name:</label></td>
					<td><s:property value="cdoBioData.title" /> <s:property value="cdoBioData.lastName" /></td>
				</tr>
				<tr>
					<td><label>First name:</label></td>
					<td><s:property value="cdoBioData.firstName" /></td>
				</tr>
				<s:if test="cdoBioData.middleName!=null">
					<tr>
						<td><label>Middle name:</label></td>
						<td><s:property value="cdoBioData.middleName" /></td>
					</tr>
				</s:if>
				<s:if test="cdoBioData.gender!=null">
					<tr>
						<td><label>Gender:</label></td>
						<td><s:text name="person.gender.%{cdoBioData.gender}" /></td>
					</tr>
				</s:if>
				<s:if test="cdoBioData.maritalStatus!=null">
					<tr>
						<td><label>Marital Status:</label></td>
						<td><s:text name="person.maritalStatus.%{cdoBioData.maritalStatus}" /></td>
					</tr>
				</s:if>
				<s:if test="cdoBioData.currentNationality!=null">
					<tr>
						<td><label>Cur. Nationality:</label></td>
						<td><s:property value="cdoBioData.currentNationality" /></td>
					</tr>
				</s:if>
				<s:if test="cdoBioData.dateOfBirth">
					<tr>
						<td><label>DoB:</label></td>
						<td><fmt:formatDate value="${cdoBioData.dateOfBirth}" type="both" pattern="dd/MM/yyyy" timeZone="${timeZone}" /></td>
					</tr>
				</s:if>
				<s:if test="cdoBioData.nationality!=null">
					<tr>
						<td><label>Nationality:</label></td>
						<td><s:property value="cdoBioData.nationality" /></td>
					</tr>
				</s:if>				
				<tr>
					<td><label>Registered:</label></td>
					<td><fmt:formatDate value="${cdoBioData.createdDate}" type="both" pattern="dd/MM/yyyy" timeZone="${timeZone}" />, <s:date name="cdoBioData.createdDate"
						nice="true" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<s:if test="cdoBioData.fileName==null || cdoBioData.fileName.length()==0">
							<s:if test="cdoBioData.gender==@org.iita.trainingunit.applications.model.ApplicantsBioData$GENDER@Male">
								<img src="<c:url value="/passports/male.png" />" height="80px" width="80px" style="text-align: center;" />
							</s:if>
							<s:elseif test="cdoBioData.gender==@org.iita.trainingunit.applications.model.ApplicantsBioData$GENDER@Female">
								<img src="<c:url value="/passports/female.png" />" height="80px" width="80px" />
							</s:elseif>
							<s:else>
								<img src="<c:url value="/passports/male.png" />" height="80px" width="80px" />
							</s:else>
							<s:include value="/WEB-INF/jsp/include/passportupload-form.jsp" />
							<%--<s:debug /> --%>
						</s:if>
						<s:else>
							<img src="<s:property value="cdoBioData.fileName" />" height="80px" width="80px" />
						</s:else>
					</td>
				</tr>
			</table>
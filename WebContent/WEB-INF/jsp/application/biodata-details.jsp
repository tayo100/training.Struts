<%@ include file="/common/taglibs.jsp"%>

<h3>PERSONAL INFORMATION</h3>
<div>
    <div>
        <table class="table inputform">
        <colgroup>
			<col width="200px" />
			<col />
		</colgroup>
            <tr>
                <td><label>Title:</label></td>
                <td><s:property value="biodata.title" /></td>
            </tr>
            <tr>
                <td>Surname: *</td>
                <td><s:property value="biodata.lastName" /></td>
            </tr>
            <tr>
                <td>Given (First) Name: *</td>
                <td><s:property value="biodata.firstName" /></td>
            </tr>
            <tr>
                <td>Middle Name:</td>
                <td><s:property value="biodata.middleName" /></td>
            </tr>
            <tr>
                <td>Maiden Name:</td>
                <td><div title="Specify it if it has changed">
                <s:property value="biodata.maidenName" /></div></td>
            </tr>
            <tr>
                <td><label>Gender: *</label></td>
                <td><s:property value="biodata.gender" />
                </td>
            </tr>
            <tr>
                <td><label>Marital Status:</label></td>
                <td><s:property value="biodata.maritalStatus" /></td>
            </tr>
            <tr>
                <td>Spouse Name:</td>
                <td><div title="If married, please specify">
                <s:property value="biodata.spouseName" /></div></td>
            </tr>
            <tr>
                <td>Date of Birth: *</td>
                <td><iita:date name="biodata.dateOfBirth" format="dd/MM/yyyy" />, <iita:date name="biodata.dateOfBirth" format="dd/MM/yyyy" nice="true" /> </td>
            </tr>
            <tr>
                <td>Current Nationality:  *</td>
                <td><s:property value="biodata.currentNationality" /></td>
            </tr>
            <tr>
                <td>Place of Birth:</td>
                <td><div title="Town/City, State, Country">
                <s:property value="biodata.placeOfBirth" /></div></td>
            </tr>
            <tr>
                <td>Nationality: *</td>
                <td><s:property value="biodata.nationality" /></td>
            </tr>
            <tr>
                <td>Email: *</td>
                <td><s:property value="biodata.emailAddress" /></td>
            </tr>
            <tr>
                <td>Telephone No.:</td>
                <td>
                <s:property value="biodata.telephoneNumbers" /></td>
            </tr>
            <tr>
                <td>International Passport No.:</td>
                <td><s:property value="biodata.passportNumber" /></td>
            </tr>
            <tr>
                <td>Permanent Address: *</td>
                <td><s:property value="biodata.permanentAddress" />
                </td>
            </tr>
            <tr>
                <td>Permanent Address Telephone: </td>
                <td><div title="Enter your permanent address contact phone number">
                <s:property value="biodata.permAddressTelephone" /></div></td>
            </tr>
            <tr>
                <td>Can you read, speak, write &amp; understand English?: *</td>
                <td><s:property value="biodata.english" /></td>
            </tr>
        </table>
    </div>
</div>
<s:include value="/WEB-INF/jsp/include/nextofkin-details.jsp" />

<s:include value="/WEB-INF/jsp/include/spokenlanguages-details.jsp" />
<s:include value="/WEB-INF/jsp/include/children-details.jsp" />
<s:include value="/WEB-INF/jsp/include/educationandtraining-details.jsp" />
<s:include value="/WEB-INF/jsp/include/employmenthistory-details.jsp" />

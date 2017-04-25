<%@ include file="/common/taglibs.jsp"%>
<s:if test="application.supportTypes!=null">
<html>
<head>
<style type="text/css">

.singleColumn{ padding-left: 5px; font-weight:normal;}
.lr{float:left; width:100%}
</style>
</head>
<body>

<h3>TYPE OF SUPPORT REQUIRED</h3>
<div>
	<div>
	    <table class="table" id="supporttypeTable">
	    <colgroup>
			<col />
			<col />
		</colgroup>
		
	       	<tr>
				<td colspan="2">
					<s:property value="application.supportTypes.typeOfSupport" />
				</td>
			</tr>
			<tr>
				<td>
					Source of funding: (Please provide proof of support)
				</td>
				<td>
					<s:property value="application.supportTypes.fundingSource" />
				</td>
			</tr>
			<tr>
				<td>
					Name of Sponsor
				</td>
				<td>
					<s:property value="application.supportTypes.sponsorName" />
				</td>
			</tr>
			<tr>
				<td>
					Address of Sponsor
				</td>
				<td>
					<s:property value="application.supportTypes.sponsorAddress" />
				</td>
			</tr>
			<tr>
				<td>
					Signature of applicant (Agreed?)
				</td>
				<td>
					<s:text name="application.supportTypes.%{application.supportTypes.signed}" />
				</td>
			</tr>
	    </table>
	</div>
</div>
</body>
</html>
</s:if>
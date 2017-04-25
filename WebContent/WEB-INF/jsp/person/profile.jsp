<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<title>Person: <s:property value="profile.legalName" /></title>
</head>
<body>
<table style="width: 100%">
	<colgroup>
		<col />
		<col width="350" />
	</colgroup>
	<tbody>
		<tr>
			<td style="padding-right: 10px;">
			<h1><s:property value="profile.legalName" /></h1>
			<table class="inputform" id="personProfile_${id}">
				<colgroup>
					<col width="200px" />
					<col />
				</colgroup>
				<tr>
					<td><label>Last name:</label></td>
					<td><s:property value="profile.title" /> <s:property value="profile.lastName" /></td>
				</tr>
				<tr>
					<td><label>First name:</label></td>
					<td><s:property value="profile.firstName" /></td>
				</tr>
				<s:if test="profile.otherNames!=null">
					<tr>
						<td><label>Other names:</label></td>
						<td><s:property value="profile.otherNames" /></td>
					</tr>
				</s:if>
				<s:if test="profile.gender!=null">
				<tr>
					<td><label>Gender:</label></td>
					<td><s:text name="person.gender.%{profile.gender}" /></td>
				</tr>
				</s:if>
				<s:if test="profile.maritalStatus!=null">
				<tr>
					<td><label>Marital Status:</label></td>
					<td><s:text name="person.maritalStatus.%{profile.maritalStatus}" /></td>
				</tr>
				</s:if>
				<s:if test="profile.country!=null">
					<tr>
						<td><label>Nationality:</label></td>
						<td><s:property value="profile.country" /></td>
					</tr>
				</s:if>
				<s:if test="profile.dob">
					<tr>
						<td><label>Date of birth:</label></td>
						<td><fmt:formatDate value="${profile.dob}" type="both" pattern="dd/MM/yyyy" timeZone="${timeZone}" /></td>
					</tr>
				</s:if>
				<s:if test="profile.countryOfResidence!=null">
					<tr>
						<td><label>Country of Residence:</label></td>
						<td><s:property value="profile.countryOfResidence" /></td>
					</tr>
				</s:if>
				<tr>
					<td><label>Alumni Status:</label></td>
					<td><s:text name="person.alumniStatus.%{profile.alumniStatus}" /></td>
				</tr>
				<s:if test="profile.user!=null">
					<tr>
						<td><label>ProMIS User:</label></td>
						<td>	
							<s:property value="profile.user.fullName" />
							Log-in username: <b><s:property value="profile.user.userName" /></b>
							<s:if test="profile.user.lastLogin!=null">Last logged in <iita:date name="profile.user.lastLogin" format="dd/MM/yyyy" /></s:if>
							<s:else>Never logged in.</s:else>
						</td>
					</tr>
				</s:if>
				<tr>
					<td><label>Registered:</label></td>
					<td><fmt:formatDate value="${profile.createdDate}" type="both" pattern="dd/MM/yyyy" timeZone="${timeZone}" />,
					<s:date name="profile.createdDate" nice="true" />					
					</td>
				</tr>
			</table>

			<iita:authorize ifAnyGranted="ROLE_CRM">
			<iita:inlineeditor id="personeditform" targetId="personProfile_${id}">
				<s:form method="post" action="person/profile!update">
					<s:hidden name="id" value="%{profile.id}" />
					<s:hidden name="profile.version" value="%{profile.version}" />
					<table class="inputform">
						<colgroup>
							<col width="200px" />
							<col />
						</colgroup>
						<tr>
							<td><label>Title:</label></td>
							<td><s:textfield name="profile.title" value="%{profile.title}" cssClass="numeric-input" /></td>
						</tr>
						<tr>
							<td><label>Last name:</label></td>
							<td><s:textfield name="profile.lastName" value="%{profile.lastName}" /></td>
						</tr>
						<tr>
							<td><label>First name:</label></td>
							<td><s:textfield name="profile.firstName" value="%{profile.firstName}" /></td>
						</tr>
						<tr>
							<td><label>Other names:</label></td>
							<td><s:textfield name="profile.otherNames" value="%{profile.otherNames}" /></td>
						</tr>
						<tr>
							<td><label>Gender:</label></td>
							<td><s:select name="profile.gender" emptyOption="true" value="%{profile.gender}" list="@org.iita.crm.model.Person$Gender@values()"
								listValue="%{getText('person.gender.' + toString())}" /></td>
						</tr>
						<tr>
							<td><label>Martial Status:</label></td>
							<td><s:select name="profile.maritalStatus" emptyOption="true" value="%{profile.maritalStatus}" list="@org.iita.crm.model.Person$MaritalStatus@values()"
								listValue="%{getText('person.maritalStatus.' + toString())}" /></td>
						</tr>
						<tr>
							<td><label>Nationality:</label></td>
							<td><s:textfield name="profile.country" value="%{profile.country}" /></td>
						</tr>
						<tr>
							<td><label>Country of Residence:</label></td>
							<td><s:select name="profile.countryOfResidence" value="%{profile.countryOfResidence}" headerKey = "" headerValue = "Select.."
									list="#{'Afghanistan':'Afghanistan','Åland Islands':'Åland Islands','Albania':'Albania','Algeria':'Algeria','American Samoa':'American Samoa','Andorra':'Andorra','Angola':'Angola','Anguilla':'Anguilla','Antigua and Barbuda':'Antigua and Barbuda','Argentina':'Argentina','Armenia':'Armenia','Aruba':'Aruba','Australia':'Australia','Austria':'Austria','Azerbaijan':'Azerbaijan','Bahamas':'Bahamas','Bahrain':'Bahrain','Bangladesh':'Bangladesh','Barbados':'Barbados','Belarus':'Belarus','Belgium':'Belgium','Belize':'Belize','Benin':'Benin','Bermuda':'Bermuda','Bhutan':'Bhutan','Bolivia (Plurinational State of)':'Bolivia (Plurinational State of)','Bonaire, Saint Eustatius and Saba':'Bonaire, Saint Eustatius and Saba','Bosnia and Herzegovina':'Bosnia and Herzegovina','Botswana':'Botswana','Brazil':'Brazil','British Virgin Islands':'British Virgin Islands','Brunei Darussalam':'Brunei Darussalam','Bulgaria':'Bulgaria','Burkina Faso':'Burkina Faso','Burundi':'Burundi','Cabo Verde':'Cabo Verde','Cambodia':'Cambodia','Cameroon':'Cameroon','Canada':'Canada','Cayman Islands':'Cayman Islands','Central African Republic':'Central African Republic','Chad':'Chad','Channel Islands':'Channel Islands','Chile':'Chile','China':'China','China,  Hong Kong Special Administrative Region':'China,  Hong Kong Special Administrative Region','China, Macao Special Administrative Region':'China, Macao Special Administrative Region','Colombia':'Colombia','Comoros':'Comoros','Congo':'Congo','Cook Islands':'Cook Islands','Costa Rica':'Costa Rica','Côte d`Ivoire':'Côte d`Ivoire','Croatia':'Croatia','Cuba':'Cuba','Curaçao':'Curaçao','Cyprus':'Cyprus','Czech Republic':'Czech Republic','Democratic People`s Republic of Korea':'Democratic People`s Republic of Korea','Democratic Republic of the Congo':'Democratic Republic of the Congo','Denmark':'Denmark','Djibouti':'Djibouti','Dominica':'Dominica','Dominican Republic':'Dominican Republic','Ecuador':'Ecuador','Egypt':'Egypt','El Salvador':'El Salvador','Equatorial Guinea':'Equatorial Guinea','Eritrea':'Eritrea','Estonia':'Estonia','Ethiopia':'Ethiopia','Faeroe Islands':'Faeroe Islands','Falkland Islands (Malvinas)':'Falkland Islands (Malvinas)','Fiji':'Fiji','Finland':'Finland','France':'France','French Guiana':'French Guiana','French Polynesia':'French Polynesia','Gabon':'Gabon','Gambia':'Gambia','Georgia':'Georgia','Germany':'Germany','Ghana':'Ghana','Gibraltar':'Gibraltar','Greece':'Greece','Greenland':'Greenland','Grenada':'Grenada','Guadeloupe':'Guadeloupe','Guam':'Guam','Guatemala':'Guatemala','Guernsey':'Guernsey','Guinea':'Guinea','Guinea-Bissau':'Guinea-Bissau','Guyana':'Guyana','Haiti':'Haiti','Holy See':'Holy See','Honduras':'Honduras','Hungary':'Hungary','Iceland':'Iceland','India':'India','Indonesia':'Indonesia','Iran (Islamic Republic of)':'Iran (Islamic Republic of)','Iraq':'Iraq','Ireland':'Ireland','Isle of Man':'Isle of Man','Israel':'Israel','Italy':'Italy','Jamaica':'Jamaica','Japan':'Japan','Jersey':'Jersey','Jordan':'Jordan','Kazakhstan':'Kazakhstan','Kenya':'Kenya','Kiribati':'Kiribati','Kuwait':'Kuwait','Kyrgyzstan':'Kyrgyzstan','Lao People`s Democratic Republic':'Lao People`s Democratic Republic','Latvia':'Latvia','Lebanon':'Lebanon','Lesotho':'Lesotho','Liberia':'Liberia','Libya':'Libya','Liechtenstein':'Liechtenstein','Lithuania':'Lithuania','Luxembourg':'Luxembourg','Madagascar':'Madagascar','Malawi':'Malawi','Malaysia':'Malaysia','Maldives':'Maldives','Mali':'Mali','Malta':'Malta','Marshall Islands':'Marshall Islands','Martinique':'Martinique','Mauritania':'Mauritania','Mauritius':'Mauritius','Mayotte':'Mayotte','Mexico':'Mexico','Micronesia (Federated States of)':'Micronesia (Federated States of)','Monaco':'Monaco','Mongolia':'Mongolia','Montenegro':'Montenegro','Montserrat':'Montserrat','Morocco':'Morocco','Mozambique':'Mozambique','Myanmar':'Myanmar','Namibia':'Namibia','Nauru':'Nauru','Nepal':'Nepal','Netherlands':'Netherlands','New Caledonia':'New Caledonia','New Zealand':'New Zealand','Nicaragua':'Nicaragua','Niger':'Niger','Nigeria':'Nigeria','Niue':'Niue','Norfolk Island':'Norfolk Island','Northern Mariana Islands':'Northern Mariana Islands','Norway':'Norway','Oman':'Oman','Pakistan':'Pakistan','Palau':'Palau','Panama':'Panama','Papua New Guinea':'Papua New Guinea','Paraguay':'Paraguay','Peru':'Peru','Philippines':'Philippines','Pitcairn':'Pitcairn','Poland':'Poland','Portugal':'Portugal','Puerto Rico':'Puerto Rico','Qatar':'Qatar','Republic of Korea':'Republic of Korea','Republic of Moldova':'Republic of Moldova','Réunion':'Réunion','Romania':'Romania','Russian Federation':'Russian Federation','Rwanda':'Rwanda','Saint-Barthélemy':'Saint-Barthélemy','Saint Helena':'Saint Helena','Saint Kitts and Nevis':'Saint Kitts and Nevis','Saint Lucia':'Saint Lucia','Saint-Martin (French part)':'Saint-Martin (French part)','Saint Pierre and Miquelon':'Saint Pierre and Miquelon','Saint Vincent and the Grenadines':'Saint Vincent and the Grenadines','Samoa':'Samoa','San Marino':'San Marino','Sao Tome and Principe':'Sao Tome and Principe','Sark':'Sark','Saudi Arabia':'Saudi Arabia','Senegal':'Senegal','Serbia':'Serbia','Seychelles':'Seychelles','Sierra Leone':'Sierra Leone','Singapore':'Singapore','Sint Maarten (Dutch part)':'Sint Maarten (Dutch part)','Slovakia':'Slovakia','Slovenia':'Slovenia','Solomon Islands':'Solomon Islands','Somalia':'Somalia','South Africa':'South Africa','South Sudan':'South Sudan','Spain':'Spain','Sri Lanka':'Sri Lanka','State of Palestine':'State of Palestine','Sudan':'Sudan','Suriname':'Suriname','Svalbard and Jan Mayen Islands':'Svalbard and Jan Mayen Islands','Swaziland':'Swaziland','Sweden':'Sweden','Switzerland':'Switzerland','Syrian Arab Republic':'Syrian Arab Republic','Tajikistan':'Tajikistan','Thailand':'Thailand','The former Yugoslav Republic of Macedonia':'The former Yugoslav Republic of Macedonia','Timor-Leste':'Timor-Leste','Togo':'Togo','Tokelau':'Tokelau','Tonga':'Tonga','Trinidad and Tobago':'Trinidad and Tobago','Tunisia':'Tunisia','Turkey':'Turkey','Turkmenistan':'Turkmenistan','Turks and Caicos Islands':'Turks and Caicos Islands','Tuvalu':'Tuvalu','Uganda':'Uganda','Ukraine':'Ukraine','United Arab Emirates':'United Arab Emirates','United Kingdom of Great Britain and Northern Ireland':'United Kingdom of Great Britain and Northern Ireland','United Republic of Tanzania':'United Republic of Tanzania','United States of America':'United States of America','United States Virgin Islands':'United States Virgin Islands','Uruguay':'Uruguay','Uzbekistan':'Uzbekistan','Vanuatu':'Vanuatu','Venezuela (Bolivarian Republic of)':'Venezuela (Bolivarian Republic of)','Viet Nam':'Viet Nam','Wallis and Futuna Islands':'Wallis and Futuna Islands','Western Sahara':'Western Sahara','Yemen':'Yemen','Zambia':'Zambia','Zimbabwe':'Zimbabwe'}"></s:select></td>
						</tr>
						<tr>
							<td><label>Date of birth:</label></td>
							<td><iita:datepicker name="profile.dob" value="%{profile.dob}" format="dd/MM/yyyy" /></td>
						</tr>
						<tr>
							<td><label>Alumni Status:</label></td>
							<td><s:select name="profile.alumniStatus" emptyOption="true" value="%{profile.alumniStatus}" list="@org.iita.crm.model.Person$AlumniStatus@values()"
								listValue="%{getText('person.alumniStatus.' + toString())}" /></td>
						</tr>
						<tr>
							<td><label>ProMIS User:</label></td>
							<td><s:url namespace="/ajax" action="public-ajax" id="xx" /> <iita:autocompleter cssClass="person" name="userId" id="person.userId" listKey="id"
									listValue="fullName" url="%{xx}" method="autocompleteUser" value="%{profile.user.id}" displayValue="%{profile.user.fullName}" /></td>
						</tr>
						<tr>
							<td />
							<td><s:submit value="Update" /> <s:submit value="Delete" action="person/profile!delete" cssClass="button-delete" onclick="javascript: return confirm('Are you sure you want to remove this record?');" /></td>
						</tr>
					</table>
				</s:form>
			</iita:inlineeditor>
			</iita:authorize>
			
			 <!-- Affiliations -->
			<h2>Affiliations</h2>
			<ul>
				<s:iterator value="profile.affiliations">
					<li><%@ include file="affiliation.jsp" %></li>
				</s:iterator>
				<iita:authorize ifAnyGranted="ROLE_CRM">
				<span id="addNewAffiliation_${id}">Add affiliation...</span>
				<iita:inlineeditor id="personaffiliation" targetId="addNewAffiliation_${id}">
				<s:push value="profile">
					<s:include value="/WEB-INF/jsp/organization/affiliation-organization-form.jsp" />
				</s:push>
				</iita:inlineeditor>
				</iita:authorize>
			</ul>
			
			</td>
			<td style="padding-left: 10px;"><s:if test="profile.lastAffiliation!=null">
				<h2>Last affiliation</h2>
				<s:push value="profile.lastAffiliation.organization">
					<s:include value="/WEB-INF/jsp/organization/quickinfo.jsp" />
				</s:push>
			</s:if>
			<h2>Contact Information</h2>
			<s:iterator value="contacts" status="status">
				<s:include value="/WEB-INF/jsp/contact/contact.jsp" />
			</s:iterator> 
			<iita:authorize ifAnyGranted="ROLE_CRM">
			<s:push value="profile">		
				<s:include value="/WEB-INF/jsp/contact/add.jsp" />
			</s:push>			
			</iita:authorize>
			</td>
		</tr>
	</tbody>
</table>

			<!-- Alumni -->
			<s:if test="alumni!=null">
			<s:push value="alumni">
			<h2>Alumnus info <a href="<s:url action="alumni/delete"/>?id=<s:property value="id" />&source=person&sourceId=<s:property value="person.id" />" onclick="if(confirm('Delete alumni info anyway?')) return true; else return false;" title="Delete alumni info">[X]</a></h2>
				<ul>
					<li><s:include value="/WEB-INF/jsp/alumni/quickinfo.jsp" /></li>
				</ul>
			</s:push>
			</s:if>
			
			<!-- Trainee -->
			<s:if test="trainees && trainees.size>0">
			<h2>Trainee in IITA</h2>
			<security:authorize ifAnyGranted="ROLE_TRAININGUNITHEAD, ROLE_ADMIN, ROLE_QUERYMANAGER">
			<span id="addTrainee_${id}">Add new trainee...</span>
			<iita:inlineeditor id="" targetId="addTrainee_${id}">
				<s:push value="profile">
					<s:include value="/WEB-INF/jsp/trainee/quickform.jsp" />
				</s:push>
			</iita:inlineeditor>
			</security:authorize>
			<ul>
			<s:iterator value="trainees">
				<li><s:include value="/WEB-INF/jsp/trainee/quickinfo.jsp" /></li>
			</s:iterator>
			</ul>
			</s:if>
			
			<!-- Trainer -->
			<s:if test="supervisions && supervisions.size>0">
			<h2>Supervising a trainee</h2>
			<ul>
			<s:iterator value="supervisions">
				<li><s:include value="/WEB-INF/jsp/trainee/quickinfo-other.jsp" /></li>
			</s:iterator>
			</ul>
			</s:if>
			
			<!-- Trainings conducted -->
			<s:if test="trainings && trainings.size>0">
			<h2>Trainer in training programs</h2>
			<ul>
			<s:iterator value="trainings">
				<li><s:include value="/WEB-INF/jsp/program/quickinfo.jsp" /></li>
			</s:iterator>
			</ul>
			</s:if>
			
			<s:if test="similarPersons!=null && similarPersons.size>0">
			<h2>Similar persons</h2>
			<ul>
			<s:iterator value="similarPersons">
				<li>
				<a style="font-weight: bold; margin-right: 10px;" href="<s:url action="merge" />?left.className=org.iita.crm.model.Person&left.id=<s:property value="profile.id" />&right.className=org.iita.crm.model.Person&right.id=<s:property value="id" />">Merge</a>
				<%@include file="/WEB-INF/jsp/person/small.jsp" %>
				</li>
			</s:iterator>
			</ul>
			</s:if>

<h2>Documents</h2>
<s:if test="profile.documents!=null">
<ul class="file-list">
	<s:iterator value="profile.documents">
		<li class="file"><s:include value="/WEB-INF/jsp/document/entitydocument-quick.jsp" /></li>
	</s:iterator>
</ul>
</s:if>

<iita:authorize ifAnyGranted="ROLE_ADMIN,ROLE_TRAININGUNITHEAD,ROLE_HEAD,ROLE_QUERYMANAGER">
	<p>Attach document to person:</p>
	<iita:fileupload action="person/document!upload" value="Upload files" queryParams="entityId=${profile.id}" />
</iita:authorize>



<s:if test="mail!=null && mail.size>0">
	<h2>Email correspondence</h2>
	<s:push value="mail">
		<s:include value="/WEB-INF/jsp/appmail/mail-list.jsp" />
	</s:push>
</s:if>

</body>
</html>
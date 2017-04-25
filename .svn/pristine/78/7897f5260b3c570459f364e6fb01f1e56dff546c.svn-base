<%@ include file="/common/taglibs.jsp"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>

<html>
<head>
<title>CDO New Announcement</title>
<script type="text/javascript" src="<c:url value='/script/moment.js'/>"></script>
<script type="text/javascript" src="<c:url value='/script/validate.js'/>"></script>
</head>
<body>

<div class="button-bar">
	<a href="<s:url action="cdoindex" />">CDO Announcements</a>
</div>

<table style="width: 100%">
		<colgroup>
			<col />
			<s:if test="announcement.id!=null">
				<col width="30%" />
			</s:if>
		</colgroup>
		<tbody>
		<tr>
			<td style="vertical-align: top; padding-right: 30px">
			
				<s:form action="save" method="post">
				<div style="font-style: italic;"><strong>*</strong> means mandatory fields</div>
					<s:hidden name="id" value="%{announcement.id}" />
					<table class="inputform">
						<colgroup>
							<col width="20%" />
							<col />
						</colgroup>
						<s:if test="announcement != null">
							<s:if test="announcement.trainingProposal != null">
								<tr>
									<td colspan="2"><h2>Announcement linked to Training Proposal Information below</h2></td>
								</tr>
								<tr>
									<td>Training Proposal Status:</td>
									<td><s:property value="announcement.trainingProposal.status" /></td>
								</tr>
								<tr>
									<td>Owner:</td>
									<td><s:property value="announcement.trainingProposal.owner.fullName" /></td>
								</tr>
								<tr>
									<td>Requester:</td>
									<td><s:property value="announcement.trainingProposal.requester.fullName" /></td>
								</tr>
								<tr>
									<td>Program Director:</td>
									<td><iita:text value="announcement.trainingProposal.programDirector.fullName" /></td>
								</tr>
								<tr>
									<td>Project Information:</td>
									<td><iita:text value="announcement.trainingProposal.projectInformation" /></td>
								</tr>
								<tr>
									<td>CRP:</td>
									<td><iita:text value="announcement.trainingProposal.crp" /></td>
								</tr>
								<tr>
									<td>Cost Center Information:</td>
									<td><s:property value="announcement.trainingProposal.costCenter" /></td>
								</tr>
								<tr>
									<td>Activity:</td>
									<td><iita:text value="announcement.trainingProposal.activity" /></td>
								</tr>
							</s:if>
						</s:if>
						<s:else>
							<tr>
								<td colspan="2"><h2>Training Announcement Source Information</h2></td>
							</tr>
							<s:if test="announcement.owner!=null">
								<tr>
									<td>Owner:</td>
									<td><s:property value="announcement.owner.fullName" /></td>
								</tr>
							</s:if>
							<tr>
								<td>Requester*:</td>
								<td>
									<s:url namespace="/ajax" action="public-ajax" id="xx" /> 
									<iita:autocompleter cssClass="person" name="requesterId" id="announcement.requester.id" listKey="id"
									listValue="fullName" url="%{xx}" method="autocompleteUser" 
									displayValue="%{announcement.requester.fullName}" value="%{announcement.requester.id}" /></td>
							</tr>
							<tr>
								<td>Unit:</td>
								<td><s:textfield name="announcement.unit"
									value="%{announcement.unit}" />
								</td>
							</tr>
							<tr>
								<td>Program Director*:</td>
								<td>
									<s:url namespace="/ajax" action="public-ajax" id="xxx" /> 
									<iita:autocompleter cssClass="person" name="directorId" id="announcement.programDirector.id" listKey="id"
									listValue="fullName" url="%{xxx}" method="autocompleteUser" 
									displayValue="%{announcement.programDirector.fullName}" value="%{announcement.programDirector.id}" />
								</td>
							</tr>
							<tr>
								<td>Project Information*:</td>
								<td><FCK:editor
										instanceName="announcement.projectInformation">
										<jsp:attribute name="value">${announcement.projectInformation}</jsp:attribute>
									</FCK:editor>
								</td>
							</tr>
							<tr>
								<td>CRP*:</td>
								<td><FCK:editor instanceName="announcement.crp">
										<jsp:attribute name="value">${announcement.crp}</jsp:attribute>
									</FCK:editor>
								</td>
							</tr>
							<tr>
								<td>Charge Cost Center*:</td>
								<td><s:textfield name="announcement.costCenter"
										value="%{announcement.costCenter}" />
								</td>
							</tr>
							<tr>
								<td>Activity*:</td>
								<td><FCK:editor instanceName="announcement.activity">
										<jsp:attribute name="value">${announcement.activity}</jsp:attribute>
									</FCK:editor>
								</td>
							</tr>
						</s:else>
						<tr>
							<td colspan="2"><h2>Training Announcement Information</h2></td>
						</tr>
						<tr>
							<td>Status:</td>
							<td><s:select name="announcement.status" list="@org.iita.trainingunit.announcements.model.Announcement$STATUS@values()" value="%{announcement.status}" /></td>
						</tr>
						<tr>
							<td>Type:*</td>
							<td><s:select name="announcement.type" list="#{'Group':'Group','Graduate':'Graduate'
							,'Non-degree':'Non-degree'
							,'In-house Group':'In-house Group'
							,'Individual':'Individual'
							,'Staff Development':'Staff Development'
							,'Sabbatical':'Sabbatical'
							,'Other':'Other'
							}" value="%{announcement.type}" emptyOption="true" /></td>
						</tr>
						<tr>
							<td>Title:*</td>
							<td><s:textfield name="announcement.title" value="%{announcement.title}" /></td>
						</tr>
						<tr>
							<td>Introduction/Background:*</td>
							<td>
								<FCK:editor instanceName="announcement.introduction" height="100">
									<jsp:attribute name="value">${announcement.introduction}</jsp:attribute>
								</FCK:editor>
							</td>
						</tr>
						<tr>
							<td>Target group/participants:</td>
							<td>
							<FCK:editor instanceName="announcement.targetGroup" height="100">
								<jsp:attribute name="value">${announcement.targetGroup}</jsp:attribute>
							</FCK:editor>
							</td>
						</tr>
						<tr>
							<td>Expected No. of participants:</td>
							<td><s:textfield name="announcement.numberOfParticipants" value="%{announcement.numberOfParticipants}" /></td>
						</tr>
						<tr>
							<td>Expected No. of female(s):</td>
							<td><s:textfield name="announcement.numberOfFemale" value="%{announcement.numberOfFemale}" /></td>
						</tr>
						<tr>
							<td>Expected No. of male(s):</td>
							<td><s:textfield name="announcement.numberOfMale" value="%{announcement.numberOfMale}" /></td>
						</tr>
						<tr>
							<td>Training fee: $</td>
							<td><s:textfield name="announcement.trainingFee" value="%{announcement.trainingFee}" /></td>
						</tr>
						<tr>
							<td>Objective:</td>
							<td>
							<FCK:editor instanceName="announcement.objective" height="100">
								<jsp:attribute name="value">${announcement.objective}</jsp:attribute>
							</FCK:editor>
							</td>
						</tr>
						<tr>
							<td>Learning method:</td>
							<td>
							<FCK:editor instanceName="announcement.learningMethod" height="100">
								<jsp:attribute name="value">${announcement.learningMethod}</jsp:attribute>
							</FCK:editor>
							</td>
						</tr>
						<tr>
							<td>Expected outcome:</td>
							<td><FCK:editor instanceName="announcement.expectedOutcome" height="100">
								<jsp:attribute name="value">${announcement.expectedOutcome}</jsp:attribute>
							</FCK:editor>
								</td>
						</tr>
						<tr>
							<td>Course contents:</td>
							<td>
								<FCK:editor instanceName="announcement.courseContents" height="100">
									<jsp:attribute name="value">${announcement.courseContents}</jsp:attribute>
								</FCK:editor>
							</td>
						</tr>		
						<tr>
							<td>Accommodation:</td>
							<td><FCK:editor instanceName="announcement.accommodation" height="100">
									<jsp:attribute name="value">${announcement.accommodation}</jsp:attribute>
								</FCK:editor>
							</td>
						</tr>
						<tr>
							<td>Payment Information:</td>
							<td><FCK:editor instanceName="announcement.payment" height="100">
								<jsp:attribute name="value">${announcement.payment}</jsp:attribute>
								</FCK:editor>
							</td>
						</tr>
						<tr>
							<td>Keywords:</td>
							<td>(keywords separated by commas)<br />
								<s:textfield name="announcement.keywords" value="%{announcement.keywords}" />
							</td>
						</tr>
						<tr>
							<td>Application deadline:*</td>
							<td><iita:datepicker id="deadline" name="announcement.deadline" value="%{announcement.deadline}" format="dd/MM/yyyy" /><span id="error" style="display:none;">Choose a valid <span style="color:red;">date</span>!</span></td>
						</tr>
						</table>
						<s:if test="announcement!=null">
									<h2>Location/Venue Information</h2>
									<table class="inputform">
											    <colgroup>
													<col width="20%" />
													<col />
													<col />
													<col />
													<col />
												</colgroup>
												<tr>
													<td />
													<td>Country</td>
													<td>Venue/Location:</td>
													<td>Started:</td>
													<td>Ended:</td>
												</tr>
												<s:if test="announcement.trainingLocations.size()>0">
													<s:iterator value="announcement.trainingLocations" status="status">
														<s:set name="locIndex" value="#status.index" />
														<tr>
															<td></td>
															<td><s:select 
																name="announcement.trainingLocations[%{locIndex}].country" 
																list="#{'Afghanistan':'Afghanistan','Åland Islands':'Åland Islands','Albania':'Albania','Algeria':'Algeria','American Samoa':'American Samoa','Andorra':'Andorra','Angola':'Angola','Anguilla':'Anguilla','Antigua and Barbuda':'Antigua and Barbuda','Argentina':'Argentina','Armenia':'Armenia','Aruba':'Aruba','Australia':'Australia','Austria':'Austria','Azerbaijan':'Azerbaijan','Bahamas':'Bahamas','Bahrain':'Bahrain','Bangladesh':'Bangladesh','Barbados':'Barbados','Belarus':'Belarus','Belgium':'Belgium','Belize':'Belize','Benin':'Benin','Bermuda':'Bermuda','Bhutan':'Bhutan','Bolivia (Plurinational State of)':'Bolivia (Plurinational State of)','Bonaire, Saint Eustatius and Saba':'Bonaire, Saint Eustatius and Saba','Bosnia and Herzegovina':'Bosnia and Herzegovina','Botswana':'Botswana','Brazil':'Brazil','British Virgin Islands':'British Virgin Islands','Brunei Darussalam':'Brunei Darussalam','Bulgaria':'Bulgaria','Burkina Faso':'Burkina Faso','Burundi':'Burundi','Cabo Verde':'Cabo Verde','Cambodia':'Cambodia','Cameroon':'Cameroon','Canada':'Canada','Cayman Islands':'Cayman Islands','Central African Republic':'Central African Republic','Chad':'Chad','Channel Islands':'Channel Islands','Chile':'Chile','China':'China','China,  Hong Kong Special Administrative Region':'China,  Hong Kong Special Administrative Region','China, Macao Special Administrative Region':'China, Macao Special Administrative Region','Colombia':'Colombia','Comoros':'Comoros','Congo':'Congo','Cook Islands':'Cook Islands','Costa Rica':'Costa Rica','Côte d`Ivoire':'Côte d`Ivoire','Croatia':'Croatia','Cuba':'Cuba','Curaçao':'Curaçao','Cyprus':'Cyprus','Czech Republic':'Czech Republic','Democratic People`s Republic of Korea':'Democratic People`s Republic of Korea','Democratic Republic of the Congo':'Democratic Republic of the Congo','Denmark':'Denmark','Djibouti':'Djibouti','Dominica':'Dominica','Dominican Republic':'Dominican Republic','Ecuador':'Ecuador','Egypt':'Egypt','El Salvador':'El Salvador','Equatorial Guinea':'Equatorial Guinea','Eritrea':'Eritrea','Estonia':'Estonia','Ethiopia':'Ethiopia','Faeroe Islands':'Faeroe Islands','Falkland Islands (Malvinas)':'Falkland Islands (Malvinas)','Fiji':'Fiji','Finland':'Finland','France':'France','French Guiana':'French Guiana','French Polynesia':'French Polynesia','Gabon':'Gabon','Gambia':'Gambia','Georgia':'Georgia','Germany':'Germany','Ghana':'Ghana','Gibraltar':'Gibraltar','Greece':'Greece','Greenland':'Greenland','Grenada':'Grenada','Guadeloupe':'Guadeloupe','Guam':'Guam','Guatemala':'Guatemala','Guernsey':'Guernsey','Guinea':'Guinea','Guinea-Bissau':'Guinea-Bissau','Guyana':'Guyana','Haiti':'Haiti','Holy See':'Holy See','Honduras':'Honduras','Hungary':'Hungary','Iceland':'Iceland','India':'India','Indonesia':'Indonesia','Iran (Islamic Republic of)':'Iran (Islamic Republic of)','Iraq':'Iraq','Ireland':'Ireland','Isle of Man':'Isle of Man','Israel':'Israel','Italy':'Italy','Jamaica':'Jamaica','Japan':'Japan','Jersey':'Jersey','Jordan':'Jordan','Kazakhstan':'Kazakhstan','Kenya':'Kenya','Kiribati':'Kiribati','Kuwait':'Kuwait','Kyrgyzstan':'Kyrgyzstan','Lao People`s Democratic Republic':'Lao People`s Democratic Republic','Latvia':'Latvia','Lebanon':'Lebanon','Lesotho':'Lesotho','Liberia':'Liberia','Libya':'Libya','Liechtenstein':'Liechtenstein','Lithuania':'Lithuania','Luxembourg':'Luxembourg','Madagascar':'Madagascar','Malawi':'Malawi','Malaysia':'Malaysia','Maldives':'Maldives','Mali':'Mali','Malta':'Malta','Marshall Islands':'Marshall Islands','Martinique':'Martinique','Mauritania':'Mauritania','Mauritius':'Mauritius','Mayotte':'Mayotte','Mexico':'Mexico','Micronesia (Federated States of)':'Micronesia (Federated States of)','Monaco':'Monaco','Mongolia':'Mongolia','Montenegro':'Montenegro','Montserrat':'Montserrat','Morocco':'Morocco','Mozambique':'Mozambique','Myanmar':'Myanmar','Namibia':'Namibia','Nauru':'Nauru','Nepal':'Nepal','Netherlands':'Netherlands','New Caledonia':'New Caledonia','New Zealand':'New Zealand','Nicaragua':'Nicaragua','Niger':'Niger','Nigeria':'Nigeria','Niue':'Niue','Norfolk Island':'Norfolk Island','Northern Mariana Islands':'Northern Mariana Islands','Norway':'Norway','Oman':'Oman','Pakistan':'Pakistan','Palau':'Palau','Panama':'Panama','Papua New Guinea':'Papua New Guinea','Paraguay':'Paraguay','Peru':'Peru','Philippines':'Philippines','Pitcairn':'Pitcairn','Poland':'Poland','Portugal':'Portugal','Puerto Rico':'Puerto Rico','Qatar':'Qatar','Republic of Korea':'Republic of Korea','Republic of Moldova':'Republic of Moldova','Réunion':'Réunion','Romania':'Romania','Russian Federation':'Russian Federation','Rwanda':'Rwanda','Saint-Barthélemy':'Saint-Barthélemy','Saint Helena':'Saint Helena','Saint Kitts and Nevis':'Saint Kitts and Nevis','Saint Lucia':'Saint Lucia','Saint-Martin (French part)':'Saint-Martin (French part)','Saint Pierre and Miquelon':'Saint Pierre and Miquelon','Saint Vincent and the Grenadines':'Saint Vincent and the Grenadines','Samoa':'Samoa','San Marino':'San Marino','Sao Tome and Principe':'Sao Tome and Principe','Sark':'Sark','Saudi Arabia':'Saudi Arabia','Senegal':'Senegal','Serbia':'Serbia','Seychelles':'Seychelles','Sierra Leone':'Sierra Leone','Singapore':'Singapore','Sint Maarten (Dutch part)':'Sint Maarten (Dutch part)','Slovakia':'Slovakia','Slovenia':'Slovenia','Solomon Islands':'Solomon Islands','Somalia':'Somalia','South Africa':'South Africa','South Sudan':'South Sudan','Spain':'Spain','Sri Lanka':'Sri Lanka','State of Palestine':'State of Palestine','Sudan':'Sudan','Suriname':'Suriname','Svalbard and Jan Mayen Islands':'Svalbard and Jan Mayen Islands','Swaziland':'Swaziland','Sweden':'Sweden','Switzerland':'Switzerland','Syrian Arab Republic':'Syrian Arab Republic','Tajikistan':'Tajikistan','Thailand':'Thailand','The former Yugoslav Republic of Macedonia':'The former Yugoslav Republic of Macedonia','Timor-Leste':'Timor-Leste','Togo':'Togo','Tokelau':'Tokelau','Tonga':'Tonga','Trinidad and Tobago':'Trinidad and Tobago','Tunisia':'Tunisia','Turkey':'Turkey','Turkmenistan':'Turkmenistan','Turks and Caicos Islands':'Turks and Caicos Islands','Tuvalu':'Tuvalu','Uganda':'Uganda','Ukraine':'Ukraine','United Arab Emirates':'United Arab Emirates','United Kingdom of Great Britain and Northern Ireland':'United Kingdom of Great Britain and Northern Ireland','United Republic of Tanzania':'United Republic of Tanzania','United States of America':'United States of America','United States Virgin Islands':'United States Virgin Islands','Uruguay':'Uruguay','Uzbekistan':'Uzbekistan','Vanuatu':'Vanuatu','Venezuela (Bolivarian Republic of)':'Venezuela (Bolivarian Republic of)','Viet Nam':'Viet Nam','Wallis and Futuna Islands':'Wallis and Futuna Islands','Western Sahara':'Western Sahara','Yemen':'Yemen','Zambia':'Zambia','Zimbabwe':'Zimbabwe'}" 
																value="%{country}" headerKey="" headerValue="--Select country--" /></td>
															<td><s:textfield name="announcement.trainingLocations[%{locIndex}].venue" value="%{venue}" /></td>
											                <td><iita:datepicker name="announcement.trainingLocations[%{locIndex}].startDate" value="%{startDate}" cssClass="mthyrpicker" /></td>
											                <td><iita:datepicker name="announcement.trainingLocations[%{locIndex}].endDate" value="%{endDate}" cssClass="mthyrpicker" /></td>
											            </tr>
													</s:iterator>
												</s:if>
											       	<tr>
														<td></td>
														<td><s:select emptyOption="" 
															name="announcement.trainingLocations[%{announcement==null || announcement.trainingLocations==null ? 0 : announement.trainingLocations.size}].country" 
															list="#{'Afghanistan':'Afghanistan','Åland Islands':'Åland Islands','Albania':'Albania','Algeria':'Algeria','American Samoa':'American Samoa','Andorra':'Andorra','Angola':'Angola','Anguilla':'Anguilla','Antigua and Barbuda':'Antigua and Barbuda','Argentina':'Argentina','Armenia':'Armenia','Aruba':'Aruba','Australia':'Australia','Austria':'Austria','Azerbaijan':'Azerbaijan','Bahamas':'Bahamas','Bahrain':'Bahrain','Bangladesh':'Bangladesh','Barbados':'Barbados','Belarus':'Belarus','Belgium':'Belgium','Belize':'Belize','Benin':'Benin','Bermuda':'Bermuda','Bhutan':'Bhutan','Bolivia (Plurinational State of)':'Bolivia (Plurinational State of)','Bonaire, Saint Eustatius and Saba':'Bonaire, Saint Eustatius and Saba','Bosnia and Herzegovina':'Bosnia and Herzegovina','Botswana':'Botswana','Brazil':'Brazil','British Virgin Islands':'British Virgin Islands','Brunei Darussalam':'Brunei Darussalam','Bulgaria':'Bulgaria','Burkina Faso':'Burkina Faso','Burundi':'Burundi','Cabo Verde':'Cabo Verde','Cambodia':'Cambodia','Cameroon':'Cameroon','Canada':'Canada','Cayman Islands':'Cayman Islands','Central African Republic':'Central African Republic','Chad':'Chad','Channel Islands':'Channel Islands','Chile':'Chile','China':'China','China,  Hong Kong Special Administrative Region':'China,  Hong Kong Special Administrative Region','China, Macao Special Administrative Region':'China, Macao Special Administrative Region','Colombia':'Colombia','Comoros':'Comoros','Congo':'Congo','Cook Islands':'Cook Islands','Costa Rica':'Costa Rica','Côte d`Ivoire':'Côte d`Ivoire','Croatia':'Croatia','Cuba':'Cuba','Curaçao':'Curaçao','Cyprus':'Cyprus','Czech Republic':'Czech Republic','Democratic People`s Republic of Korea':'Democratic People`s Republic of Korea','Democratic Republic of the Congo':'Democratic Republic of the Congo','Denmark':'Denmark','Djibouti':'Djibouti','Dominica':'Dominica','Dominican Republic':'Dominican Republic','Ecuador':'Ecuador','Egypt':'Egypt','El Salvador':'El Salvador','Equatorial Guinea':'Equatorial Guinea','Eritrea':'Eritrea','Estonia':'Estonia','Ethiopia':'Ethiopia','Faeroe Islands':'Faeroe Islands','Falkland Islands (Malvinas)':'Falkland Islands (Malvinas)','Fiji':'Fiji','Finland':'Finland','France':'France','French Guiana':'French Guiana','French Polynesia':'French Polynesia','Gabon':'Gabon','Gambia':'Gambia','Georgia':'Georgia','Germany':'Germany','Ghana':'Ghana','Gibraltar':'Gibraltar','Greece':'Greece','Greenland':'Greenland','Grenada':'Grenada','Guadeloupe':'Guadeloupe','Guam':'Guam','Guatemala':'Guatemala','Guernsey':'Guernsey','Guinea':'Guinea','Guinea-Bissau':'Guinea-Bissau','Guyana':'Guyana','Haiti':'Haiti','Holy See':'Holy See','Honduras':'Honduras','Hungary':'Hungary','Iceland':'Iceland','India':'India','Indonesia':'Indonesia','Iran (Islamic Republic of)':'Iran (Islamic Republic of)','Iraq':'Iraq','Ireland':'Ireland','Isle of Man':'Isle of Man','Israel':'Israel','Italy':'Italy','Jamaica':'Jamaica','Japan':'Japan','Jersey':'Jersey','Jordan':'Jordan','Kazakhstan':'Kazakhstan','Kenya':'Kenya','Kiribati':'Kiribati','Kuwait':'Kuwait','Kyrgyzstan':'Kyrgyzstan','Lao People`s Democratic Republic':'Lao People`s Democratic Republic','Latvia':'Latvia','Lebanon':'Lebanon','Lesotho':'Lesotho','Liberia':'Liberia','Libya':'Libya','Liechtenstein':'Liechtenstein','Lithuania':'Lithuania','Luxembourg':'Luxembourg','Madagascar':'Madagascar','Malawi':'Malawi','Malaysia':'Malaysia','Maldives':'Maldives','Mali':'Mali','Malta':'Malta','Marshall Islands':'Marshall Islands','Martinique':'Martinique','Mauritania':'Mauritania','Mauritius':'Mauritius','Mayotte':'Mayotte','Mexico':'Mexico','Micronesia (Federated States of)':'Micronesia (Federated States of)','Monaco':'Monaco','Mongolia':'Mongolia','Montenegro':'Montenegro','Montserrat':'Montserrat','Morocco':'Morocco','Mozambique':'Mozambique','Myanmar':'Myanmar','Namibia':'Namibia','Nauru':'Nauru','Nepal':'Nepal','Netherlands':'Netherlands','New Caledonia':'New Caledonia','New Zealand':'New Zealand','Nicaragua':'Nicaragua','Niger':'Niger','Nigeria':'Nigeria','Niue':'Niue','Norfolk Island':'Norfolk Island','Northern Mariana Islands':'Northern Mariana Islands','Norway':'Norway','Oman':'Oman','Pakistan':'Pakistan','Palau':'Palau','Panama':'Panama','Papua New Guinea':'Papua New Guinea','Paraguay':'Paraguay','Peru':'Peru','Philippines':'Philippines','Pitcairn':'Pitcairn','Poland':'Poland','Portugal':'Portugal','Puerto Rico':'Puerto Rico','Qatar':'Qatar','Republic of Korea':'Republic of Korea','Republic of Moldova':'Republic of Moldova','Réunion':'Réunion','Romania':'Romania','Russian Federation':'Russian Federation','Rwanda':'Rwanda','Saint-Barthélemy':'Saint-Barthélemy','Saint Helena':'Saint Helena','Saint Kitts and Nevis':'Saint Kitts and Nevis','Saint Lucia':'Saint Lucia','Saint-Martin (French part)':'Saint-Martin (French part)','Saint Pierre and Miquelon':'Saint Pierre and Miquelon','Saint Vincent and the Grenadines':'Saint Vincent and the Grenadines','Samoa':'Samoa','San Marino':'San Marino','Sao Tome and Principe':'Sao Tome and Principe','Sark':'Sark','Saudi Arabia':'Saudi Arabia','Senegal':'Senegal','Serbia':'Serbia','Seychelles':'Seychelles','Sierra Leone':'Sierra Leone','Singapore':'Singapore','Sint Maarten (Dutch part)':'Sint Maarten (Dutch part)','Slovakia':'Slovakia','Slovenia':'Slovenia','Solomon Islands':'Solomon Islands','Somalia':'Somalia','South Africa':'South Africa','South Sudan':'South Sudan','Spain':'Spain','Sri Lanka':'Sri Lanka','State of Palestine':'State of Palestine','Sudan':'Sudan','Suriname':'Suriname','Svalbard and Jan Mayen Islands':'Svalbard and Jan Mayen Islands','Swaziland':'Swaziland','Sweden':'Sweden','Switzerland':'Switzerland','Syrian Arab Republic':'Syrian Arab Republic','Tajikistan':'Tajikistan','Thailand':'Thailand','The former Yugoslav Republic of Macedonia':'The former Yugoslav Republic of Macedonia','Timor-Leste':'Timor-Leste','Togo':'Togo','Tokelau':'Tokelau','Tonga':'Tonga','Trinidad and Tobago':'Trinidad and Tobago','Tunisia':'Tunisia','Turkey':'Turkey','Turkmenistan':'Turkmenistan','Turks and Caicos Islands':'Turks and Caicos Islands','Tuvalu':'Tuvalu','Uganda':'Uganda','Ukraine':'Ukraine','United Arab Emirates':'United Arab Emirates','United Kingdom of Great Britain and Northern Ireland':'United Kingdom of Great Britain and Northern Ireland','United Republic of Tanzania':'United Republic of Tanzania','United States of America':'United States of America','United States Virgin Islands':'United States Virgin Islands','Uruguay':'Uruguay','Uzbekistan':'Uzbekistan','Vanuatu':'Vanuatu','Venezuela (Bolivarian Republic of)':'Venezuela (Bolivarian Republic of)','Viet Nam':'Viet Nam','Wallis and Futuna Islands':'Wallis and Futuna Islands','Western Sahara':'Western Sahara','Yemen':'Yemen','Zambia':'Zambia','Zimbabwe':'Zimbabwe'}" 
															value="%{country}" headerKey="" headerValue="--Select country--" /></td>
														<td><s:textfield name="announcement.trainingLocations[%{announcement==null || announcement.trainingLocations==null ? 0 : announement.trainingLocations.size}].venue" value="%{venue}" /></td>
										                <td><iita:datepicker name="announcement.trainingLocations[%{announcement==null || announcement.trainingLocations==null ? 0 : announement.trainingLocations.size}].startDate" value="" cssClass="mthyrpicker" /></td>
										                <td><iita:datepicker name="announcement.trainingLocations[%{announcement==null || announcement.trainingLocations==null ? 0 : announement.trainingLocations.size}].endDate" value="" cssClass="mthyrpicker" /></td>
													</tr>
													<tr>
														<td></td>
														<td><a onclick="javascript: copyBudget($($(this).parentNode.parentNode).previous(), 3, 0); return false;">More location info +</a></td>
													</tr>
									</table>
									<h2>Resource Persons/Trainers</h2>
									<table class="inputform">
										<colgroup>
											<col width="20%" />
											<col />
										</colgroup>
										<tbody>
											<s:if test="announcement.trainers.size()>0">
												<s:iterator value="announcement.trainers" status="status">
													<s:set name="trainerIndex" value="#status.index" />
													<s:include value="announcement-trainer-form.jsp" />
												</s:iterator>
											</s:if>
											<s:else>
												<s:set name="trainerIndex" value="announement==null || announcement.trainers==null ? 0 : announcement.trainers.size" />
												<s:include value="announcement-trainer-form.jsp" />
											</s:else>
										</tbody>
										<tbody style="display: none;">
											<s:include value="announcement-trainer-form.jsp" />
										</tbody>
										<tr>
											<td><a onclick="javascript: copyBudget($($(this).parentNode.parentNode.parentNode).previous(), 3, 0); return false;">More trainers +</a></td>
											<td />
										</tr>
									</table>
									</s:if>
									<div class="button-bar" style="margin: 10px 0px 0px 250px;">
									<s:submit value="Save announcement" onclick="javascript: return __date();" />	
									<s:if test="announcement.status!=@org.iita.trainingunit.announcements.model.Announcement$STATUS@Published">
										<s:submit action="deleteannouncement" onclick="javascript: return confirm('Delete this announcement anyway?');" cssStyle="color: Red;" value="Delete record" />		
									</s:if>
								</div>
				</s:form>
			</td>
		<s:if test="announcement.id!=null">
			<td style="vertical-align: top;">
				<h2>Training Materials</h2>
				<s:if test="announcement.documents!=null">
					<ul class="file-list">
						<s:iterator value="announcement.documents">
							<li class="file"><s:include value="/WEB-INF/jsp/document/entitydocument-announcement-quick.jsp" /></li>
						</s:iterator>
					</ul>
				</s:if> 
				<iita:authorize ifAnyGranted="ROLE_CRM">
					<p>Attach document/material to announcement:</p>
					<iita:fileupload action="announcement-document!upload"
						value="Upload files" queryParams="entityId=${announcement.id}" />
				</iita:authorize>
			</td>
		</s:if>
	</tr>
	</tbody>
	</table>
</body>
</html>
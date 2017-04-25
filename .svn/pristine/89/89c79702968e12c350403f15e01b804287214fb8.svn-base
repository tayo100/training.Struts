<%@ include file="/common/taglibs.jsp"%>
<head>
	<title>IYA Announcement form</title>
</head>
<s:form namespace="/iya" action="save-announcement" method="post">
	<s:if test="id!=null">
		<s:hidden name="announcement.id" value="%{id}" />
	</s:if>
	<table class="inputform">
		<colgroup>
			<col width="200px" />
			<col />
			<col />
		</colgroup>
		<tr>
			<td>Sponsor:</td>
			<td>
				<s:url namespace="/ajax" action="public-ajax" id="xx" /> <iita:autocompleter cssClass="organization" name="announcement.sponsor" 
				id="announcement.sponsor" listKey="title" listValue="title" url="%{xx}" method="autocompleteOrganization" displayValue="%{announcement.sponsor}" />
			</td>
		</tr>
		<tr>
			<td>Organizer:</td>
			<td>
				<s:url namespace="/ajax" action="public-ajax" id="xxx" /> <iita:autocompleter cssClass="organization" name="announcement.organizer" 
				id="announcement.organizer" listKey="title" listValue="title" url="%{xxx}" method="autocompleteOrganization" displayValue="%{announcement.organizer}" />
			</td>
		</tr>
		<%--
		<tr>
			<td>Training Objectives:</td>
			<td>
				<table>
					<colgroup>
						<col />
					</colgroup>
					<thead>
						<tr>
							<th align="left">Objective(s)</th>
						</tr>
					</thead>
					<s:if test="announcement.trainingObjectives.size()>0">
						<s:iterator value="announcement.trainingObjectives" status="status">
							<s:set name="trainingObj" value="#status.index" />
								<tr>
									<td>
										<s:textfield name="announcement.trainingObjectives[%{trainingObj}].objective" value="%{objective}" />
									</td>
								</tr>
						</s:iterator>
					</s:if>
					<tr>
						<td>
							<s:textfield name="announcement.trainingObjectives[%{announcement==null || announcement.trainingObjectives==null ? 0 : announcement.trainingObjectives.size}].objective" value="%{objective}" />
						</td>
					</tr>
					<tr>
						<td><a onclick="javascript: copyTrainer($($(this).parentNode.parentNode).previous(), 3, 0); return false;">More objectives +</a></td>
					</tr>
				</table>
			</td>
		</tr>
		 --%>
		<tr>
			<td>Training Course/Module:</td>
			<td><s:textarea name="announcement.trainingCourse" value="%{announcement.trainingCourse}"></s:textarea></td>
		</tr>
		<%--
		<tr>
					<td valign="top">Location/Venue Information:</td>
					<td>
						<table>
								    <colgroup>
										<col width="30%" />
										<col width="43%" />
										<col width="13%" />
										<col width="12%" />
									</colgroup>
									<thead>
										<tr>
											<th align="left">Country</th>
											<th align="left">Venue/Location:</th>
											<th align="left">Starts:</th>
											<th align="left">Ends:</th>
										</tr>
									</thead>
									<s:if test="announcement.trainingLocations.size()>0">
										<s:iterator value="announcement.trainingLocations" status="status">
											<s:set name="locIndex" value="#status.index" />
											<tr>
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
											<td><s:select emptyOption="" 
												name="announcement.trainingLocations[%{announcement==null || announcement.trainingLocations==null ? 0 : announcement.trainingLocations.size}].country" 
												list="#{'Afghanistan':'Afghanistan','Åland Islands':'Åland Islands','Albania':'Albania','Algeria':'Algeria','American Samoa':'American Samoa','Andorra':'Andorra','Angola':'Angola','Anguilla':'Anguilla','Antigua and Barbuda':'Antigua and Barbuda','Argentina':'Argentina','Armenia':'Armenia','Aruba':'Aruba','Australia':'Australia','Austria':'Austria','Azerbaijan':'Azerbaijan','Bahamas':'Bahamas','Bahrain':'Bahrain','Bangladesh':'Bangladesh','Barbados':'Barbados','Belarus':'Belarus','Belgium':'Belgium','Belize':'Belize','Benin':'Benin','Bermuda':'Bermuda','Bhutan':'Bhutan','Bolivia (Plurinational State of)':'Bolivia (Plurinational State of)','Bonaire, Saint Eustatius and Saba':'Bonaire, Saint Eustatius and Saba','Bosnia and Herzegovina':'Bosnia and Herzegovina','Botswana':'Botswana','Brazil':'Brazil','British Virgin Islands':'British Virgin Islands','Brunei Darussalam':'Brunei Darussalam','Bulgaria':'Bulgaria','Burkina Faso':'Burkina Faso','Burundi':'Burundi','Cabo Verde':'Cabo Verde','Cambodia':'Cambodia','Cameroon':'Cameroon','Canada':'Canada','Cayman Islands':'Cayman Islands','Central African Republic':'Central African Republic','Chad':'Chad','Channel Islands':'Channel Islands','Chile':'Chile','China':'China','China,  Hong Kong Special Administrative Region':'China,  Hong Kong Special Administrative Region','China, Macao Special Administrative Region':'China, Macao Special Administrative Region','Colombia':'Colombia','Comoros':'Comoros','Congo':'Congo','Cook Islands':'Cook Islands','Costa Rica':'Costa Rica','Côte d`Ivoire':'Côte d`Ivoire','Croatia':'Croatia','Cuba':'Cuba','Curaçao':'Curaçao','Cyprus':'Cyprus','Czech Republic':'Czech Republic','Democratic People`s Republic of Korea':'Democratic People`s Republic of Korea','Democratic Republic of the Congo':'Democratic Republic of the Congo','Denmark':'Denmark','Djibouti':'Djibouti','Dominica':'Dominica','Dominican Republic':'Dominican Republic','Ecuador':'Ecuador','Egypt':'Egypt','El Salvador':'El Salvador','Equatorial Guinea':'Equatorial Guinea','Eritrea':'Eritrea','Estonia':'Estonia','Ethiopia':'Ethiopia','Faeroe Islands':'Faeroe Islands','Falkland Islands (Malvinas)':'Falkland Islands (Malvinas)','Fiji':'Fiji','Finland':'Finland','France':'France','French Guiana':'French Guiana','French Polynesia':'French Polynesia','Gabon':'Gabon','Gambia':'Gambia','Georgia':'Georgia','Germany':'Germany','Ghana':'Ghana','Gibraltar':'Gibraltar','Greece':'Greece','Greenland':'Greenland','Grenada':'Grenada','Guadeloupe':'Guadeloupe','Guam':'Guam','Guatemala':'Guatemala','Guernsey':'Guernsey','Guinea':'Guinea','Guinea-Bissau':'Guinea-Bissau','Guyana':'Guyana','Haiti':'Haiti','Holy See':'Holy See','Honduras':'Honduras','Hungary':'Hungary','Iceland':'Iceland','India':'India','Indonesia':'Indonesia','Iran (Islamic Republic of)':'Iran (Islamic Republic of)','Iraq':'Iraq','Ireland':'Ireland','Isle of Man':'Isle of Man','Israel':'Israel','Italy':'Italy','Jamaica':'Jamaica','Japan':'Japan','Jersey':'Jersey','Jordan':'Jordan','Kazakhstan':'Kazakhstan','Kenya':'Kenya','Kiribati':'Kiribati','Kuwait':'Kuwait','Kyrgyzstan':'Kyrgyzstan','Lao People`s Democratic Republic':'Lao People`s Democratic Republic','Latvia':'Latvia','Lebanon':'Lebanon','Lesotho':'Lesotho','Liberia':'Liberia','Libya':'Libya','Liechtenstein':'Liechtenstein','Lithuania':'Lithuania','Luxembourg':'Luxembourg','Madagascar':'Madagascar','Malawi':'Malawi','Malaysia':'Malaysia','Maldives':'Maldives','Mali':'Mali','Malta':'Malta','Marshall Islands':'Marshall Islands','Martinique':'Martinique','Mauritania':'Mauritania','Mauritius':'Mauritius','Mayotte':'Mayotte','Mexico':'Mexico','Micronesia (Federated States of)':'Micronesia (Federated States of)','Monaco':'Monaco','Mongolia':'Mongolia','Montenegro':'Montenegro','Montserrat':'Montserrat','Morocco':'Morocco','Mozambique':'Mozambique','Myanmar':'Myanmar','Namibia':'Namibia','Nauru':'Nauru','Nepal':'Nepal','Netherlands':'Netherlands','New Caledonia':'New Caledonia','New Zealand':'New Zealand','Nicaragua':'Nicaragua','Niger':'Niger','Nigeria':'Nigeria','Niue':'Niue','Norfolk Island':'Norfolk Island','Northern Mariana Islands':'Northern Mariana Islands','Norway':'Norway','Oman':'Oman','Pakistan':'Pakistan','Palau':'Palau','Panama':'Panama','Papua New Guinea':'Papua New Guinea','Paraguay':'Paraguay','Peru':'Peru','Philippines':'Philippines','Pitcairn':'Pitcairn','Poland':'Poland','Portugal':'Portugal','Puerto Rico':'Puerto Rico','Qatar':'Qatar','Republic of Korea':'Republic of Korea','Republic of Moldova':'Republic of Moldova','Réunion':'Réunion','Romania':'Romania','Russian Federation':'Russian Federation','Rwanda':'Rwanda','Saint-Barthélemy':'Saint-Barthélemy','Saint Helena':'Saint Helena','Saint Kitts and Nevis':'Saint Kitts and Nevis','Saint Lucia':'Saint Lucia','Saint-Martin (French part)':'Saint-Martin (French part)','Saint Pierre and Miquelon':'Saint Pierre and Miquelon','Saint Vincent and the Grenadines':'Saint Vincent and the Grenadines','Samoa':'Samoa','San Marino':'San Marino','Sao Tome and Principe':'Sao Tome and Principe','Sark':'Sark','Saudi Arabia':'Saudi Arabia','Senegal':'Senegal','Serbia':'Serbia','Seychelles':'Seychelles','Sierra Leone':'Sierra Leone','Singapore':'Singapore','Sint Maarten (Dutch part)':'Sint Maarten (Dutch part)','Slovakia':'Slovakia','Slovenia':'Slovenia','Solomon Islands':'Solomon Islands','Somalia':'Somalia','South Africa':'South Africa','South Sudan':'South Sudan','Spain':'Spain','Sri Lanka':'Sri Lanka','State of Palestine':'State of Palestine','Sudan':'Sudan','Suriname':'Suriname','Svalbard and Jan Mayen Islands':'Svalbard and Jan Mayen Islands','Swaziland':'Swaziland','Sweden':'Sweden','Switzerland':'Switzerland','Syrian Arab Republic':'Syrian Arab Republic','Tajikistan':'Tajikistan','Thailand':'Thailand','The former Yugoslav Republic of Macedonia':'The former Yugoslav Republic of Macedonia','Timor-Leste':'Timor-Leste','Togo':'Togo','Tokelau':'Tokelau','Tonga':'Tonga','Trinidad and Tobago':'Trinidad and Tobago','Tunisia':'Tunisia','Turkey':'Turkey','Turkmenistan':'Turkmenistan','Turks and Caicos Islands':'Turks and Caicos Islands','Tuvalu':'Tuvalu','Uganda':'Uganda','Ukraine':'Ukraine','United Arab Emirates':'United Arab Emirates','United Kingdom of Great Britain and Northern Ireland':'United Kingdom of Great Britain and Northern Ireland','United Republic of Tanzania':'United Republic of Tanzania','United States of America':'United States of America','United States Virgin Islands':'United States Virgin Islands','Uruguay':'Uruguay','Uzbekistan':'Uzbekistan','Vanuatu':'Vanuatu','Venezuela (Bolivarian Republic of)':'Venezuela (Bolivarian Republic of)','Viet Nam':'Viet Nam','Wallis and Futuna Islands':'Wallis and Futuna Islands','Western Sahara':'Western Sahara','Yemen':'Yemen','Zambia':'Zambia','Zimbabwe':'Zimbabwe'}" 
												value="%{country}" headerKey="" headerValue="--Select country--" /></td>
											<td><s:textfield name="announcement.trainingLocations[%{announcement==null || announcement.trainingLocations==null ? 0 : announcement.trainingLocations.size}].venue" value="%{venue}" /></td>
							                <td><iita:datepicker name="announcement.trainingLocations[%{announcement==null || announcement.trainingLocations==null ? 0 : announcement.trainingLocations.size}].startDate" value="" cssClass="mthyrpicker" /></td>
							                <td><iita:datepicker name="announcement.trainingLocations[%{announcement==null || announcement.trainingLocations==null ? 0 : announcement.trainingLocations.size}].endDate" value="" cssClass="mthyrpicker" /></td>
										</tr>
										<tr>
											<td colspan="4"><a onclick="javascript: copyBudget($($(this).parentNode.parentNode).previous(), 3, 0); return false;">More location info +</a></td>
										</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td valign="top">Facilitators/Trainers:</td>
					<td>					
					<table>
						<colgroup>
							<col width="38%" />
							<col width="25%" />
							<col width="15%" />
							<col />
						</colgroup>
						<thead>
							<tr>
								<th align="left">Person</th>
								<th align="left">Email</th>
								<th align="left">Type</th>
								<th align="left">Note</th>
							</tr>
						</thead>
						<s:if test="announcement.facilitators.size()>0">
							<s:iterator value="announcement.facilitators" status="status">
								<s:set name="trainerIndex" value="#status.index" />
								<tr>
									<td>
										<s:textfield name="announcement.facilitators[%{trainerIndex}].names" value="%{person==null ? names : person.fullName}" />
										
									</td>
									<td><s:textfield name="announcement.facilitators[%{trainerIndex}].email" value="%{email}" /></td>
									<td><s:select name="announcement.facilitators[%{trainerIndex}].type" value="%{type}" list="@org.iita.trainingunit.model.Trainer$TrainerType@values()" /></td>
									<td><s:textarea name="announcement.facilitators[%{trainerIndex}].notes" value="%{notes}" /></td>
								</tr>
							</s:iterator>
						</s:if>
						<tr>
							<td>
							<s:textfield name="announcement.facilitators[%{announcement==null || announcement.facilitators==null ? 0 : announcement.facilitators.size}].names" value="%{names}" /></td>
							<td><s:textfield name="announcement.facilitators[%{announcement==null || announcement.facilitators==null ? 0 : announcement.facilitators.size}].email" value="%{email}" /></td>
							<td><s:select name="announcement.facilitators[%{announcement==null || announcement.facilitators==null ? 0 : announcement.facilitators.size}].type" value="%{type}" list="@org.iita.trainingunit.model.Trainer$TrainerType@values()" /></td>
							<td><s:textarea name="announcement.facilitators[%{announcement==null || announcement.facilitators==null ? 0 : announcement.facilitators.size}].notes" value="%{notes}" /></td>
						</tr>
						<tr>
							<td><a onclick="javascript: copyTrainer($($(this).parentNode.parentNode).previous(), 3, 0); return false;">More trainers +</a></td>
							<td colspan="2" />
						</tr>
					</table>
					</td>
				</tr>
				  --%>
		<tr>
			<td></td>
			<td><s:if test="announcement.id==null || announcement.id<=0"><s:submit value="Submit" onclick="javascript: return confirm('Are you sure you want to save this record?');" cssClass="btn btn-warning" /></s:if><s:else><s:submit value="Update" action="announcement/save-edit" cssClass="btn btn-warning" onclick="javascript: return confirm('Are you sure you want to update this record?');" /></s:else></td>
		</tr>
	</table>
</s:form>
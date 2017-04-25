<%@ include file="/common/taglibs.jsp"%>
<head>
	<title>IYA Announcement form</title>
</head>
<s:form namespace="/stafftraining" action="save-registrationt" method="post">

	<table class="inputform">
		<colgroup>
			<col width="200px" />
			<col />
			<col />
		</colgroup>
		<tr>SECTION A -TO BE COMPLETED BY APPLICANT</tr>
		
		<tr>Personal Details</tr>

		<tr>
			<td>Surname:</td>
			<td><s:textfield name="surname" value="%{surname}" /></td>
			<td>Given Name(s):</td>
			<td><s:textfield name="othernames" value="%{othernames}" /></td>
		</tr>
		<tr><td>Designation: </td><td><s:textfield name="designation" value="%{designation}"/></td>
			<td>PG:</td><td><s:textfield name="paygrade" value="%{paygrade}"/></td>
			<td>Grade for IRS:</td><td><s:textfield name="irs_grade" value="%{irs_grade}"/></td>
		</tr>
		<tr><td>Unit/Project: </td><td><s:textfield name="project" value="%{project}"/></td>
			<td>Directorate:</td><td><s:textfield name="directorate" value="%{directorate}"/></td>
		</tr>
		<tr><td>Duty Station:</td><td><s:textfield name="station" value="%{station}"/></td>
			<td>Hub:</td><td><s:textfield name="hub" value="%{station}"/></td>
		</tr>
		<tr><td><s:checkbox label="Male" name="sex" value="sex" fieldValue=""/></td>
				<td><s:checkbox label="Female" name="sex" value="sex" fieldValue=""/></td>
			<td>Supervisor: </td><td><s:textfield name="supervisor" value="%{supervisor}"/></td>
		</tr>
		<tr><td>Highest Educational qualification:</td><td><s:textfield name="qualification" value="%{qualification}"/></td>
			
		</tr>
		<tr><td>List briefly your job description:</td><td><s:textarea name="job_description" value="%{job_description}"/></td>			
		</tr>
		<tr>Type of training</tr>
		<tr>
			<td>
				<tr>
					<td>Internal Training</td>
					
					<td></td>
					<td><s:checkbox label="Talent" name="talent" value="talent" fieldValue=""/></td>
					<td></td>
					<td><s:checkbox label="Short Term course" name="short_term" value="short_term" fieldValue=""/></td>
					<td></td>
					<td><s:checkbox label="Mentoring/Coaching" name="coaching" value="" fieldValue=""/></td>
					<td></td>
				</tr>
			</td>
			<td>
				<tr>
					<td>External Training</td>
					<td></td>
					<td> <s:checkbox label="Short Term course" name="short_term" value="" fieldValue=""/></td>
					<td></td>
					<td><s:checkbox label="Long Term course" name="long_term" value="" fieldValue=""/></td>
					<td></td>
					<td><s:checkbox label="Attendance (conference, workshop)" name="attendance" value="" fieldValue=""/></td>
					<td></td>
					<td>Visit<s:checkbox label="" name="" value="" fieldValue=""/></td>
					<td></td>
				</tr>
			</td>
		</tr>

	<tr>Course details</tr>
		<tr><td>Course applying for:</td><td><s:textfield name="course" value="%{course}"/></td>			
		</tr>
		<tr>
			<td>Desired Qualification:</td>
			<td><s:textfield name="desired_qualification" value="%{desired_qualification}" /></td>
			<td>Organizing body:</td>
			<td><s:url namespace="/ajax" action="public-ajax" id="xxx" /> <iita:autocompleter
				cssClass="organization" name="organizer" id="organizer"
				listKey="title" listValue="title" url="%{xxx}"
				method="autocompleteOrganization" displayValue="%{organizer}" /></td>
			</td>
		</tr>

		</tr>
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
	
		<!-- <tr><td>Location:</td><td><s:textfield name="location" value="%{}"/></td>
			<td>Country:</td><td><s:textfield name="country" value="%{}"/></td>
		</tr>
		<tr><td>Course Duration:</td><td><s:textfield name="duration" value="%{duration}"/></td>
			<td>Start date:</td><td><s:textfield name="start_date" value="%{}"/></td>
			<td>End date:</td><td><s:textfield name="end_date" value="%{}"/></td> -->
		<tr>
			Course relevance- please complete the following section in detail
		</tr>
		<tr>
			<td>1. Purpose of the application (Describe the reasons/need to
			participate in the training, with reference to issues or problems to
			be addressed): <br>
			<s:textarea name="purpose" value="%{purpose}" /></td>
		</tr>
		<tr>
			<td>2. Objectives of the course applied for:<br>
			<s:textarea name="course_obj" value="%{course_obj}" /></td>
			<td></td>
		</tr>
		<tr>
			<td>3. How does this course meet your professional needs?<br>
			<s:textarea name="needs" value="%{needs}" /></td>
			<td></td>
		</tr>
		<tr>
			<td>4. How do you intend to use your new skills after the
			completion of the course?<br>
			<s:textarea name="skill_use" value="%{skill_use}" /></td>
			<td></td>
		</tr>
		<tr>
			<td>5. State how this course will bring added value to the
			Unit/IITA?<br>
			<s:textarea name="add_value" value="%{add_value}" /></td>
			<td></td>
		</tr>
		<tr>
			SECTION B - TO BE COMPLETED BY HEAD OF UNIT/SUPERVISOR
		</tr>
		<tr>
			<td>Name:</td>
			<td><s:textfield name="name" value="%{name}" /></td>
		</tr>
		<tr>
			<td>6. State why you support the applicant for this course:<br>
			<s:textarea name="support" value="%{support}" /></td>
			<td></td>
		</tr>
		<tr>
			<td>7. Has replacement staff been organized for the applicant to
			attend this course?</td>
			<td><s:checkbox label="Yes" name="replacement_staff" value="" fieldValue=""/></td>
			<td><s:checkbox label="No" name="replacement_staff" value="" fieldValue=""/></td>
		</tr>

		<tr>
			SECTION C - COST IMPLICATION FOR THE COURSE
		</tr>

		<tr>
			<td>8. Estimated costs:</td>
			<td><s:textfield label = "(i) Tuition fee:" name="tuition" value="%{tuition}" /></td>
			<td><s:textfield label = "(ii) Visa fees:" name="visa" value="%{visa}" /></td>
			<td><s:textfield label = "(iii) Flight and shuttle costs:" name="flight" value="%{flight}" /></td>
			<td><s:textfield label = "(iv) Per diem:" name="perdiem" value="%{perdiem}" /></td>
			<td><s:textfield label = "(v) Others (specify):" name="others" value="%{others}" /></td>
			<td><s:textfield label = "(vi) Total:" name="total" value="%{total}" /></td>
		</tr>

		<tr>
			<td><s:textfield label = "9. Total Amount Request:" name="amount" value="%{amount}" /></td>
			<td></td>
			Note: Maximum support for Talent Grant is $4000
		</tr>

		<tr>
			<td>Approvals</td>
			<td></td>
			<td></td>
			<td></td>
			<td>Comments</td>
		</tr>
		<tr>
			<td>Head of Unit</td>
			<td>Approval</td>
			<td><s:checkbox label="Yes" name="approval" value="" fieldValue=""/></td>
			<td><s:checkbox label="No" name="approval" value="" fieldValue=""/></td>
			<td></td>
		</tr>
		<tr>
			<td>Committee Approval</td>
			<td>Approval</td>
			<td><s:checkbox label="Yes" name="approval" value="" fieldValue=""/></td>
			<td><s:checkbox label="No" name="approval" value="" fieldValue=""/></td>
			<td></td>		</tr>
		<tr>
			<td>Head CDO</td>
			<td>Approval</td>
			<td><s:checkbox label="Yes" name="approval" value="" fieldValue=""/></td>
			<td><s:checkbox label="No" name="approval" value="" fieldValue=""/></td>
			<td></td>		</tr>
		<tr>
			<td>DDG PCD</td>
			<td>Approval</td>
			<td><s:checkbox label="Yes" name="approval" value="" fieldValue=""/></td>
			<td><s:checkbox label="No" name="approval" value="" fieldValue=""/></td>
			<td></td>
		</tr>
		<tr>
			Feedback by Applicant (after training)
		</tr>
		<tr>11. Briefly comment on your experience in the training (did the training meet your expectations?)<br>
			<td> Strongly Agree</td><td>Agree</td><td>Disagree</td><td>Neutral</td><td>Strongly Disagree</td>
		</tr>
		<tr>
			<td>The training objectives were met</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>The training enhanced my knowledge and skills</td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Information could be applied to practice</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>The course will be of value to me in my role</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
       
		<tr><td>12. Additional comments<br>
				<s:textarea name="" value="%{}"/> </td></td><td></td>
		</tr>		
	</table>
</s:form>
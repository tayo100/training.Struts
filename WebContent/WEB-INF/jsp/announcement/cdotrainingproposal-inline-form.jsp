<%@ include file="/common/taglibs.jsp"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>

<s:form action="save-proposal" method="post">
				<s:hidden name="id" value="%{trainingProposal.id}" />
				<table class="inputform">
					<colgroup>
						<col width="20%" />
						<col />
					</colgroup>
					<tr>
						<td colspan="2" align="left"><h2>Training Proposal Background</h2></td>
					</tr>
					<tr>
						<td>Type:*</td>
						<td><s:select name="trainingProposal.type" list="#{'Group':'Group'
						,'Graduate':'Graduate'
						,'Non-degree':'Non-degree'
						,'In-house Group':'In-house Group'
						,'Individual':'Individual'
						,'Staff Development':'Staff Development'
						,'Sabbatical':'Sabbatical'
						,'Talent Grant':'Talent Grant'
						,'Other':'Other'
						}" value="%{trainingProposal.type}" emptyOption="true" /></td>
					</tr>
					<tr>
						<td valign="top">Title:*</td>
						<td>
							<s:textfield id="tptitle" name="trainingProposal.title" value="%{trainingProposal.title}" />
							<s:div id="divRelated"></s:div>
						</td>
					</tr>
					<s:if test="trainingProposal.owner!=null">
						<tr>
							<td>Owner:</td>
							<td><s:property value="trainingProposal.owner.fullName" /></td>
						</tr>
					</s:if>
					<s:if test="trainingProposal.id!=null">
						<tr>
							<td>Status:</td>
							<td><s:property value="trainingProposal.status" /></td>
						</tr>
					</s:if>
					<tr>
						<td>Requester*:</td>
						<td>
							<s:url namespace="/ajax" action="public-ajax" id="xx" /> 
							<iita:autocompleter cssClass="person" name="requesterId" id="trainingProposal.requester.id" listKey="id"
							listValue="fullName" url="%{xx}" method="autocompleteUser" 
							displayValue="%{trainingProposal.requester.fullName}" value="%{trainingProposal.requester.id}" /></td>
					</tr>
					<tr>
						<td>Unit:</td>
						<td><s:textfield name="trainingProposal.unit"
								value="%{trainingProposal.unit}" />
						</td>
					</tr>
					<tr>
						<td>Program Director*:</td>
						<td>
							<s:url namespace="/ajax" action="public-ajax" id="xxx" /> 
							<iita:autocompleter cssClass="person" name="directorId" id="trainingProposal.programDirector.id" listKey="id"
							listValue="fullName" url="%{xxx}" method="autocompleteUser" 
							displayValue="%{trainingProposal.programDirector.fullName}" value="%{trainingProposal.programDirector.id}" />
						</td>
					</tr>
					<tr>
						<td>Project Information*:</td>
						<td><FCK:editor
								instanceName="trainingProposal.projectInformation" height="100">
								<jsp:attribute name="value">${trainingProposal.projectInformation}</jsp:attribute>
							</FCK:editor>
						</td>
					</tr>
					<tr>
						<td>CRP*:</td>
						<td>
							<s:select name="trainingProposal.crp" list="#{'CRP 1.2 Humid':'CRP 1.2 Humid'
							,'CRP 3.2 Maize':'CRP 3.2 Maize'
							,'CRP 3.4 RTB':'CRP 3.4 RTB'
							,'CRP 3.5 Cereal Legumes':'CRP 3.5 Cereal Legumes'
							,'CRP 4 A4NH':'CRP 4 A4NH'
							,'CRP 5 WLE':'CRP 5 WLE'
							,'CRP 7 CCAFS':'CRP 7 CCAFS'
							,'CRP Genebank':'CRP Genebank'
							,'IITA Strategic':'IITA Strategic'
							}" value="%{trainingProposal.crp}" multiple="false" 
							headerKey="" headerValue="-- Select CRP --" />
						</td>
					</tr>
					<tr>
						<td>Charge Cost Center*:</td>
						<td><s:textfield name="trainingProposal.costCenter"
								value="%{trainingProposal.costCenter}" />
						</td>
					</tr>
					<tr>
						<td>Activity*:</td>
						<td><FCK:editor instanceName="trainingProposal.activity" height="100">
								<jsp:attribute name="value">${trainingProposal.activity}</jsp:attribute>
							</FCK:editor>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="left"><h2>Training Proposal Information</h2></td>
					</tr>
					
					<tr>
						<td>Training Introduction/Background:*</td>
						<td>
							<FCK:editor instanceName="trainingProposal.introduction" height="100">
								<jsp:attribute name="value">${trainingProposal.introduction}</jsp:attribute>
							</FCK:editor>
						</td>
					</tr>
					<tr>
						<td>Target group/participants:</td>
						<td>
						<FCK:editor instanceName="trainingProposal.targetGroup" height="100">
							<jsp:attribute name="value">${trainingProposal.targetGroup}</jsp:attribute>
						</FCK:editor>
						</td>
					</tr>
					<tr>
						<td>Expected No. of participants:</td>
						<td><s:textfield name="trainingProposal.numberOfParticipants" value="%{trainingProposal.numberOfParticipants}" /></td>
					</tr>
					<tr>
						<td>Expected No. of female(s):</td>
						<td><s:textfield name="trainingProposal.numberOfFemale" value="%{trainingProposal.numberOfFemale}" /></td>
					</tr>
					<tr>
						<td>Expected No. of male(s):</td>
						<td><s:textfield name="trainingProposal.numberOfMale" value="%{trainingProposal.numberOfMale}" /></td>
					</tr> 
					<tr>
						<td>Objective:</td>
						<td>
						<FCK:editor instanceName="trainingProposal.objective" height="100">
							<jsp:attribute name="value">${trainingProposal.objective}</jsp:attribute>
						</FCK:editor>
						</td>
					</tr>
					<tr>
						<td>Learning method:</td>
						<td>
						<FCK:editor instanceName="trainingProposal.learningMethod" height="100">
							<jsp:attribute name="value">${trainingProposal.learningMethod}</jsp:attribute>
						</FCK:editor>
						</td>
					</tr>
					<tr>
						<td>Expected outcome:</td>
						<td><FCK:editor instanceName="trainingProposal.expectedOutcome" height="100">
							<jsp:attribute name="value">${trainingProposal.expectedOutcome}</jsp:attribute>
						</FCK:editor>
							</td>
					</tr>
					<tr>
						<td>Course contents:</td>
						<td>
							<FCK:editor instanceName="trainingProposal.courseContents" height="100">
								<jsp:attribute name="value">${trainingProposal.courseContents}</jsp:attribute>
							</FCK:editor>
						</td>
					</tr>
			
					<tr>
						<td>Training fee: $</td>
						<td>
							<s:textfield cssClass="numeric" name="trainingProposal.trainingFee" value="%{trainingProposal.trainingFee}" />
						</td>
					</tr>
					<tr>
						<td>Accommodation:</td>
						<td><FCK:editor instanceName="trainingProposal.accommodation" height="100">
								<jsp:attribute name="value">${trainingProposal.accommodation}</jsp:attribute>
							</FCK:editor>
								</td>
					</tr>
					<tr>
						<td>Payment Information:</td>
						<td><FCK:editor instanceName="trainingProposal.payment" height="100">
							<jsp:attribute name="value">${trainingProposal.payment}</jsp:attribute>
							</FCK:editor>
							</td>
					</tr>
					<tr>
						<td>Application deadline*:</td>
						<td><iita:datepicker id="deadline" name="trainingProposal.deadline" value="%{trainingProposal.deadline}" format="dd/MM/yyyy" /> <span id="error" style="display:none;">Choose a valid <span
style="color:red;">date</span>!</span></td>
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
									<s:if test="trainingProposal.trainingLocations.size()>0">
										<s:iterator value="trainingProposal.trainingLocations" status="status">
											<s:set name="locIndex" value="#status.index" />
											<tr>
												<td><s:select 
													name="trainingProposal.trainingLocations[%{locIndex}].country" 
													list="#{'Afghanistan':'Afghanistan','Åland Islands':'Åland Islands','Albania':'Albania','Algeria':'Algeria','American Samoa':'American Samoa','Andorra':'Andorra','Angola':'Angola','Anguilla':'Anguilla','Antigua and Barbuda':'Antigua and Barbuda','Argentina':'Argentina','Armenia':'Armenia','Aruba':'Aruba','Australia':'Australia','Austria':'Austria','Azerbaijan':'Azerbaijan','Bahamas':'Bahamas','Bahrain':'Bahrain','Bangladesh':'Bangladesh','Barbados':'Barbados','Belarus':'Belarus','Belgium':'Belgium','Belize':'Belize','Benin':'Benin','Bermuda':'Bermuda','Bhutan':'Bhutan','Bolivia (Plurinational State of)':'Bolivia (Plurinational State of)','Bonaire, Saint Eustatius and Saba':'Bonaire, Saint Eustatius and Saba','Bosnia and Herzegovina':'Bosnia and Herzegovina','Botswana':'Botswana','Brazil':'Brazil','British Virgin Islands':'British Virgin Islands','Brunei Darussalam':'Brunei Darussalam','Bulgaria':'Bulgaria','Burkina Faso':'Burkina Faso','Burundi':'Burundi','Cabo Verde':'Cabo Verde','Cambodia':'Cambodia','Cameroon':'Cameroon','Canada':'Canada','Cayman Islands':'Cayman Islands','Central African Republic':'Central African Republic','Chad':'Chad','Channel Islands':'Channel Islands','Chile':'Chile','China':'China','China,  Hong Kong Special Administrative Region':'China,  Hong Kong Special Administrative Region','China, Macao Special Administrative Region':'China, Macao Special Administrative Region','Colombia':'Colombia','Comoros':'Comoros','Congo':'Congo','Cook Islands':'Cook Islands','Costa Rica':'Costa Rica','Côte d`Ivoire':'Côte d`Ivoire','Croatia':'Croatia','Cuba':'Cuba','Curaçao':'Curaçao','Cyprus':'Cyprus','Czech Republic':'Czech Republic','Democratic People`s Republic of Korea':'Democratic People`s Republic of Korea','Democratic Republic of the Congo':'Democratic Republic of the Congo','Denmark':'Denmark','Djibouti':'Djibouti','Dominica':'Dominica','Dominican Republic':'Dominican Republic','Ecuador':'Ecuador','Egypt':'Egypt','El Salvador':'El Salvador','Equatorial Guinea':'Equatorial Guinea','Eritrea':'Eritrea','Estonia':'Estonia','Ethiopia':'Ethiopia','Faeroe Islands':'Faeroe Islands','Falkland Islands (Malvinas)':'Falkland Islands (Malvinas)','Fiji':'Fiji','Finland':'Finland','France':'France','French Guiana':'French Guiana','French Polynesia':'French Polynesia','Gabon':'Gabon','Gambia':'Gambia','Georgia':'Georgia','Germany':'Germany','Ghana':'Ghana','Gibraltar':'Gibraltar','Greece':'Greece','Greenland':'Greenland','Grenada':'Grenada','Guadeloupe':'Guadeloupe','Guam':'Guam','Guatemala':'Guatemala','Guernsey':'Guernsey','Guinea':'Guinea','Guinea-Bissau':'Guinea-Bissau','Guyana':'Guyana','Haiti':'Haiti','Holy See':'Holy See','Honduras':'Honduras','Hungary':'Hungary','Iceland':'Iceland','India':'India','Indonesia':'Indonesia','Iran (Islamic Republic of)':'Iran (Islamic Republic of)','Iraq':'Iraq','Ireland':'Ireland','Isle of Man':'Isle of Man','Israel':'Israel','Italy':'Italy','Jamaica':'Jamaica','Japan':'Japan','Jersey':'Jersey','Jordan':'Jordan','Kazakhstan':'Kazakhstan','Kenya':'Kenya','Kiribati':'Kiribati','Kuwait':'Kuwait','Kyrgyzstan':'Kyrgyzstan','Lao People`s Democratic Republic':'Lao People`s Democratic Republic','Latvia':'Latvia','Lebanon':'Lebanon','Lesotho':'Lesotho','Liberia':'Liberia','Libya':'Libya','Liechtenstein':'Liechtenstein','Lithuania':'Lithuania','Luxembourg':'Luxembourg','Madagascar':'Madagascar','Malawi':'Malawi','Malaysia':'Malaysia','Maldives':'Maldives','Mali':'Mali','Malta':'Malta','Marshall Islands':'Marshall Islands','Martinique':'Martinique','Mauritania':'Mauritania','Mauritius':'Mauritius','Mayotte':'Mayotte','Mexico':'Mexico','Micronesia (Federated States of)':'Micronesia (Federated States of)','Monaco':'Monaco','Mongolia':'Mongolia','Montenegro':'Montenegro','Montserrat':'Montserrat','Morocco':'Morocco','Mozambique':'Mozambique','Myanmar':'Myanmar','Namibia':'Namibia','Nauru':'Nauru','Nepal':'Nepal','Netherlands':'Netherlands','New Caledonia':'New Caledonia','New Zealand':'New Zealand','Nicaragua':'Nicaragua','Niger':'Niger','Nigeria':'Nigeria','Niue':'Niue','Norfolk Island':'Norfolk Island','Northern Mariana Islands':'Northern Mariana Islands','Norway':'Norway','Oman':'Oman','Pakistan':'Pakistan','Palau':'Palau','Panama':'Panama','Papua New Guinea':'Papua New Guinea','Paraguay':'Paraguay','Peru':'Peru','Philippines':'Philippines','Pitcairn':'Pitcairn','Poland':'Poland','Portugal':'Portugal','Puerto Rico':'Puerto Rico','Qatar':'Qatar','Republic of Korea':'Republic of Korea','Republic of Moldova':'Republic of Moldova','Réunion':'Réunion','Romania':'Romania','Russian Federation':'Russian Federation','Rwanda':'Rwanda','Saint-Barthélemy':'Saint-Barthélemy','Saint Helena':'Saint Helena','Saint Kitts and Nevis':'Saint Kitts and Nevis','Saint Lucia':'Saint Lucia','Saint-Martin (French part)':'Saint-Martin (French part)','Saint Pierre and Miquelon':'Saint Pierre and Miquelon','Saint Vincent and the Grenadines':'Saint Vincent and the Grenadines','Samoa':'Samoa','San Marino':'San Marino','Sao Tome and Principe':'Sao Tome and Principe','Sark':'Sark','Saudi Arabia':'Saudi Arabia','Senegal':'Senegal','Serbia':'Serbia','Seychelles':'Seychelles','Sierra Leone':'Sierra Leone','Singapore':'Singapore','Sint Maarten (Dutch part)':'Sint Maarten (Dutch part)','Slovakia':'Slovakia','Slovenia':'Slovenia','Solomon Islands':'Solomon Islands','Somalia':'Somalia','South Africa':'South Africa','South Sudan':'South Sudan','Spain':'Spain','Sri Lanka':'Sri Lanka','State of Palestine':'State of Palestine','Sudan':'Sudan','Suriname':'Suriname','Svalbard and Jan Mayen Islands':'Svalbard and Jan Mayen Islands','Swaziland':'Swaziland','Sweden':'Sweden','Switzerland':'Switzerland','Syrian Arab Republic':'Syrian Arab Republic','Tajikistan':'Tajikistan','Thailand':'Thailand','The former Yugoslav Republic of Macedonia':'The former Yugoslav Republic of Macedonia','Timor-Leste':'Timor-Leste','Togo':'Togo','Tokelau':'Tokelau','Tonga':'Tonga','Trinidad and Tobago':'Trinidad and Tobago','Tunisia':'Tunisia','Turkey':'Turkey','Turkmenistan':'Turkmenistan','Turks and Caicos Islands':'Turks and Caicos Islands','Tuvalu':'Tuvalu','Uganda':'Uganda','Ukraine':'Ukraine','United Arab Emirates':'United Arab Emirates','United Kingdom of Great Britain and Northern Ireland':'United Kingdom of Great Britain and Northern Ireland','United Republic of Tanzania':'United Republic of Tanzania','United States of America':'United States of America','United States Virgin Islands':'United States Virgin Islands','Uruguay':'Uruguay','Uzbekistan':'Uzbekistan','Vanuatu':'Vanuatu','Venezuela (Bolivarian Republic of)':'Venezuela (Bolivarian Republic of)','Viet Nam':'Viet Nam','Wallis and Futuna Islands':'Wallis and Futuna Islands','Western Sahara':'Western Sahara','Yemen':'Yemen','Zambia':'Zambia','Zimbabwe':'Zimbabwe'}" 
													value="%{country}" headerKey="" headerValue="--Select country--" /></td>
												<td><s:textfield name="trainingProposal.trainingLocations[%{locIndex}].venue" value="%{venue}" /></td>
								                <td><iita:datepicker name="trainingProposal.trainingLocations[%{locIndex}].startDate" value="%{startDate}" cssClass="mthyrpicker" /></td>
								                <td><iita:datepicker name="trainingProposal.trainingLocations[%{locIndex}].endDate" value="%{endDate}" cssClass="mthyrpicker" /></td>
								            </tr>
										</s:iterator>
									</s:if>
								       	<tr>
											<td><s:select emptyOption="" 
												name="trainingProposal.trainingLocations[%{trainingProposal==null || trainingProposal.trainingLocations==null ? 0 : trainingProposal.trainingLocations.size}].country" 
												list="#{'Afghanistan':'Afghanistan','Åland Islands':'Åland Islands','Albania':'Albania','Algeria':'Algeria','American Samoa':'American Samoa','Andorra':'Andorra','Angola':'Angola','Anguilla':'Anguilla','Antigua and Barbuda':'Antigua and Barbuda','Argentina':'Argentina','Armenia':'Armenia','Aruba':'Aruba','Australia':'Australia','Austria':'Austria','Azerbaijan':'Azerbaijan','Bahamas':'Bahamas','Bahrain':'Bahrain','Bangladesh':'Bangladesh','Barbados':'Barbados','Belarus':'Belarus','Belgium':'Belgium','Belize':'Belize','Benin':'Benin','Bermuda':'Bermuda','Bhutan':'Bhutan','Bolivia (Plurinational State of)':'Bolivia (Plurinational State of)','Bonaire, Saint Eustatius and Saba':'Bonaire, Saint Eustatius and Saba','Bosnia and Herzegovina':'Bosnia and Herzegovina','Botswana':'Botswana','Brazil':'Brazil','British Virgin Islands':'British Virgin Islands','Brunei Darussalam':'Brunei Darussalam','Bulgaria':'Bulgaria','Burkina Faso':'Burkina Faso','Burundi':'Burundi','Cabo Verde':'Cabo Verde','Cambodia':'Cambodia','Cameroon':'Cameroon','Canada':'Canada','Cayman Islands':'Cayman Islands','Central African Republic':'Central African Republic','Chad':'Chad','Channel Islands':'Channel Islands','Chile':'Chile','China':'China','China,  Hong Kong Special Administrative Region':'China,  Hong Kong Special Administrative Region','China, Macao Special Administrative Region':'China, Macao Special Administrative Region','Colombia':'Colombia','Comoros':'Comoros','Congo':'Congo','Cook Islands':'Cook Islands','Costa Rica':'Costa Rica','Côte d`Ivoire':'Côte d`Ivoire','Croatia':'Croatia','Cuba':'Cuba','Curaçao':'Curaçao','Cyprus':'Cyprus','Czech Republic':'Czech Republic','Democratic People`s Republic of Korea':'Democratic People`s Republic of Korea','Democratic Republic of the Congo':'Democratic Republic of the Congo','Denmark':'Denmark','Djibouti':'Djibouti','Dominica':'Dominica','Dominican Republic':'Dominican Republic','Ecuador':'Ecuador','Egypt':'Egypt','El Salvador':'El Salvador','Equatorial Guinea':'Equatorial Guinea','Eritrea':'Eritrea','Estonia':'Estonia','Ethiopia':'Ethiopia','Faeroe Islands':'Faeroe Islands','Falkland Islands (Malvinas)':'Falkland Islands (Malvinas)','Fiji':'Fiji','Finland':'Finland','France':'France','French Guiana':'French Guiana','French Polynesia':'French Polynesia','Gabon':'Gabon','Gambia':'Gambia','Georgia':'Georgia','Germany':'Germany','Ghana':'Ghana','Gibraltar':'Gibraltar','Greece':'Greece','Greenland':'Greenland','Grenada':'Grenada','Guadeloupe':'Guadeloupe','Guam':'Guam','Guatemala':'Guatemala','Guernsey':'Guernsey','Guinea':'Guinea','Guinea-Bissau':'Guinea-Bissau','Guyana':'Guyana','Haiti':'Haiti','Holy See':'Holy See','Honduras':'Honduras','Hungary':'Hungary','Iceland':'Iceland','India':'India','Indonesia':'Indonesia','Iran (Islamic Republic of)':'Iran (Islamic Republic of)','Iraq':'Iraq','Ireland':'Ireland','Isle of Man':'Isle of Man','Israel':'Israel','Italy':'Italy','Jamaica':'Jamaica','Japan':'Japan','Jersey':'Jersey','Jordan':'Jordan','Kazakhstan':'Kazakhstan','Kenya':'Kenya','Kiribati':'Kiribati','Kuwait':'Kuwait','Kyrgyzstan':'Kyrgyzstan','Lao People`s Democratic Republic':'Lao People`s Democratic Republic','Latvia':'Latvia','Lebanon':'Lebanon','Lesotho':'Lesotho','Liberia':'Liberia','Libya':'Libya','Liechtenstein':'Liechtenstein','Lithuania':'Lithuania','Luxembourg':'Luxembourg','Madagascar':'Madagascar','Malawi':'Malawi','Malaysia':'Malaysia','Maldives':'Maldives','Mali':'Mali','Malta':'Malta','Marshall Islands':'Marshall Islands','Martinique':'Martinique','Mauritania':'Mauritania','Mauritius':'Mauritius','Mayotte':'Mayotte','Mexico':'Mexico','Micronesia (Federated States of)':'Micronesia (Federated States of)','Monaco':'Monaco','Mongolia':'Mongolia','Montenegro':'Montenegro','Montserrat':'Montserrat','Morocco':'Morocco','Mozambique':'Mozambique','Myanmar':'Myanmar','Namibia':'Namibia','Nauru':'Nauru','Nepal':'Nepal','Netherlands':'Netherlands','New Caledonia':'New Caledonia','New Zealand':'New Zealand','Nicaragua':'Nicaragua','Niger':'Niger','Nigeria':'Nigeria','Niue':'Niue','Norfolk Island':'Norfolk Island','Northern Mariana Islands':'Northern Mariana Islands','Norway':'Norway','Oman':'Oman','Pakistan':'Pakistan','Palau':'Palau','Panama':'Panama','Papua New Guinea':'Papua New Guinea','Paraguay':'Paraguay','Peru':'Peru','Philippines':'Philippines','Pitcairn':'Pitcairn','Poland':'Poland','Portugal':'Portugal','Puerto Rico':'Puerto Rico','Qatar':'Qatar','Republic of Korea':'Republic of Korea','Republic of Moldova':'Republic of Moldova','Réunion':'Réunion','Romania':'Romania','Russian Federation':'Russian Federation','Rwanda':'Rwanda','Saint-Barthélemy':'Saint-Barthélemy','Saint Helena':'Saint Helena','Saint Kitts and Nevis':'Saint Kitts and Nevis','Saint Lucia':'Saint Lucia','Saint-Martin (French part)':'Saint-Martin (French part)','Saint Pierre and Miquelon':'Saint Pierre and Miquelon','Saint Vincent and the Grenadines':'Saint Vincent and the Grenadines','Samoa':'Samoa','San Marino':'San Marino','Sao Tome and Principe':'Sao Tome and Principe','Sark':'Sark','Saudi Arabia':'Saudi Arabia','Senegal':'Senegal','Serbia':'Serbia','Seychelles':'Seychelles','Sierra Leone':'Sierra Leone','Singapore':'Singapore','Sint Maarten (Dutch part)':'Sint Maarten (Dutch part)','Slovakia':'Slovakia','Slovenia':'Slovenia','Solomon Islands':'Solomon Islands','Somalia':'Somalia','South Africa':'South Africa','South Sudan':'South Sudan','Spain':'Spain','Sri Lanka':'Sri Lanka','State of Palestine':'State of Palestine','Sudan':'Sudan','Suriname':'Suriname','Svalbard and Jan Mayen Islands':'Svalbard and Jan Mayen Islands','Swaziland':'Swaziland','Sweden':'Sweden','Switzerland':'Switzerland','Syrian Arab Republic':'Syrian Arab Republic','Tajikistan':'Tajikistan','Thailand':'Thailand','The former Yugoslav Republic of Macedonia':'The former Yugoslav Republic of Macedonia','Timor-Leste':'Timor-Leste','Togo':'Togo','Tokelau':'Tokelau','Tonga':'Tonga','Trinidad and Tobago':'Trinidad and Tobago','Tunisia':'Tunisia','Turkey':'Turkey','Turkmenistan':'Turkmenistan','Turks and Caicos Islands':'Turks and Caicos Islands','Tuvalu':'Tuvalu','Uganda':'Uganda','Ukraine':'Ukraine','United Arab Emirates':'United Arab Emirates','United Kingdom of Great Britain and Northern Ireland':'United Kingdom of Great Britain and Northern Ireland','United Republic of Tanzania':'United Republic of Tanzania','United States of America':'United States of America','United States Virgin Islands':'United States Virgin Islands','Uruguay':'Uruguay','Uzbekistan':'Uzbekistan','Vanuatu':'Vanuatu','Venezuela (Bolivarian Republic of)':'Venezuela (Bolivarian Republic of)','Viet Nam':'Viet Nam','Wallis and Futuna Islands':'Wallis and Futuna Islands','Western Sahara':'Western Sahara','Yemen':'Yemen','Zambia':'Zambia','Zimbabwe':'Zimbabwe'}" 
												value="%{country}" headerKey="" headerValue="--Select country--" /></td>
											<td><s:textfield name="trainingProposal.trainingLocations[%{trainingProposal==null || trainingProposal.trainingLocations==null ? 0 : trainingProposal.trainingLocations.size}].venue" value="%{venue}" /></td>
							                <td><iita:datepicker name="trainingProposal.trainingLocations[%{trainingProposal==null || trainingProposal.trainingLocations==null ? 0 : trainingProposal.trainingLocations.size}].startDate" value="" cssClass="mthyrpicker" /></td>
							                <td><iita:datepicker name="trainingProposal.trainingLocations[%{trainingProposal==null || trainingProposal.trainingLocations==null ? 0 : trainingProposal.trainingLocations.size}].endDate" value="" cssClass="mthyrpicker" /></td>
										</tr>
										<tr>
											<td colspan="4"><a onclick="javascript: copyBudget($($(this).parentNode.parentNode).previous(), 3, 0); return false;">More location info +</a></td>
										</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td valign="top">Resource Persons/Trainers:</td>
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
						<s:if test="trainingProposal.trainers.size()>0">
							<s:iterator value="trainingProposal.trainers" status="status">
								<s:set name="trainerIndex" value="#status.index" />
								<tr>
									<td>
									<s:textfield name="trainingProposal.trainers[%{trainerIndex}].names" value="%{person==null ? names : person.fullName}" /></td>
									<td><s:textfield name="trainingProposal.trainers[%{trainerIndex}].email" value="%{email}" /></td>
									<td><s:select name="trainingProposal.trainers[%{trainerIndex}].type" value="%{type}" list="@org.iita.trainingunit.model.Trainer$TrainerType@values()" /></td>
									<td><s:textarea name="trainingProposal.trainers[%{trainerIndex}].notes" value="%{notes}" /></td>
								</tr>
							</s:iterator>
						</s:if>
						<tr>
							<td>
							<s:textfield name="trainingProposal.trainers[%{trainingProposal==null || trainingProposal.trainers==null ? 0 : trainingProposal.trainers.size}].names" value="%{names}" /></td>
							<td><s:textfield name="trainingProposal.trainers[%{trainingProposal==null || trainingProposal.trainers==null ? 0 : trainingProposal.trainers.size}].email" value="%{email}" /></td>
							<td><s:select name="trainingProposal.trainers[%{trainingProposal==null || trainingProposal.trainers==null ? 0 : trainingProposal.trainers.size}].type" value="%{type}" list="@org.iita.trainingunit.model.Trainer$TrainerType@values()" /></td>
							<td><s:textarea name="trainingProposal.trainers[%{trainingProposal==null || trainingProposal.trainers==null ? 0 : trainingProposal.trainers.size}].notes" value="%{notes}" /></td>
						</tr>
						<tr>
							<td><a onclick="javascript: copyTrainer($($(this).parentNode.parentNode).previous(), 3, 0); return false;">More trainers +</a></td>
							<td colspan="2" />
						</tr>
					</table>
					</td>
				</tr>
				<tr>
					<td />
					<td>
						<div class="button-bar" style="margin: 10px 0px 0px 0px;">
							<s:submit value="Save Proposal" onclick="javascript: __date();" /> 
							<s:submit action="submit-proposal" onclick="javascript: return confirm('Submit this proposal anyway?');" value="Submit proposal" />	
							<s:if test="trainingProposal.status!=@org.iita.trainingunit.announcements.model.TrainingProposal$STATUS@SUBMITTED">
								<s:submit action="trainingproposaldelete" onclick="javascript: return confirm('Delete this proposal anyway?');" cssStyle="color: Red;" value="Delete record" />		
							</s:if>
						</div>
					</td>
				</tr>
				</table>
			</s:form>
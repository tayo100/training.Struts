<%@ include file="/common/taglibs.jsp"%>

<s:form action="update-trainee" method="post">
	<s:if test="top instanceof org.iita.crm.model.Person && id!=null">
		<s:hidden name="personId" value="%{id}" />
	</s:if>
	<s:push value="profile">
		<s:hidden name="id" value="%{profile.id}" />
	</s:push>
	<table class="inputform">
		<colgroup>
			<col width="20%" />
			<col />
		</colgroup>
		<tr>
			<td>Research Topic:</td>
			<td><s:textfield name="profile.researchTopic" value="%{profile.researchTopic}" /></td>
		</tr>
		<tr>
			<td>Research Location:</td>
			<td><s:textfield name="profile.location" value="%{profile.location}" /></td>
		</tr>
		<!-- 
		<tr>
			<td>Longitude:</td>
			<td><s:textfield name="profile.longitude" value="%{profile.longitude}" /></td>
		</tr>
		<tr>
			<td>Latitude:</td>
			<td><s:textfield name="profile.latitude" value="%{profile.latitude}" /></td>
		</tr> -->
		<tr>
			<td>Research Country:</td>
			<td><s:textfield name="profile.country" value="%{profile.country}" /></td>
		</tr>
		<tr>
			<td>Degree:</td>
			<td><s:select name="profile.degree" value="%{profile.degree}" emptyOption="true" 
			list="#{'NYSC':'NYSC','MSc':'MSc','PhD':'PhD','INTERNSHIP':'Internship','VisitingScientist':'Visiting Scientist',
			'Sabbatical':'Sabbatical','TalentGrant':'Talent Grant', 'Individual':'Individual', 'StaffDevelopment':'Staff Development'
			, 'Other':'Other'}" /></td>
		</tr>
		<tr>
			<td>Field of Study:</td>
			<td><s:select name="profile.discipline" list="#{'Agric Economics':'Agric Economics','Agric Engineering':'Agric Engineering'
			,'Agricultural Extension':'Agricultural Extension','Agricultural Rural Sociology':'Agricultural Rural Sociology'
			,'Agro-Climatology':'Agro-Climatology','Agronomy':'Agronomy'
			,'Biotechnology':'Biotechnology','Biological Control':'Biological Control'
			,'Biometrics':'Biometrics','Crop Production':'Crop Production'
			,'Entomology/InsectEcology':'Entomology/InsectEcology','Farm Mechanisation/Management':'Farm Mechanisation/Management'
			,'Forest Managemnt':'Forest Managemnt','Fisheries':'Fisheries'
			,'Food Processing/Utilization':'Food Processing/Utilization','Genetic Resources Conservation':'Genetic Resources Conservation'
			,'Information Services/Library':'Information Services/Library','Nematology':'Nematology'
			,'Plant Breeding':'Plant Breeding','Plant Pathology':'Plant Pathology'
			,'Plant Nutrition':'Plant Nutrition','Post-Harvest Technology':'Post-Harvest Technology'
			,'Resource Management':'Resource Management','Soil & Plant Analysis':'Soil & Plant Analysis'
			,'Soil Biology':'Soil Biology','Soil Chemistry':'Soil Chemistry'
			,'Soil Conservation':'Soil Conservation','Soil Fertility':'Soil Fertility'
			,'Soil Microbiology':'Soil Microbiology','Soil Physics':'Soil Physics'
			,'Tissue Culture':'Tissue Culture','Virology':'Virology'
			,'Weed Science':'Weed Science'}" value="%{profile.discipline}" emptyOption="true" />
			</td>
		</tr>
		<!-- 
		<tr>
			<td>Program:</td>
			<td><s:select name="profile.program" list="#{'Agro-biodiversity':'Agro-biodiversity','Banana and Plantains Systems':'Banana and Plantains Systems'
			,'Cereals and Legumes Systems':'Cereals and Legumes Systems','Horticulture and Tree Crop Systems':'Horticulture and Tree Crop Systems'
			,'Opportunities and Threats':'Opportunities and Threats','Roots and Tubers Systems':'Roots and Tubers Systems'
			,'System-wide Propram on IPM':'System-wide Propram on IPM','Agriculture and Health':'Agriculture and Health'
			,'N/A':'N/A'}" value="%{profile.program}" emptyOption="true" />
			</td>
		</tr>
		
		<tr>
			<td>Sub Programs:</td>
			<td>
				<s:select name="subPrograms" value="%{selectedSubPrograms}"
				 	list="#{}" multiple="true">
	    			<s:optgroup label="Roots and Tubers Systems"
	                	list="%{#{'Banana':'Banana','Cassava':'Cassava','Plantain':'Plantain','Yam':'Yam'}}" />
	    			<s:optgroup label="Cereals and Legumes Systems"
	               		list="%{#{'Cocoa':'Cocoa','Soybean':'Soybean'}}" />
				</s:select>
			</td>
		</tr>
		 -->
		<tr>
			<td>University:</td>
			<td><s:url namespace="/ajax" action="public-ajax" id="xx" /> <iita:autocompleter cssClass="organization" name="profile.university"
				id="aff.organizationId" listKey="id" listValue="title" url="%{xx}" method="autocompleteOrganization" submitTextTo="universityName"
				value="%{profile.university.id}" displayValue="%{profile.university.title}" /></td>
		</tr>
		<tr>
			<td>Start date:</td>
			<td><iita:datepicker name="profile.startDate" value="%{profile.startDate}" format="dd/MM/yyyy" /></td>
		</tr>
		<tr>
			<td>End date:</td>
			<td><iita:datepicker name="profile.endDate" value="%{profile.endDate}" format="dd/MM/yyyy" /></td>
		</tr>
		<tr>
			<td>Extension date:</td>
			<td><iita:datepicker name="profile.extensionDate" value="%{profile.extensionDate}" format="dd/MM/yyyy" /></td>
		</tr>
		<!-- 
		<tr>
			<td>Degree Award date:</td>
			<td><iita:datepicker name="profile.degreeAwardDate" value="%{profile.degreeAwardDate}" format="dd/MM/yyyy" /></td>
		</tr>
		 -->
		<tr>
			<td>Sponsor:</td>
			<td><s:textfield name="profile.sponsor" value="%{profile.sponsor}" /></td>
		</tr>
		
		<tr>
			<td>Crps:</td>
			<td><s:select name="crps" list="#{'CRP 1.2 Humid':'CRP 1.2 Humid'
			,'CRP 3.2 Maize':'CRP 3.2 Maize'
			,'CRP 3.4 RTB':'CRP 3.4 RTB'
			,'CRP 3.5 Cereal Legumes':'CRP 3.5 Cereal Legumes'
			,'CRP 4 A4NH':'CRP 4 A4NH'
			,'CRP 5 WLE':'CRP 5 WLE'
			,'CRP 7 CCAFS':'CRP 7 CCAFS'
			,'CRP Genebank':'CRP Genebank'
			,'IITA Strategic':'IITA Strategic'
			}" value="%{selectedCrps}" multiple="true" />
			</td>
		</tr>
		
		<tr>
			<td>Hubs:</td>
			<td><s:select name="hubs" list="#{'Western Africa':'Western Africa','Eastern Africa':'Eastern Africa',
			'Central Africa':'Central Africa','Southern Africa':'Southern Africa'}" value="%{selectedHubs}" multiple="true" />
			</td>
		</tr>
		
		<tr>
			<td>Core Competencies:</td>
			<td><s:select name="coreCompetencies" list="#{'Natural Resource Management':'Natural Resource Management'
			,'Biotech & Plant Breeding':'Biotech & Plant Breeding'
			,'Social Science & Agribusiness':'Social Science & Agribusiness'
			,'Plant Production & Health':'Plant Production & Health'}" value="%{selectedCoreCompetencies}" multiple="true" />
			</td>
		</tr>
		
		<tr>
			<td>Keywords:</td>
			<td><s:textfield name="profile.keywords" value="%{profile.keywords}" /></td>
		</tr>
		<tr>
			<td></td>
			<td><s:submit value="Update trainee" /></td>
		</tr>
	</table>
</s:form>
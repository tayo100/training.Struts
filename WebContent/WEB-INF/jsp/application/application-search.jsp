<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Application Data</title>
<style>
	@import "http://fonts.googleapis.com/css?family=Roboto:300,400,500,700";

	.container { margin-top: 20px; }
	.mb20 { margin-bottom: 20px; } 
	
	hgroup { padding-left: 15px; border-bottom: 1px solid #ccc; }
	hgroup h1 { font: 500 normal 1.625em "Roboto",Arial,Verdana,sans-serif; color: #2a3644; margin-top: 0; line-height: 1.15; }
	hgroup h2.lead { font: normal normal 1.125em "Roboto",Arial,Verdana,sans-serif; color: #2a3644; margin: 0; padding-bottom: 10px; }
	
	.search-result .thumbnail { border-radius: 0 !important; }
	.search-result:first-child { margin-top: 0 !important; }
	.search-result { margin-top: 20px; }
	.search-result .col-md-2 { border-right: 1px dotted #ccc; min-height: 140px; }
	.search-result ul { padding-left: 0 !important; list-style: none;  }
	.search-result ul li { font: 400 normal .85em "Roboto",Arial,Verdana,sans-serif;  line-height: 20px; }
	.search-result ul li i { padding-right: 5px; }
	.search-result .col-md-7 { position: relative; }
	.search-result h3 { font: 500 normal 1.375em "Roboto",Arial,Verdana,sans-serif; margin-top: 0 !important; margin-bottom: 10px !important; }
	.search-result h3 > a, .search-result i { color: #248dc1 !important; }
	.search-result p { font: normal normal 1.125em "Roboto",Arial,Verdana,sans-serif; } 
	.search-result span.plus { position: absolute; right: 0; top: 126px; }
	.search-result span.plus a { background-color: #248dc1; padding: 5px 5px 3px 5px; }
	.search-result span.plus a:hover { background-color: #414141; }
	.search-result span.plus a i { color: #fff !important; }
	.search-result span.border { display: block; width: 97%; margin: 0 15px; border-bottom: 1px dotted #ccc; }
</style>
</head>
<body>
<div class="container-fluid">
	<s:form method="post" action="search-applications!query">
		<div class="row">
			<div class="form-group">
				<div class="col-md-6 col-xs-6">
					<label class="col-xs-12">Free Text:</label>
					<s:textfield cssClass="form-control" name="details" value="%{details}" />
				</div>
				
				<div class="col-md-6 col-xs-6">
					<label class="col-xs-12">Field of Study:</label>
					<s:select cssClass="form-control" 
						name="majorFieldOfStudy" 
						list="#{'Accounting':'Accounting'
	,'Addiction Medicine':'Addiction Medicine'
	,'Admiralty Law':'Admiralty Law'
	,'Advertising':'Advertising'
	,'Aerospace Engineering':'Aerospace Engineering'
	,'Agricultural Education':'Agricultural Education'
	,'Agricultural Engineering':'Agricultural Engineering'
	,'Agricultural Policy':'Agricultural Policy'
	,'Alternative Education':'Alternative Education'
	,'American Sign Language':'American Sign Language'
	,'Amphibious Warfare':'Amphibious Warfare'
	,'Andrology':'Andrology'
	,'Animal Communication':'Animal Communication'
	,'Animal Law/Animal Rights':'Animal Law/Animal Rights'
	,'Apparel Design':'Apparel Design'
	,'Applied Science In Biology':'Applied Science In Biology'
	,'Applied Science In Exercise Science':'Applied Science In Exercise Science'
	,'Applied Science In Psychology':'Applied Science In Psychology'
	,'Archival Science':'Archival Science'
	,'Art History':'Art History'
	,'Art Education':'Art Education'
	,'Artillery':'Artillery'
	,'Associate Of Arts Program':'Associate Of Arts Program'
	,'Athletic Director':'Athletic Director'
	,'Athletic Training':'Athletic Training'
	,'Automotive Engineering':'Automotive Engineering'
	,'Bariatric Surgery':'Bariatric Surgery'
	,'Behavioral Medicine':'Behavioral Medicine'
	,'Biblical Hebrew':'Biblical Hebrew'
	,'Biblical Studies/Sacred Scripture':'Biblical Studies/Sacred Scripture'
	,'Bibliometrics':'Bibliometrics'
	,'Bilingual Education':'Bilingual Education'
	,'Bioengineering':'Bioengineering'
	,'Biology':'Biology'
	,'Biomechanical Engineering':'Biomechanical Engineering'
	,'Biomechanics/Sports Biomechanics':'Biomechanics/Sports Biomechanics'
	,'Biomedical Engineering':'Biomedical Engineering'
	,'Broadcast Journalism':'Broadcast Journalism'
	,'Business Administration- Marketing And Management':'Business Administration- Marketing And Management'
	,'Business-To-Business Sales':'Business-To-Business Sales'
	,'Business-To-Business Sales Certificates I&Ii':'Business-To-Business Sales Certificates I&Ii'
	,'Campaigning':'Campaigning'
	,'Canon Law':'Canon Law'
	,'Cardiology':'Cardiology'
	,'Cardiothoracic Surgery':'Cardiothoracic Surgery'
	,'Catechetical Ministry Certificate':'Catechetical Ministry Certificate'
	,'Ceramic Engineering':'Ceramic Engineering'
	,'Chemical Engineering':'Chemical Engineering'
	,'Chemistry':'Chemistry'
	,'Chemistry Education':'Chemistry Education'
	,'Child Welfare':'Child Welfare'
	,'Christian Ethics':'Christian Ethics'
	,'Church History':'Church History'
	,'Citation Analysis':'Citation Analysis'
	,'Civil Engineering':'Civil Engineering'
	,'Civil Law':'Civil Law'
	,'Civil Procedure':'Civil Procedure'
	,'Clinical Physiology':'Clinical Physiology'
	,'Clinical Biochemistry':'Clinical Biochemistry'
	,'Clinical Immunology':'Clinical Immunology'
	,'Clinical Laboratory Sciences/Clinical Pathology/Laboratory Medicine':'Clinical Laboratory Sciences/Clinical Pathology/Laboratory Medicine'
	,'Clinical Microbiology':'Clinical Microbiology'
	,'Clinical Psychology':'Clinical Psychology'
	,'Coastal Management':'Coastal Management'
	,'Coding Specialist':'Coding Specialist'
	,'Communication Studies':'Communication Studies'
	,'Communication Design':'Communication Design'
	,'Communication- Oral':'Communication- Oral'
	,'Community Health Worker':'Community Health Worker'
	,'Community Informatics':'Community Informatics'
	,'Community Organizing':'Community Organizing'
	,'Community Practice':'Community Practice'
	,'Comparative Law':'Comparative Law'
	,'Competition Law':'Competition Law'
	,'Computational Economics':'Computational Economics'
	,'Computational Finance':'Computational Finance'
	,'Computational Sociology':'Computational Sociology'
	,'Computer Science':'Computer Science'
	,'Computer Engineering':'Computer Engineering'
	,'Conservation Biology':'Conservation Biology'
	,'Conservation Science':'Conservation Science'
	,'Constitutional Law':'Constitutional Law'
	,'Consumer Education':'Consumer Education'
	,'Contract Law':'Contract Law'
	,'Control Systems Engineering':'Control Systems Engineering'
	,'Cooperative Learning':'Cooperative Learning'
	,'Corporations':'Corporations'
	,'Corrections':'Corrections'
	,'Counseling Psychology':'Counseling Psychology'
	,'Counselor Education':'Counselor Education'
	,'Criminal Justice':'Criminal Justice'
	,'Criminal Law':'Criminal Law'
	,'Criminal Procedure':'Criminal Procedure'
	,'Critical Studies Of Race And Ethnicity':'Critical Studies Of Race And Ethnicity'
	,'Critical Pedagogy':'Critical Pedagogy'
	,'Cytogenetics':'Cytogenetics'
	,'Cytohematology':'Cytohematology'
	,'Cytology':'Cytology'
	,'Dance':'Dance'
	,'Defense Policy':'Defense Policy'
	,'Dental Hygiene And Epidemiology':'Dental Hygiene And Epidemiology'
	,'Dental Surgery':'Dental Surgery'
	,'Dentistry':'Dentistry'
	,'Dermatology':'Dermatology'
	,'Dietetics':'Dietetics'
	,'Distance Education':'Distance Education'
	,'Doctrine':'Doctrine'
	,'Dogmatic Theology':'Dogmatic Theology'
	,'Domestic Policy':'Domestic Policy'
	,'Drug Policy':'Drug Policy'
	,'Earthquake Engineering':'Earthquake Engineering'
	,'Ecclesiology':'Ecclesiology'
	,'Ecological Engineering':'Ecological Engineering'
	,'Economics':'Economics'
	,'Education':'Education'
	,'Education Policy':'Education Policy'
	,'Educational Leadership':'Educational Leadership'
	,'Educational Philosophy':'Educational Philosophy'
	,'Educational Psychology':'Educational Psychology'
	,'Educational Technology':'Educational Technology'
	,'Electrical Engineering':'Electrical Engineering'
	,'Electronic Media Studies':'Electronic Media Studies'
	,'Electronic Engineering':'Electronic Engineering'
	,'Elementary Education':'Elementary Education'
	,'Emergency Management':'Emergency Management'
	,'Endocrinology':'Endocrinology'
	,'Endodontics':'Endodontics'
	,'Energy Policy':'Energy Policy'
	,'Engineering Geology':'Engineering Geology'
	,'Engineering Physics':'Engineering Physics'
	,'English':'English'
	,'Environmental Communication':'Environmental Communication'
	,'Environmental Engineering':'Environmental Engineering'
	,'Environmental Law':'Environmental Law'
	,'Environmental Management':'Environmental Management'
	,'Environmental Policy':'Environmental Policy'
	,'Ergonomics':'Ergonomics'
	,'Exercise Science And Nutrition (Combined Major)':'Exercise Science And Nutrition (Combined Major)'
	,'Exercise And Sport Science':'Exercise And Sport Science'
	,'Exercise Physiology':'Exercise Physiology'
	,'Family And Consumer Science':'Family And Consumer Science'
	,'Fashion Merchandising':'Fashion Merchandising'
	,'Financial Economics':'Financial Economics'
	,'Fire Ecology (Wildland Fire Management)':'Fire Ecology (Wildland Fire Management)'
	,'Fire Safety (Structural Fire Protection)':'Fire Safety (Structural Fire Protection)'
	,'Fiscal Policy':'Fiscal Policy'
	,'Fisheries Management':'Fisheries Management'
	,'Food Engineering':'Food Engineering'
	,'Foods And Nutrition- Business':'Foods And Nutrition- Business'
	,'Foods And Nutrition- Science':'Foods And Nutrition- Science'
	,'Foodservice Management':'Foodservice Management'
	,'Foot And Ankle Surgery':'Foot And Ankle Surgery'
	,'Foreign Policy':'Foreign Policy'
	,'Forensic Science':'Forensic Science'
	,'French':'French'
	,'Game Design':'Game Design'
	,'Game Theory':'Game Theory'
	,'Gastroenterology':'Gastroenterology'
	,'General Practice':'General Practice'
	,'Geography':'Geography'
	,'Geotechnical Engineering':'Geotechnical Engineering'
	,'Geriatrics':'Geriatrics'
	,'Gerontology':'Gerontology'
	,'Governmental Affairs':'Governmental Affairs'
	,'Group Fitness/Aerobics':'Group Fitness/Aerobics'
	,'Gynaecology':'Gynaecology'
	,'Haemostasiology':'Haemostasiology'
	,'Hand Surgery':'Hand Surgery'
	,'Health Information Specialist':'Health Information Specialist'
	,'Health Informatics/Clinical Informatics':'Health Informatics/Clinical Informatics'
	,'Health Policy':'Health Policy'
	,'Health Psychology':'Health Psychology'
	,'Healthcare Management':'Healthcare Management'
	,'Healthcare Sales':'Healthcare Sales'
	,'Healthcare Sales Certificate':'Healthcare Sales Certificate'
	,'Hematology':'Hematology'
	,'Hepatology':'Hepatology'
	,'Higher Education':'Higher Education'
	,'Highway Engineering':'Highway Engineering'
	,'Highway Safety':'Highway Safety'
	,'Histology':'Histology'
	,'History':'History'
	,'History Of Computer Hardware':'History Of Computer Hardware'
	,'History Of Computer Science':'History Of Computer Science'
	,'Homiletics':'Homiletics'
	,'Honors Program':'Honors Program'
	,'Housing':'Housing'
	,'Housing Policy':'Housing Policy'
	,'Humanistic Informatics':'Humanistic Informatics'
	,'Immigration Policy':'Immigration Policy'
	,'Implantology':'Implantology'
	,'Industrial Engineering':'Industrial Engineering'
	,'Infectious Disease':'Infectious Disease'
	,'Infographics':'Infographics'
	,'Informatics':'Informatics'
	,'Information Architecture':'Information Architecture'
	,'Information Theory':'Information Theory'
	,'Instrumentation Engineering':'Instrumentation Engineering'
	,'Intercultural Communication':'Intercultural Communication'
	,'Interdisciplinary':'Interdisciplinary'
	,'Interior Design':'Interior Design'
	,'Intermodal Transportation Studies':'Intermodal Transportation Studies'
	,'Internal Medicine':'Internal Medicine'
	,'International Business And Economics':'International Business And Economics'
	,'International Relations':'International Relations'
	,'International Affairs':'International Affairs'
	,'International Law':'International Law'
	,'Internet':'Internet'
	,'Interpreting':'Interpreting'
	,'Islamic Law':'Islamic Law'
	,'Jewish Law':'Jewish Law'
	,'Joint Replacement':'Joint Replacement'
	,'Journalism':'Journalism'
	,'Jurisprudence (Philosophy Of Law)':'Jurisprudence (Philosophy Of Law)'
	,'Kinesiology/Exercise Science/Human Performance':'Kinesiology/Exercise Science/Human Performance'
	,'Labor Law':'Labor Law'
	,'Labor Policy':'Labor Policy'
	,'Land Management':'Land Management'
	,'Language Education':'Language Education'
	,'Latin':'Latin'
	,'Leadership':'Leadership'
	,'Legal Education':'Legal Education'
	,'Leisure Studies':'Leisure Studies'
	,'Literary Journalism':'Literary Journalism'
	,'Liturgy':'Liturgy'
	,'Logistics':'Logistics'
	,'Magazine':'Magazine'
	,'Manufacturing Engineering':'Manufacturing Engineering'
	,'Marine Engineering':'Marine Engineering'
	,'Marine Transportation':'Marine Transportation'
	,'Marketing':'Marketing'
	,'Mass Communication':'Mass Communication'
	,'Mass Transit':'Mass Transit'
	,'Mastery Learning':'Mastery Learning'
	,'Materials Engineering':'Materials Engineering'
	,'Mathematics':'Mathematics'
	,'Mathematics Education':'Mathematics Education'
	,'Mechanical Engineering':'Mechanical Engineering'
	,'Media Studies (Mass Media)':'Media Studies (Mass Media)'
	,'Medical Education':'Medical Education'
	,'Medical Psychology':'Medical Psychology'
	,'Medical Social Work':'Medical Social Work'
	,'Medical Toxicology':'Medical Toxicology'
	,'Mental Health':'Mental Health'
	,'Metallurgical Engineering':'Metallurgical Engineering'
	,'Midwifery-Obstetrics':'Midwifery-Obstetrics'
	,'Military Education And Training':'Military Education And Training'
	,'Military Engineering':'Military Engineering'
	,'Military History':'Military History'
	,'Military Intelligence':'Military Intelligence'
	,'Military Law':'Military Law'
	,'Military Medicine':'Military Medicine'
	,'Mining Engineering':'Mining Engineering'
	,'Missiology':'Missiology'
	,'Molecular Genetics':'Molecular Genetics'
	,'Montessori Early Childhood Associate Credential':'Montessori Early Childhood Associate Credential'
	,'Museology':'Museology'
	,'Museum Administration':'Museum Administration'
	,'Music Studies':'Music Studies'
	,'Music Theater':'Music Theater'
	,'Music Education':'Music Education'
	,'Music In The Church':'Music In The Church'
	,'Nanoengineering':'Nanoengineering'
	,'Natural Resource Management':'Natural Resource Management'
	,'Naval Architecture':'Naval Architecture'
	,'Naval Engineering':'Naval Engineering'
	,'Naval Science':'Naval Science'
	,'Naval Tactics':'Naval Tactics'
	,'Nephrology':'Nephrology'
	,'Neurology':'Neurology'
	,'Neurosurgery':'Neurosurgery'
	,'New Testament Greek':'New Testament Greek'
	,'New Media Journalism':'New Media Journalism'
	,'Newspaper':'Newspaper'
	,'Non-Governmental Organization (Ngo) Administration':'Non-Governmental Organization (Ngo) Administration'
	,'Nonprofit Administration':'Nonprofit Administration'
	,'Nonverbal Communication':'Nonverbal Communication'
	,'Nuclear Engineering':'Nuclear Engineering'
	,'Nursing':'Nursing'
	,'Nursing Education':'Nursing Education'
	,'Nursing Theory':'Nursing Theory'
	,'Nutrition':'Nutrition'
	,'Nutritionand Dietetics':'Nutritionand Dietetics'
	,'Obstetrics':'Obstetrics'
	,'Occupational Science- Pre-Occupational Therapy':'Occupational Science- Pre-Occupational Therapy'
	,'Occupational Therapy Assistant':'Occupational Therapy Assistant'
	,'Occupational Therapy':'Occupational Therapy'
	,'Ocean Engineering':'Ocean Engineering'
	,'Old Church Slavonic':'Old Church Slavonic'
	,'Oncology':'Oncology'
	,'Operations Research':'Operations Research'
	,'Ophthalmic Technician Program':'Ophthalmic Technician Program'
	,'Ophthalmology':'Ophthalmology'
	,'Optical Engineering':'Optical Engineering'
	,'Optometry':'Optometry'
	,'Oral And Maxillofacial Surgery':'Oral And Maxillofacial Surgery'
	,'Organizational Communication':'Organizational Communication'
	,'Orthodontics':'Orthodontics'
	,'Orthopedic Surgery':'Orthopedic Surgery'
	,'Orthoptics':'Orthoptics'
	,'Otolaryngology':'Otolaryngology'
	,'Paralegal Studies':'Paralegal Studies'
	,'Parasitology':'Parasitology'
	,'Pastoral Ministry Certificate':'Pastoral Ministry Certificate'
	,'Pastoral Counseling':'Pastoral Counseling'
	,'Pastoral Theology':'Pastoral Theology'
	,'Pathology':'Pathology'
	,'Peace And Conflict Studies':'Peace And Conflict Studies'
	,'Peace Education':'Peace Education'
	,'Pediatrics':'Pediatrics'
	,'Periodontics':'Periodontics'
	,'Personal Fitness Training':'Personal Fitness Training'
	,'Personal Trainer/Personal Fitness Training':'Personal Trainer/Personal Fitness Training'
	,'Petroleum Engineering':'Petroleum Engineering'
	,'Pharmaceutical Sciences':'Pharmaceutical Sciences'
	,'Pharmacy':'Pharmacy'
	,'Philosophy':'Philosophy'
	,'Philosophy- Ethics':'Philosophy- Ethics'
	,'Philosophy- History And Ideas':'Philosophy- History And Ideas'
	,'Phlebotomy Program':'Phlebotomy Program'
	,'Physical Therapist Assistant':'Physical Therapist Assistant'
	,'Physical Education/Pedagogy':'Physical Education/Pedagogy'
	,'Physical Education/Sports Coaching':'Physical Education/Sports Coaching'
	,'Physical Fitness':'Physical Fitness'
	,'Physics Education':'Physics Education'
	,'Physiotherapy':'Physiotherapy'
	,'Plastic Surgery':'Plastic Surgery'
	,'Podiatry':'Podiatry'
	,'Police Science':'Police Science'
	,'Political Science':'Political Science'
	,'Polymer Engineering':'Polymer Engineering'
	,'Port Management':'Port Management'
	,'Preventive Medicine':'Preventive Medicine'
	,'Primary Care':'Primary Care'
	,'Print Journalism':'Print Journalism'
	,'Propaganda':'Propaganda'
	,'Property Law':'Property Law'
	,'Prosthodontics':'Prosthodontics'
	,'Psychiatry':'Psychiatry'
	,'Psychology':'Psychology'
	,'Public Health':'Public Health'
	,'Public Administration':'Public Administration'
	,'Public Policy':'Public Policy'
	,'Public Relations':'Public Relations'
	,'Pulmonology':'Pulmonology'
	,'Quality Assurance Engineering':'Quality Assurance Engineering'
	,'Radio':'Radio'
	,'Radiography':'Radiography'
	,'Radiology':'Radiology'
	,'Reading Education':'Reading Education'
	,'Recreation Ecology':'Recreation Ecology'
	,'Recreation Therapy':'Recreation Therapy'
	,'Rehabilitation Medicine':'Rehabilitation Medicine'
	,'Religious Education':'Religious Education'
	,'Religious Education Techniques':'Religious Education Techniques'
	,'Respiratory Care':'Respiratory Care'
	,'Respiratory Medicine':'Respiratory Medicine'
	,'Respiratory Therapy':'Respiratory Therapy'
	,'Rheumatology':'Rheumatology'
	,'Sacramental Theology':'Sacramental Theology'
	,'Sacred Music':'Sacred Music'
	,'Safety Engineering':'Safety Engineering'
	,'School Social Work':'School Social Work'
	,'Science Education':'Science Education'
	,'Engineering And Mathematics (Stem)':'Engineering And Mathematics (Stem)'
	,'Second Major Certificate':'Second Major Certificate'
	,'Secondary Education':'Secondary Education'
	,'Sex Education':'Sex Education'
	,'Sexology':'Sexology'
	,'Shoulder Surgery':'Shoulder Surgery'
	,'Silviculture':'Silviculture'
	,'Sleep Medicine':'Sleep Medicine'
	,'Small Business/Entrepreneurship':'Small Business/Entrepreneurship'
	,'Social Studies':'Social Studies'
	,'Social Work':'Social Work'
	,'Social Policy':'Social Policy'
	,'Sociology':'Sociology'
	,'Sociology Of Education':'Sociology Of Education'
	,'Sociology Of Sport':'Sociology Of Sport'
	,'Software Engineering':'Software Engineering'
	,'Sonography':'Sonography'
	,'Spanish':'Spanish'
	,'Special Education':'Special Education'
	,'Speech And Language Pathology':'Speech And Language Pathology'
	,'Speech Communication':'Speech Communication'
	,'Sport Management':'Sport Management'
	,'Sport Psychology':'Sport Psychology'
	,'Sports Coaching':'Sports Coaching'
	,'Sports Journalism/Sportscasting':'Sports Journalism/Sportscasting'
	,'Sports Medicine':'Sports Medicine'
	,'Strategy':'Strategy'
	,'Structural Engineering':'Structural Engineering'
	,'Studio Art':'Studio Art'
	,'Surgery':'Surgery'
	,'Sustainability Studies':'Sustainability Studies'
	,'Sustainable Development':'Sustainable Development'
	,'Systematic Theology':'Systematic Theology'
	,'Systems Engineering':'Systems Engineering'
	,'Tactics':'Tactics'
	,'Tax Law':'Tax Law'
	,'Technical Writing':'Technical Writing'
	,'Technology Education':'Technology Education'
	,'Telecommunications Engineering':'Telecommunications Engineering'
	,'Television':'Television'
	,'Television Studies':'Television Studies'
	,'Textiles':'Textiles'
	,'The Digital Humanities (Humanities Computing)':'The Digital Humanities (Humanities Computing)'
	,'Theology':'Theology'
	,'Tort Law':'Tort Law'
	,'Toxicology':'Toxicology'
	,'Toy And Amusement Design':'Toy And Amusement Design'
	,'Trade Policy':'Trade Policy'
	,'Translation':'Translation'
	,'Transportation Engineering':'Transportation Engineering'
	,'Traumatology':'Traumatology'
	,'Urology':'Urology'
	,'Vehicle Engineering':'Vehicle Engineering'
	,'Veterinary Medicine':'Veterinary Medicine'
	,'Vocational Education':'Vocational Education'
	,'Weapons Systems':'Weapons Systems'
	,'Web Engineering':'Web Engineering'
	,'Wildlife Management':'Wildlife Management'
	,'Women And International Development':'Women And International Development'
	,'Women`s Studies':'Women`s Studies'}" 
						value="%{majorFieldOfStudy}" emptyOption="true" />
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group">
				<div class="col-md-3 col-xs-6">
					<label class="col-xs-12">Type:</label>
					<s:select name="trainingType" emptyOption="true" cssClass="form-control" 
					list="#{ 'Graduate' : 'Graduate Trainee', 'Group':'Group', 'Internship':'Internship', 'Sabbatical':'Sabbatical' }"
					value="%{trainingType}" />
				</div>
				
				<div class="col-md-3 col-xs-6">
					<label class="col-xs-12">Degree:</label>
					<s:select cssClass="form-control" emptyOption="true"
					list="#{'MSc.':'Master of Science','PhD':'Doctor of Philosopy'}"
						name="degree" value="%{degree}" />
				</div>
					
				<div class="col-md-6 col-xs-6">
					<label class="col-xs-12">Nationality:</label>
					<s:select cssClass="form-control" emptyOption="true" value="%{nationality}" name="nationality" 
			        list="#{'Afghanistan':'Afghanistan','�land Islands':'�land Islands','Albania':'Albania','Algeria':'Algeria','American Samoa':'American Samoa','Andorra':'Andorra','Angola':'Angola','Anguilla':'Anguilla','Antigua and Barbuda':'Antigua and Barbuda','Argentina':'Argentina','Armenia':'Armenia','Aruba':'Aruba','Australia':'Australia','Austria':'Austria','Azerbaijan':'Azerbaijan','Bahamas':'Bahamas','Bahrain':'Bahrain','Bangladesh':'Bangladesh','Barbados':'Barbados','Belarus':'Belarus','Belgium':'Belgium','Belize':'Belize','Benin':'Benin','Bermuda':'Bermuda','Bhutan':'Bhutan','Bolivia (Plurinational State of)':'Bolivia (Plurinational State of)','Bonaire, Saint Eustatius and Saba':'Bonaire, Saint Eustatius and Saba','Bosnia and Herzegovina':'Bosnia and Herzegovina','Botswana':'Botswana','Brazil':'Brazil','British Virgin Islands':'British Virgin Islands','Brunei Darussalam':'Brunei Darussalam','Bulgaria':'Bulgaria','Burkina Faso':'Burkina Faso','Burundi':'Burundi','Cabo Verde':'Cabo Verde','Cambodia':'Cambodia','Cameroon':'Cameroon','Canada':'Canada','Cayman Islands':'Cayman Islands','Central African Republic':'Central African Republic','Chad':'Chad','Channel Islands':'Channel Islands','Chile':'Chile','China':'China','China,  Hong Kong Special Administrative Region':'China,  Hong Kong Special Administrative Region','China, Macao Special Administrative Region':'China, Macao Special Administrative Region','Colombia':'Colombia','Comoros':'Comoros','Congo':'Congo','Cook Islands':'Cook Islands','Costa Rica':'Costa Rica','C�te d`Ivoire':'C�te d`Ivoire','Croatia':'Croatia','Cuba':'Cuba','Cura�ao':'Cura�ao','Cyprus':'Cyprus','Czech Republic':'Czech Republic','Democratic People`s Republic of Korea':'Democratic People`s Republic of Korea','Democratic Republic of the Congo':'Democratic Republic of the Congo','Denmark':'Denmark','Djibouti':'Djibouti','Dominica':'Dominica','Dominican Republic':'Dominican Republic','Ecuador':'Ecuador','Egypt':'Egypt','El Salvador':'El Salvador','Equatorial Guinea':'Equatorial Guinea','Eritrea':'Eritrea','Estonia':'Estonia','Ethiopia':'Ethiopia','Faeroe Islands':'Faeroe Islands','Falkland Islands (Malvinas)':'Falkland Islands (Malvinas)','Fiji':'Fiji','Finland':'Finland','France':'France','French Guiana':'French Guiana','French Polynesia':'French Polynesia','Gabon':'Gabon','Gambia':'Gambia','Georgia':'Georgia','Germany':'Germany','Ghana':'Ghana','Gibraltar':'Gibraltar','Greece':'Greece','Greenland':'Greenland','Grenada':'Grenada','Guadeloupe':'Guadeloupe','Guam':'Guam','Guatemala':'Guatemala','Guernsey':'Guernsey','Guinea':'Guinea','Guinea-Bissau':'Guinea-Bissau','Guyana':'Guyana','Haiti':'Haiti','Holy See':'Holy See','Honduras':'Honduras','Hungary':'Hungary','Iceland':'Iceland','India':'India','Indonesia':'Indonesia','Iran (Islamic Republic of)':'Iran (Islamic Republic of)','Iraq':'Iraq','Ireland':'Ireland','Isle of Man':'Isle of Man','Israel':'Israel','Italy':'Italy','Jamaica':'Jamaica','Japan':'Japan','Jersey':'Jersey','Jordan':'Jordan','Kazakhstan':'Kazakhstan','Kenya':'Kenya','Kiribati':'Kiribati','Kuwait':'Kuwait','Kyrgyzstan':'Kyrgyzstan','Lao People`s Democratic Republic':'Lao People`s Democratic Republic','Latvia':'Latvia','Lebanon':'Lebanon','Lesotho':'Lesotho','Liberia':'Liberia','Libya':'Libya','Liechtenstein':'Liechtenstein','Lithuania':'Lithuania','Luxembourg':'Luxembourg','Madagascar':'Madagascar','Malawi':'Malawi','Malaysia':'Malaysia','Maldives':'Maldives','Mali':'Mali','Malta':'Malta','Marshall Islands':'Marshall Islands','Martinique':'Martinique','Mauritania':'Mauritania','Mauritius':'Mauritius','Mayotte':'Mayotte','Mexico':'Mexico','Micronesia (Federated States of)':'Micronesia (Federated States of)','Monaco':'Monaco','Mongolia':'Mongolia','Montenegro':'Montenegro','Montserrat':'Montserrat','Morocco':'Morocco','Mozambique':'Mozambique','Myanmar':'Myanmar','Namibia':'Namibia','Nauru':'Nauru','Nepal':'Nepal','Netherlands':'Netherlands','New Caledonia':'New Caledonia','New Zealand':'New Zealand','Nicaragua':'Nicaragua','Niger':'Niger','Nigeria':'Nigeria','Niue':'Niue','Norfolk Island':'Norfolk Island','Northern Mariana Islands':'Northern Mariana Islands','Norway':'Norway','Oman':'Oman','Pakistan':'Pakistan','Palau':'Palau','Panama':'Panama','Papua New Guinea':'Papua New Guinea','Paraguay':'Paraguay','Peru':'Peru','Philippines':'Philippines','Pitcairn':'Pitcairn','Poland':'Poland','Portugal':'Portugal','Puerto Rico':'Puerto Rico','Qatar':'Qatar','Republic of Korea':'Republic of Korea','Republic of Moldova':'Republic of Moldova','R�union':'R�union','Romania':'Romania','Russian Federation':'Russian Federation','Rwanda':'Rwanda','Saint-Barth�lemy':'Saint-Barth�lemy','Saint Helena':'Saint Helena','Saint Kitts and Nevis':'Saint Kitts and Nevis','Saint Lucia':'Saint Lucia','Saint-Martin (French part)':'Saint-Martin (French part)','Saint Pierre and Miquelon':'Saint Pierre and Miquelon','Saint Vincent and the Grenadines':'Saint Vincent and the Grenadines','Samoa':'Samoa','San Marino':'San Marino','Sao Tome and Principe':'Sao Tome and Principe','Sark':'Sark','Saudi Arabia':'Saudi Arabia','Senegal':'Senegal','Serbia':'Serbia','Seychelles':'Seychelles','Sierra Leone':'Sierra Leone','Singapore':'Singapore','Sint Maarten (Dutch part)':'Sint Maarten (Dutch part)','Slovakia':'Slovakia','Slovenia':'Slovenia','Solomon Islands':'Solomon Islands','Somalia':'Somalia','South Africa':'South Africa','South Sudan':'South Sudan','Spain':'Spain','Sri Lanka':'Sri Lanka','State of Palestine':'State of Palestine','Sudan':'Sudan','Suriname':'Suriname','Svalbard and Jan Mayen Islands':'Svalbard and Jan Mayen Islands','Swaziland':'Swaziland','Sweden':'Sweden','Switzerland':'Switzerland','Syrian Arab Republic':'Syrian Arab Republic','Tajikistan':'Tajikistan','Thailand':'Thailand','The former Yugoslav Republic of Macedonia':'The former Yugoslav Republic of Macedonia','Timor-Leste':'Timor-Leste','Togo':'Togo','Tokelau':'Tokelau','Tonga':'Tonga','Trinidad and Tobago':'Trinidad and Tobago','Tunisia':'Tunisia','Turkey':'Turkey','Turkmenistan':'Turkmenistan','Turks and Caicos Islands':'Turks and Caicos Islands','Tuvalu':'Tuvalu','Uganda':'Uganda','Ukraine':'Ukraine','United Arab Emirates':'United Arab Emirates','United Kingdom of Great Britain and Northern Ireland':'United Kingdom of Great Britain and Northern Ireland','United Republic of Tanzania':'United Republic of Tanzania','United States of America':'United States of America','United States Virgin Islands':'United States Virgin Islands','Uruguay':'Uruguay','Uzbekistan':'Uzbekistan','Vanuatu':'Vanuatu','Venezuela (Bolivarian Republic of)':'Venezuela (Bolivarian Republic of)','Viet Nam':'Viet Nam','Wallis and Futuna Islands':'Wallis and Futuna Islands','Western Sahara':'Western Sahara','Yemen':'Yemen','Zambia':'Zambia','Zimbabwe':'Zimbabwe'}"
			 />
			 	</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group">
			 	<div class="col-md-6 col-xs-6">
					<div class="col-md-3 col-xs-3">
						<label class="col-xs-12">Submission From:</label>
						<iita:datepicker cssClass="form-control" name="fromDate" value="%{fromDate}" format="dd/MM/yyyy" />
					</div>
					
					<div class="col-md-3 col-xs-3">
						<label class="col-xs-12">To:</label>
						<iita:datepicker cssClass="form-control" name="toDate" value="%{toDate}" format="dd/MM/yyyy" />
					</div>
				</div>
				
				<div class="col-md-6 col-xs-6">					
					<div class="col-md-3 col-xs-3">
						<label class="col-xs-12">DoB From:</label>
						<iita:datepicker cssClass="form-control" name="dobFromDate" value="%{dobFromDate}" format="dd/MM/yyyy" />
					</div>
					
					<div class="col-md-3 col-xs-3">
						<label class="col-xs-12">To:</label>
						<iita:datepicker cssClass="form-control" name="dobToDate" value="%{dobToDate}" format="dd/MM/yyyy" />
					</div>
					
					<div class="col-md-12 col-xs-6">
						<label class="col-xs-12">&nbsp;</label>
						<s:submit cssClass="btn btn-primary" value="Search" /> 
						<s:submit cssClass="btn btn-info" value="Export to Excel" action="search-applications!export" />
					</div>	
				</div>						
			</div>
		</div>
	</s:form>

</div>

<div class="container">
    <section class="col-xs-12 col-sm-6 col-md-12">
    	<s:if test="paged!=null && paged.pageSize>0">
			<s:push value="paged">
				<hgroup class="mb20">
					<h1>Search Results</h1>
					<h2 class="lead">
						<s:include value="/WEB-INF/jsp/paging.jsp">
							<s:param name="href" value="%{'details=' + details + '&fromDate=' + fromDate + '&toDate=' + toDate
						 + '&dobFromDate=' + dobFromDate + '&dobToDate=' + dobToDate
						  + '&majorFieldOfStudy=' + majorFieldOfStudy + '&trainingType=' + trainingType
						  + '&nationality=' + nationality + '&degree=' + degree}" />
						</s:include>
					</h2>
				</hgroup>
			</s:push>
		
			<s:iterator value="paged.results">
				<s:if test="top instanceof org.iita.trainingunit.applications.model.Application">
					<s:include value="/WEB-INF/jsp/application/small-new.jsp" />
				</s:if>
				<s:else>
					<s:property value="top" /> <s:property value="top.class" />
				</s:else>
			</s:iterator>
		</s:if>
	</section>
</div>
</body>
</html>
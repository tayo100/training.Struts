<%@ include file="/common/taglibs.jsp"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>

<html>
<head>
<title>Scientists Training Proposal Form</title>
</head>
<body>
	<div class="button-bar">
		<a href="<s:url action="trainingproposal" />">Training Proposal</a>
	</div>
	<table style="width: 100%">
		<colgroup>
			<col />
			<s:if test="trainingProposal.id!=null">
				<col width="30%" />
			</s:if>
		</colgroup>
		<tbody>
		<tr>
			<td style="vertical-align: top; padding-right: 30px">
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
						<td>Appraiser:</td>
						<td><s:hidden name="appraiser" /><s:textfield id="ac_appraiser" value="" /></td>
					</tr>
					<tr>
						<td>Appraisee:</td>
						<td><s:hidden name="appraisee" /><s:textfield id="ac_appraisee" value="" /></td>
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
						,'Other':'Other'
						}" value="%{trainingProposal.type}" emptyOption="true" /></td>
					</tr>
					<tr>
						<td>Title:*</td>
						<td><s:hidden name="relatedtitle" /><s:textfield id="tptitle" value="" />
						<div id="divRelated"></div>
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
						<td>Unit:</td>
						<td><s:textfield name="trainingProposal.unit"
								value="%{trainingProposal.unit}" />
						</td>
					</tr>
					
				</table>
			
				<div class="button-bar" style="margin: 10px 0px 0px 250px;">
					<s:submit value="Save Proposal" /> <s:submit action="submit-proposal" onclick="javascript:return confirm('Submit this proposal anyway?');" value="Submit proposal" />	
				</div>
			</s:form>
			<script type="text/javascript">
							function makeAutocomplete(ac, valuefield, url, paramName) {
								// inject div
								var div=$(document.createElement("DIV"));
								div.addClassName("autocomplete");
								div.setAttribute("style", "display:none;");
								ac.parentNode.insertBefore(div, ac);
								new Ajax.Autocompleter(ac, div, url, {paramName:paramName,minChars:3,afterUpdateElement:function(text, li) { 
										text.value=li.innerHTML; valuefield.value=li.getAttribute('ajaxvalue'); 
									}});
							}
							makeAutocomplete($('tptitle'), $('save-proposal_relatedtitle'), '<s:url namespace="/projectajax" action="relatedtp" />', 'lookup');
							makeAutocomplete($('ac_appraiser'), $('save-proposal_appraiser'), '<s:url namespace="/projectajax" action="user" />', 'lookup');
							makeAutocomplete($('ac_appraisee'), $('save-proposal_appraisee'), '<s:url namespace="/projectajax" action="user" />', 'lookup');
						</script>
		</td>
		<s:if test="trainingProposal.id!=null">
			<td style="vertical-align: top;">
				<h2>Training Materials</h2>
				<s:if test="trainingProposal.documents!=null">
					<ul class="file-list">
						<s:iterator value="trainingProposal.documents">
							<li class="file"><s:include value="/WEB-INF/jsp/document/entitydocument-trainingproposal-quick.jsp" /></li>
						</s:iterator>
					</ul>
				</s:if> 
				<iita:authorize ifAnyGranted="ROLE_USER,ROLE_CRM">
					<p>Attach document/material:</p>
					<s:if test="trainingProposal.status==@org.iita.trainingunit.announcements.model.TrainingProposal$STATUS@DRAFT">
						<iita:fileupload action="trainingproposaledit-document!upload"
						value="Upload files" queryParams="entityId=${trainingProposal.id}" />
					</s:if>
				</iita:authorize>
								
				<!-- Conversion to announcement -->
				<iita:authorize ifAnyGranted="ROLE_CRM">
					<s:if test="trainingProposal.status==@org.iita.trainingunit.announcements.model.TrainingProposal$STATUS@SUBMITTED && 
					trainingProposal.announcement==null">
						<s:form action="convert-proposal" method="post">
							<s:hidden name="id" value="%{trainingProposal.id}" />
							<s:textarea name="comments" value="%{comment}" />
							<button class="button-success pure-button button-xlarge">
							    <i class="fa fa-cog"></i>
							    Approve?
							</button>
							<button class="button-success pure-button button-xlarge">
							    <i class="fa fa-cog"></i>
							    Reject?
							</button>
						</s:form>
					</s:if>
					<s:elseif test="trainingProposal.status==@org.iita.trainingunit.announcements.model.TrainingProposal$STATUS@SUBMITTED && 
					trainingProposal.announcement!=null">
					<button class="pure-button pure-button-disabled button-warning button-xlarge">Training Proposal Announced!</button>
					</s:elseif>
				</iita:authorize>
			</td>
		</s:if>
	</tr>
	</tbody>
	</table>
</body>
</html>
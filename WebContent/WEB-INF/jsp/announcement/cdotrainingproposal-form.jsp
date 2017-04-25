<%@ include file="/common/taglibs.jsp"%>


<html>
<head>
<title>Scientists Training Proposal Form</title>
<script type='text/javascript' src='/training/script/jquery-1.11.1.min.js'></script>

<script type="text/javascript">
jQuery.noConflict();
jQuery( function($) {
	$(document).ready(function() {
	    // page is now ready, initialize the calendar...
	    $("#tptitle").keypress(function(){
	    	if($("#tptitle").val().length>2){
	    		var lkup = $('#tptitle').val();
				var qryAllEvents = "/training/relatedajax/relatedTrainingProposal.jspx";
				$("#divRelated").html().empty();
				$("#divRelated").css({"display":"none"});
				$.getJSON(qryAllEvents,{title:lkup}, function(data) {
					var subTitle = "<h4>Related training proposals</h4>";
		            itemsHtml = "<ul>";
		            var counter = 0;
		            $.each(data, function() {
		            	if(this.id!="undefined" && this.status=="SUBMITTED"){//
		            		counter++;
			                itemsHtml += "<li><a href='trainingproposal-details.jspx?id=" + this.id + "' target='_blank'>" + this.title + " (" + this.status + ")</a></li>";
		            	}
		            });
		            itemsHtml += "</ul>";
		            if(counter>0) {
		            	$("#divRelated").html(subTitle + itemsHtml);
		            	$("#divRelated").css({"display":"none","border":"1px solid #808080", "background-color":"#ECFFBF"});
		            	$("#divRelated").slideDown("slow");
		            }
		        });
	    	}else{
	    		$("#divRelated").slideUp("slow");
	    		$("#divRelated").html().empty();
	    		$("#divRelated").css({"display":"none"});
	    	}
		});
	});
});
</script>
<script type="text/javascript" src="<c:url value='/training/script/moment.js'/>"></script>
<script type="text/javascript" src="<c:url value='/training/script/validate.js'/>"></script>
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
			<s:set name="profile" value="trainingProposal" />
				<s:if test="trainingProposal.status!=@org.iita.trainingunit.announcements.model.TrainingProposal$STATUS@SUBMITTED">
					<s:include value="cdotrainingproposal-inline-form.jsp" id="tpform" />
				</s:if>
				<s:else>
					<s:include value="cdotrainingproposal-inline-details.jsp" id="tpform" />
				</s:else>
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
					<s:if test="trainingProposal.status==@org.iita.trainingunit.announcements.model.TrainingProposal$STATUS@DRAFT">
						<p>Attach document/material:</p>
						<iita:fileupload action="trainingproposaledit-document!upload"
						value="Upload files" queryParams="entityId=${trainingProposal.id}" />
					</s:if>
				</iita:authorize>
								
				<!-- Conversion to announcement -->
				<iita:authorize ifAnyGranted="ROLE_CRM">
					<s:if test="trainingProposal.status==@org.iita.trainingunit.announcements.model.TrainingProposal$STATUS@SUBMITTED && 
					trainingProposal.announcement==null">
						<p>
							<h4>Convert to Announcement</h4><br />
							<s:form action="convert-proposal" method="post">
								<s:hidden name="id" value="%{trainingProposal.id}" />								
								Comment:<br />
								<s:textarea name="comments" value="%{comment}" cols="30" rows="3" cssStyle="padding:3px;" /><br />
								<button class="button-success pure-button button-xlarge" onclick="javascript: return confirm('Approve anyway?');">
								    <i class="fa fa-cog"></i>
								    Approve?
								</button>
								<s:submit cssClass="button-error pure-button button-xlarge" onclick="javascript: confirm('Request for ammendment anyway?');" action="reject-proposal" value="Request for Ammendment?" />
							</s:form>
						</p>
					</s:if>
					<s:elseif test="trainingProposal.status==@org.iita.trainingunit.announcements.model.TrainingProposal$STATUS@SUBMITTED && 
					trainingProposal.announcement!=null">
						<button class="pure-button pure-button-disabled button-warning button-xlarge">Training Proposal Announced!</button>
					</s:elseif>
				</iita:authorize>
				
				<s:if test="trainingProposal.actionLog.size()>0">
					<h2 id="action-log">Action log</h2>
					<table class="data-listing">
						<colgroup>
							<col width="95px" />
							<col width="95px" />
							<col width="100px" />
							<col />
						</colgroup>
						<thead>
							<tr>
								<td>Date</td>
								<td class="identifying">Action</td>
								<td>Who</td>
								<td>Comment</td>
							</tr>
						</thead>
						<s:iterator value="trainingProposal.actionLog" status="status">
							<tr>
								<td><s:property value="sysDate" /></td>
								<td class="identifying"><s:property value="action" /></td>
								<td><s:property value="username" /></td>
								<td><s:property value="comment" /></td>
							</tr>
						</s:iterator>
					</table>
				</s:if>
			</td>
		</s:if>
	</tr>
	</tbody>
	</table>
</body>
</html>
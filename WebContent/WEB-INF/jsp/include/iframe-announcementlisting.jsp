<%@ include file="/common/taglibs.jsp"%>

<html>
<head><title>Public Announcement Board</title>

<style media="screen" type="text/css">
a, a:active, a:visited {color: #A64D00 ! important;text-decoration: none;border-bottom: none ! important;line-height:2px;}
ul {ist-style-type: none; padding:0; margin:0;}
div.separator {border-top: 1px dotted #BFBFBF; margin: 5px;padding-bottom:2px;}
.title {margin-top:5px;margin-bottom:7px;padding-bottom:10px;font-weight:bold;font-size:13px;}
ul {list-style-type: none;padding:0;margin:0;}
li {margin-bottom: 1em;margin:5;}
div#unsolicited {margin-top:10px;margin-bottom:10px;padding-bottom:5px;}
</style>

</head>
<body>
	<div>
		<s:form method="post" action="search!details" namespace="/iframe">
			Search: <s:textfield name="ask"/> <s:submit value="Search" />
		</s:form>
	</div>
	<div id="unsolicited">
	 <a href="<s:url namespace='/application' action='usindex' />" target="_blank">Unsolicited applications</a> <br />
	</div>
	<div>		
		<s:if test="iframeAll.size() > 0">
			<span class="title">Click to View Announcements</span><br>
			<table>
				<tr>
					<td>
					<span style="margin: 5px; font-size:11px  ! important; font-family:Arial,Verdana,Helvetica,serif  ! important; font-weight:bold  ! important;">
						<ul>
							<s:iterator value="iframeAll">
									<li>								
											<s:if test="user==null">
												<a target="_blank" href="<s:url namespace="/application" action="fulldetail" />?id=<s:property value="id" />">
											</s:if>
											<s:else>
												<a target="_blank" href="<s:url namespace="/applicant" action="announcementdetail" />?id=<s:property value="id" />">
											</s:else>
											<s:if test="title!=null">
												<s:property value="title" /></a>
												<span style="font-style: italic ! important; font-weight: normal ! important; color: #000000 ! important;">
													<s:if test="deadline!=null">
														<br>Deadline: <s:date format="%{getText('date.format')}" name="deadline" />
													</s:if>
												</span>
											</s:if>
											<s:else>
												Unspecified title
												<s:if test="deadline!=null">
													(Open until - <s:date format="%{getText('date.format')}" name="deadline" />)
												</s:if>
											</s:else>
												</a>
											<div class="separator"></div>					
									</li>
							</s:iterator>
						</ul>
						</span>
					</td>
				</tr>
			</table>
		</s:if>
	
		<s:if test="iframeAll.size()==0">
			<p>No IITA training announcements found. Please check later.</p>
		</s:if>
	</div>
</body>
</html>
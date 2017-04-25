<%@ include file="/common/taglibs.jsp"%>

<div class="note">
	<div class="note-text"><s:property value="text" /></div>
	<div class="note-info"><s:property value="lastUpdatedBy" />, <iita:date name="lastUpdated" format="dd/MM/yyyy" /></div>
</div>
	<div class="note">
	<div class="note-text" id="note_${id}"><s:property value="text" /></div>
	<div class="note-info"><s:property value="lastUpdatedBy" />, <iita:date
		name="lastUpdated" format="dd/MM/yyyy" /></div>
	
	<iita:authorize ifAnyGranted="ROLE_CGO,ROLE_CGOREAD">
		<iita:inlineeditor id="noteeditform" targetId="note_${id}">
			<s:form method="post" action="project/note!update">
				<s:hidden name="note.project" value="%{profile.id}" />
				<s:hidden name="id" value="%{id}" />
				<s:textarea name="note.text" cssClass="sizable-textarea"
					cssStyle="width: 200px;" value="%{text}" />
				<s:submit value="Save" /><s:submit value="Delete" action="project/note!remove" cssClass="button-delete" onclick="javascript: return confirm('Are you sure you want to remove this record?');" />
			</s:form>
		</iita:inlineeditor>
	</iita:authorize>
	<s:elseif test="owner.id==user.id">
		<%-- Is user owner of note? --%>
		<iita:inlineeditor id="noteeditform" targetId="note_${id}">
			<s:form method="post" action="project/note!update">
				<s:hidden name="note.project" value="%{profile.id}" />
				<s:hidden name="id" value="%{id}" />
				<s:textarea name="note.text" cssClass="sizable-textarea"
					cssStyle="width: 200px;" value="%{text}" />
				<s:submit value="Save" /><s:submit value="Delete" action="project/note!remove" cssClass="button-delete" onclick="javascript: return confirm('Are you sure you want to remove this record?');" />
			</s:form>
		</iita:inlineeditor>
	</s:elseif>
	</div>

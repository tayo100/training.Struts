<%@ include file="/common/taglibs.jsp"%>
<s:form method="post" action="tag!update">
	<s:hidden name="id" value="%{id}" /><!-- top.class.simpleName.indexOf('Tag') -->
	<s:hidden name="%{top.class.simpleName.substring(0, top.class.simpleName.indexOf('Tag')).charAt(0).toString().toLowerCase()+top.class.simpleName.substring(1, top.class.simpleName.indexOf('Tag')).toString().toString()}" value="%{entity.id}" />
	<table class="rawform">
		<colgroup>
			<col width="100px" />
			<col />
		</colgroup>
		<tr>
			<td>Tag:</td>
			<td>
			<s:url namespace="/ajax" action="public-ajax" id="xx" /> <iita:autocompleter name="tag.tag" id="%{'tag_tagtag_' + id}"
				displayValue="%{tag}" listKey="this" listValue="this" url="%{xx}" method="autocompleteTag" submitTextTo="tagValue" /></td>
		</tr>
		<tr>
			<td class="ar">Percentage:</td>
			<td><s:textfield name="tag.percentage" value="%{percentage}" cssClass="numeric-input" /></td>
		</tr>
		<tr>
			<td />
			<td><s:if test="id==null"><s:submit value="Add tag" /></s:if><s:else>
				<s:submit value="Update" />
				<s:submit value="Remove" action="tag!remove" cssClass="button-delete" onclick="javascript: return confirm('Are you sure you want to remove this record?');" />
				</s:else>				
			</td>
		</tr>
	</table>
</s:form>
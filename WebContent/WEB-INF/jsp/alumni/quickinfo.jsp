<%@ include file="/common/taglibs.jsp"%>
<div class="quick"><span class="small">
<a href="<s:url action="person/profile"/>?id=<s:property value="person.id" />"><s:property
	value="person.legalName" /></a></span>
<s:if test="supervisor!=null">
<div><strong>Supervisors info</strong><br/>
<s:property	value="supervisor" /></div>
</s:if>
<s:if test="costCenter!=null">
<div><strong>Cost center info</strong><br/>
<s:property	value="costCenter" /></div>
</s:if>
<s:if test="sponsor!=null">
<div><strong>Sponsor info</strong><br/>
<s:property	value="sponsor" /></div>
</s:if>
<s:if test="department!=null">
<div><strong>Department info</strong><br/>
<s:property	value="department" /></div>
</s:if>
</div>
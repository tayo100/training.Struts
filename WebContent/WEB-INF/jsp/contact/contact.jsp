<%@ include file="/common/taglibs.jsp"%>

<s:if test="top instanceof org.iita.crm.model.AddressContact">
	<%@include file="address.jsp" %>
</s:if>
<s:elseif test="top instanceof org.iita.crm.model.EmailContact">
	<%@include file="email.jsp" %>
</s:elseif>
<s:elseif test="top instanceof org.iita.crm.model.PhoneContact">
	<%@include file="phone.jsp" %>
</s:elseif>
<s:elseif test="top instanceof org.iita.crm.model.MobileContact">
	<%@include file="mobile.jsp" %>
</s:elseif>
<s:elseif test="top instanceof org.iita.crm.model.FaxContact">
	<%@include file="fax.jsp" %>
</s:elseif>
<s:elseif test="top instanceof org.iita.crm.model.RssContact">
	<%@include file="rss.jsp" %>
</s:elseif>
<s:elseif test="top instanceof org.iita.crm.model.SkypeimContact">
	<%@include file="skypeim.jsp" %>
</s:elseif>

<s:elseif test="top instanceof org.iita.crm.model.WebsiteContact">
	<%@include file="website.jsp" %>
</s:elseif>
<s:elseif test="top instanceof org.iita.promis.model.BankAccountContact">
	<%@include file="bankaccount.jsp" %>
</s:elseif>
<s:else>
	<p>Unhandled contact type <s:property value="top.class" /></p>
</s:else>
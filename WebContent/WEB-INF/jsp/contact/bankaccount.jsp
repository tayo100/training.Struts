<%@ include file="/common/taglibs.jsp"%>

<div id="bankacc_${id}" class="contact bankaccount <s:if test="!active">inactive</s:if>">
<s:if test="bankName!=null"><div><s:property value="bankName" /></div></s:if>
<s:if test="bankAddress!=null"><div><s:property value="bankAddress" /></div></s:if>
<s:if test="accountName!=null"><div><s:property value="accountName" /></div></s:if>
<s:if test="accountNumber!=null"><div><s:property value="accountNumber" /></div></s:if>
<s:if test="swift!=null"><div><s:property value="swift" /></div></s:if>
<s:if test="iban!=null"><div><s:property value="iban" /></div></s:if>
<s:if test="notes!=null"><div><s:property value="notes" /></div></s:if>
<%--
<s:if test="latitude!=null && longitude!=null">
<script src="http://maps.google.com/maps?file=api&amp;v=2&amp;sensor=false&amp;key=ABQIAAAA6SPOQ9Bd95WFl0M2_MbbSBRN3akhAGL9hmvx4-AtMDkjp7ht8hRj6_uAYw1PmBTr8bjp3GGyMhD1ew" type="text/javascript"></script>
<script type="text/javascript">
var address_gmap${id} = new GMap2($("address_gmap${id}"));
address_gmap${id}.setCenter(new GLatLng(${latitude}, ${longitude}), 12);
address_gmap${id}.addOverlay(new GMarker(new GLatLng(${latitude}, ${longitude}), { title: "Location", draggable: true }));
address_gmap${id}.setUIToDefault();
address_gmap${id}.setMapType(G_HYBRID_MAP);
</script>
</s:if>
--%>
</div>
<iita:authorize ifAnyGranted="ROLE_CRM">
<iita:inlineeditor id="bankingForm" targetId="bankacc_${id}">
	<s:include value="bankaccount-inlineform.jsp" />
</iita:inlineeditor>
</iita:authorize>
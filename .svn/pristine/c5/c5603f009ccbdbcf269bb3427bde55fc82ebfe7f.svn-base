<%@ include file="/common/taglibs.jsp"%>

<div id="address_${id}" class="contact address <s:if test="!active">inactive</s:if>">
<div><s:property value="attn" /></div>
<div><s:property value="address" /></div>
<div><s:property value="city" /></div>
<div><s:property value="longitude" /></div>
<div><s:property value="latitude" /></div>
<div><s:property value="state" /></div>
<div><s:property value="postalAddress" /></div>
<div><s:property value="country" /></div>
<div><s:property value="Continent" /></div>
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
<iita:inlineeditor id="addressForm" targetId="address_${id}">
	<s:include value="address-inlineform.jsp" />
</iita:inlineeditor>
</iita:authorize>
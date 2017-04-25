<%@ include file="/common/taglibs.jsp"%>
<s:form action="contact!updateContact" method="post">
	<s:hidden name="id" value="%{id}" />
	<s:hidden name="partnerId" value="%{profile.id}" />
	<table class="rawform">
		<colgroup>
			<col width="50" />
			<col />
		</colgroup>
		<tr>
			<td>Attn:</td>
			<td><s:textfield name="contact.attn" value="%{attn}" /></td>
		</tr>
		<tr>
			<td>Address:</td>
			<td><s:textarea id="contact_address" name="contact.address" value="%{address}" /></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><s:textfield id="contact_city" name="contact.city" value="%{city}" /></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><s:textfield name="contact.state" value="%{state}" /></td>
		</tr>
		<tr>
			<td>Country:</td>
			<td><s:textfield id="contact_country" name="contact.country" value="%{country}" /></td>
		</tr>
		<tr>
			<td>Continent:</td>
			<td><s:textfield id="contact_continent" name="contact.continent" value="%{continent}" /></td>
		</tr>
		<tr>
			<td>Postal Address:</td>
			<td><s:textfield id="contact_postaladdress" name="contact.postalAddress" value="%{postalAddress}" /></td>
		</tr>
		<tr>
			<td>GeoRef:</td>
			<td>
				<s:textfield id="contact_lat" name="contact.latitude" value="%{latitude}" cssClass="numeric-input" /> <s:textfield id="contact_lng" name="contact.longitude" value="%{longitude}" cssClass="numeric-input" />
				<%--
				<input type="button" value="Lookup" onClick="javascript: find()" />
				<div>
					<div id="address_gmap${id}" style="width: 100%; height: 300px"></div>
				</div>
				--%>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" class="ar"><s:submit value="Update" /> <s:submit value="Delete" action="contact!remove" cssClass="button-delete" onclick="javascript: return confirm('Are you sure you want to remove this record?');" /></td>
		</tr>
	</table>
</s:form>
 <%--
<script src="http://maps.google.com/maps?file=api&amp;v=2&amp;sensor=false&amp;key=ABQIAAAA6SPOQ9Bd95WFl0M2_MbbSBRN3akhAGL9hmvx4-AtMDkjp7ht8hRj6_uAYw1PmBTr8bjp3GGyMhD1ew" type="text/javascript"></script>
<script type="text/javascript">
var address_gmap${id} = new GMap2($("address_gmap${id}"));
<s:if test="contact.latitude!=null && contact.longitude!=null">
address_gmap${id}.setCenter(new GLatLng(${contact.latitude}, ${contact.longitude}), 12);
</s:if>
address_gmap${id}.setUIToDefault();
address_gmap${id}.setMapType(G_HYBRID_MAP);

function find() {
	if (IITA.geoc==null) IITA.geoc=new GClientGeocoder();
	var addr=$("contact_address").value + " " + $("contact_city").value + " " + $("contact_country").value;
	IITA.geoc.getLatLng(addr, function(loc) {
		if (loc!=null) {
			address_gmap${id}.setCenter(loc, 16);
			var marker=address_gmap${id}.marker;
			if (marker==null) {
				marker=address_gmap${id}.marker=new GMarker(loc, { title: "Dragme", draggable: true });
				GEvent.addListener(marker, "drag", function(loc) { $("contact_lat").value=loc.lat(); $("contact_lng").value=loc.lng(); });
				address_gmap${id}.addOverlay(marker);
			} 				
			$("contact_lat").value=loc.lat();
			$("contact_lng").value=loc.lng();
		}
	});		
}
</script>
 --%>
<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<title>Administrator Dashboard</title>
</head>
<body>
<h2>Tools</h2>
<p><a href="<s:url action="schedule/index" />">Scheduled jobs</a></p>
<p><a href="<s:url action="lucene/reindex" />">Lucene reindex</a></p>
<p><a href="<s:url action="applock" />">Block access to application</a></p>
<p><a href="<s:url action="java-status" />">JRE status</a></p>

<%--
<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000"
        codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0"
        width="760" height="300" id="graph-2">
 
	<param name="allowScriptAccess" value="sameDomain" />
	<param name="movie" value="<c:url value="/img/open-flash-chart.swf" />" />
	<param name="quality" value="high" />
	<param name="flashvars" value="get-data=test&id=one" />
	<embed src="<c:url value="/img/open-flash-chart.swf" />"
		   quality="high"
		   bgcolor="#FFFFFF"
		   width="760"
		   height="300"
		   name="open-flash-chart"
		   align="middle"
		   allowScriptAccess="sameDomain"
		   flashvars="get-data=test&id=one"
		   type="application/x-shockwave-flash"
		   pluginspage="http://www.macromedia.com/go/getflashplayer" />
</object>
<script type="text/javascript">
function test(id) {
	//alert("get-data(" + id +")");
	
	
	var chart = {
			elements : [ {
				      type: "bar_filled",
				      values: [ 9, 8, 7, 6, 5, 4, 3, 2, 1 ]
				    }, {
					      type: "bar_filled",
					      values: [ 1, 2,3, 4, 5, 6, 9, 8, { top: 5, colour: "#d0a0e0", tip: "Hello #val#" } ], 
					      colour: "#fe3666",
					      tip: "I'm here #val#",
					      "on-click": "tester"
					    },
					    {
						      type: "bar_filled",
						      values: [ 5, 3, 1, 6, 3, 6, 8, 5, 9 ], 
						      colour: "Yellow"
						    }
			],
			title : {
				text : "Matija rulez",
				style: "{font-weight: bold; font-family: Tahoma; font-size: 20px;margin-bottom: 10px}"
			},
			x_axis: { colour: "#000000", labels: { labels: [ "a", "b", "c", "d", "4", "5", "6" ] }, steps: 0, stroke: 0, "grid-colour": "#D7E4A3"},
			y_axis: { min: 0, colour: "#000000" },
			bg_colour: "#ffffff",
			x_legend: { text: "1983 to 2008", style: "{font-size: 20px; color: #000000}" }
		};
		//alert(Object.toJSON(chart));
		return Object.toJSON(chart);
	}

function tester(a, b) {
	alert(a + " " + b);
}
</script>
--%>
<h2>Session</h2>
<p>Session timeout: <b>${pageContext.session.maxInactiveInterval} seconds</b></p>
<h2>Server locale and time zone settings</h2>
<p>Locale: <b><s:property value="@java.util.Locale@getDefault()" /></b></p>
<p>Timezone: <b><s:property value="@java.util.TimeZone@getDefault()" /></b></p>
<h2>User locale and time zone</h2>
<p>Locale: <b><s:property value="getLocale()" /></b></p>

</body>
</html>
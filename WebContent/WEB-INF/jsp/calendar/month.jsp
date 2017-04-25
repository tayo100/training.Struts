<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<title>Calendar <s:date name="dateFrom.time" format="dd/MM/yyyy" /> - <s:date name="dateTo.time" format="dd/MM/yyyy" /></title>
</head>
<body>
<%--<s:form method="get" action="calendar">
	<iita:datepicker name="dateFrom.time" value="%{dateFrom}" format="dd/MM/yyyy" />
	<iita:datepicker name="dateTo.time" value="%{dateTo}" format="dd/MM/yyyy" />
	<s:submit value="Show" />
</s:form>--%>
<a href="<s:url action="calendar" />?dateFrom=<s:date name="prevMonth(dateFrom).time" format="dd/MM/yyyy" />">Previous month</a>
<a href="<s:url action="calendar" />?dateFrom=<s:date name="nextMonth(dateFrom).time" format="dd/MM/yyyy" />">Next month</a>

<h1>Trainees active <s:date name="dateFrom.time" format="dd/MM/yyyy" /> - <s:date name="dateTo.time" format="dd/MM/yyyy" /></h1>
<s:if test="trainees && trainees.size>0">
	<ul>
		<s:iterator value="trainees">
			<li><s:include value="/WEB-INF/jsp/trainee/quickinfo-other.jsp" /></li>
		</s:iterator>
	</ul>
</s:if>
<s:else><div class="errorMessage">No trainees in selected time period</div></s:else>

<h1>Training programs active <s:date name="dateFrom.time" format="dd/MM/yyyy" /> - <s:date name="dateTo.time" format="dd/MM/yyyy" /></h1>
<s:if test="programs && programs.size>0">
	<ul>
		<s:iterator value="programs">
			<li><s:include value="/WEB-INF/jsp/program/quickinfo.jsp" /></li>
		</s:iterator>
	</ul>
</s:if>
<s:else><div class="errorMessage">No training programs in selected time period</div></s:else>


</body>
</html>
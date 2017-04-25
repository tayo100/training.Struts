<%@ include file="/common/taglibs.jsp"%>
<s:if test="%{top instanceof org.iita.util.PagedResult}">
	<div style="margin: 0px 0px 2em; text-align: center;"><s:text
		name="search.paging.title" />: <c:if test="${page>10}">
		<a
			href="?${param.href}&table=${param.table}&startDate=${param.startDate}&endDate=${param.endDate}&text=${param.text}&origin=${param.origin}&sDate=${param.sDate}&eDate=${param.eDate}&operands=${param.operands}&selectedType=${param.selectedType}&trainers=${param.selTrainers}&crps=${param.crps}&hubs=${param.hubs}&coreCompetencies=${param.coreCompetencies}&sponsors=${param.sponsors}&fullText=${param.fullText}&groupYearly=${param.groupYearly}&cc=${param.cc}"
			style="color: Blue; font-weight: bold;"><s:text
			name="search.paging.first" /></a>
	</c:if><c:if test="${page>1}">
		<a
			href="?startAt=${(page-2)*pageSize}&${param.href}&table=${param.table}&startDate=${param.startDate}&endDate=${param.endDate}&text=${param.text}&origin=${param.origin}&sDate=${param.sDate}&eDate=${param.eDate}&operands=${param.operands}&selectedType=${param.selectedType}&trainers=${param.selTrainers}&crps=${param.crps}&hubs=${param.hubs}&coreCompetencies=${param.coreCompetencies}&sponsors=${param.sponsors}&fullText=${param.fullText}&groupYealry=${param.groupYearly}&cc=${param.cc}"
			style="color: Blue; font-weight: bold;"><s:text
			name="search.paging.previous" /></a>
	</c:if> <c:forEach var="i" begin="${page>10 ? page-10 : 1}"
		end="${pages-page>10 ? page+9 : pages}"> 
		<a
			href="?startAt=<c:out value="${(i-1)*pageSize}" />&${param.href}&table=${param.table}&startDate=${param.startDate}&endDate=${param.endDate}&text=${param.text}&origin=${param.origin}&sDate=${param.sDate}&eDate=${param.eDate}&operands=${param.operands}&selectedType=${param.selectedType}&trainers=${param.selTrainers}&hubs=${param.crps}&hubs=${param.hubs}&coreCompetencies=${param.coreCompetencies}&sponsors=${param.sponsors}&fullText=${param.fullText}&groupYearly=${param.groupYearly}&cc=${param.cc}"
			<c:if test="${page==i}"> style="color: Red"</c:if>><c:out
			value="${i}" /></a>
	</c:forEach> <c:if test="${0+page<0+pages}">
		<a
			href="?startAt=${(page)*pageSize}&${param.href}&table=${param.table}&startDate=${param.startDate}&endDate=${param.endDate}&text=${param.text}&origin=${param.origin}&sDate=${param.sDate}&eDate=${param.eDate}&operands=${param.operands}&selectedType=${param.selectedType}&trainers=${param.selTrainers}&crps=${param.crps}&hubs=${param.hubs}&coreCompetencies=${param.coreCompetencies}&sponsors=${param.sponsors}&fullText=${param.fullText}&groupYearly=${param.groupYearly}&cc=${param.cc}"
			style="color: Blue; font-weight: bold;"><s:text
			name="search.paging.next" /></a>
	</c:if><c:if test="${0+page<0+pages}">
		<a
			href="?startAt=${(pages-1)*pageSize}&${param.href}&table=${param.table}&startDate=${param.startDate}&endDate=${param.endDate}&text=${param.text}&origin=${param.origin}&sDate=${param.sDate}&eDate=${param.eDate}&operands=${param.operands}&selectedType=${param.selectedType}&trainers=${param.selTrainers}&hubs=${param.crps}&hubs=${param.hubs}&coreCompetencies=${param.coreCompetencies}&sponsors=${param.sponsors}&fullText=${param.fullText}&groupYearly=${param.groupYearly}&cc=${param.cc}"
			style="color: Blue; font-weight: bold;"><s:text
			name="search.paging.last" /></a>
	</c:if> <span style="margin-left: 10px;">Total: <s:property
		value="totalHits" /></span></div>
</s:if>
<s:else>
	<c:if test="${0+param.page <= 0+param.pages}">
		<div style="margin: 0px 0px 2em; text-align: center;"><s:text
			name="search.paging.title" />: <c:if test="${param.page>10}">
			<a
				href="?${param.href}&table=${param.table}&startDate=${param.startDate}&endDate=${param.endDate}&text=${param.text}&origin=${param.origin}&sDate=${param.sDate}&eDate=${param.eDate}&operands=${param.operands}&selectedType=${param.selectedType}&trainers=${param.selTrainers}&hubs=${param.crps}&hubs=${param.hubs}&coreCompetencies=${param.coreCompetencies}&sponsors=${param.sponsors}&fullText=${param.fullText}&groupYearly=${param.groupYearly}&cc=${param.cc}"
				style="color: Blue; font-weight: bold;"><s:text
				name="search.paging.first" /></a>
		</c:if><c:if test="${param.page>1}">
			<a
				href="?startAt=${(param.page-2)*param.pageSize}&${param.href}&table=${param.table}&startDate=${param.startDate}&endDate=${param.endDate}&text=${param.text}&origin=${param.origin}&sDate=${param.sDate}&eDate=${param.eDate}&operands=${param.operands}&selectedType=${param.selectedType}&trainers=${param.selTrainers}&hubs=${param.crps}&hubs=${param.hubs}&coreCompetencies=${param.coreCompetencies}&sponsors=${param.sponsors}&fullText=${param.fullText}&groupYearly=${param.groupYearly}&cc=${param.cc}"
				style="color: Blue; font-weight: bold;"><s:text
				name="search.paging.previous" /></a>
		</c:if> <c:forEach var="i" begin="${param.page>10 ? param.page-10 : 1}"
			end="${param.pages-param.page>10 ? param.page+9 : param.pages}">
			<a
				href="?startAt=<c:out value="${(i-1)*param.pageSize}&table=${param.table}&startDate=${param.startDate}&endDate=${param.endDate}&text=${param.text}&origin=${param.origin}&sDate=${param.sDate}&eDate=${param.eDate}&operands=${param.operands}&selectedType=${param.selectedType}&trainers=${param.selTrainers}&hubs=${param.crps}&hubs=${param.hubs}&coreCompetencies=${param.coreCompetencies}&sponsors=${param.sponsors}&fullText=${param.fullText}&groupYearly=${param.groupYearly}&cc=${param.cc}" />&${param.href}"
				<c:if test="${param.page==i}"> style="color: Red"</c:if>><c:out
				value="${i}" /></a>
		</c:forEach> <c:if test="${0+param.page<0+param.pages}">
			<a
				href="?startAt=${(param.page)*param.pageSize}&${param.href}&table=${param.table}&startDate=${param.startDate}&endDate=${param.endDate}&text=${param.text}&origin=${param.origin}&sDate=${param.sDate}&eDate=${param.eDate}&operands=${param.operands}&selectedType=${param.selectedType}&trainers=${param.selTrainers}&hubs=${param.crps}&hubs=${param.hubs}&coreCompetencies=${param.coreCompetencies}&sponsors=${param.sponsors}&fullText=${param.fullText}&groupYearly=${param.groupYearly}&cc=${param.cc}"
				style="color: Blue; font-weight: bold;"><s:text
				name="search.paging.next" /></a>
		</c:if><c:if test="${0+param.page<0+param.pages}">
			<a
				href="?startAt=${(param.pages-1)*param.pageSize}&${param.href}&table=${param.table}&startDate=${param.startDate}&endDate=${param.endDate}&text=${param.text}&origin=${param.origin}&sDate=${param.sDate}&eDate=${param.eDate}&operands=${param.operands}&selectedType=${param.selectedType}&trainers=${param.selTrainers}&hubs=${param.crps}&hubs=${param.hubs}&coreCompetencies=${param.coreCompetencies}&sponsors=${param.sponsors}&fullText=${param.fullText}&groupYearly=${param.groupYearly}&cc=${param.cc}"
				style="color: Blue; font-weight: bold;"><s:text
				name="search.paging.last" /></a>
		</c:if></div>
	</c:if>
</s:else>
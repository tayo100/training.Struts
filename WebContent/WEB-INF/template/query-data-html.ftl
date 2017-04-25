<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="CONTENT-TYPE" content="text/html; charset=utf-8">
<title>${query.title!'Unnamed query'}</title>
<style type="text/css">
table.data { border-collapse: collapse; border-bottom: solid 2px black; border-top: solid 2px black; }
table.data td { padding: 2px 4px; }
table.data thead td { font-weight: bold; font-size: 12px; border-bottom: solid 1px black; }
table.data tfoot td { font-weight: bold; font-size: 12px; border-top: solid 1px black; }
p { margin: 5px 0 10px 0 };
</style>
</head>
<body>
<h1>${query.title!'Unnamed query'}</h1>
<p>Results of running a system query <b>${query.title!'Unnamed query'}</b> resulted in <b>${results?size} rows</b>.</p>
<#if (paged.pages > 1)>
<p><b>Note:</b> There are ${paged.totalHits} records that match the query, only the first ${paged.pageSize} are included in this email.</p>
</#if>

<#if (paged.totalHits==0)>
	<p><b>No records matching your query.</b></p>
<#else>
	<table class="data" border="1" cellpadding="1">
	<thead>
		<tr>
			<#list query.headings as data><td><b>${data!""}</b></td></#list>
		</tr>
	</thead>
	<tbody>
	<#list results as row>
		<tr>
			<#list row as data><#if data??>
				<td><#if "${data}"?starts_with("http:")><a href="${config['application.url']}${data?substring(5)}">Link</a><#else>${data}</#if></td>
				<#else><td /></#if>
			</#list>
				
		</tr>
	</#list>
	</tbody>
	</table>
</#if>
</body>
</html>
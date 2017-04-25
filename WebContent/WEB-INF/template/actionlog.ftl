<#if ta.actionLog??>

Action log
<#list app.actionLog as log>	- ${log.sysDate?date}: ${log.username} ${log.action}
</#list>
</#if>
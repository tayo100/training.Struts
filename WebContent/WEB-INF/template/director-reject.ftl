
Dear ${application.biodata.owner.firstName} ${application.biodata.owner.lastName}, 

${application.announcement.programDirector.fullName} has rejected your training application request. 
Login to On-line CDO system to view details at http://tomcat1.iita.cgiarad.org/training/

<#if comment??>
Reason/Comment:
${comment}
</#if>

<#include "applicationdata.ftl"><#include "mailfooter.ftl">
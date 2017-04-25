<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="CONTENT-TYPE" content="text/html; charset=utf-8">
<title>${trainingproposal.title!'Unnamed training proposal'}</title>
<style type="text/css">
table.data { border-collapse: collapse; border-bottom: solid 2px black; border-top: solid 2px black; }
table.data td { padding: 2px 4px; }
table.data thead td { font-weight: bold; font-size: 12px; border-bottom: solid 1px black; }
table.data tfoot td { font-weight: bold; font-size: 12px; border-top: solid 1px black; }
p { margin: 5px 0 10px 0 };
</style>
</head>
<body>
<p>Attn: CDO Training Proposal Submission</p> 

<p>Training Proposal submission for ${trainingproposal.title!''} received.</p>

<p>Below is a copy of submitted registration form.</p>

<#include "trainingproposaldata.ftl">

VIEW LINK: <a href="${config['application.url']}/announcement/trainingproposal/profile.jspx?id=${trainingproposal.id}">View details</a>

<#include "mailfooter.ftl">
</body>
</html>
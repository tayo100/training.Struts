<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="CONTENT-TYPE" content="text/html; charset=utf-8">
<title>${announcement.title!'Unnamed announcement'}</title>
<style type="text/css">
table.data { border-collapse: collapse; border-bottom: solid 2px black; border-top: solid 2px black; }
table.data td { padding: 2px 4px; }
table.data thead td { font-weight: bold; font-size: 12px; border-bottom: solid 1px black; }
table.data tfoot td { font-weight: bold; font-size: 12px; border-top: solid 1px black; }
p { margin: 5px 0 10px 0 };
</style>
</head>
<body>
<p>Dear ${applicant.title} ${applicant.lastName}, ${applicant.firstName}, </p>

<p>Thank you for your interest in our training on ${announcement.title} in ${announcement.type}.</p>

<p>Find your user login credentials, which will enable you to login and complete your training application process.</p>

<p>Below is a copy of your bio-data registration form.</p>

<#include "biodata.ftl">

<#include "mailfooter.ftl">
</body>
</html>
<%@ include file="/common/taglibs.jsp"%>
<head>
<title>Struts 2 radio button example</title>
</head>
<s:form namespace="/iya" action="resultAction">
<h2>
  <s:radio label="Gender" name="yourGender" list="genders"/>
  <s:radio label="Language" name="yourLanguage" list="languages"      />
  <s:radio label="Answer" name="yourAnswer" list="#{'1':'Yes','2':'No'}" value="2" />
</h2> 
<s:submit value="submit" name="submit" />
</s:form>
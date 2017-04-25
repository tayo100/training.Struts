<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%
response.setHeader("Cache-Control","private, max-age=3600");
%>

IITA.ProMIS = Class.create();
IITA.ProMIS.PrivateService=new IITA.AjaxRPC("<c:url value="/ajax/gui-ajax.jspx" />");

IITA.ProMIS.Installment = Class.create();
IITA.ProMIS.Installment.getRate=function (e) {
	var form = $(e.form);
	var rateElement=form.getInputs('text', 'installment.rate')[0];
	var fromCurrency=form.getInputs('text', 'installment.originalCurrency')[0].value;
	var toCurrency='USD';
	if (fromCurrency==toCurrency) {
		rateElement.value="1.0";
		return;
	}
	IITA.ProMIS.PrivateService.getConversionRate(fromCurrency, toCurrency, null, function(x) {
		var rate=x.responseJSON.result;
		if (rate) { 
			if (rateElement) rateElement.value=rate.rate;
			IITA.ProMIS.Installment.conv(e);
		}
	}); 
};
IITA.ProMIS.Installment.conv=function(e) {
	var form = $(e.form);
	var amountElement=form.getInputs('text', 'installment.amount')[0];
	if (amountElement)
		try {
			var amount=parseFloat(form.getInputs('text', 'installment.originalAmount')[0].value);
			var rate=parseFloat(form.getInputs('text', 'installment.rate')[0].value);
			amountElement.value=amount * rate;
		} catch (e) {
			alert(e);
		}
};

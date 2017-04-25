<%@ include file="/common/taglibs.jsp"%>
<page:applyDecorator name="plain">
<html>
<head>
<title>Currency converter</title>
</head>
<body>
<form>
<table class="inputform">
<colgroup><col width="200" /><col /></colgroup>
	<tr>
		<td>From:</td>
		<td><input type="text" name="originalAmount" style="width:130px"  onblur="javascript: conv(this);" /> <input type="text" style="width:35px" maxlength="3" name="originalCurrency" value="USD" onblur="javascript: conv(this);" /></td>
	</tr>
	<tr>
		<td>To:</td>
		<td><input type="text" readonly="true" style="width:130px" name="amount" /> <input type="text" name="currency" style="width:35px" maxlength="3" value="NGN" onblur="javascript: conv(this);" /></td>
	</tr>
	<tr>
		<td>Exchange date:</td>
		<td><span id="exchDate"></span></td>
	</tr>
	<tr>
		<td>Rate:</td>
		<td><span id="exchRate"></span></td>
	</tr>
	<tr>
		<td />
		<td><input type="button" value="Convert" onclick="javascript: conv(this);" /></td>
	</tr>
</table>
</form>
<script type="text/javascript">
function conv(e) {
	var form = $(e.form);
	var amount=form.getInputs('text', 'originalAmount')[0].value;
	var fromCurrency=form.getInputs('text', 'originalCurrency')[0].value;
	var toCurrency= form.getInputs('text', 'currency')[0].value;	
	var destinationElement=form.getInputs('text', 'amount')[0];
	if (fromCurrency==toCurrency) {
		destinationElement.value=amount;
		$('exchDate').innerHTML='';
		$('exchRate').innerHTML='';
	} else {
		IITA.ProMIS.PrivateService.getConversionRate(fromCurrency, toCurrency, null, function(x) {
			var rate=x.responseJSON.result;
			if (rate) { 
				destinationElement.value=Math.round(100 * amount * rate.rate)/100;
				$('exchDate').innerHTML=rate.date;
				$('exchRate').innerHTML='1 ' + fromCurrency + ' = ' + rate.rate + ' ' + toCurrency;
			} else {
				$('exchDate').innerHTML='';
				$('exchRate').innerHTML='';
			}
		}); 
	}
}
</script>
</body>
</html>
</page:applyDecorator>
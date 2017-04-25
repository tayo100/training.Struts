<%@ include file="/common/taglibs.jsp"%>

<h3>TRAINING TYPE</h3>

<div>
    <div>
        <table class="inputform">
	        <colgroup>
				<col width="200px" />
				<col />
			</colgroup>
        	<tr>
	            <td>Type of Training
	            </td>
	            <td>
	                <input type="radio" name="trainingtype" value="Solicited">Solicited (Advertised)<br>
	                <input type="radio" name="trainingtype" value="Unsolicited">Unsolicited
	            </td>
	        </tr>
	        <tr>
	            <td>Degree</td>
	            <td><input type="radio" name="degree" value="BSc">BSc<br>
	                <input type="radio" name="degree" value="MSc">MSc<br>
	                <input type="radio" name="degree" value="MPhil">MPhil<br>
	                <input type="radio" name="degree" value="PhD">PhD
	            </td>
	        </tr>
        </table>
    </div>
</div>
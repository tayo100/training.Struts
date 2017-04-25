<%@ include file="/common/taglibs.jsp"%>

<h3>PROPOSED ACADEMIC PROGRAM</h3>

<div>
    <div>
        <table class="inputform">
	        <colgroup>
				<col width="200px" />
				<col />
			</colgroup>
        	<tr>
	            <td>Present University</td>
	            <td><input type="text" name="university" id="university"></td>
	        </tr>
	        <tr>
	            <td>Degree Sought</td>
	            <td><input type="text" name="degreeSought" id="degreeSought"></td>
	        </tr>
	        <tr>
	            <td>Proposed Research Theme</td>
	            <td><input type="text" name="researchTheme" id="researchTheme"></td>
	        </tr>
	        <tr>
	            <td>University Supervisor Name</td>
	            <td><input type="text" name="supervisorName" id="supervisorName"></td>
	        </tr>
	        <tr>
	            <td>Supervisor Email</td>
	            <td><input id="emailSuperVisor" type="email" name="email" placeholder="e.g. ads@cgiar.org"/></td>
	        </tr>
	        <tr>
	            <td>IITA Supervisor</td>
	            <td><input type="text" name="iitaSupervisor" id="iitaSupervisor"></td>
	        </tr>
	        <tr>
	            <td>Research Locations</td>
	            <td><input type="text" name="researchLocations" id="researchLocations"></td>
	        </tr>
	        <tr>
	            <td>Expected Duration</td>
	            <td><input type="number" name="expectedDuration" id="expectedDuration"></td>
	        </tr>
	        <tr>
	            <td>Start Date</td>
	            <td><input type="text" class="datepicker" name="startDate"></td>
	        </tr>
	        <tr>
	            <td>End Date</td>
	            <td><input type="text" class="datepicker" name="enDate"></td>
	        </tr>
	        <tr>
	            <td>English</td>
	            <td><select>
	                <option value="eNil">Nil</option>
	                <option value="eAverage">Average</option>
	                <option value="eGood">Good</option>
	                <option value="eExcellent">Excellent</option>
	            </select></td>
	        </tr>
	        <tr>
	            <td>French</td>
	            <td><select>
	                <option value="fNil">Nil</option>
	                <option value="fAverage">Average</option>
	                <option value="fGood">Good</option>
	                <option value="fExcellent">Excellent</option>
	            </select></td>
	        </tr>
	        <tr>
	            <td>Portugese</td>
	            <td><select>
	                <option value="pNil">Nil</option>
	                <option value="pAverage">Average</option>
	                <option value="pGood">Good</option>
	                <option value="pExcellent">Excellent</option>
	            </select></td>
	        </tr>
	        <tr>
	            <td>Swahili</td>
	            <td><select>
	                <option value="sNil">Nil</option>
	                <option value="sAverage">Average</option>
	                <option value="sGood">Good</option>
	                <option value="sExcellent">Excellent</option>
	            </select></td>
	        </tr>
	        <tr>
	            <td>Local/Other</td>
	
	            <td>
	                <input type="text" name="localOthers" id="localOthers" placeholder="Indicate, if any"><br>
	                <select>
	                    <option value="fNil">Nil</option>
	                    <option value="fAverage">Average</option>
	                    <option value="fGood">Good</option>
	                    <option value="fExcellent">Excellent</option>
	                </select></td>
	        </tr>
	        <tr>
	            <td><label>Support Required</label></td>
	            <td>
	                <input type="checkbox" value="fuS">Full scholarship<br>
	                <input type="checkbox" value="relS">Research and living costs<br>
	                <input type="checkbox" value="reS">Research costs only<br>
	                <input type="checkbox" value="noneS">None<br>
	            </td>
	        </tr>
	        <tr>
	            <td><label>Funding Source</label></td>
	            <td>
	                <input type="checkbox" value="employerS">Employer <input type="checkbox" value="donorS">Donor<br>
	                <input type="checkbox" value="selfS">Self <input type="checkbox" value="jointS">Joint<br>
	                <label>IITA</label><br>
	                <input type="checkbox" value="jointS">Core <input type="checkbox" value="project">Project<br>
	            </td>
	        </tr>
	        <tr>
	            <td>Sponsor's Name</td>
	            <td><input type="text" name="sponsorName" id="sponsorName"></td>
	        </tr>
	        <tr>
	            <td>Sponsor's Address</td>
	            <td><textarea name="sponsorAd" maxlength="1000" cols="25" rows="5"></textarea></td>
	        </tr>
	        <tr>
	            <td>Date</td>
	            <td><input type="text" class="datepicker" name="finalDate"></td>
	        </tr>
        </table>
    </div>
</div>
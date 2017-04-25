<%@ include file="/common/taglibs.jsp"%>
<head>
<title>IYA Evaluation form</title>
</head>
<s:form action="save-evaluation" method="post">

	<s:if test="regId!=null">
		<s:hidden name="regId" value="%{regId}" />
	</s:if>
	<s:if test="id!=null">
		<s:hidden name="id" value="%{id}" />
	</s:if>
	<s:hidden name="type" value="org.iita.trainingunit.model.IYAEvaluation" />

	<table class="inputform">
		<colgroup>
			<col />
			<col width="150px" />
			<col width="150px" />
			<col width="150px" />
			<col width="150px" />
			<col width="150px" />
		</colgroup>
		<thead>
			<tr>
				<th></th>
				<th>Strongly Agree</th>
				<th>Agree</th>
				<th>Disagree</th>
				<th>Neutral</th>
				<th>Strongly Disagree</th>
			</tr>
		</thead>
		<tr>
			<td>Training objectives were met <em><font
				style="color: #ff0000">*</font></em></td>
			<td>
			<div class="row">
			<div class="form-group">
			<div class="col-xs-12 col-md-12"><s:radio id="objMet1"
				name="evaluation.objectivesMet" value="%{evaluation.objectivesMet}" list="#{'STRONGLYAGREE':''}" /></div>
			</div>
			</div>
			</td>
			<td>
			<div class="row">
			<div class="form-group">
			<div class="col-xs-12 col-md-12"><s:radio id="objMet2"
				name="evaluation.objectivesMet" value="%{evaluation.objectivesMet}" list="#{'AGREE':''}" /></div>
			</div>
			</div>
			</td>
			<td>
			<div class="row">
			<div class="form-group">
			<div class="col-xs-12 col-md-12"><s:radio id="objMet3"
				name="evaluation.objectivesMet" value="%{evaluation.objectivesMet}" list="#{'DISAGREE':''}" /></div>
			</div>
			</div>
			</td>
			<td>
			<div class="row">
			<div class="form-group">
			<div class="col-xs-12 col-md-12"><s:radio id="objMet4"
				name="evaluation.objectivesMet" value="%{evaluation.objectivesMet}" list="#{'NEUTRAL':''}" /></div>
			</div>
			</div>
			</td>
			<td>
			<div class="row">
			<div class="form-group">
			<div class="col-xs-12 col-md-12"><s:radio id="objMet5"
				name="evaluation.objectivesMet" value="%{evaluation.objectivesMet}" list="#{'STRONGLYDISAGREE':''}" />
			</div>
			</div>
			</div>
			</td>
		</tr>
		
		<tr>
			<td>Achieved Mastery of the Subject<em><font
				style="color: #ff0000">*</font></em></td>
			<td>
			<div class="row">
			<div class="form-group">
			<div class="col-xs-12 col-md-12"><s:radio id="subjectMastery1"
				name="evaluation.subjectMastery" value="%{evaluation.subjectMastery}"
				list="#{'STRONGLYAGREE':''}" /></div>
			</div>
			</div>
			</td>
			<td>
			<div class="row">
			<div class="form-group">
			<div class="col-xs-12 col-md-12"><s:radio id="subjectMastery2"
				name="evaluation.subjectMastery" value="%{evaluation.subjectMastery}" list="#{'AGREE':''}" />
			</div>
			</div>
			</div>
			</td>
			<td>
			<div class="row">
			<div class="form-group">
			<div class="col-xs-12 col-md-12"><s:radio id="subjectMastery3"
				name="evaluation.subjectMastery" value="%{evaluation.subjectMastery}"
				list="#{'DISAGREE':''}" /></div>
			</div>
			</div>
			</td>
			<td>
			<div class="row">
			<div class="form-group">
			<div class="col-xs-12 col-md-12"><s:radio id="subjectMastery4"
				name="evaluation.subjectMastery" value="%{evaluation.subjectMastery}"
				list="#{'NEUTRAL':''}" /></div>
			</div>
			</div>
			</td>
			<td>
			<div class="row">
			<div class="form-group">
			<div class="col-xs-12 col-md-12"><s:radio id="subjectMastery5"
				name="evaluation.subjectMastery" value="%{evaluation.subjectMastery}"
				list="#{'STRONGLYDISAGREE':''}" /></div>
			</div>
			</div>
			</td>
		</tr>
		
		<tr>
			<td>Course Was Delivered Within Alloted Time<em><font
				style="color: #ff0000">*</font></em></td>
			<td>
			<div class="row">
			<div class="form-group">
			<div class="col-xs-12 col-md-12"><s:radio
				id="courseDelivery1" name="evaluation.courseDelivery"
				value="%{evaluation.courseDelivery}" list="#{'STRONGLYAGREE':''}" /></div>
			</div>
			</div>
			</td>
			<td>
			<div class="row">
			<div class="form-group">
			<div class="col-xs-12 col-md-12"><s:radio
				id="courseDelivery2" name="evaluation.courseDelivery"
				value="%{evaluation.courseDelivery}" list="#{'AGREE':''}" /></div>
			</div>
			</div>
			</td>
			<td>
			<div class="row">
			<div class="form-group">
			<div class="col-xs-12 col-md-12"><s:radio
				id="courseDelivery3" name="evaluation.courseDelivery"
				value="%{evaluation.courseDelivery}" list="#{'DISAGREE':''}" /></div>
			</div>
			</div>
			</td>
			<td>
			<div class="row">
			<div class="form-group">
			<div class="col-xs-12 col-md-12"><s:radio
				id="courseDelivery4" name="evaluation.courseDelivery"
				value="%{evaluation.courseDelivery}" list="#{'NEUTRAL':''}" /></div>
			</div>
			</div>
			</td>
			<td>
			<div class="row">
			<div class="form-group">
			<div class="col-xs-12 col-md-12"><s:radio
				id="courseDelivery5" name="evaluation.courseDelivery"
				value="%{evaluation.courseDelivery}" list="#{'STRONGLYDISAGREE':''}" /></div>
			</div>
			</div>
			</td>
		</tr>
		<tr>
			<td>Quality Classroom Interaction <em><font
				style="color: #ff0000">*</font></em></td>
			<td>
			<div class="row">
			<div class="form-group">
			<div class="col-xs-12 col-md-12"><s:radio id="classInteraction1"
				name="evaluation.classInteraction" value="%{evaluation.classInteraction}" list="#{'STRONGLYAGREE':''}" />
			</div>
			</div>
			</div>
			</td>
			<td>
			<div class="row">
			<div class="form-group">
			<div class="col-xs-12 col-md-12"><s:radio id="classInteraction2"
				name="evaluation.classInteraction" value="%{evaluation.classInteraction}" list="#{'AGREE':''}" /></div>
			</div>
			</div>
			</td>
			<td>
			<div class="row">
			<div class="form-group">
			<div class="col-xs-12 col-md-12"><s:radio id="classInteraction3"
				name="evaluation.classInteraction" value="%{evaluation.classInteraction}" list="#{'DISAGREE':''}" />
			</div>
			</div>
			</div>
			</td>
			<td>
			<div class="row">
			<div class="form-group">
			<div class="col-xs-12 col-md-12"><s:radio id="classInteraction4"
				name="evaluation.classInteraction" value="%{evaluation.classInteraction}" list="#{'NEUTRAL':''}" /></div>
			</div>
			</div>
			</td>
			<td>
			<div class="row">
			<div class="form-group">
			<div class="col-xs-12 col-md-12"><s:radio id="classInteraction5"
				name="evaluation.classInteraction" value="%{evaluation.classInteraction}"
				list="#{'STRONGLYDISAGREE':''}" /></div>
			</div>
			</div>
			</td>
		</tr>


		
		<!--


		<tr>
			<td>Classroom Interaction:</td>			
			<td><s:checkboxlist name="evaluation.classInteraction" list="@org.iita.trainingunit.iya.model.ClassInteraction$InteractionType@values()" value="%{selectedClassInteractions}" listValue="%{getText('iya.classinteraction.'+toString())}" /></td>			
		</tr>
		--><tr>
			<td></td>
			<td><s:submit value="Submit" /></td>
		</tr>
	</table>
</s:form>
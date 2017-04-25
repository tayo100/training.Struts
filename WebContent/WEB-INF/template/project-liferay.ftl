<?xml version='1.0' encoding='UTF-8'?>
<root available-locales="en_US" default-locale="en_US">
	<static-content language-id="en_US"><![CDATA[
<h1>${project.title}</h1>
${project.description!''}

<#if project.narratives['goals']??>
<h2>Goals</h2>
${project.narratives['goals']!''}
</#if>

<#if project.narratives['purposes']??>
<h2>Purposes</h2>
${project.narratives['purposes']!''}
</#if>

<#if project.narratives['expectedResults']??>
<h2>Expected results</h2>
${project.narratives['expectedResults']!''}
</#if>

<#if project.narratives['beneficiaries']??>
<h2>Beneficiaries</h2>
${project.narratives['beneficiaries']!''}
</#if>

<#assign donors = promisService.listDonors(project) >
<#if (donors?size>0)>
<h2>Donors</h2>
<ul>
<#list donors as org>
	<li>${org.title} <#if org.shortName??>(${org.shortName})</#if></li>
</#list>
</ul>
</#if>

<#assign partners = promisService.listPartners(project) >
<#if (partners?size>0)>
<h2>Partners</h2>
<ul>
<#list partners as org>
	<li>${org.title} <#if org.shortName??>(${org.shortName})</#if></li>
</#list>
</ul>
</#if>

<#assign countries = promisService.getTagsInCategory(project, 'COUNTRY') >
<#if (countries?size>0)>
<h2>Countries</h2>
<ul>
<#list countries as tag>
	<li>${tag?substring(8)}</li>
</#list>
</ul>
</#if>

<div>
<#if project.startDate??>Start date:  ${project.startDate?date}<br /></#if>
<#if project.actualEndDate??>End date: 	${(project.actualEndDate)?date}<br /></#if>
</div>
]]></static-content>
</root>
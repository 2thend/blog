--------------------ȡֵ����-------------<br/>
${username}<br/>
-------------------macro���Ժ�ָ��--------------------<br/>
<#macro m1>
	name:<input type="text" name="name"/><br/>
</#macro>
<@m1/><@m1/><@m1/>

<#macro copyright date>
  <p>Copyright (C) ${date} ����.</p> 
</#macro>
<@copyright "1234"/><br/>

<#macro m2 a b c >
	${a}--${b}--${c}
</#macro><br/>
<@m2 a="1" b="2" c="3"/><br/>
---------------assign��ֵ����------------------------<br/>
<#--�൱��<c:set/>------->
<#assign ctx="/blog"/>
<a href="${ctx}/a">��¼</a><br/>
---------------if--------------------<br/>
<#if flag==true>
	falg is true
</#if>
<br/>
<#if num gte 18>
	>=18
	<#else>
	20
</#if><br/>
<#if num gte 30>
	30
	<#elseif num gte 20>
	20
	<#else>
	10
</#if><br/>
----------------list-------------------------<br/>
<#list employees as employee>
		${employee.lastName}<br/>
</#list><br/>
----------------nestedָ��---------------------<br/>
<#macro border> 
  <table border=4 cellspacing=0 cellpadding=4><tr><td> 
    <#nested> 
  </td></tr></table> 
</#macro>
<@border >����е�����</@border><br/>
----------------includeָ��--------------------------<br/>
<#include "test.txt"/><br/>


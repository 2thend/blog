--------------------取值操作-------------<br/>
${username}<br/>
-------------------macro测试宏指令--------------------<br/>
<#macro m1>
	name:<input type="text" name="name"/><br/>
</#macro>
<@m1/><@m1/><@m1/>

<#macro copyright date>
  <p>Copyright (C) ${date} 用友.</p> 
</#macro>
<@copyright "1234"/><br/>

<#macro m2 a b c >
	${a}--${b}--${c}
</#macro><br/>
<@m2 a="1" b="2" c="3"/><br/>
---------------assign赋值操作------------------------<br/>
<#--相当于<c:set/>------->
<#assign ctx="/blog"/>
<a href="${ctx}/a">登录</a><br/>
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
----------------nested指令---------------------<br/>
<#macro border> 
  <table border=4 cellspacing=0 cellpadding=4><tr><td> 
    <#nested> 
  </td></tr></table> 
</#macro>
<@border >表格中的内容</@border><br/>
----------------include指令--------------------------<br/>
<#include "test.txt"/><br/>


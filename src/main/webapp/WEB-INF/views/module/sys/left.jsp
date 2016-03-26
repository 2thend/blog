<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${ctxStatic}/sys/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${ctxStatic}/sys/js/jquery.js"></script>

<script type="text/javascript">
$(function(){
	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
		
	});

})	
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>管理</div>
    
    <dl class="leftmenu">    
    <dd>
    <div class="title">
    <span><img src="${ctxStatic}/sys/images/leftico01.png"/></span>管理信息
    </div>
      <ul class="menuson">
        <li><cite></cite><a href="${ctx}/menu/workspace" target="rightFrame">博客导航</a><i></i></li>
        <li><cite></cite><a href="${ctx}/fixUserinfo" target="rightFrame">个人信息</a><i></i></li>
        <li><cite></cite><a href="${ctx}/a/article/sysManager" target="rightFrame">博客管理</a><i></i></li>
       </ul>    
    </dd>
    </dl>
</body>
</html>

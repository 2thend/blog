<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${ctxStatic}/sys/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${ctxStatic}/sys/js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>


</head>

<body style="background:url(${ctxStatic}/sys/images/topbg.gif) repeat-x;">

    <div class="topleft">
    <a href="main.html" target="_parent"><img src="${ctxStatic}/sys/images/logo.png" title="系统首页" /></a>
    </div>
        
    <ul class="nav">
    </ul>
            
    <div class="topright">    
    <ul>
    <li><span><a href="${ctx}/f" target="_parent">哎博客</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="${ctx}/a/logout" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
    <span>admin</span>
    <i>消息</i>
    <b>5</b>
    </div>    
    
    </div>

</body>
</html>

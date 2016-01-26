<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>无标题文档</title>
<link href="${ctxStatic}/sys/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">表单</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    <form action="" method="post">
    <ul class="forminfo">
   	<li> <label>头像</label><img src="${ctxStatic}/images/photo/1.jpg" height="80px" width="80px"></li>
    <li><label>登录名</label><input name="" type="text" class="dfinput" /><i>标题不能超过30个字符</i></li>
    <li><label>用户名</label><input name="" type="text" class="dfinput" /><i>多个关键字用,隔开</i></li>
    <li><label>密码</label><cite><input name="" type="password" class="dfinput" /></li>
    <li><label>确认密码</label><input name="" type="password" class="dfinput" /></li>
    <li><label>地址</label><input name="" type="text" class="dfinput" /></li>
    <li><label>电话</label><input name="" type="text" class="dfinput" /></li>
    <li><label>邮箱</label><input name="" type="text" class="dfinput" /></li>
    <li><label>年龄</label><input name="" type="text" class="dfinput" /></li>
    <li><label>生日</label><input name="" type="text" class="dfinput" /></li>  
    <li><label>&nbsp;</label><input name="" type="button" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    
    </div>


</body>

</html>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>无标题文档</title>
<link href="${ctxStatic}/sys/css/style.css" rel="stylesheet" type="text/css" />
  <script type="text/javascript" src="${ctxStatic}/JBox/jquery-1.4.2.min.js"></script>
  <script type="text/javascript" src="${ctxStatic}/JBox/jquery.jBox-2.3.min.js"></script>
  <script type="text/javascript" src="${ctxStatic}/JBox/i18n/jquery.jBox-zh-CN.js"></script>

   <link type="text/css" rel="stylesheet" href="${ctxStatic}/JBox/Skins/Gray/jbox.css"/>
<script type="text/javascript">
	$(function(){
		$("#userPhoto").click(function(){
			$.jBox(
					"iframe:${ctx}/choosePhoto",
					{
						title:"修改头像",
						width:650,
						height:450,
						buttons:{'关闭':true}
					}
			);
		});
	});
</script>
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
    <form action="${ctx}/a/saveInfo" method="post">
    <ul class="forminfo">
   	<li> <label>头像</label>
   	<input type="hidden" name="photo" value="${user.photo}">
   	<img src="${user.photo}" height="80px" width="80px" id="userPhoto"></li>
    <li><label>登录名</label>${user.loginName}</li>
    <li><label>用户名</label><input name="name" type="text" class="dfinput" value="${user.name}"/></li>
    <li><label>密码</label><input name="password" type="password" class="dfinput"/></li>
    <li><label>确认密码</label><input name="" type="password" class="dfinput" /></li>
    <li><label>地址</label><input name="address" type="text" class="dfinput" value="${user.address}"/></li>
    <li><label>电话</label><input name="phone" type="text" class="dfinput" value="${user.phone}"/></li>
    <!-- <li><label>邮箱</label><input name="" type="text" class="dfinput" /></li> -->
    <li><label>年龄</label><input name="age" type="text" class="dfinput" value="${user.age}"/></li>
    <li><label>生日</label><input name="birthday" type="text" class="dfinput" ${user.birthday}/></li>  
    <li><label>&nbsp;</label><input type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>
    
    </div>


</body>

</html>

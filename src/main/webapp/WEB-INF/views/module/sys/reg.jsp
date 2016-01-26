<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<link rel="stylesheet" type="text/css" href="${ctxStatic}/sys/css/buttons.css" />
<link rel="stylesheet" href="${ctxStatic}/sys/css/jquery-labelauty.css">
<html>
  <head>
	<title>注册页面</title>
	<style type="text/css">
	.content{margin:auto;width:400px;margin-top:150px;border:1px solid #ccc;padding:40px;}
	input{height:30px;}
	#code{width:50px;margin-left:52px;}
	img{height:30px;}
    </style>
  <script type="text/javascript" src="${ctxStatic}/jBox/jquery-1.4.2.min.js"></script>
  <script type="text/javascript" src="${ctxStatic}/jBox/jquery.jBox-2.3.min.js"></script>
  <script type="text/javascript" src="${ctxStatic}/jBox/i18n/jquery.jBox-zh-CN.js"></script>

   <link type="text/css" rel="stylesheet" href="${ctxStatic}/jBox/Skins/Gray/jbox.css"/>
   <script type="text/javascript" src="${ctxStatic}/sys/js/jquery.js"></script>
   <script type="text/javascript">
   
  	$(function (){
  		$("#register").attr({"disabled":"disabled"});
  		$("#vali").click(function(){
			 this.src="${ctx}/Validate?tm="+Math.random();  			
  		});
  		
  		$("#code").blur(function(){
  			
  		var code=$("#code").val();
   		$.get(
   			"${ctx}/a/validate",
   			{"code":code},
   			function(data){
   				if(data==false){
   					$("#register").attr({"disabled":"disabled"});
   				}else{
   					$("#register").removeAttr("disabled");
   				}
   			}
   		);
  		
		});
  	});
	
   </script>
  </head>
  
  <body>
  	${errMsg}
	<div class="content">
	<form action="${ctx}/a/register" method="post" id="regForm">
  		<table>
		<tr>
			<td>登录名：</td>
			<td><input type="text" id="loginName" name="loginName" value="" width="20px;"></td>
		</tr>
		<tr>
			<td>密码:</td>
			<td><input type="password" id="password" name="password" value=""></td>
		</tr>
		<tr>
			<td>确认密码:</td>
			<td><input type="password" id="password" name="passwordConfirm" value=""></td>
		</tr>
		<tr>
			<td>昵称:</td>
			<td><input type="text" id="password" name="name" value=""></td>
		</tr>
		<tr>
			<td>验证码:</td>
			<td><img src="${ctx}/Validate" id="vali"><input type="text" id="code"></td>
		</tr>
	</table>
	<input type="submit" value="注册" id="register">
  	</form>
	</div>
	
  </body>
</html>

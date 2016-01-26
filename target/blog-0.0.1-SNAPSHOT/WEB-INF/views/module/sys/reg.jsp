<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<link href="${ctxStatic}/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<script src="${ctxStatic}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${ctxStatic}/sys/css/buttons.css" />
<link rel="stylesheet" href="${ctxStatic}/sys/css/jquery-labelauty.css">
<html>
  <head>
		<title>登陆页面</title>
	<style type="text/css">
      html,body,table{background-color:#f5f5f5;width:100%;text-align:center;}.form-signin-heading{font-family:Helvetica, Georgia, Arial, sans-serif, 黑体;font-size:36px;margin-bottom:20px;color:#0663a2;}
      .form-signin{position:relative;text-align:left;width:300px;padding:25px 29px 29px;margin:0 auto 20px;background-color:#fff;border:1px solid #e5e5e5;
        	-webkit-border-radius:5px;-moz-border-radius:5px;border-radius:5px;-webkit-box-shadow:0 1px 2px rgba(0,0,0,.05);-moz-box-shadow:0 1px 2px rgba(0,0,0,.05);box-shadow:0 1px 2px rgba(0,0,0,.05);}
      .form-signin .checkbox{margin-bottom:10px;color:#0663a2;} .form-signin .input-label{font-size:16px;line-height:23px;color:#999;}
      .form-signin .input-block-level{font-size:16px;height:auto;margin-bottom:15px;padding:7px;*width:283px;*padding-bottom:0;_padding:7px 7px 9px 7px;}
      .form-signin .btn.btn-large{font-size:16px;} .form-signin #themeSwitch{position:absolute;right:15px;bottom:10px;}
      .form-signin div.validateCode {padding-bottom:15px;} .mid{vertical-align:middle;}
      .header{height:80px;padding-top:20px;} .alert{position:relative;width:300px;margin:0 auto;*padding-bottom:0px;}
      label.error{background:none;width:270px;font-weight:normal;color:inherit;margin:0;}
    </style>
   <script type="text/javascript" src="${ctxStatic}/sys/js/jquery.js"></script>
   <script type="text/javascript">
   
  	$(function (){
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
	<div class="header">
		<div id="messageBox" class="alert alert-error ${empty message ? 'hide' : ''}"><button data-dismiss="alert" class="close">×</button>
			<label id="loginError" class="error">${message}</label>
		</div>
	</div> 
    <form action="${ctx}/a/login" class="form-signin" method="post" id="regForm">
		用户名:<input type="text" id="username" name="username" class="input-block-level required" value="" width="20px;">
		密码:<input type="password" id="password" name="password" class="input-block-level required" value="">
		确认密码:<input type="password" id="password" name="passwordConfirm" class="input-block-level required" value="">
		email:<input type="text" id="password" name="password" class="input-block-level required" value="">
   		昵称:<input type="text" id="password" name="password" class="input-block-level required" value="">
   		验证码:<img src="${ctx}/Validate"><input type="text" id="code">
   		<button class="button small blue rounded" id="register">注册</button>
   		<br/><br/>
  	</form>
  	
 	<div class="footer">
		xxxxxxx
	</div>
  </body>
</html>

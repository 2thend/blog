<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="${ctxStatic}/sys/js/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		$("#testJson").click(function(){
			var url=this.href;
			var args={};
			$.post(url,args,function(data){
				for(var i=0;i<data.length;i++){
					var name=data[i].name;
					var age=data[i].age;
					alert("name:"+name+" age:"+age);
				}
			});
			return false;
		});
	})
	
</script>
</head>
<body>
<!-- 自定义转化器测试格式是：name-age -->
	<form action="<%=request.getContextPath()%>/test/testConversionService" method="POST">
		<!-- 格式:name-age -->
		<input type="text" name="user"/>
		<input type="submit" value="submit"/>
	</form>
	<form action="${ctx}/test/testDefaultConversion" method="POST">
		name:<input type="text" name="name" /><br>
		age:<input type="text" name="age"/><br/>
		birth:<input type="text" name="birth"><br/>
		salary:<input type="text" name="salary"><br/>
		<input type="submit" value="submit">
	</form>
	<a href="${ctx}/test/testNative">Test Native</a><br/>
	<a href="${ctx}/test/testJson" id="testJson">Test Json</a><br/>
	
	<form action="${ctx}/test/testMessageConverter" method="POST" enctype="mulipart/form-data">
		file:<input type="file" name="file"/><br/>
		desc:<input type="text" name="desc"/><br/>
		<input type="submit" value="Submit"/>
	</form>
	<a href="${ctx}/test/testResponseEntity">Test ResponseEntity</a><br/>
	<a href="${ctx}/test/HttpEntity">Test HttpEntity</a><br/>
	<a href="${ctx}/emps">显示所有员工</a><br/>
	<a href="${ctx}/test/testFreemark">Test Freemark</a>
</body>
</html>
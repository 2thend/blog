<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>编辑用户</title>
</head>
<body>
	<form:form action="${ctx}/emp" method="POST" modelAttribute="employee">
		<form:hidden path="id"/>
		姓名:<form:input path="lastName"/><br/>
		邮箱:<form:input path="email"/><br/>
		性别:<form:radiobuttons path="gender" items="${genders}"/><br/>
		部门:<form:select path="department.id" items="${departments}" itemLabel="name" itemValue="id"></form:select><br/>
		<input type="submit" value="增加">
	</form:form>
</body>
</html>
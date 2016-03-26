<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${ctxStatic}/sys/js/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		$(".delete").click(function(){
			var href=$(this).attr("href");
			$("form").attr("action",href);
			$("form").submit();
			return false;
		});
	})
</script>
<title>用户列表</title>
</head>
<body>
	<c:if test="${empty emps}">
		没有数据
	</c:if>
	${msg}
	<!-- 设置一个隐藏域,通过将_method的表单将POST转化为DELETE或者PUT -->
	<form method="POST" action="">
		<input type="hidden" name="_method" value="DELETE"/>
	</form>
	<c:if test="${not empty emps}">
		<table border="1">
			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>邮箱</th>
				<th>性别</th>
				<th>部门</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${emps}" var="item">
				<tr>
				<th>${item.id}</th>
				<th>${item.lastName}</th>
				<th>${item.email}</th>
				<th>${item.gender==1?'男':'女'}</th>
				<th>${item.department.name}</th>
				<th><a href="${ctx}/emp?id=${item.id}">编辑</a>&nbsp;
				<a href="${ctx}/delete?id=${item.id}">删除</a></th>
				</tr>
			</c:forEach>
		</table>
	</c:if>
<br/><a href="${ctx}/emp">增加用户</a>
</body>
</html>
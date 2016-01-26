
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>博客首页</title>
<script type="text/javascript" src="${ctxStatic}/front/js/jquery-1.4.4.min.js"></script>
<link href="${ctxStatic}/front/css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="${ctxStatic}/front/css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script type="text/javascript">
	$(document).ready(function(){
		$(".article img").hide();
	});
	$(document).ready(function(){
		
		$("#testjson").click(function(){
			alert("1111");
			
			var url="${ctx}/f/testJson";
			var dataType = "text";
			$.post(url,dataType,function(data){
				alert(data);
			});
			
			return false;
		});
	});

</script>
<style type="text/css">
	
</style>
</head>
<body>
<div>
	城市:${weather.cityName}温度:${weather.tem}状态:${weather.data}
</div>
	<!-- header-section-starts -->
	<div class="header">
		<div class="container">
			<div class="logo">
				<a href="#"><h1>哎博客</h1></a>
			</div>
			<div class="pages">
				<ul>
					<li><a href="#">博客分类:</a>
					</li>
					<select id="my-menu">
						<option value="JavaScript">站长之家</option>
						<option value="C++">站长素材</option>
						<option value="Ruby">HTML5特效</option>
						<option value="jQuery">jQuery特效</option>
						<option value="Python">CSS3特效</option>
						<option value="Golang" selected>音效下载</option>
					</select>
				</ul>
			</div>
			<div class="navigation">
				<ul>
				<shiro:notAuthenticated>
					<li><a href="${ctx}/a/register" id="reg">注册</a></li>
					<li><a href="${ctx}/a" id="login">登录</a></li>
					</shiro:notAuthenticated>
					<li><a class="active" href="${ctx}/a">个人博客</a></li>
				</ul>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="container">
		<div class="header-bottom">
            <div class="type">
				<h5>文章类型</h5>
			</div>
			<span class="menu"></span>
			<div class="list-nav">
				<ul>                                                                 
					<li><a href="#">ORACLE</a></li>|
					<li><a href="#">MySQL</a></li>|
					<li><a href="#">SQL Server</a></li>|
					<li><a href="#l">NoSQL</a></li>|
					<li><a href="#">大数据</a></li>|
					<li><a href="#">其他数据库</a></li>
				</ul>
			</div>
			<!-- script for menu -->
				<script>
				$( "span.menu" ).click(function() {
				  $( ".list-nav" ).slideToggle( "slow", function() {
				    // Animation complete.
				  });
				});
			</script>
			<!-- script for menu -->

			<div class="clearfix"></div>
        </div>
	</div>
	<div class="container">
		<div class="content">
			<div class="col-md-7 content-left">
				<div class="article">
					<h5 class="head">最新博客</h5>
				</div>
				<c:forEach items="${articles}" var="item">
				<div class="article">
					<h6><a href="${ctx}/f/articleView?articleId=${item.id}">${item.title}</a></h6>
					<div class="aContent">
					<p>${fnc:transCodage(item.articleData.content)}
					<br/>
						<a href="#">${item.createBy.name}</a> 发布于 ${item.createDate} 评论(0)阅读(31)
					</p>
					</div>
				</div>	
				</c:forEach>
				<br/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">上一页</a>1,2,3...17<a href="#">下一页</a>
			</div>
			<div class="col-md-5 content-right">
			<div class="content-right-top">
				<h5 class="head">热门博客</h5>	
				<div class="article">
					<h6><a href="${ctx}/f/articleView?articleId=${articleId }">Oracle数据泵操作</a></h6>
					<p>EXPDP和IMPDP使用说明
						Oracle Database 10g引入了最新的数据泵(Data Dump)技术，数据泵导出导入(EXPDP和IMPDP)的作用
						1）实现逻辑备份和逻辑恢复.
						2）在数据库用户之间移动对象...<br/>
						自由飞 发布于 2015-11-12 21:54 评论(0)阅读(31)
						</p>
				</div>
				<div class="article">
					<h6><a href="${ctx}/f/articleView?articleId=${articleId }">Oracle数据泵操作</a></h6>
					<p>EXPDP和IMPDP使用说明
						Oracle Database 10g引入了最新的数据泵(Data Dump)技术，数据泵导出导入(EXPDP和IMPDP)的作用
						1）实现逻辑备份和逻辑恢复.
						2）在数据库用户之间移动对象...<br/>
						自由飞 发布于 2015-11-12 21:54 评论(0)阅读(31)
						</p>
				</div>
				<div class="article">
					<h6><a href="${ctx}/f/articleView?articleId=${articleId }">Oracle数据泵操作</a></h6>
					<p>EXPDP和IMPDP使用说明
						Oracle Database 10g引入了最新的数据泵(Data Dump)技术，数据泵导出导入(EXPDP和IMPDP)的作用
						1）实现逻辑备份和逻辑恢复.
						2）在数据库用户之间移动对象...<br/>
						自由飞 发布于 2015-11-12 21:54 评论(0)阅读(31)
						</p>
				</div>

				<div class="article">
					<h6><a href="${ctx}/f/articleView?articleId=${articleId }">Oracle数据泵操作</a></h6>
					<p>EXPDP和IMPDP使用说明
						Oracle Database 10g引入了最新的数据泵(Data Dump)技术，数据泵导出导入(EXPDP和IMPDP)的作用
						1）实现逻辑备份和逻辑恢复.
						2）在数据库用户之间移动对象...<br/>
						自由飞 发布于 2015-11-12 21:54 评论(0)阅读(31)
						</p>
				</div>
				<div class="article">
					<h6><a href="articleView.html">Oracle数据泵操作</a></h6>
					<p>EXPDP和IMPDP使用说明
						Oracle Database 10g引入了最新的数据泵(Data Dump)技术，数据泵导出导入(EXPDP和IMPDP)的作用
						1）实现逻辑备份和逻辑恢复.
						2）在数据库用户之间移动对象...<br/>
						自由飞 发布于 2015-11-12 21:54 评论(0)阅读(31)
						</p>
				</div>
				</div>
				<div class="editors-pic-grids">
					<h5>图文</h5>
					<div class="editors-pic">
						<div class="e-pic">
							<a href="#"><img src="${ctxStatic}/front/images/ep1.jpg" alt="" /></a>
						</div>
						<div class="e-pic-info">
							<a href="#">Web前端</a>
							<span></span>
							<label>2 天前</label>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="editors-pic">
						<div class="e-pic">
							<a href="single.html"><img src="${ctxStatic}/front/images/ep2.jpg" alt="" /></a>
						</div>
						<div class="e-pic-info">
							<a href="#">NoSQL笔记</a>
							<span></span>
							<label>5天前</label>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="editors-pic">
						<div class="e-pic">
							<a href="#"><img src="${ctxStatic}/front/images/ep2.jpg" alt="" /></a>
						</div>
						<div class="e-pic-info">
							<a href="#">NoSQL笔记</a>
							<span></span>
							<label>5天前</label>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="editors-pic">
						<div class="e-pic">
							<a href="#"><img src="${ctxStatic}/front/images/ep3.jpg" alt="" /></a>
						</div>
						<div class="e-pic-info">
							<a href="#">ORACLE培训</a>
							<span></span>
							<label>1天前</label>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="editors-pic">
						<div class="e-pic">
							<a href="#"><img src="${ctxStatic}/front/images/ep3.jpg" alt="" /></a>
						</div>
						<div class="e-pic-info">
							<a href="#">ORACLE培训</a>
							<span></span>
							<label>1天前</label>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="editors-pic">
						<div class="e-pic">
							<a href="#"><img src="${ctxStatic}/front/images/ep3.jpg" alt="" /></a>
						</div>
						<div class="e-pic-info">
							<a href="#">ORACLE培训</a>
							<span></span>
							<label>1天前</label>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="editors-pic">
						<div class="e-pic">
							<a href="#"><img src="${ctxStatic}/front/images/ep4.jpg" alt="" /></a>
						</div>
						<div class="e-pic-info">
							<a href="#">SQL Servier性能优化</a>
							<span></span>
							<label>一个星期前</label>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
			<div class="clearfix"></div>
		<div class="col-md-7 content-left">
				<div class="article">
					<h5 class="head">广告栏</h5>
					<a class="title" href="#">广告栏正在招商</a>
					<a href="#"><img src="${ctxStatic}/front/images/a1.jpg" alt="" /></a>
					<p>广告广告广告广告广告广告广告广告广告广告广告广告广告广告广告广告广告广告广告广告广告广告广告广告广告广告广告</p>
					<p>广告广告广告广告广告广告广告广告广告广告广告广告广告广告广告广告广告广告广告广告...</p>
				</div>
			</div>
			<div class="col-md-5 content-right content-right-top">
				<h5 class="head">下载专区</h5>	
				<a href="#">
				<div class="editor text-center">
					<h6>DeltaMaker – The new kid on the block An Elegant 3D Printer</h6>
					<label>2 Days Ago</label>
					<span></span>
				</div>
				</a>
			</div>	
			<div class="clearfix"></div>			
		</div>
	</div>
	<div class="footer">
		<div class="footer-top">
		PROW BY XXX
		</div>
	</div>
</body>
</html>
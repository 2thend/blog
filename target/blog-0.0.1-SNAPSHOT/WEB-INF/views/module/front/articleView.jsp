<%@ page contentType="text/html;charset=utf-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<title>${article.title} - 哎客园</title>
<link type="text/css" rel="stylesheet" href="${ctxStatic}/front/css/blog-common.css">
<link id="MainCss" type="text/css" rel="stylesheet" href="${ctxStatic}/front/css/bundle-SimpleBlue.css">
</head>
<body>
<a name="top"></a>

<div id="home">
	<div id="header">
		<div id="blogTitle">
			<div class="title">
			<a id="Header1_HeaderTitle" class="headermaintitle" href=#"></a>
			</div>
		</div><!--end: blogTitle 博客的标题和副标题 -->
	<div id="navigator">		
		<ul id="navList">
			<li id="nav_myhome"><a id="MyLinks1_MyHomeLink" class="menu" href="${ctx}/f">首页</a></li>
			<li id="nav_admin"><a id="MyLinks1_Admin" class="menu" rel="nofollow" href="#">管理</a></li>
		</ul>
		<div class="blogStats">
			<!--done-->
			随笔-4&nbsp;
			文章-1&nbsp;
			评论-104&nbsp;	
		</div><!--end: blogStats -->
	</div><!--end: navigator 博客导航栏 -->
</div><!--end: header 头部 -->
<div id="main">
	<div id="mainContent">
		<div class="forFlow">	
			<div id="post_detail">
<!--done-->
				<div id="topics">
					<div class="post">
						<h1 class="postTitle">
						<a id="cb_post_title_url" class="postTitle2" href="">${article.title}</a>
						</h1>
						<div class="clear">
						</div>
						<div id="cnblogs_post_body">
						${articleData.content}
						</div>
					</div>

					<div class="clear"></div>
					<div id="blog_post_info_block">
						<div id="BlogPostCategory">分类: <a href="">数据库</a></div>
						<div id="EntryTag">标签:
							<a href="">oracle</a>
						</div>
						<div class="clear"></div>
					</div>
				</div>
				<div class="postDesc">时间 @ <span id="post-date">${article.createDate}</span> <a href="#">/*${user.name}*/</a> 阅读(<span id="post_view_count">${article.hits})</span>) 评论(<span id="post_comment_count">0</span>) 
				<a href="#" onclick="AddToWz(4961215);return false;">转载</a>
				</div>
			</div>
		</div><!--end: topics 文章、评论容器-->
	</div><a name="!comments"></a><div id="blog-comments-placeholder"></div>
		<div id="comment_form" class="commentform">
			<a name="commentform"></a>
				<div id="divCommentShow"></div>
					<div id="comment_nav"><span id="span_refresh_tips"></span>
						<a href="javascript:void(0);" id="lnk_RefreshComments" onclick="return RefreshCommentList();">刷新评论</a><a href="#">刷新页面</a><a href="#">返回顶部</a></div>
						<span id="tip_comment" style="color:Red"></span>
						<p>
						<div id="google_ad_c3" class="c_ad_block">
						</div>
						<div id="HistoryToday" class="c_ad_block"></div>
						</div>
					</div><!--end: forFlow -->
	</div><!--end: mainContent 主体内容容器-->

	<div id="sideBar">
		<div id="sideBarMain">
			
			<div id="calendar"><div id="blog-calendar" style=""></div></div>
			
			<div id="leftcontentcontainer">
				<div id="blog-sidecolumn">
					<div id="sidebar_search" class="sidebar-block">
						<div id="author_profile_info" class="author_profile_info">
							<a href="#" target="_blank">
							<img src="${user.photo}" class="author_avatar" width="200px" height="200px" alt=""></a>
								<div id="author_profile_detail" class="author_profile_info">
									<a href="">${user.name}</a><br>
									<a href="">关注 - 4</a><br>
									<a href="">粉丝 - 24</a>
									<div id="author_profile_follow">
											 <a href="javascript:void(0);" onclick="">+加关注</a>
									</div>
								</div>
					</div><br/><br/>
			</div>
		</div>
<div id="sidebar_categories">
	<div class="catListPostCategory">
	<h3 class="catListTitle">博客分类</h3>
	<ul>
		<li><a id="CatList_LinkList_0_Link_0" href="#">Spring学习日记</a> </li>
		<li><a id="CatList_LinkList_0_Link_0" href="#">Shiro源码分析</a> </li>
	</ul>
	</div>
	<div class="catListPostArchive">
		<h3 class="catListTitle">博客档案</h3>
		<ul>
			<li><a id="CatList_LinkList_1_Link_0" href="#">2015年11月 (1)</a> </li>

		</ul>
	</div>
</div>
<div id="sidebar_scorerank" class="sidebar-block">
	<div class="catListBlogRank">
		<h3 class="catListTitle">积分与排名</h3>
		<ul>
			<li class="liScore">积分 -	9700</li>
			<li class="liRank">排名 -	17297</li>
		</ul>
	</div>
	<div id="footer">	
<!--done-->
Copyright ©2015 /*${user.name}*/
	</div><!--end: footer -->
</div><!--end: home 自定义的最大容器 -->


</body></html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<title>Oracle性能优化/*作者*/ - 哎客园</title>
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
						<a id="cb_post_title_url" class="postTitle2" href="">Oracle数据泵操作</a>
						</h1>
						<div class="clear">
						</div>
						<div id="cnblogs_post_body">一、EXPDP和IMPDP使用说明
						Oracle Database 10g引入了最新的数据泵(Data Dump)技术，数据泵导出导入(EXPDP和IMPDP)的作用
						1）实现逻辑备份和逻辑恢复.<br/>
						2）在数据库用户之间移动对象.<br/>
						3）在数据库之间移动对象<br/>
						4）实现表空间搬移.<br/>
 
二、数据泵导出导入与传统导出导入的区别<br/>
在10g之前,传统的导出和导入分别使用EXP工具和IMP工具,从10g开始,不仅保留了原有的EXP和IMP工具,还提供了数据泵导出导入工具EXPDP和IMPDP.使用EXPDP和IMPDP时应该注意的事项：<br/>
1）EXP和IMP是客户端工具程序,它们既可以在可以客户端使用,也可以在服务端使用。<br/>
2）EXPDP和IMPDP是服务端的工具程序,他们只能在ORACLE服务端使用,不能在客户端使用。<br/>
3）IMP只适用于EXP导出文件,不适用于EXPDP导出文件;IMPDP只适用于EXPDP导出文件,而不适用于EXP导出文件。<br/>
数据泵导出包括导出表,导出方案,导出表空间,导出数据库4种方式.
 
三、Expdp参数
EXPDP命令行选项，可通过expdp help=y查看：
E:\emp>expdp help=y
Export: Release 10.2.0.1.0- Production on 星期日, 03 5月, 2009 17:54:49
Copyright (c) 2003, 2005, Oracle.  All rights reserved.
数据泵导出实用程序提供了一种用于在 Oracle 数据库之间传输
数据对象的机制。该实用程序可以使用以下命令进行调用:
   示例: expdp scott/tigerDIRECTORY=dmpdir DUMPFILE=scott.dmp
您可以控制导出的运行方式。具体方法是: 在 'expdp' 命令后输入
各种参数。要指定各参数, 请使用关键字:
   格式: expdp KEYWORD=value 或 KEYWORD=(value1,value2,...,valueN)
   示例: expdp scott/tigerDUMPFILE=scott.dmp DIRECTORY=dmpdir SCHEMAS=scott
               或 TABLES=(T1:P1,T1:P2), 如果 T1 是分区表
USERID 必须是命令行中的第一个参数。
关键字               说明 (默认)
------------------------------------------------------------------------------
ATTACH                连接到现有作业, 例如 ATTACH [=作业名]。
COMPRESSION           减小有效的转储文件内容的大小
                      关键字值为: (METADATA_ONLY) 和 NONE。
CONTENT               指定要卸载的数据, 其中有效关键字为:
                      (ALL), DATA_ONLY 和 METADATA_ONLY。
DIRECTORY             供转储文件和日志文件使用的目录对象。
DUMPFILE              目标转储文件 (expdat.dmp) 的列表,
                      例如 DUMPFILE=scott1.dmp, scott2.dmp,dmpdir:scott3.dmp。
ENCRYPTION_PASSWORD   用于创建加密列数据的口令关键字。
ESTIMATE              计算作业估计值, 其中有效关键字为:
                     (BLOCKS) 和 STATISTICS。
ESTIMATE_ONLY         在不执行导出的情况下计算作业估计值。
EXCLUDE               排除特定的对象类型, 例如EXCLUDE=TABLE:EMP。
FILESIZE              以字节为单位指定每个转储文件的大小。
FLASHBACK_SCN         用于将会话快照设置回以前状态的 SCN。
FLASHBACK_TIME        用于获取最接近指定时间的 SCN 的时间。
FULL                  导出整个数据库 (N)。
HELP                  显示帮助消息 (N)。
INCLUDE               包括特定的对象类型, 例如INCLUDE=TABLE_DATA。
JOB_NAME              要创建的导出作业的名称。
LOGFILE               日志文件名 (export.log)。
NETWORK_LINK          链接到源系统的远程数据库的名称。
NOLOGFILE             不写入日志文件 (N)。
PARALLEL              更改当前作业的活动 worker 的数目。
PARFILE               指定参数文件。
QUERY                 用于导出表的子集的谓词子句。
SAMPLE                要导出的数据的百分比;
SCHEMAS               要导出的方案的列表 (登录方案)。
STATUS                在默认值 (0) 将显示可用时的新状态的情况下,
                      要监视的频率 (以秒计) 作业状态。
TABLES                标识要导出的表的列表 - 只有一个方案。
TABLESPACES           标识要导出的表空间的列表。
TRANSPORT_FULL_CHECK  验证所有表的存储段 (N)。
TRANSPORT_TABLESPACES 要从中卸载元数据的表空间的列表。
VERSION               要导出的对象的版本, 其中有效关键字为:
                      (COMPATIBLE), LATEST 或任何有效的数据库版本。
 
下列命令在交互模式下有效。
注: 允许使用缩写
 
命令               说明
------------------------------------------------------------------------------
ADD_FILE              向转储文件集中添加转储文件。
CONTINUE_CLIENT       返回到记录模式。如果处于空闲状态, 将重新启动作业。
EXIT_CLIENT           退出客户机会话并使作业处于运行状态。
FILESIZE              后续 ADD_FILE 命令的默认文件大小 (字节)。
HELP                  总结交互命令。
KILL_JOB              分离和删除作业。
PARALLEL              更改当前作业的活动 worker 的数目。
                      PARALLEL=<worker 的数目>。
START_JOB             启动/恢复当前作业。
STATUS                在默认值 (0) 将显示可用时的新状态的情况下,
                      要监视的频率 (以秒计) 作业状态。
                      STATUS[=interval]
STOP_JOB              顺序关闭执行的作业并退出客户机。
                      STOP_JOB=IMMEDIATE 将立即关闭
                      数据泵作业。
1）ATTACH
该选项用于在客户会话与已存在导出作用之间建立关联.语法如下
ATTACH=[schema_name.]job_name
Schema_name用于指定方案名,job_name用于指定导出作业名.注意,如果使用ATTACH选项在命令行除了连接字符串和ATTACH选项外,不能指定任何其他选项,示例如下:
Expdp scott/tiger ATTACH=scott.export_job
2） CONTENT
该选项用于指定要导出的内容.默认值为ALL
CONTENT={ALL | DATA_ONLY | METADATA_ONLY}
当设置CONTENT为ALL 时,将导出对象定义及其所有数据.为DATA_ONLY时,只导出对象数据,为METADATA_ONLY时,只导出对象定义
Expdp scott/tiger DIRECTORY=dumpDUMPFILE=a.dump
CONTENT=METADATA_ONLY
3） DIRECTORY
指定转储文件和日志文件所在的目录
DIRECTORY=directory_object
Directory_object用于指定目录对象名称.需要注意,目录对象是使用CREATE DIRECTORY语句建立的对象,而不是OS 目录
Expdp scott/tiger DIRECTORY=dumpDUMPFILE=a.dump
建立目录:
SQL> createdirectory dump_dir as 'd:\dump';
目录已创建。
SQL> grantread,write on directory dump_dir to scott;
授权成功。
查询创建了那些子目录:
SELECT * FROM dba_directories;
4） DUMPFILE
用于指定转储文件的名称,默认名称为expdat.dmp
DUMPFILE=[directory_object:]file_name [,….]
Directory_object用于指定目录对象名,file_name用于指定转储文件名.需要注意,如果不指定directory_object,导出工具会自动使用DIRECTORY选项指定的目录对象
Expdp scott/tiger DIRECTORY=dump1DUMPFILE=dump2:a.dmp
5.）ESTIMATE
指定估算被导出表所占用磁盘空间分方法.默认值是BLOCKS
EXTIMATE={BLOCKS | STATISTICS}
设置为BLOCKS时,oracle会按照目标对象所占用的数据块个数乘以数据块尺寸估算对象占用的空间,设置为STATISTICS时,根据最近统计值估算对象占用空间
Expdp scott/tiger TABLES=empESTIMATE=STATISTICS
DIRECTORY=dump DUMPFILE=a.dump
6.）EXTIMATE_ONLY
指定是否只估算导出作业所占用的磁盘空间,默认值为N
EXTIMATE_ONLY={Y | N}
设置为Y时,导出作用只估算对象所占用的磁盘空间,而不会执行导出作业,为N时,不仅估算对象所占用的磁盘空间,还会执行导出操作.
Expdp scott/tiger ESTIMATE_ONLY=yNOLOGFILE=y
7.）EXCLUDE
该选项用于指定执行操作时释放要排除对象类型或相关对象
EXCLUDE=object_type[:name_clause] [,….]
Object_type用于指定要排除的对象类型,name_clause用于指定要排除的具体对象.EXCLUDE和INCLUDE不能同时使用
Expdp scott/tiger DIRECTORY=dumpDUMPFILE=a.dup EXCLUDE=VIEW
8）FILESIZE
指定导出文件的最大尺寸,默认为0,(表示文件尺寸没有限制)
9. FLASHBACK_SCN
指定导出特定SCN时刻的表数据
FLASHBACK_SCN=scn_value
Scn_value用于标识SCN值.FLASHBACK_SCN和FLASHBACK_TIME不能同时使用
Expdp scott/tiger DIRECTORY=dumpDUMPFILE=a.dmp
FLASHBACK_SCN=358523
10）FLASHBACK_TIME
指定导出特定时间点的表数据
FLASHBACK_TIME=”TO_TIMESTAMP(time_value)”
Expdp scott/tiger DIRECTORY=dumpDUMPFILE=a.dmp FLASHBACK_TIME=
“TO_TIMESTAMP(’25-08-200414:35:00’,’DD-MM-YYYYHH24:MI:SS’)”
11）FULL
指定数据库模式导出,默认为N
FULL={Y | N}
为Y时,标识执行数据库导出.
12）HELP
指定是否显示EXPDP命令行选项的帮助信息,默认为N
当设置为Y时,会显示导出选项的帮助信息.
Expdp help=y
13）INCLUDE
指定导出时要包含的对象类型及相关对象
INCLUDE = object_type[:name_clause] [,… ]
14）JOB_NAME
指定要导出作用的名称,默认为SYS_XXX
JOB_NAME=jobname_string
15）LOGFILE
指定导出日志文件文件的名称,默认名称为export.log
LOGFILE=[directory_object:]file_name
Directory_object用于指定目录对象名称,file_name用于指定导出日志文件名.如果不指定directory_object.导出作用会自动使用DIRECTORY的相应选项值.
Expdp scott/tiger DIRECTORY=dumpDUMPFILE=a.dmp logfile=a.log
16）NETWORK_LINK
指定数据库链名,如果要将远程数据库对象导出到本地例程的转储文件中,必须设置该选项.
17）NOLOGFILE
该选项用于指定禁止生成导出日志文件,默认值为N.
18）PARALLEL
指定执行导出操作的并行进程个数,默认值为1
19）PARFILE
指定导出参数文件的名称
PARFILE=[directory_path] file_name
20）QUERY
用于指定过滤导出数据的where条件
QUERY=[schema.] [table_name:] query_clause
Schema用于指定方案名,table_name用于指定表名,query_clause用于指定条件限制子句.QUERY选项不能与CONNECT=METADATA_ONLY,EXTIMATE_ONLY,TRANSPORT_TABLESPACES等选项同时使用.
Expdp scott/tiger directory=dumpdumpfiel=a.dmp
Tables=emp query=’WHERE deptno=20’
21）SCHEMAS
该方案用于指定执行方案模式导出,默认为当前用户方案.
22）STATUS
指定显示导出作用进程的详细状态,默认值为0
23）TABLES
指定表模式导出
TABLES=[schema_name.]table_name[:partition_name][,…]
Schema_name用于指定方案名,table_name用于指定导出的表名,partition_name用于指定要导出的分区名.
24）TABLESPACES
指定要导出表空间列表
25）TRANSPORT_FULL_CHECK
该选项用于指定被搬移表空间和未搬移表空间关联关系的检查方式,默认为N.
当设置为Y时,导出作用会检查表空间直接的完整关联关系,如果表空间所在表空间或其索引所在的表空间只有一个表空间被搬移,将显示错误信息.当设置为N时,导出作用只检查单端依赖,如果搬移索引所在表空间,但未搬移表所在表空间,将显示出错信息,如果搬移表所在表空间,未搬移索引所在表空间,则不会显示错误信息.
26）TRANSPORT_TABLESPACES
指定执行表空间模式导出
27）VERSION
指定被导出对象的数据库版本,默认值为COMPATIBLE.
VERSION={COMPATIBLE | LATEST |version_string}
为COMPATIBLE时,会根据初始化参数COMPATIBLE生成对象元数据;为LATEST时,会根据数据库的实际版本生成对象元数据.version_string用于指定数据库版本字符串.
 
四、EXPDP用法
使用EXPDP工具时,其转储文件只能被存放在DIRECTORY对象对应的OS目录中,而不能直接指定转储文件所在的OS目录.因此,使用EXPDP工具时,必须首先建立DIRECTORY对象.并且需要为数据库用户授予使用DIRECTORY对象权限.
CREATE DIRECTORY dump_dir AS ‘c:\emp’;
GRANT READ, WRITE ON DIRECTORY dump_dir TO scott;</div>
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
				<div class="postDesc">时间 @ <span id="post-date">2015-11-13 09:24</span> <a href="#">/*作者*/</a> 阅读(<span id="post_view_count">93</span>) 评论(<span id="post_comment_count">0</span>) 
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
							<img src="${ctxStatic}/front/images/20150809180411.png" class="author_avatar" width="200px" height="200px" alt=""></a>
								<div id="author_profile_detail" class="author_profile_info">
									<a href="">Hotusm</a><br>
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
Copyright ©2015 /*梦里花落知多少*/
	</div><!--end: footer -->
</div><!--end: home 自定义的最大容器 -->


</body></html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>无标题文档</title>
<link href="${ctxStatic}/sys/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctxStatic}/sys/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctxStatic}/sys/js/jquery.js"></script>
<script type="text/javascript" src="${ctxStatic}/sys/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="${ctxStatic}/sys/js/select-ui.min.js"></script>
<script type="text/javascript" charset="utf-8" src="${ctxStatic}/ueditor1_4_3-utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${ctxStatic}/ueditor1_4_3-utf8-jsp/ueditor.all.js"></script>
<link rel="stylesheet" type="text/css" href="${ctxStatic}/ueditor1_4_3-utf8-jsp/themes/default/css/ueditor.css" />
<script type="text/javascript">
$(document).ready(function(){
	var ue = UE.getEditor("content", {
	    //关闭字数统计
	    wordCount:true,
	    maximumWords:2000,
	    autoHeightEnabled: true,
	    //关闭elementPath
	    elementPathEnabled:false,
	    //默认的编辑区域高度
	    initialFrameHeight:300,
	    initialFrameWidth:750
	    //更多其他参数，请参考ueditor.config.js中的配置项
	});
	
	
});



</script>
  
<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">文章管理</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    <div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">发布博客</a></li> 
    <li><a href="#tab2">博客列表</a></li> 
  	</ul>
    </div> 
    
    <form id="detailForm" method="post" action="${ctx}/cms/save">
  	<div id="tab1" class="tabson">
    <ul class="forminfo">
    <li><label>博客名称<b>*</b></label><input name="title" type="text" class="dfinput" value=""  style="width:518px;"/></li>
   
    <li><label>博客分类<b>*</b></label>  
    

    <div class="vocation">
    <select class="select1" name="category.id">
    <option value="001">Java技术</option>
    <option value="002">.net技术</option>
    <option value="003">数据库技术</option>
    <option value="004">安卓技术</option>
    <option value="005">IOS技术</option>
    <option value="006">WEB前端技术</option>
    </select>
    </div>
    
    </li>
    <li>
    
    	<textarea id="content" name="content"></textarea>
    	<input type="hidden" value=""/>
    	<li><label>&nbsp;</label><input name="" type="submit" class="btn" value="马上发布"/></li>
	
    
    </li>
    </form>
    </ul>
    
    </div> 
    
  	<div id="tab2" class="tabson">
    
    <ul class="seachform">
    
    <li><label>博客名称</label><input name="" type="text" class="scinput" /></li>
    
    
    <li><label>博客分类</label>  
    <div class="vocation">
	<select class="select1">
	<option>全部</option>
    <option>Java技术</option>
    <option>.net技术</option>
    <option>数据库技术</option>
    <option>安卓技术</option>
    <option>IOS技术</option>
    <option>WEB前端技术</option>
    </select>
    </div>
    </li>
    
    <li><label>&nbsp;</label><input name="" type="button" class="scbtn" value="查询"/></li>
    
    </ul>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>标题<i class="sort"><img src="${ctxStatic}/sys/images/px.gif" /></i></th>
        <th>发布时间</th>
        <th>最后更新时间</th>
        <th>阅读</th>
        <th>评论</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${articles}" var="item">
        <tr>
        <td><a href="${ctx}/f/articleView?articleId=${item.id}" target="_blank">${item.title}</a></td>
        <td>${item.createDate}</td>
        <td>${item.updateDate}</td>
        <td>${item.hits}</td>
        <td>2</td>
        <td><a href="#" class="tablelink">编辑</a>     <a href="#" class="tablelink"> 删除</a></td>
        </tr>
        </c:forEach>
    
        </tbody>
    </table>
   
    </div>  
       
	</div> 
 
	<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
    
    
    
    
    
    </div>


</body>

</html>

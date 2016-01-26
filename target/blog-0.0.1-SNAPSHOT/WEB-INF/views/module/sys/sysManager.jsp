<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${ctxStatic}/sys/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctxStatic}/sys/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctxStatic}/sys/js/jquery.js"></script>
<script type="text/javascript" src="${ctxStatic}/sys/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="${ctxStatic}/sys/js/select-ui.min.js"></script>
<script type="text/javascript" src="${ctxStatic}/sys/editor/kindeditor.js"></script>
<script type="text/javascript" src="${ctxStatic}/sys/editor/tiny.js"></script>
<script type="text/javascript" src="${ctxStatic}/ckeditor4.5/ckeditor.js"></script>
<script type="text/javascript">
    var editor = null;
    window.onload = function() {
        editor = CKEDITOR.replace( 'content', {
            customConfig:'${contextPath}/ckeditor4.1/jwc_config.js'
        });
        CKFinder.setupCKEditor( editor, '${contextPath}/ckfinder2.3.1/' );
    };
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
    
  	<div id="tab1" class="tabson">
    <ul class="forminfo">
    <li><label>博客名称<b>*</b></label><input name="" type="text" class="dfinput" value=""  style="width:518px;"/></li>
   
    <li><label>博客分类<b>*</b></label>  
    

    <div class="vocation">
    <select class="select1">
    <option>Java技术</option>
    <option>.net技术</option>
    <option>数据库技术</option>
    <option>安卓技术</option>
    <option>IOS技术</option>
    <option>WEB前端技术</option>
    </select>
    </div>
    
    </li>
    <li>
    <form id="detailForm" method="post">
    	<textarea id="content" name="content" cols="40"></textarea>
	</form>
    
    </li>
    <li><label>&nbsp;</label><input name="" type="button" class="btn" value="马上发布"/></li>
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
        <th>编号<i class="sort"><img src="${ctxStatic}/sys/images/px.gif" /></i></th>
        <th>发布时间</th>
        <th>最后更新时间</th>
        <th>阅读</th>
        <th>评论</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr>
        <td>王金平幕僚：马英九声明字字见血 人活着没意思</td>
        <td>2013-09-09 15:05</td>
        <td>2013-09-09 15:05</td>
        <td>20</td>
        <td>2</td>
        <td><a href="#" class="tablelink">编辑</a>     <a href="#" class="tablelink"> 删除</a></td>
        </tr> 
        
        <tr>
        <td>温州19名小学生中毒流鼻血续：周边部分企业关停</td>
        <td>2013-09-08 14:02</td>
        <td>2013-09-08 14:02</td>
        <td>20</td>
        <td>2</td>
        <td><a href="#" class="tablelink">编辑</a>     <a href="#" class="tablelink">删除</a></td>
        </tr>
        
        <tr>
        <td>社科院:电子商务促进了农村经济结构和社会转型</td>
        <td>2013-09-07 13:16</td>
        <td>2013-09-07 13:16</td>
        <td>20</td>
        <td>2</td>
        <td><a href="#" class="tablelink">编辑</a>     <a href="#" class="tablelink">删除</a></td>
        </tr>
        
        <tr>
        <td>江西&quot;局长违规建豪宅&quot;：局长检讨</td>
        <td>2013-09-06 10:36</td>
        <td>2013-09-06 10:36</td>
        <td>20</td>
        <td>2</td>
        <td><a href="#" class="tablelink">编辑</a>     <a href="#" class="tablelink">删除</a></td>
        </tr>
        
        <tr>
        <td>温州19名小学生中毒流鼻血续：周边部分企业关停</td>
        <td>2013-09-08 14:02</td>
        <td>2013-09-08 14:02</td>
        <td>20</td>
        <td>2</td>
        <td><a href="#" class="tablelink">编辑</a>     <a href="#" class="tablelink">删除</a></td>
        </tr>
    
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

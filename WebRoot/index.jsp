<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	
  </head>
  
  <body style="font-family:Microsoft YaHei">
  	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath}/js/ajax.js"></script>
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css" type="text/css" />
  	<div class="top_container"></div>
  	<div id="container">
	    <div id="text_container">
	    	<div id="div"></div>
	    	<div class="page">
	    		<div class="page_s">
	    			<span class="next_page">
						<input class="btn" type="submit" value="next page">
					</span>
	    		</div>
	    	</div>
	    </div>
	    
	    <div id="tran"></div>
  	</div>
  </body>
</html>

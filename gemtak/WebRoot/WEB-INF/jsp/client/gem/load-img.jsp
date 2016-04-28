<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />


					<img src="${ctx }/resources/${model}/hbx/001.jpg" width="100%" height="100%" 
					class="reel change"
				   	id="image"
				  	data-images="${ctx }/resources/1024/${model}/###.jpg"
				 	data-frames="200"
				  	data-footage="50"
				  	data-cw="true"
				  	data-orbital="0"
				  	data-inversed="true"
				  	data-speed="0.1"
					data-revolution="800"
					data-scrollable="true"
					data-cursor="hand"
					data-delay="1"
					data-timeout="1"/>
	<script type="text/javascript">
	$(function(){
		GetArgsFromHref();
	});

	 function GetArgsFromHref() 
	 { 
		$("#image").prop("src","${ctx }/resources/1024/${model}/001.jpg");
		$("#image").attr("data-images","${ctx }/resources/1024/${model}/###.jpg");
	 } 
 		
	</script>
	<script src='${ctx }/resources/reel/js/jquery.bavlo.js' type='text/javascript'></script>


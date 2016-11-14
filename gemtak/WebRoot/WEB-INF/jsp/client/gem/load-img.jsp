<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />


					<img src="http://gemtakimg.b0.upaiyun.com/Gemtak/${gem.url_360 }/${gem.is_cover}!max" width="100%" height="100%" 
					class="reel change"
				   	id="image"
				  	data-images="http://gemtakimg.b0.upaiyun.com/Gemtak/${gem.url_360 }/#####.jpg!max"
				 	data-frames="200"
				  	data-footage="50"
				  	data-cw="false"
				  	data-orbital="0"
				  	data-inversed="true"
				  	data-speed="0.08"
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
		$("#image").prop("src","http://gemtakimg.b0.upaiyun.com/Gemtak/${gem.url_360 }/${gem.is_cover}!max");
		$("#image").attr("data-images","http://gemtakimg.b0.upaiyun.com/Gemtak/${gem.url_360 }/#####.jpg!max");
	 } 
 		
	</script>
	<script src='${ctx }/resources/reel/js/jquery.bavlo.js' type='text/javascript'></script>


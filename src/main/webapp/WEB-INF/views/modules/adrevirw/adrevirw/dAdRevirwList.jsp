<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>adRevirw管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
<form id="start" method="get" action="dAdRevirw/save">
	<input type="hidden" name="">
	name<input type="text" name="name"><br>
	type<input type="text" name="type"><br>
	value<input type="text" name="value"><br>
	<input type="submit">
	<input type="hidden" name="id">
	<input type="hidden" name="act.taskId">
	<input type="hidden" name="act.taskName">
	<input type="hidden" name="act.taskDefKey">
	<input type="hidden" name="act.procInsId">
	<input type="hidden" name="act.procDefId">
	<input type="hidden" id="flag" name="act.flag">
</form>
</body>
</html>
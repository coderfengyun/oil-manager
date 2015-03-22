<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta charset="utf-8">
<title>石油数据管理系统->油井流入动态->产能预测</title>
<link id="bs-css" href="lib/chrisma/css/bootstrap-cerulean.css"
	rel="stylesheet">
<link href="lib/chrisma/css/opa-icons.css" rel="stylesheet">
<link href="lib/chrisma/css/charisma-app.css" rel="stylesheet">
<link href='lib/mine/css/api.css' rel='stylesheet'>
<link href="lib/dataTable/css/jquery.dataTables.css" rel="stylesheet">
<link href="lib/bootstrap/css/bootstrap-select.css" rel="stylesheet">

</head>
<body>
	<table id="wellInflowTrendTable"
		class="table table-striped table-bordered bootstrap-datatable datatable">
		<thead>
			<tr>
				<th><input type="checkbox" id="checkAll"></th>
				<th></th>
				<th><fmt:message key="wellInflowTrend.producedFluidVolume" /></th>
				<th><fmt:message key="wellInflowTrend.wellBotomFlowPressure" /></th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	<!-- 3rd party script starts! -->
	<script src="lib/jquery/script/jquery-2.1.3.min.js"></script>
	<script src="lib/jquery/script/jquery-ui.min.js"></script>
	<script src="lib/dataTable/js/jquery.dataTables.js"></script>
	<script src="lib/bootstrap/js/bootstrap-modal.js"></script>
	<script src="lib/bootstrap/js/bootstrap.min.js"></script>
	<script src="lib/bootstrap/js/bootstrap-modal.js"></script>
	<script src="lib/jqueryi18n/jquery.i18n.properties-1.0.9.js"></script>
	<script src="lib/chrisma/js/jquery.cookie.js"></script>
	<script src="lib/chrisma/js/theme.js"></script>
	<script src="lib/other/jquery.noty.packaged.min.js"></script>
	<!-- 3rd party script end! -->
	<!-- My own script start! -->
	<script src="lib/mine/script/util/base.js"></script>
	<!-- My own script end! -->
</body>
</html>
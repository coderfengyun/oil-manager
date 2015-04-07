<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta charset="utf-8">
<title>油井流入动态</title>
<link href='lib/bootstrap/css/bootstrap.min.css' rel="stylesheet">
</head>
<body>
	<fmt:bundle basename="i18n">
		<jsp:include page="lib/mine/shareControl/navigateBar.jsp"></jsp:include>
		<div class="container">
			<div class="row-fluid sortable">
				<div class="box span4 ">
					<div class="box-header well" data-original-title>
						<div class="box-icon">
							<a class="btn btn-primary btn-lg btn-add"><i
								class="icon-plus">添加</i></a> <a class="btn btn-lg btn-success"
								id="updateChart"><i class="icon-list">更新曲线</i></a> <a
								class="btn btn-minimize btn-round"><i
								class="icon-chevron-up"></i></a>
						</div>
					</div>
					<div class="box-content">
						<table id="wellInflowTrendTable"
							class="table table-striped table-bordered bootstrap-datatable datatable">
							<thead>
								<tr>
									<th><fmt:message key="wellInflowTrend.jsp.number" /></th>
									<th><fmt:message key="wellInflowTrend.producedFluidVolume" /></th>
									<th><fmt:message
											key="wellInflowTrend.wellBotomFlowPressure" /></th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</div>
				</div>
				<div class="box span8">
					<div id="highchartsPlot"></div>
				</div>
			</div>
			<div id="other-modal-window">"hah"</div>
		</div>
		<!-- .container -->
	</fmt:bundle>
	<!-- 3rd party script starts! -->
	<script src="lib/jquery/script/jquery-2.1.3.min.js"></script>
	<script src="lib/jquery/script/jquery-ui.min.js"></script>
	<script src="lib/dataTable/js/jquery.dataTables.js"></script>
	<script src="lib/bootstrap/js/bootstrap.min.js"></script>
	<script src="lib/jqueryi18n/jquery.i18n.properties-1.0.9.js"></script>
	<script src="lib/other/jquery.noty.packaged.min.js"></script>
	<script src="lib/highcharts/js/highcharts.js"></script>
	<!-- 3rd party script end! -->
	<!-- My own util script start! -->
	<script src="lib/mine/script/util/base.js"></script>
	<script src="lib/mine/script/util/information.js"></script>
	<script src="lib/mine/script/util/oil.table.js"></script>
	<script src="lib/mine/script/util/modal.window.js"></script>
	<script src="lib/mine/script/util/ChartHelper.js"></script>
	<script src="lib/mine/script/util/UrlParamParser.js"></script>
	<script src="lib/mine/shareControl/navigateBar.js"></script>
	<!-- My own util script end! -->
	<!-- This page script start -->
	<script src="lib/mine/script/wellInflowTrend.js"></script>
	<!-- This page script end -->
</body>
</html>
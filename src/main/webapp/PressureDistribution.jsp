<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>压力分布计算</title>
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<fmt:bundle basename="i18n">
		<jsp:include page="lib/mine/shareControl/navigateBar.jsp"></jsp:include>
		<div class="container">
			<div class="row-fluid sortable">
				<div class="box span6">
					<div class="box-header well">
						<div class="box-icon">
							<a class="btn btn-primary btn-lg btn-add"><i
								class="icon-plus">添加</i></a> <a class="btn btn-lg btn-success"
								id="updateChart"><i class="icon-list">更新曲线</i></a> <a
								class="btn btn-primary btn-lg"><i class="icon-chevron-up"></i></a>
						</div>
					</div>
					<div class="box-content">
						<table id="wellPressureDistributionTable"
							class="table table-striped table-bordered bootstrap-datatable datatable">
							<thead>
								<tr>
									<th>序号</th>
									<th>下泵深度（m）</th>
									<th>沉没压力(MPa)</th>
									<th>充满系数</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
						<!-- box content -->
					</div>
					<!-- box span12 -->
				</div>
				<div id="sinkingPressurePlot"></div>
				<div id="fulfillCoefficientPlot"></div>
			</div>
		</div>
		<!-- /.container -->
	</fmt:bundle>
	<!--3rd Party Script Begin -->
	<script src="lib/jquery/script/jquery-2.1.3.min.js"></script>
	<script src="lib/dataTable/js/jquery.dataTables.js"></script>
	<script src="lib/bootstrap/js/bootstrap.min.js"></script>
	<script src="lib/other/jquery.noty.packaged.min.js"></script>
	<script src="lib/jqueryi18n/jquery.i18n.properties-1.0.9.js"></script>
	<script src="lib/highcharts/js/highcharts.js"></script>
	<!-- 3rd Party Script End -->
	<!-- My Own Util Start-->
	<script src="lib/mine/script/util/oil.table.js"></script>
	<script src="lib/mine/script/util/modal.window.js"></script>
	<script src="lib/mine/script/util/UrlParamParser.js"></script>
	<script src="lib/mine/script/util/information.js"></script>
	<script src="lib/mine/script/util/ChartHelper.js"></script>
	<script src="lib/mine/shareControl/navigateBar.js"></script>
	<!-- My Own Util End -->
	<!-- My Own Script Begin -->
	<script src="lib/mine/script/api.js"></script>
	<script src="lib/mine/script/pressureDistribution.js"></script>
	<!-- My Own Script End -->
</body>
</html>

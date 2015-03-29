<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>抽油杆柱设计结果</title>
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
								class="icon-plus">添加</i></a> <a
								class="btn btn-lg btn-success btn-calculate" id="updateChart">计算<i
								class="icon-list"></i></a>
						</div>
					</div>
					<!-- box-header wel -->
					<div class="box-content">
						<table id="preferredPlanBaseTable"
							class="table table-striped table-bordered bootstrap-datatable datatable">
							<thead>
								<tr>
									<th><fmt:message key="wellInflowTrend.jsp.number" /></th>
									<th><fmt:message key="RodDesign.params.pumpDepth" /></th>
									<th><fmt:message key="RodDesign.params.pumpEffeciency" /></th>
									<th><fmt:message key="RodDesign.params.systemEffeciency" /></th>
									<th><fmt:message key="RodDesign.params.production" /></th>
									<th><fmt:message key="RodDesign.params.econemicBenifits" /></th>
									<th><fmt:message key="RodDesign.params.utilization" /></th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</div>
					<!-- .box-content -->
					<div class="box-content">
						<table id="preferredPlanScoreTable"
							class="table table-striped table-bordered bootstrap-datatable datatable">
							<thead>
								<tr>
									<th><fmt:message key="wellInflowTrend.jsp.number" /></th>
									<th><fmt:message key="RodDesign.params.pumpDepth" /></th>
									<th><fmt:message key="RodDesign.params.score" /></th>
								</tr>
							</thead>
						</table>
					</div>
					<!-- .box-content -->
				</div>
				<!-- box span6 -->
			</div>
			<!-- row-fluid sortable -->
		</div>
		<!-- container -->
	</fmt:bundle>
	<!--3rd Party Script Begin -->
	<script src="lib/jquery/script/jquery-2.1.3.min.js"></script>
	<script src="lib/dataTable/js/jquery.dataTables.js"></script>
	<script src="lib/bootstrap/js/bootstrap.min.js"></script>
	<script src="lib/other/jquery.noty.packaged.min.js"></script>
	<script src="lib/jqueryi18n/jquery.i18n.properties-1.0.9.js"></script>
	<!--3rd Party Script End -->

	<!-- My Own Util Start-->
	<script src="lib/mine/script/util/oil.table.js"></script>
	<script src="lib/mine/script/util/UrlParamParser.js"></script>
	<script src="lib/mine/script/util/information.js"></script>
	<script src="lib/mine/script/util/modal.window.js"></script>
	<script src="lib/mine/script/util/ChartHelper.js"></script>
	<script src="lib/mine/shareControl/navigateBar.js"></script>
	<!-- My Own Util End-->

	<!-- My Own Script Begin -->
	<script src="lib/mine/script/PreferredPlan.js"></script>
	<!-- My Own Script End -->
</body>
</html>
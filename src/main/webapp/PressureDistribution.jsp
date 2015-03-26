<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<div class="row-fluid sortable">
			<div class="box span12 ">
				<div class="box-header well" data-original-title>
					<div class="box-icon">
						<a class="btn btn-primary btn-lg"><i class="icon-plus">增加压力分布参数</i></a>
						<a class="btn btn-round" id="agentList"><i class="icon-list"></i></a>
						<a class="btn btn-minimize btn-round"><i
							class="icon-chevron-up"></i></a>
					</div>
				</div>
				<div class="box-content">
					<table id="wellBaseDataTable"
						class="table table-striped table-bordered bootstrap-datatable datatable">
						<thead>
							<tr>
								<th><input type="checkbox" id="checkAll"></th>
								<th></th>
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
			<!-- fluid sortable -->
		</div>
	</fmt:bundle>
	<!--3rd Party Script Begin -->
	<script src="lib/jquery/script/jquery-2.1.3.min.js"></script>
	<script src="lib/bootstrap/js/bootstrap.min.js"></script>
	<!-- 3rd Party Script End -->
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta charset="utf-8">
<title>杏北开发区抽油泵合理沉没压力研究</title>
<link href='lib/bootstrap/css/bootstrap.min.css' rel="stylesheet">

</head>
<body style="border: 0px solid red;">
	<fmt:bundle basename="i18n">
		<jsp:include page="lib/mine/shareControl/navigateBar.jsp"></jsp:include>
		<div class="container">
			<div class="row-fluid sortable">
				<div class="box span12 ">
					<div class="box-header well" data-original-title>
						<div class="span8"></div>
						<div class="box-icon span4">
							<a class="btn btn-primary btn-lg btn-add">添加<i
								class="icon-plus"></i></a> <a class="btn btn-round" id="agentList"><i
								class="icon-list"></i></a> <a class="btn btn-minimize btn-round"><i
								class="icon-chevron-up"></i></a>
						</div>
					</div>
					<div class="box-content">
						<table id="wellBaseDataTable"
							class="table table-striped table-bordered bootstrap-datatable datatable">
							<thead>
								<tr>
									<th><input type="checkbox" id="checkAll"></th>
									<th><fmt:message key="Well_Depth" /></th>
									<th><fmt:message key="casingOutterDiameter" /></th>
									<th><fmt:message key="casingInnerDiameter" /></th>
									<th><fmt:message key="reservoirTemperature" /></th>
									<th><fmt:message key="tubingOutterDiameter" /></th>
									<th><fmt:message key="tubingInnerDiameter" /></th>
									<th><fmt:message key="allowed-operation" /></th>
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
			<div class="modal fade" id="WellBaseDataParams">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">x</button>
							<h3>
								<fmt:message key="index_add_well_base_data" />
							</h3>
						</div>
						<div class="modal-body">
							<div class="control-group">
								<label class="control-label" for="focusedInput"><fmt:message
										key="Well_Depth" /></label> <input class="input-xlarge focused"
									id="wellDepth" type="text" value="">
							</div>
							<div class="control-group">
								<label class="control-label" for="focusedInput"><fmt:message
										key="casingOutterDiameter" /></label> <input
									class="input-xlarge focused" id="casingOutterDiameter"
									type="text" value="">
							</div>
							<div class="control-group">
								<label class="control-label" for="focusedInput"><fmt:message
										key="casingInnerDiameter" /></label> <input
									class="input-xlarge focused" id="casingInnerDiameter"
									type="text" value="">

							</div>
							<div class="control-group">
								<label class="control-label" for="focusedInput"><fmt:message
										key="reservoirTemperature" /></label> <input
									class="input-xlarge focused" id="reservoirTemperature"
									type="text" value="">
							</div>
							<div class="control-group">
								<label class="control-label" for="focusedInput"><fmt:message
										key="tubingOutterDiameter" /></label> <input
									class="input-xlarge focused" id="tubingOutterDiameter"
									type="text" value="">
								<div id='tubingOutterDiameter_error'
									style='display: none; color: red'></div>
							</div>
							<div class="control-group">
								<label class="control-label" for="focusedInput"><fmt:message
										key="tubingInnerDiameter" /></label> <input
									class="input-xlarge focused" id="tubingInnerDiameter"
									type="text" value="">
								<div id='tubingInnerDiameter_error'
									style='display: none; color: red'></div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary"
								data-dismiss="modal" onClick="submitWellBaseData()">
								<fmt:message key="well_base_data_add_submit" />
							</button>
							<button type="button" class="btn btn-primary"
								data-dismiss="modal">
								<fmt:message key="well_base_data_add_cancel" />
							</button>
						</div>
					</div>
				</div>
				<!-- .modal-content -->
			</div>
			<!-- .modal-dialog -->
			<div id="other-modal-window"></div>
		</div>
		<!-- container -->
	</fmt:bundle>

	<!-- scripts start -->

	<script src="lib/jquery/script/jquery-2.1.3.min.js"></script>
	<script src="lib/jquery/script/jquery-ui.min.js"></script>
	<script src="lib/dataTable/js/jquery.dataTables.js"></script>
	<script src="lib/bootstrap/js/bootstrap.min.js"></script>
	<script src="lib/jqueryi18n/jquery.i18n.properties-1.0.9.js"></script>
	<script src="lib/other/jquery.noty.packaged.min.js"></script>

	<script src="lib/mine/script/util/base.js"></script>
	<script src="lib/mine/script/util/information.js"></script>
	<script src="lib/mine/script/util/oil.table.js"></script>
	<script src="lib/mine/script/util/modal.window.js"></script>
	<script src="lib/mine/script/util/UrlParamParser.js"></script>

	<script src="lib/mine/script/model/WellProductDataModel.js"></script>
	<script src="lib/mine/script/model/FluidPhysicalParameterModel.js"></script>
	<script src="lib/mine/script/model/WellDesignParameterModel.js"></script>
	<script src="lib/mine/script/model/RodStringDesignParameterModel.js"></script>
	<script src="lib/mine/script/model/RodStructureParameterModel.js"></script>
	<script src="lib/mine/script/model/IndicatorWeightDistributionModel.js"></script>
	<script src="lib/mine/script/index.js"></script>
</body>
</html>

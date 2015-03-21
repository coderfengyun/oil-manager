<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta charset="utf-8">
<title>石油数据管理系统</title>
<link id="bs-css" href="lib/chrisma/css/bootstrap-cerulean.css"
	rel="stylesheet">
<link href="lib/chrisma/css/opa-icons.css" rel="stylesheet">
<link href="lib/chrisma/css/charisma-app.css" rel="stylesheet">
<link rel="shortcut icon" href="images/bench4q.png">
<link href='lib/mine/css/api.css' rel='stylesheet'>
<link href="lib/dataTable/css/jquery.dataTables.css" rel="stylesheet">
<link href="lib/bootstrap/css/bootstrap-select.css" rel="stylesheet">
</head>
<body>
	<fmt:bundle basename="i18n">
		<h2>Hello World!</h2>
		<div class="row-fluid sortable">
			<div class="box span12 ">
				<div class="box-header well" data-original-title>
					<h2>
						<i><fmt:message key="well_base_data" /></i>
					</h2>
					<div class="box-icon">
						<a class="btn btn-setting btn-round"><i class="icon-plus"></i></a>
						<a class="btn btn-round" id="agentList"><i class="icon-list"></i></a>
						<a class="btn btn-minimize btn-round"><i
							class="icon-chevron-up"></i></a>
						<!-- <select class='selectpicker'
							onchange='onSelectChange(this.value)'>
							<option>operations</option>
							<option value="WellProductData">油井生产数据</option>
							<option value="FluidPhysicalParameter">流体物性参数</option>
							<option value="WellDesignParameter">油井设计工作参数</option>
							<option value="RodStringDesignParameter">抽油杆柱设计工作参数</option>
							<option value="RodStructureParameter">抽油杆结构参数</option>
							<option value="IndicatorWeightDistribution">指标权重分配</option>
						</select> -->
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
		<div class="modal hide fade" id="WellBaseDataParams">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">x</button>
				<h3>
					<fmt:message key="index_add_well_base_data" />
				</h3>
			</div>
			<div class="modal-body">
				<form class="form-horizontal">
					<fieldset>
						<div class="control-group">
							<label class="control-label" for="focusedInput"><fmt:message
									key="Well_Depth" /></label>
							<div class="controls">
								<input class="input-xlarge focused" id="wellDepth" type="text"
									value="">
								<div id='Well_Depth_error' style='display: none; color: red'>
								</div>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="focusedInput"><fmt:message
									key="casingOutterDiameter" /></label>
							<div class="controls">
								<input class="input-xlarge focused" id="casingOutterDiameter"
									type="text" value="">
								<div id='casingOutterDiameter_error'
									style='display: none; color: red'></div>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="focusedInput"><fmt:message
									key="casingInnerDiameter" /></label>
							<div class="controls">
								<input class="input-xlarge focused" id="casingInnerDiameter"
									type="text" value="">
								<div id='casingInnerDiameter_error'
									style='display: none; color: red'></div>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="focusedInput"><fmt:message
									key="reservoirTemperature" /></label>
							<div class="controls">
								<input class="input-xlarge focused" id="reservoirTemperature"
									type="text" value="">
								<div id='reservoirTemperature_error'
									style='display: none; color: red'></div>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="focusedInput"><fmt:message
									key="tubingOutterDiameter" /></label>
							<div class="controls">
								<input class="input-xlarge focused" id="tubingOutterDiameter"
									type="text" value="">
								<div id='tubingOutterDiameter_error'
									style='display: none; color: red'></div>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="focusedInput"><fmt:message
									key="tubingInnerDiameter" /></label>
							<div class="controls">
								<input class="input-xlarge focused" id="tubingInnerDiameter"
									type="text" value="">
								<div id='tubingInnerDiameter_error'
									style='display: none; color: red'></div>
							</div>
						</div>
					</fieldset>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal"
					onClick="submitWellBaseData()">
					<fmt:message key="well_base_data_add_submit" />
				</button>
				<button type="button" class="btn btn-primary" data-dismiss="modal">
					<fmt:message key="well_base_data_add_cancel" />
				</button>
			</div>
		</div>
		<div id="other-modal-window">"hah"</div>
	</fmt:bundle>
	<!-- scripts start -->

	<script src="lib/jquery/script/jquery-2.1.3.min.js"></script>
	<script src="lib/jquery/script/jquery-ui.min.js"></script>
	<script src="lib/dataTable/js/jquery.dataTables.js"></script>
	<script src="lib/bootstrap/js/bootstrap-modal.js"></script>
	<script src="lib/bootstrap/js/bootstrap.min.js"></script>
	<script src="lib/bootstrap/js/bootstrap-modal.js"></script>
	<script src="lib/jqueryi18n/jquery.i18n.properties-1.0.9.js"></script>
	<script src="lib/chrisma/js/jquery.cookie.js"></script>
	<script src="lib/chrisma/js/theme.js"></script>
	<script src="lib/mine/script/base.js"></script>
	<script src="lib/other/jquery.noty.packaged.min.js"></script>
	<script src="lib/mine/script/uiFactory.js"></script>
	<script src="lib/mine/script/oil.table.js"></script>
	<script src="lib/mine/script/util/modal.window.js"></script>

	<script src="lib/mine/script/model/WellProductDataModel.js"></script>
	<script src="lib/mine/script/model/FluidPhysicalParameterModel.js"></script>
	<script src="lib/mine/script/model/WellDesignParameterModel.js"></script>
	<script src="lib/mine/script/model/RodStringDesignParameterModel.js"></script>
	<script src="lib/mine/script/model/RodStructureParameterModel.js"></script>
	<script src="lib/mine/script/model/IndicatorWeightDistributionModel.js"></script>
	<script src="lib/mine/script/index.js"></script>
	<script src="lib/other/jquery.noty.packaged.min.js"></script>
</body>
</html>

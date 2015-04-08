function PressureDistribution() {
}

PressureDistribution.prototype = function() {
	var table = $("#wellPressureDistributionTable").DataTable();
	var urlParamParser = new UrlParamParser();
	var wellId = urlParamParser.getParamFromUri('wellId');
	var chartHelper = new ChartHelper();
	var sinkingPressureOptions = chartHelper.buildOptions(
			'sinkingPressurePlot', '沉没压力与下泵深度关系曲线', '下泵深度(m)', '沉没压力(MPa)');
	var sinkingPressureChart = new Highcharts.Chart(sinkingPressureOptions);
	var fulfillCoefficientOptions = chartHelper.buildOptions(
			'fulfillCoefficientPlot', '沉没压力与充满系数关系曲线', '沉没压力(MPa)', '充满系数');
	var fulfillCoefficientChart = new Highcharts.Chart(
			fulfillCoefficientOptions);
	var pressureDistribution_API = new PressureDistribution_API();
	var modalWindowHelper = new ModalWindowHelper();
	var PressureDistribution_Params = new Array();
	PressureDistribution_Params[0] = "pumpDepth";
	PressureDistribution_Params[1] = "sinkingPressure";
	PressureDistribution_Params[2] = "fulfillCoefficient";

	var PressureDistribution_Labels = new Array();
	PressureDistribution_Labels[0] = "下泵深度(m)";
	PressureDistribution_Labels[1] = "沉没压力(MPa)";
	PressureDistribution_Labels[2] = "充满系数";

			appendRowToTable = function(data) {
				new OilTable().appendRowToTable(table, data);
			},

			addAWellPressureDistribution = function() {
				var paramNameValueMap = _buildParamNameValueMap();
				pressureDistribution_API.add(wellId, paramNameValueMap,
						addPressureDistributionCallBack)
			},

			_buildParamNameValueMap = function() {
				var result = new Array();
				for (var i = 0; i < PressureDistribution_Params.length; i++) {
					result[PressureDistribution_Params[i]] = _getValByDomId(PressureDistribution_Params[i]);
				}
				return result;
			},

			_getValByDomId = function(id) {
				return $("#" + id).val();
			},

			addPressureDistributionCallBack = function(rowData, response) {
				if (response == null || response == false) {
					information("Add WellInflowTrend Fails!");
				} else {
					appendRowToTable(rowData);
					information("Success!");
				}
			},

			sortByFirstColumn = function(a, b) {
				if (a[0] < b[0]) {
					return -1;
				} else if (a[0] > b[0]) {
					return 1;
				} else {
					return 0;
				}
			},

			drawAllChartWithDataInTable = function() {
				_drawChart(sinkingPressureOptions, sinkingPressureChart, 1, 2);
				_drawChart(fulfillCoefficientOptions, fulfillCoefficientChart,
						2, 3);
			},

			_drawChart = function(options, targetChart, xIndex, yIndex) {
				var rowCount = table.rows().indexes().length;
				var seriesData = options.series[0].data;
				seriesData.splice(0, rowCount - 1);
				for (var i = 0; i < rowCount; i++) {
					var data = table.row(i).data();
					seriesData.push([ data[xIndex], data[yIndex] ]);
				}
				seriesData.sort(sortByFirstColumn);
				targetChart = new Highcharts.Chart(options);
			},

			loadAll = function() {
				pressureDistribution_API.load(wellId, loadCallBack);
			},

			loadCallBack = function(data) {
				if (data == null) {
					information("Get Pressure Distribution Fails!")
				} else {
					for (var i = 0; i < data.length; i++) {
						var pressureDistribution = data[i];
						var tr = table.row
								.add(
										[
												i + 1,
												pressureDistribution.pumpDepth,
												pressureDistribution.sinkingPressure,
												pressureDistribution.fulfillCoefficient ])
								.draw().node();
						$(tr).attr("id", pressureDistribution.id);
					}
				}
			},

			pageInit = function() {
				$(".btn-add").click(
						function(e) {
							modalWindowHelper.showWith(
									'PressureDistributionParams', 'body',
									PressureDistribution_Params, null,
									PressureDistribution_Labels,
									'addAWellPressureDistribution()');
						});
				$("#updateChart").click(function(e) {
					drawAllChartWithDataInTable();
				});
				$(document).ready(function() {
					loadAll();
				});
			}

	return {
		addAWellPressureDistribution : addAWellPressureDistribution,
		pageInit : pageInit
	};
}();

var PressureDistribution_Instance = new PressureDistribution();
PressureDistribution_Instance.pageInit();
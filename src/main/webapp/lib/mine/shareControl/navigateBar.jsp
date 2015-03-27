<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle collapsed"
			data-toggle="collapse" data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="index.jsp">杏北开发区抽油泵合理沉没压力研究</a>
	</div>
	<div class="navbar-collapse collapse">
		<ul class="nav navbar-nav">
			<li><a href="index.jsp">数据准备</a></li>
			<li><a class="oil-navigate-button" href="wellInflowTrend.jsp">油井流入动态</a></li>
			<li><a class="oil-navigate-button"
				href="PressureDistribution.jsp">压力分布</a></li>
			<li><a class="oil-navigate-button" href="RodDesign.jsp">抽油杆柱设计</a></li>
			<li><a class="oil-navigate-button">帮助</a></li>
			<li><a class="oil-navigate-button">退出</a></li>
		</ul>
	</div>
	<!--/.nav-collapse -->
</div>
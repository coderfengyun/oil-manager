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
								class="icon-plus">添加</i></a> <a class="btn btn-lg btn-success"
								id="updateChart">更新曲线<i class="icon-list"></i></a> <a
								class="btn btn-primary btn-lg"><i class="icon-chevron-up"></i></a>
						</div>
					</div>
					<!-- box-header wel -->
				</div>
				<!-- box span6 -->
			</div>
			<!-- row-fluid sortable -->
		</div>
		<!-- container -->
	</fmt:bundle>
</body>
</html>
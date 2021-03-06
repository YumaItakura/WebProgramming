<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<title>Delete</title>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">

<a class="navbar-brand" href="#">${userInfo.name} さん</a>
<form class="form-inline my-2 my-lg-0">
<a class="btn btn-outline-success my-2 my-sm-0" href="LogoutServlet">Logout</a>
</form>

</nav>

<div class="text-center"><h1>ユーザ削除確認</h1></div>

<div class="container">
	<form action="UserDeleteServlet" method="post">
		<div class="form-group row">
			<h3 class="col-sm-12">ログインID ・ ${user.loginId}</h3>
			<input type="hidden" name="loginId" value="${user.loginId}">
		</div>

		<div class="form-group row">
			<h3 class="col-sm-12">を本当に消去してよろしいでしょうか。</h3>
		</div>

		<div class="form-group row">

			<div class="col-sm-6"> <a class="btn btn-secondary" href="UserListServlet">キャンセル</a></div>
			<div class="col-sm-4"> <button type="submit" class="btn btn-secondary">ＯＫ</button></div>
		</div>
	</form>
</div>

</body>
</html>
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

<link rel="stylesheet" href="style.css">
<title>login</title>

</head>
<body>
<div class="container">
		<h1 class= "text-center">ログイン画面</h1>

		<c:if test="${errMsg != null}">
			<div class="alert alert-danger" >
			  ${errMsg}
			</div>
		</c:if>
<form action="LoginServlet" method="post">
			<div class="form-group row">
				<h3 class="col-sm-2">ログインID </h3>
				 <input type="text" class="form-control col-sm-6" name="loginId" >
			</div>

			<div class="form-group row">
				<h3 class="col-sm-2">パスワード </h3>
				 <input type="password" class="form-control col-sm-6" name="password">
			</div>

		<div class="text-center">
			<button type="submit" class="btn btn-secondary">ログイン</button>
		</div>
</form>
</div>

</body>
</html>
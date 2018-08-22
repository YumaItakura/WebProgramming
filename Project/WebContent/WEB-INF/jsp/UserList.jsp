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
<title>list</title>
</head>
<body>
 <nav class="navbar navbar-expand-md navbar-dark bg-dark">

<a class="navbar-brand" href="#">${userInfo.name} さん</a>
<form class="form-inline my-2 my-lg-0">
<a class="btn btn-outline-success my-2 my-sm-0" href="LogoutServlet">Logout</a>
</form>

</nav>
<div class="text-center"><h1>ユーザ一覧</h1></div>

<div class="text-right">
	<a class="btn btn-outline-success my-2 my-sm-0 " href="UserRegistServlet">新規登録</a>
</div>

<div class="container">
	<form action="UserListServlet" method="post">
		<div class="form-group row">
			<h3 class="col-sm-2">ログインID </h3>
			 <input type="text" class="form-control col-sm-6" name="loginId">
		</div>
		<div class="form-group row">
			<h3 class="col-sm-2">ユーザ名 </h3>
			 <input type="text" class="form-control col-sm-6" name="userName">
		</div>
		<div class="form-group row">
			<h3 class="col-sm-2">生年月日 </h3>
			 <input type="date" class="form-control col-sm-3" name="birtDate1">
			 <h3 class="col-sm-1">~</h3>
			 <input type="date" class="form-control col-sm-3" name="birtDate2">
		</div>

		<div class="text-right">
			<button type="submit" class="btn btn-secondary">検索</button>
		</div>
	</form>



	<table class="table table-bordered">
  <thead class="thead-light">
    <tr>
      <th scope="col">ログインID</th>
      <th scope="col">ユーザ名</th>
      <th scope="col">生年月日</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>

		<c:forEach var="User" items="${userList}" >
		    <tr>
			      <th scope="row">${User.loginId}</th>
			      <td>${User.name}</td>
			      <td>${User.birthDate}</td>
		    		<td>
			      <a class="btn btn-primary" href="UserDetailServlet?id=${User.id}">詳細</a>
			<c:if test='${userInfo.loginId.equals("admin") || userInfo.loginId.equals(User.loginId)}'>
			      <a class="btn btn-success" href="UserUpdateServlet?id=${User.id}">更新</a>
			</c:if>
			<c:if test='${userInfo.loginId.equals("admin")}'>
			      <a class="btn btn-danger" href="UserDeleteServlet?id=${User.id}">削除</a>
			</c:if>
		     	 </td>
		    </tr>
		</c:forEach>

  </tbody>
</table>


</div>
</body>
</html>
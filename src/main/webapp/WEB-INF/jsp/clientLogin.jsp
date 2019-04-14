<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>登录界面</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css">
<style>
.form {
	width: 25%;
	margin: 50px auto;
	border: 1px solid rgb(238, 238, 238);
	border-radius: 10px;
	padding: 10px;
	padding-right: 30px;
	background-color: #40e9f369
}

.user {
	width: 100%;
	height: 50px;
	line-height: 50px;
	text-align: center;
	font-size: 18px;
	font-weight: 600;
}

.message {
	width: 100%;
	height: 50px;
	line-height: 50px;
	text-align: center;
	font-size: 19px;
	font-weight: 600;
}

body {
	background-color: #2c6063;
}
</style>
</head>

<body>
	<form class="layui-form form" action="/client/home" method="post">
		<div class="user">JIMI client</div>
		<div class="message">${loginMessage }</div>
		<div class="layui-form-item">
			<label class="layui-form-label label">身份证：</label>
			<div class="layui-input-block">
				<input type="text" name="clientIdNumber" required lay-verify="required"
					placeholder="请输入账号" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">密码：</label>
			<div class="layui-input-block">
				<input type="password" name="passWord" lay-verify="pass" required
					placeholder="请输入密码" autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="formDemo">登录</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
		<div class="layui-form-item">
			<a href="/client/skp">没有开户？前往注册</a>
		</div>
	</form>
	<script src="${pageContext.request.contextPath}/resources/layui/layui.all.js"></script>
</body>

</html>
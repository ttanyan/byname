<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>注册</title>
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
	<script type="text/javascript">
		function CheckPsw2() {
			var check = false;
			var pwd1 = document.getElementById("pwd1").value;
			var pwd2 = document.getElementById("pwd2").value;
			if (pwd1 != pwd2) {
				document.getElementById("tip2").innerHTML = " 两次输入密码不一致";
				check = false;
			} else {
				document.getElementById("tip2").innerHTML = "输入正确";
				check = true;
			}
			return check;
		}
		function check() {
			var check = CheckPsw2() ;
			return check;
		}
	</script>
</head>

<body>
<form class="layui-form form" method="post" action="/client/regist"  onsubmit="return check()">
	<div class="user">开户</div>
	<div class="message">${registMessage }</div>
	<div class="layui-form-item">
		<label class="layui-form-label label">身份证：</label>
		<div class="layui-input-block">
			<input type="text" name="clientIdNumber" required lay-verify="required"
				   placeholder="请输入身份证" autocomplete="off" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label label">姓名：</label>
		<div class="layui-input-block">
			<input type="text" name="clientName" required lay-verify="required"
				   placeholder="请输入姓名" autocomplete="off" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label label">手机号码：</label>
		<div class="layui-input-block">
			<input type="number" name="clientPhone" required lay-verify="required"
				   placeholder="请输入手机号" autocomplete="off" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label label">银行卡号：</label>
		<div class="layui-input-block">
			<input type="number" name="clientAccount" required lay-verify="required"
				   placeholder="请输入手机号" autocomplete="off" class="layui-input" value="${clientAccount}">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">输入密码：</label>
		<div class="layui-input-block">
			<input  id="pwd1" type="password" name="clientPassword" required lay-verify="required" placeholder="请输入密码" autocomplete="off"
					class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">确认密码：</label>
		<div class="layui-input-block">
			<input  onchange="CheckPsw2()" id="pwd2" type="password" name="repassword" required
					lay-verify="required" placeholder="确认密码" autocomplete="off"
					class="layui-input">
			<!--用于密码验证提示-->
			<span id="tip2"></span>
		</div>
	</div>
	<div class="layui-form-item">
		<div class="layui-input-block">
			<button  class="layui-btn regist" lay-submit lay-filter="formDemo">立即提交</button>
			<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		</div>
	</div>
	<div class="layui-form-item">
		<a href="/client/login">已有账号，返回登录</a>
	</div>
</form>

<script src="${pageContext.request.contextPath}/resources/layui/layui.all.js"></script>
</body>
</html>
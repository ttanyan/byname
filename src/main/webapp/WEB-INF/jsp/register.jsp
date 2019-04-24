<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
            font-size: 23px;
            font-weight: 600;
            font-family: 楷体;
            color: red;
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
                document.getElementById("tip2").innerHTML = "两次输入密码正确";
                check = true;
            }
            return check;
        }

        function check() {
            var check = CheckPsw2();
            return check;
        }
    </script>
</head>

<body>
<form class="layui-form form" method="post" action="/register" onsubmit="return check()">
    <div class="user">用户注册</div>
    <div class="message">${registerMessage }</div>
    <div class="layui-form-item">
        <label class="layui-form-label label">学号</label>
        <div class="layui-input-block">
            <input type="number" name="number" required lay-verify="required"
                   placeholder="请输入学号" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label label">姓名</label>
        <div class="layui-input-block">
            <input type="text" name="name" required lay-verify="required"
                   placeholder="请输入姓名" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label label">学院</label>
        <div class="layui-input-block">
            <input type="text" name="college" required lay-verify="required"
                   placeholder="请输入账号" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label label">专业</label>
        <div class="layui-input-block">
            <input type="text" name="majory" required lay-verify="required"
                   placeholder="请输入账号" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <input type="radio" name="sex" value="男" title="男" checked="">
            <input type="radio" name="sex" value="女" title="女">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-block">
            <input type="text" name="email" lay-verify="email"  placeholder="请输正确的邮箱" autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">手机号</label>
        <div class="layui-input-block">
            <input type="tel" name="tel" lay-verify="required|phone"  placeholder="请输入手机号码" autocomplete="off"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">输入密码</label>
        <div class="layui-input-block">
            <input id="pwd1" type="password" name="password" required
                   lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">确认密码</label>
        <div class="layui-input-block">
            <input onchange="CheckPsw2()" id="pwd2" type="password" name="repassword" required
                   lay-verify="required" placeholder="确认密码" autocomplete="off"
                   class="layui-input">
            <!--用于密码验证提示-->
            <span id="tip2"></span>
        </div>
    </div>
    <div class="user">
            <button  class="layui-btn layui-btn-radius" lay-filter="demo1"  lay-submit="">立即提交</button>
            <button  type="reset" class="layui-btn layui-btn-primary layui-btn-radius">重置</button>
    </div>
    <div class="layui-form-item">
        <a href="/byname">已有账号，返回登录</a>
    </div>
</form>

<script src="${pageContext.request.contextPath}/resources/layui/layui.all.js"></script>
</body>
</html>
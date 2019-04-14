<%--
  Created by IntelliJ IDEA.
  User: Tanlianwang
  Date: 2018/12/26
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>ByName   ${clientName },欢迎您!</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css" media="all">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">JIMI ATM </div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    ${clientName}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                    <dd><a href="/client/exit">安全退出</a></dd>
                </dl>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">存取款</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/client/skpAddMoney">存钱</a></dd>
                        <dd><a href="/client/skpGetMoney">取钱</a></dd>
                        <dd><a href="/client/selectMoney">余额</a></dd>
                        <dd><a href="">明细1</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="http://www.jimicloud.com">关于</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">

            <form class="layui-form form" action="/client/addMoney" method="post">
                <div class="message"><h2>${addMoneyMessage }</h2></div>
                <div class="layui-form-item">
                    <label class="layui-form-label label">存入账号：</label>
                    <div class="layui-input-block">
                        <input type="text" name="clientIdNumber" required lay-verify="required"
                               placeholder="请输入金额" autocomplete="off" class="layui-input" value="${clientIdNumber}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label label">存入金额：</label>
                    <div class="layui-input-block">
                        <input type="text" name="clientMoney" required lay-verify="required"
                               placeholder="请输入金额" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">确定</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div class="layui-footer">
        © www.dlnu.edu.cn----- By Name 教师点名系统
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/layui/layui.all.js" charset="utf-8"></script>
<script>
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>

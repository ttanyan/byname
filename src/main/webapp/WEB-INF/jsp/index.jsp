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
    <title>ByName System Config</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css" media="all">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">
            大连民族大学-点名系统
        </div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="${pageContext.request.contextPath}/resources/layui/images/logo/dlnu1.jpg"
                         class="layui-nav-img">
                    ${loginUser.name}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                    <dd><a href="/exit">安全退出</a></dd>
                </dl>
            </li>
        </ul>
    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item"><a href="/client/skpAddMoney">权限管理</a></li>
                <li class="layui-nav-item"><a href="/client/skpGetMoney">角色管理</a></li>
                <li class="layui-nav-item"><a href="/client/selectMoney">用户管理</a></li>
                <li class="layui-nav-item"><a href="javascript:;">明细</a></li>
                <li class="layui-nav-item"><a href="https://blog.csdn.net/tingfengqianqu">关于作者</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <h1>${loginUser.name},欢迎您！</h1>
        </div>
    </div>

    <div class="layui-footer">
        © www.jimi.com - ATM系统
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/layui/layui.all.js" charset="utf-8"></script>
<script>
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
</body>
</html>

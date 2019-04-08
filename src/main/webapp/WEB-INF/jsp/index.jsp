<%--
  Created by IntelliJ IDEA.
  User: Tanlianwang
  Date: 2018/12/26
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>JIMI ATM   ${clientName },欢迎您!</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css" media="all">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">JIMI ATM </div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="${pageContext.request.contextPath}/resources/layui/images/dlnu.png"
                         class="layui-nav-img">
                    ${userName}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                    <dd><a href="/admin/exit">安全退出</a></dd>
                </dl>
            </li>
        </ul>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <fieldset class="layui-elem-field layui-field-title"
                      style="margin-top: 20px;">
                <legend>客户列表</legend>

            </fieldset>

            <div class="layui-form">
                <table class="layui-table">
                    <colgroup>
                        <col width="150">
                        <col width="150">
                        <col width="150">
                        <col width="150">
                        <col width="150">
                        <col width="150">
                    </colgroup>
                    <thead>
                    <tr>
                        <th>身份证</th>
                        <th>姓名</th>
                        <th>电话</th>
                        <th>卡号</th>
                        <th>余额</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="user" items="${AllUser}">
                        <tr>
                            <td>${user.clientIdNumber}</td>
                            <td>${user.clientName}</td>
                            <td>${user.clientPhone}</td>
                            <td>${user.clientAccount}</td>
                            <td>${user.clientMonye}</td>
                            <td><a href="">增添</a>&nbsp <a href="">删除</a>&nbsp <a href="">修改</a>&nbsp</td>
                        </tr>
                    </c:forEach>
                    <tr>

                    </tr>
                    </tbody>
                </table>
            </div>


        </div>
    </div>

    <div class="layui-footer">
        © www.jimi.com - ATM系统
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

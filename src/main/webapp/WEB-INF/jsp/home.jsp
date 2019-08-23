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
    <title>ByName By DLNU</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css" media="all">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header" style="height: 114px;background-color: #151b5f" >
        <div class="layui-log" >
            <img src="${pageContext.request.contextPath}/resources/layui/images/logo/dlnu.png">
        </div>
        <!--TODO-->
        <!--点名系统字样-->

        <ul class="layui-nav layui-layout-right ">
            <li class="layui-nav-item "><a href="">教师</a></li>
            <li class="layui-nav-item "><a href="">学生</a></li>
            <li class="layui-nav-item"><a href="">大数据</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">登录</a>
                <dl class="layui-nav-child">
                    <dd><a href="">教师</a></dd>
                    <dd><a href="">学生</a></dd>
                    <dd><a href="">管理员</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">关于</a></li>
        </ul>
    </div>

    <div class="layui-carousel" id="test1">
        <div carousel-item>
            <div><p class="layui-bg-green demo-carousel">在这里，你将以最直观的形式体验 layui！</p></div>
            <div><p class="layui-bg-red demo-carousel">在编辑器中可以执行 layui 相关的一切代码</p></div>
            <div><p class="layui-bg-blue demo-carousel">你也可以点击左侧导航针对性地试验我们提供的示例</p></div>
            <div><p class="layui-bg-orange demo-carousel">如果最左侧的导航的高度超出了你的屏幕</p></div>
            <div><p class="layui-bg-cyan demo-carousel">你可以将鼠标移入导航区域，然后滑动鼠标滚轮即可</p></div>
        </div>
    </div>


    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <h1>${loginUser},欢迎您！</h1>
        </div>

    </div>

    <div class="layui-footer">
        © www.jimi.com - ATM系统
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/layui/layui.all.js" charset="utf-8"></script>

<script>
    layui.use('carousel', function(){
        var carousel = layui.carousel
            ,form = layui.form;

        //常规轮播
        carousel.render({
            elem: '#test1'
            ,arrow: 'always'
        });

    });
</script>
</body>
</html>

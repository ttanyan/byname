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

    <div class="layui-carousel" style="margin: 0 auto" id="test1">
        <div carousel-item>
            <div><img src="${pageContext.request.contextPath}/resources/layui/images/logo/lun1.jpg"></div>
            <div><img src="${pageContext.request.contextPath}/resources/layui/images/logo/lun2.jpg"></div>
            <div><img src="${pageContext.request.contextPath}/resources/layui/images/logo/lun3.jpg"></div>
            <div><img src="${pageContext.request.contextPath}/resources/layui/images/logo/lun4.jpg"></div>
            <div><img src="${pageContext.request.contextPath}/resources/layui/images/logo/lun5.jpg"></div>

        </div>
    </div>


    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <h1>${loginUser},欢迎您！</h1>
        </div>

    </div>

</div>
<script src="${pageContext.request.contextPath}/resources/layui/layui.all.js" charset="utf-8"></script>
<script>
    layui.use('carousel', function(){
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
             elem: '#test1'
            ,width: '1311px' //设置容器宽度
            ,arrow: 'always'
            ,anim: 'fade' //切换动画方式
            ,indicator:"inside"
            ,height:"400px"
        });
    });
</script>
</body>
</html>

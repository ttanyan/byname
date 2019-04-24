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
    <title>JIMI ATM ${ },欢迎您!</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css" media="all">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">JIMI ATM</div>
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
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">存取款</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/client/skpAddMoney">存钱</a></dd>
                        <dd><a href="/client/skpGetMoney">取钱</a></dd>
                        <dd><a href="/client/selectMoney">余额</a></dd>
                        <dd><a href="">明细</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="http://www.jimicloud.com">关于</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <table class="layui-table" lay-data="{width: 892, height:332, url:'/demo/table/user/', page:true, id:'idTest'}"
               lay-filter="demo">
            <thead>
            <tr>
                <th lay-data="{type:'checkbox', fixed: 'left'}"></th>
                <th lay-data="{field:'id', width:80, sort: true, fixed: true}">ID</th>
                <th lay-data="{field:'username', width:80}">用户名</th>
                <th lay-data="{field:'sex', width:80, sort: true}">性别</th>
                <th lay-data="{field:'city', width:80}">城市</th>
                <th lay-data="{field:'sign', width:160}">签名</th>
                <th lay-data="{field:'experience', width:80, sort: true}">积分</th>

                <th lay-data="{field:'classify', width:80}">职业</th>
                <th lay-data="{field:'wealth', width:135, sort: true}">财富</th>
                <th lay-data="{field:'score', width:80, sort: true, fixed: 'right'}">评分</th>
                <th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th>
            </tr>
            </thead>
        </table>
        <script type="text/html" id="barDemo">
            <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
            <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
        </script>
    </div>

    <div class="layui-footer">
        © www.jimi.com - ATM系统
    </div>
</div>

<script src="${pageContext.request.contextPath}/resources/layui/layui.all.js" charset="utf-8"></script>
<script>
    layui.use('table', function () {
        var table = layui.table;
        //监听表格复选框选择
        table.on('checkbox(demo)', function (obj) {
            console.log(obj)
        });
        //监听工具条
        table.on('tool(demo)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                layer.msg('ID：' + data.id + ' 的查看操作');
            } else if (obj.event === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    obj.del();
                    layer.close(index);
                });
            } else if (obj.event === 'edit') {
                layer.alert('编辑行：<br>' + JSON.stringify(data))
            }
        });


        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
</script>

</body>
</html>

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
    <title>
        ByName System Config
    </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css" media="all">
    <style>
        .left {
            float: left;
        }

        .center {
            float: right;
        }
    </style>
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
                    <dd><a href="/logout">安全退出</a></dd>
                </dl>
            </li>
        </ul>
    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item"><a href="/jump-listPermission">权限管理</a></li>
                <li class="layui-nav-item"><a href="jump-listPermission">角色管理</a></li>
                <li class="layui-nav-item"><a href="/jump-listPermission">用户管理</a></li>
                <li class="layui-nav-item"><a href="https://blog.csdn.net/tingfengqianqu">关于作者</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">

        <!-- 内容主体区域 -->
        <table class="layui-hide" id="test" lay-filter="test"></table>

    </div>

    <!--弹出层-->
    <div id="addPermission" style="display:none;">
        <form class="layui-form"  id="addPermissionForm" action="" >
            <div class="layui-form-item">
                <label class="layui-form-label">权限名称</label>
                <div class="layui-input-inline">
                    <input type="text" name="name" required lay-verify="required" placeholder="权限名称"
                           autocomplete="off"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">权限路径</label>
                <div class="layui-input-inline">
                    <input type="text" name="url" required lay-verify="required" placeholder="权限路径"
                           autocomplete="off"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">添加</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>

    <div class="layui-footer">
        © www.dlnu.com - 教师点名系统
    </div>
</div>

<script src="${pageContext.request.contextPath}/resources/layui/layui.all.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/resources/jquery-3.4.1.min.js" charset="utf-8"></script>
<script type="text/html" id="toolbarDemo">

    <span class="left">
      <div class="layui-btn-container">
        <button class="layui-btn " lay-event="addData" data-method="offset" data-type="auto">新增</button>
        <button class="layui-btn " lay-event="deleteData">删除</button>
      </div>
    </span>
    <span class="center">
        <div class="demoTable">
            搜索ID：
            <div class="layui-inline">
                <input class="layui-input " name="id" id="demoReload" autocomplete="off">
            </div>
            <button class="layui-btn " data-type="reload">搜索</button>
        </div>
    </span>

</script>

<script>
    layui.use('table', function () {
        var table = layui.table;
        table.render({
            elem: '#test'
            , cellMinWidth: 80
            , url: '/config/listPermission'
            , toolbar: '#toolbarDemo'
            , title: '权限数据表'
            , cols: [[
                {type: 'checkbox', fixed: 'left'}
                , {field: 'id', title: 'ID', width: 80, fixed: 'left', unresize: true, sort: true}
                , {field: 'name', title: '权限名称', edit: 'text', sort: true}
                , {field: 'url', title: '权限路径', edit: 'text', sort: true}
                , {field: 'gmtCreate', title: '创建时间'}
                , {field: 'gmtModified', title: '更新时间'}
            ]]
            , page: true
            , id: 'testTable'
        });


        //监听单元格编辑
        table.on('edit(test)', function (obj) {
            var value = obj.value //得到修改后的值
                , data = obj.data //得到所在行所有键值
            // console.log(JSON.stringify(data));
            $.ajax({
                type: 'POST',
                url: "/config/updatePermission",
                contentType: "application/json",
                data: JSON.stringify(data),
                dataType: "json",
                success: function (data) {
                    //TODO 优化提示
                    layer.msg(data.msg);
                    //重载表格
                    table.reload('testTable');
                },
                error: function () {
                    layer.msg("网络错误！");
                }
            });

        });

        //头工具栏事件
        table.on('toolbar(test)', function (obj) {
            // console.log(obj.config.id)
            var checkStatus = table.checkStatus(obj.config.id);
            switch (obj.event) {
                case 'addData':
                    var data = checkStatus.data;
                    layer.open({
                        type: 1,
                        title: "添加权限",
                        area: ['35%', '35%'],
                        content: $("#addPermission"),
                    });

                    break;
                case 'deleteData':
                    var data = checkStatus.data;
                    console.log(JSON.stringify(data))
                    layer.confirm('确定删除:' + data.length + ' 个？', function (index) {
                        layer.close(index);
                        $.ajax({
                            type: 'POST',
                            url: "/config/deletePermission",
                            contentType: "application/json",
                            data: JSON.stringify(data),
                            dataType: "json",
                            success: function (data) {
                                layer.msg(data.msg);
                                //重载表格
                                table.reload('testTable');
                            },
                            error: function () {
                                layer.msg("网络错误！");
                            }
                        });
                    });
                    break;
            }
            ;
        });
    });

    //增加权限
    layui.use('form', function () {
        var form = layui.form;
        //监听提交
        form.on('submit(formDemo)', function (data) {
            console.log(JSON.stringify(data.field))
            $.ajax({
                type: 'POST',
                url: "/config/insertPermission",
                contentType: "application/json",
                data: JSON.stringify(data.field),
                dataType: "json",
                success: function (data) {
                    // 关闭所有弹窗
                    layer.closeAll();
                    document.getElementById("addPermissionForm").reset();
                    layer.msg(data.msg);
                    //重载表格
                    table.reload('testTable');
                },
                error: function () {
                    layer.msg("网络错误！");
                }
            });
            return false;
        });
    });

</script>
</body>
</html>

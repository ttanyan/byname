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

        .right {
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
                    ${loginUser}
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
                <li class="layui-nav-item"><a href="/jump-listRole">角色管理</a></li>
                <li class="layui-nav-item"><a href="/jump-listPermission">用户管理</a></li>
                <li class="layui-nav-item"><a href="https://blog.csdn.net/tingfengqianqu">关于作者</a></li>
            </ul>
        </div>
    </div>
    <!-- 内容主体区域 -->
    <div class="layui-body" style="bottom: 0px">
        <table class="layui-hide" id="test" lay-filter="test"></table>
    </div>

    <!--弹出层-->
    <div id="addForm" style="display:none;">
        <form class="layui-form" id="addPermissionForm" action="">
            <div class="layui-form-item">
                <label class="layui-form-label">角色名称</label>
                <div class="layui-input-inline">
                    <input type="text" name="name" required lay-verify="required" placeholder="角色名称"
                           autocomplete="off"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">角色描述</label>
                <div class="layui-input-inline">
                    <input type="text" name="note" required lay-verify="required" placeholder="角色描述"
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
    <!--底部-->
    <%--<div class="layui-footer">--%>
    <%--© www.dlnu.com - 教师点名系统--%>
    <%--</div>--%>
</div>

<script src="${pageContext.request.contextPath}/resources/layui/layui.all.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/resources/jquery-3.4.1.min.js" charset="utf-8"></script>

<!--头部工具栏-->
<script type="text/html" id="toolbarDemo">
    <span class="left">
      <div class="layui-btn-container">
        <button class="layui-btn " lay-event="addData" data-method="offset" data-type="auto">新增</button>
        <button class="layui-btn " lay-event="deleteData">删除</button>
      </div>
    </span>
    <span class="right">
        <div class="demoTable">
            <div class="layui-inline">
                 <i class="layui-icon layui-icon-search" style="position: absolute;top:5px;right: 8px;"/>
                <input class="layui-input" name="search_value" id="search_value" placeholder="ID/角色名称/角色描述"
                       autocomplete="off">
            </div>
            <button class="layui-btn" ay-submit lay-event="search" id="search">搜索</button>
        </div>
    </span>
</script>

<!--数据操作框-->
<script type="text/html" id="barDemo">
    <%--<a class="layui-btn layui-btn-normal layui-btn-sm" lay-event="detail">查看</a>--%>
    <a class="layui-btn layui-btn-sm" lay-event="edit">编辑</a>
</script>

<script>
    //初始化渲染表格
    layui.use('table', function () {
        var table = layui.table;
        table.render({
              elem: '#test'
            , cellMinWidth: 80
            , url: '/config/listRole'
            , toolbar: '#toolbarDemo'
            , title: '权限数据表'
            , cols: [[
                {type: 'checkbox', fixed: 'left'}
                , {field: 'id', title: '角色ID', width: 90, fixed: 'left', unresize: true, sort: true}
                , {field: 'name', title: '角色名称', edit: 'text', sort: true}
                , {field: 'note', title: '角色描述', edit: 'text', sort: true}
                , {field: 'gmtCreate', title: '创建时间'}
                , {field: 'gmtModified', title: '更新时间'}
                , {fixed: 'right', title: '权限操作',align:'center', toolbar: '#barDemo'}
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
                url: "/config/updateRole",
                contentType: "application/json",
                data: JSON.stringify(data),
                dataType: "json",
                success: function (data) {
                    //TODO 优化提示
                    layer.msg(data.msg);
                },
                error: function () {
                    layer.msg("网络错误！");
                }
            });
        });
        //监听 操作框
        table.on('tool(test)', function(obj){
            var data = obj.data;
            // if(obj.event === 'detail'){
            //     layer.msg('ID：'+ data.id + ' 的查看操作');
            // } else
            if(obj.event === 'edit'){
                // console.log(data.name);
                layer.open({
                    type: 2,
                    title: "【"+data.name+"】"+"角色权限关联",
                    area: ['78%', '78%'],
                    content: 'jump-popupsPermission?roleId='+data.id

                });
            }
        });

        //头部工具栏事件--增加、删除、搜索
        table.on('toolbar(test)', function (obj) {
            // console.log(obj.config.id)
            var checkStatus = table.checkStatus(obj.config.id);
            switch (obj.event) {
                case 'addData':
                    var data = checkStatus.data;
                    layer.open({
                        type: 1,
                        title: "添加角色",
                        area: ['35%', '35%'],
                        content: $("#addForm"),
                        cancel: function (index) {
                            document.getElementById('addForm').style.display = 'none';
                            layer.close(index);
                            return false;
                        }
                    });
                    break;
                case 'deleteData':
                    var data = checkStatus.data;
                    // console.log(JSON.stringify(data))
                    layer.confirm('确定删除:' + data.length + ' 个？', function (index) {
                        layer.close(index);
                        $.ajax({
                            type: 'POST',
                            url: "/config/deleteRole",
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
                case 'search':
                    var data = $('#search_value').val();
                    table.reload('testTable', {
                        url: "/config/selectKeyRole"
                        , where: {
                            keyWord: data
                        }
                        , page: true
                    });
                    break;
            };
        });
        //增加权限（form表单）
        layui.use('form', function () {
            var form = layui.form;
            //监听提交
            form.on('submit(formDemo)', function (data) {
                $.ajax({
                    type: 'POST',
                    url: "/config/insertRole",
                    contentType: "application/json",
                    data: JSON.stringify(data.field),
                    dataType: "json",
                    success: function (data) {
                        // 关闭所有弹窗
                        layer.closeAll();
                        //重置输入框
                        document.getElementById("addPermissionForm").reset();
                        //隐藏弹出框
                        document.getElementById('addForm').style.display = 'none';
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
    });

</script>
</body>
</html>

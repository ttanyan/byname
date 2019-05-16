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

    <div class="layui-footer">
        © www.dlnu.com - 教师点名系统
    </div>
</div>

<script src="${pageContext.request.contextPath}/resources/layui/layui.all.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/resources/jquery-3.4.1.min.js" charset="utf-8"></script>
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="addData">新增权限</button>
        <button class="layui-btn layui-btn-sm" lay-event="deleteData">批量删除</button>
    </div>
</script>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>
    layui.use('table', function(){
        var table = layui.table;
        table.render({
            elem: '#test'
            ,url:'/config/listPermission'
            ,toolbar: '#toolbarDemo'
            ,title: '权限数据表'
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{field:'id', title:'ID', width:80, fixed: 'left', unresize: true, sort: true}
                ,{field:'name', title:'权限名称', width:120, edit: 'text'}
                ,{field:'url', title:'权限路径', width:120, edit: 'text',sort: true}
                ,{field:'gmtCreate', title:'创建时间', width:200}
                ,{field:'gmtModified', title:'更新时间', width:200}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
            ]]
            ,page: true
        });

        //头工具栏事件
        table.on('toolbar(test)', function(obj){
            // console.log(obj.config.id)
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
                case 'addData':
                    var data = checkStatus.data;
                    // console.log(data);data是一个对象，无法反序列化成JSON数组！
                    layer.alert(JSON.stringify(data));
                    break;
                case 'deleteData':
                    var data = checkStatus.data;
                    console.log(JSON.stringify(data))
                    layer.confirm('批量删除:'+ data.length+ ' 个？', function(index){
                        layer.close(index);
                        $.ajax({
                            type: 'POST',
                            url: "/config/deletePermission",
                            contentType: "application/json",
                            data:JSON.stringify(data),
                            dataType: "json",
                            success: function(data){
                                layer.msg(data.msg);
                                //请求成功后刷新页面
                                // window.location.reload();

                            },
                            error:function(){
                                layer.msg("网络错误！");
                            }
                        });
                    });
                    break;
            };
        });

        //监听行工具事件
        table.on('tool(test)', function(obj){
            var data = obj.data;
            console.log(JSON.stringify(data));
            if(obj.event === 'del'){
                layer.confirm('确定删除？', function(index){
                    layer.close(index);
                    $.ajax({
                        type: 'POST',
                        url: "/config/deletePermission",
                        contentType: "application/json",
                        data:"["+JSON.stringify(data)+"]",
                        dataType: "json",
                        success: function(data){
                            location.reload();
                            layer.msg(data.msg);
                        },
                        error:function(){
                            layer.msg("网络错误！");
                        }
                    });
                    // obj.del();
                });
            } else if(obj.event === 'edit'){
                layer.prompt({
                    formType: 2
                    ,value: data.email
                }, function(value, index){
                    obj.update({
                        email: value
                    });
                    layer.close(index);
                });
            }
        });
    });

</script>
</body>
</html>

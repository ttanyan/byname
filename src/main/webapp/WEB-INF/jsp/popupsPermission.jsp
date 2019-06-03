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
<!-- 内容主体区域 -->
<div style="bottom: 0px;">
    <table class="layui-hide" id="test" lay-filter="test"></table>
</div>

<script src="${pageContext.request.contextPath}/resources/layui/layui.all.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/resources/jquery-3.4.1.min.js" charset="utf-8"></script>
<script type="text/html" id="toolbarDemo">
    <span class="left">
      <div class="layui-btn-container">
          <button class="layui-btn " lay-event="addRolePemission">添加</button>
          <button class="layui-btn " lay-event="deleteData" data-method="offset" data-type="auto">取消</button>
      </div>
    </span>
    <span class="right">
        <div class="demoTable">
            <div class="layui-inline">
                 <i class="layui-icon layui-icon-search" style="position: absolute;top:5px;right: 8px;"/>
                <input class="layui-input" name="search_value" id="search_value" placeholder="ID/权限名称/权限路径"
                       autocomplete="off">
            </div>
            <button class="layui-btn" ay-submit lay-event="search" id="search">搜索</button>
        </div>
    </span>
</script>

<script>
    //初始化渲染表格
    layui.use('table', function () {
        var table = layui.table;
        table.render({
            elem: '#test'
            , cellMinWidth: 80
            , url: '/config/listPermission'
            ,parseData: function(res){ //res 即为原始返回的数据 对其进行预处理 动态添加复选框状态
                /**
                 *  在遍历JSON数据的时候很不认真所以导致在这个地方卡了很久 希望以后切记
                 *  两个for循环用了一个变量----len，导致每次遍历的都只能遍历十个，巨坑
                 */
                var listRole = ${RolePermission};
                for(var j = 0,lengRole = listRole.length; j < lengRole; j++){
                    for(var i = 0,len = res.data.length; i < len; i++){
                        if(listRole[j] == res.data[i].id){
                            //添加复选框选中的状态
                            res.data[i].LAY_CHECKED = true;
                        }
                    }
                }
            }
            , toolbar: '#toolbarDemo'
            , title: '权限数据表'
            , size: 'sm'
            , cols: [[
                {type: 'checkbox', fixed: 'left'}
                , {field: 'id', title: '权限ID', width: 90, fixed: 'left', unresize: true, sort: true}
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
                },
                error: function () {
                    layer.msg("网络错误！");
                }
            });
        });

        //头工具栏事件--删除权限、增加权限、搜索
        table.on('toolbar(test)', function (obj) {
            // console.log(obj.config.id)
            var checkStatus = table.checkStatus(obj.config.id);
            switch (obj.event) {
                case 'deleteData':
                    var data = checkStatus.data;
                    // console.log(JSON.stringify(data))
                    layer.confirm('确定取消:' + data.length + ' 个权限？', function (index) {
                        layer.close(index);
                        $.ajax({
                            type: 'POST',
                            url: "/config/deleteRolePermission?roleId=${roleId}",
                            contentType: "application/json",
                            data: JSON.stringify(data),
                            dataType: "json",
                            success: function (data) {
                                layer.msg(data.msg);
                              //重载表格 获取新的listRole
                                window.location.href="jump-popupsPermission?roleId=${roleId}";

                            },
                            error: function () {
                                layer.msg("网络错误！");
                            }
                        });
                    });
                    break;
                case 'addRolePemission':
                    var data = checkStatus.data;
                    // console.log(JSON.stringify(data))
                    layer.confirm('确定添加:' + data.length + ' 个权限？', function (index) {
                        layer.close(index);
                        $.ajax({
                            type: 'POST',
                            url: "/config/addRolePermission?roleId=${roleId}",
                            contentType: "application/json",
                            data: JSON.stringify(data),
                            dataType: "json",
                            success: function (data) {
                                layer.msg(data.msg);
                               //重载表格 获取新的listRole
                                window.location.href="jump-popupsPermission?roleId=${roleId}";

                            },
                            error: function () {
                                layer.msg("网络错误！");
                            }
                        });
                    });
                    break;
                case 'search':
                    var data = $('#search_value').val();
                    // console.log(data);
                    if (data == null) {
                        data = '';
                    }
                    table.reload('testTable', {
                        url: "/config/selectKeyPermission"
                        , where: {
                            keyWord: data
                        }
                        , page: true
                    });
                    break;
            }
            ;
        });
        //增加权限（form表单）
        layui.use('form', function () {
            var form = layui.form;
            //监听提交
            form.on('submit(formDemo)', function (data) {
                $.ajax({
                    type: 'POST',
                    url: "/config/insertPermission",
                    contentType: "application/json",
                    data: JSON.stringify(data.field),
                    dataType: "json",
                    success: function (data) {
                        // 关闭所有弹窗
                        layer.closeAll();
                        //重置输入框
                        document.getElementById("addPermissionForm").reset();
                        //隐藏弹出框
                        document.getElementById('addPermission').style.display = 'none';
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

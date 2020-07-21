$(function () {
    /*角色数据列表*/
    $("#role_dg").datagrid({
        url:"/getRoles",
        columns:[[
            {field:'rnum',title:'角色编号',width:100,align:'center'},
            {field:'rname',title:'角色名称',width:100,align:'center'},
        ]],
        fit:true,//填充页面
        fitColumns:true,//列宽度
        rownumbers:true,//行号
        pagination:true,//分页
        toolbar:"#toolbar",//工具栏
        singleSelect:true,
        striped:true,//单选隔行变色
    });

    $("#dialog").dialog({
        width:600,
        height:500,
        title:"添加角色",
        closed:true,
        buttons:[
            {
                text:"保存",
                handler:function () {

                    /*判断是保存操作还是编辑*/
                   var rid= $("[name='rid']").val();
                   var url;
                    if(rid){
                        url="/updateRole";
                    }else{
                        url="/saveRole";
                    }
                    /*提交表单*/
                    $("#myform").form("submit",{
                        url:url,
                        onSubmit:function(param){//添加额外的参数
                            /*获取已选定的权限*/
                            var allRows=$("#role_data2").datagrid("getRows");
                            for (var i=0;i<allRows.length;i++){
                                /*取出每一个权限*/
                                var row=allRows[i];
                                /*封装集合*/
                                param["permissions["+i+"].pid"]=row.pid;
                            }
                        },
                        success:function (data) {
                            data=$.parseJSON(data)
                            if(data.success){
                                $("#dialog").dialog("close")
                                $("#role_dg").datagrid("reload");
                                $.messager.alert("温馨提示",data.msg);

                            }else{
                                $.messager.alert("温馨提示",data.msg);

                            }
                        }
                    })
                }
            },
            {
                text: "关闭",
                handler:function () {
                    $("#dialog").dialog("close");
                }
            }
        ]
    });
    /*添加角色*/
    $("#add").click(function () {
        $("#dialog").dialog("open");
        $("#myform").form("clear");
        $("#role_data2").datagrid("loadData",{rows:[]})
        $("#dialog").datagrid("setTitle","添加角色")
    });
    /*权限列表*/
    $("#role_data1").datagrid({
        url: "/permissionList",
        title:"所有权限",
        width:250,
        height: 325,
        fitColumns: true,
        singleSelect: true,
        columns: [[
            {field:'pname',title:"权限名称",width:100,align:"center"}
        ]],
        onClickRow:function (rowIndex,rowData) {//点击一行时
            /*判断是否存在该权限*/
            /*取出已选权限*/
            var allRows=$("#role_data2").datagrid("getRows");
            for (var i=0;i<allRows.length;i++) {
                /*取出每一行*/
                var row=allRows[i];
                if(rowData.pid==row.pid){/*存在该权限*/

                    /*获取存在选中的角标*/
                   var index=$("#role_data2").datagrid("getRowIndex",row);
                    /*让存在的权限成为选中状态*/
                    $("#role_data2").datagrid("selectRow",index);
                    return;

                }
            }
            /*把当前选择的权限添加到已选权限*/
            $("#role_data2").datagrid("appendRow",rowData)
        }
    });
    $("#role_data2").datagrid({
        title:"已选权限",
        width:250,
        height: 325,
        fitColumns: true,
        singleSelect: true,
        columns: [[
            {field:'pname',title:"权限名称",width:100,align:"center"}
        ]],
        onClickRow:function (rowIndex,rowData) {//点击一行时
            /*删除当前选中的这行*/
            $("#role_data2").datagrid("deleteRow",rowIndex);
        },

    });


    /*编辑按钮点击*/
    $("#edit").click(function () {
        /*获取当前行*/
        var rowdata = $("#role_dg").datagrid("getSelected");
        if(!rowdata){
            $.messager.alert("提示","请选择一行数据进行编辑");
            return;
        }
        /*回显权限*/
        var options=$("#role_data2").datagrid("options");
        options.url="/getPermissionById?rid="+rowdata.rid;
        /*重新加载数据*/
        $("#role_data2").datagrid("load");
        /*回显表单*/
        $("#myform").form("load",rowdata);
        $("#dialog").dialog("setTitle","编辑角色");
        $("#dialog").dialog("open");

    });
    /*监听删除的点击*/
    $("#remove").click(function () {
        /*获取当前行*/
        var rowdata = $("#role_dg").datagrid("getSelected");
        if(!rowdata){
            $.messager.alert("提示","请选择一行数据进行编辑");
            return;
        }
        $.get("deleteRole?rid="+rowdata.rid,function (data) {
            if(data.success){
                $("#role_dg").datagrid("reload");
                $.messager.alert("温馨提示",data.msg);

            }else{
                $.messager.alert("温馨提示",data.msg);

            }
        })
    })

})
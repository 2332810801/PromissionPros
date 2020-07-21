$(function () {
  $("#dg").datagrid({
    url:"/emploeeList",
    columns:[[
      {field:'username',title:'姓名',width:100,align:'center'},
      {field:'inputtime',title:'入职时间',width:100,align:'center'},
      {field:'tel',title:'电话',width:100,align:'center'},
      {field:'email',title:'邮箱',width:100,align:'center'},
      {field:'department',title:'部门',width:100,align:'center',formatter:function (value,row,index) {
         if(value){
           return value.name;
         }
        }},
      {field:'state',title:'状态',width:100,align:'center',formatter:function (value,row,index) {
        if(row.state){
          return "在职";
        }else{
          return "<font color='red'>离职</font>";
        }
        }},
      {field:'admin',title:'管理员',width:100,align:'center',formatter:function (value,row,index) {
          if(row.admin){
            return "是";
          }else{
            return "否";
          }
        }},
    ]],
    fit:true,//填充页面
    fitColumns:true,//列宽度
    rownumbers:true,//行号
    pagination:true,//分页
    toolbar:"#tb",//工具栏
    singleSelect:true,
    striped:true,//单选隔行变色
    onClickRow:function (rowIndex,rowData) {
      if(!rowData.state){
        /*禁用离职按钮*/
        $("#delete").linkbutton("disable");
      }else{
        /*启用离职按钮*/
        $("#delete").linkbutton("enable");
      }
    },
    pageList:[5,10,15,20,30,50]
  });

  /*对话框*/
    $("#dialog").dialog({
      width:350,
      height:300,
      closed:true,
      buttons:[
          {
            text:"保存",
            handler:function () {
              /*判断当前是添加 还是编辑*/
              var url;
              var id=$("[name='id']").val();
                 if(id){
                   /*编辑*/
                   url="updateEmployee"
                 } else{
                   /*添加*/
                   url="saveEmployee";
                 }


             $("#employeeForm").form("submit",{
               url:url,
               success:function (data) {
                 data=$.parseJSON(data)
                 if(data.success){
                   $.messager.alert("温馨提示",data.msg)
                   $("#dialog").dialog("close")
                   $("#dg").datagrid("reload");
                 }else {
                   $.messager.alert("温馨提示",data.msg)
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
  /*监听添加按钮点击*/
  $("#add").click(function () {
    $("#employeeForm").form("clear");
    $("#dialog").dialog("open");
    $("#password").show();
    /*添加密码验证*/
    $("[name='password']").validatebox({required:true});
    $("#dialog").dialog("setTitle","添加员工")
  });

  /*编辑按钮点击*/
  $("#edit").click(function () {
   /*获取当前行*/
    var rowdata = $("#dg").datagrid("getSelected");
    if(!rowdata){
      $.messager.alert("提示","请选择一行数据进行编辑");
      return;
    }
    /*隐藏密码框*/
      $("#password").hide();
      /*取消密码验证*/
      $("[name='password']").validatebox({required:false});
      $("#dialog").dialog("setTitle","编辑员工")
      $("#dialog").dialog("open");
      /*选中数据的回显*/
      /*回显部门*/
      rowdata["department.id"]=rowdata["department"].id;
      /*回显管理员*/
      rowdata["admin"]=rowdata["admin"]+"";
      $("#employeeForm").form("load",rowdata);
  });

  /*部门选择*/
  $("#department").combobox({
    width:150,
    panelHeight:'auto',
    editable:false,
    textField:'name',
    valueField:'id',
    url:"depaterList",
    onLoadSuccess:function () {
      /*数据加载完后的回调*/
        $("#department").each(function(i){
          var span = $(this).siblings("span")[i];
          var targetInput = $(span).find("input:first");
          if(targetInput){
            $(targetInput).attr("placeholder", $(this).attr("placeholder"));
          }
        });
    },
  })
  $("#state").combobox({
    width:150,
    panelHeight:'auto',
    textField:'label',
    valueField:'value',
    editable:false,
    data:[
     {
      label:'是',
      value:'true'
    },{
        label:'否',
        value:'false'
      }
    ],
    onLoadSuccess:function () {
      /*数据加载完后的回调*/
        $("#state").each(function(i){
          var span = $(this).siblings("span")[i];
          var targetInput = $(span).find("input:first");
          if(targetInput){
            $(targetInput).attr("placeholder", $(this).attr("placeholder"));
          }
        });
    },
  })
  /*监听离职按钮的点击*/
  $("#delete").click(function () {
    /*获取当前行*/
    var rowdata = $("#dg").datagrid("getSelected");
    if(!rowdata){
      $.messager.alert("提示","请选择一行数据进行编辑");
      return;
    }
    /*提醒用户是否进行离职操作*/
    $.messager.confirm("确认","是否做离职操作",function (res) {
        if(res){
          /*做离职操作*/
          $.get("/updateState?id="+rowdata.id,function (data) {
            if(data.success){
              $.messager.alert("温馨提示",data.msg);
              $("#dg").datagrid("reload");
            }else {
              $.messager.alert("温馨提示",data.msg);
            }

          })
        }
    });
  });
  $("#reload").click(function () {
    $("[name='keyword']").val('');
    $("#dg").datagrid("load",{});
  })
  $("#searchbtn").click(function () {
      /*获取搜索内容*/
      var keyword=$("[name='keyword']").val();
      /*重新加载列表，把参数传过去*/
      $("#dg").datagrid("load",{keyword:keyword});

  })
});
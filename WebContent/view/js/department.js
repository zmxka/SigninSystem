$(document).ready(function () {

   $(".layui-btn").click(function (e) { 
      $.ajax({
        type: "post",
        url: "../../DepartmentMaintain?sign=2",
        data: $(".layui-form").serialize(),
        success: function (res) {
        	if(res==1){
        		alert("添加成功")
        		window.location.reload();
        	}else if(res==0){
        		alert("所属部门不存在")
        	}else if(res==3){
        		alert("该部门已存在")
        	}else if(res==4){
        		alert("输入框不能为空")
        	}
        },
      });
     
   });
});
layui.use(['element','table'], function(){
    var element = layui.element;
    var table = layui.table;

    table.render({
        elem: '#department'
        ,width:406
        ,url:'../../DepartmentMaintain?sign=1'
        ,title: '用户数据表'
        ,cols: [[
          {field: 'departmentId', title: '部门编号', width:86,align: 'center'}
          ,{field: 'departmentName', title: '部门名', width:80,align: 'center',templet: function(res){
              return '<em>'+ res.departmentName +'</em>'
          }}
          ,{field: 'preDpartmentId', title: '隶属部门编号', width:120,align: 'center'}
          ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:115}
        ]]
      });
      
      //监听行工具事件
      table.on('tool(test)', function(obj){
        var data = obj.data;
        if(obj.event === 'del'){
          layer.confirm('真的删除行么', function(index){
            //obj.del();
            layer.close(index);
            $.ajax({
              type: "post",
              url: "../../DepartmentMaintain",
              data: {"index" : data.departmentId,"sign": 1},
              success: function (e) {
                if(e==1){
                  alert("删除成功");
                  window.location.reload()
                }
                else if(e==0)
                alert("部门下有员工，请处理后删除");
              },
		          error:function(e){
		          }
            });
          });
        } else if(obj.event === 'edit'){
          layer.prompt({
            formType: 3
            ,value: data.departmentName
          }, function(value, index){
        	  $.ajax({
              type: "post",
              url: "../../DepartmentMaintain",
              data: {"index" : data.departmentId,"sign": 0,"value":value},
              success: function (response) {
                alert("修改成功");
                window.location.reload()
              }
            });
          });
        }
      });
    });

$(document).ready(function () {
    $.ajax({
        type: "get",
        url: "../../DepartmentMaintain?sign=2",
        data: "data",
        success: function (e) {
            var dataObj = eval("("+e+")");
            $('#tree').treeview({data: dataObj})
        }
    });
   
});
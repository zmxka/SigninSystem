$(document).ready(function () {
  $.ajax({
    type: "get",
    url: "../../DepartmentMaintain?sign=1",
    success: function (res) {
    	var res = res.data; 
    	for(var i=0;i<res.length;i++){
          $("#select").append("<option value="+res[i].departmentId+">" + res[i].departmentName+ "</option>");
          layui.use('form', function(){
        	  var form = layui.form;
        	  form.render('select');
        	});
    	}
    }
  });
	$("#layui-btn1").click(function (e) { 
		  
		  
	      $.ajax({
	        type: "post",
	        url: "../../UserMaintain?sign=2",
	        data: $(".layui-form").serialize(),
	        success: function (res) {
	        	if(res==1){
	        		alert("保存成功");
	        		window.location.reload();
	        	}else if(res==2){
	        		alert("该用户昵称已经存在")
	        	}
	        },
	      });
	   });
	
});
layui.use(['element','table','form'], function(){
    var element = layui.element;
    var table = layui.table;
    var form = layui.form;
    
    table.render({
        elem: '#user'
        ,url:'../../UserMaintain?sign='+1
        ,title: '用户数据表'
        ,cols: [[
          {field: 'userId', title: '用户ID',align: 'center'}
          ,{field: 'userName', title: '用户昵称', align: 'center',}
          ,{field: 'passWord', title: '登陆密码', align: 'center'}
          ,{field: 'sex', title: '性别',align: 'center'}
          ,{field: 'name', title: '员工姓名',align: 'center'}
          ,{field: 'telephoneNumber', title: '电话号码', align: 'center'}
          ,{field: 'email', title: '邮箱',align: 'center'}
          ,{field: 'departmentId', title: '隶属部门', align: 'center'}
          ,{field: 'type', title: '账户类型',align: 'center'}
          ,{field: 'iDCard', title: '身份证号码',align: 'center'}
          ,{field: 'creditCard', title: '银行卡号', align: 'center'}
          ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:115}
        ]]
    	,page:true
    	,id: 'testReload'
      });
    	
    var $ = layui.$, active = {
    	    reload: function(){
    	      var demoReload = $('#demoReload');
    	      
    	      //执行重载
    	      table.reload('testReload', {
    	        page: {
    	          curr: 1 //重新从第 1 页开始
    	        }
    	        ,url:'../../UserMaintain?sign='+3
    	        ,where: {
    	            userId: demoReload.val()
    	        }
    	      });
    	    }
    	  };
    	  
    	  $('.demoTable .layui-btn').on('click', function(){
    	    var type = $(this).data('type');
    	    active[type] ? active[type].call(this) : '';
    	  });
    
      //监听行工具事件
      table.on('tool(user)', function(obj){
        var data = obj.data;
        if(obj.event === 'del'){
          layer.confirm('真的删除行么,该操作将删除用户的签到信息', function(index){
            //obj.del();
            layer.close(index);
            $.ajax({
              type: "post",
              url: "../../UserMaintain",
              data: {"index" : data.userId,"sign": 1},
              success: function (e) {
                if(e==1){
                  alert("删除成功");
                  window.location.reload()
                }
              },
		          error:function(e){
		          }
            });
          });
        } else if(obj.event === 'edit'){
        	$("input[name='userName']").attr("disabled", true);
        	$("input[name='userName']").val(data.userName);
        	$("input[name='passWord']").val(data.passWord);
        	$("input[name='name']").val(data.name);
        	$("input[name='creditCard']").val(data.creditCard);
        	$("input[name='telePhoneNumber']").val(data.telephoneNumber);
        	$("input[name='idCard']").val(data.iDCard);
        	$("input[name='email']").val(data.email);  
        	form.val("form1", {  		 
        		  "sex": ""+data.sex+""
        		  ,"type": ""+data.type+""
        		})
        	$("select").val(""+data.departmentId+"");
        	form.render('select');
        	$("input[name='hidden']").val(data.userId);
        }
      });
    });
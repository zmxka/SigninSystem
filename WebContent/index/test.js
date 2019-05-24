layui.use('element', function(){
  var element = layui.element;
});
$(document).ready(function () {
  $("#department").click(function (e) { 
    $('iframe').attr('src','../view/jsp/department.html'); 
  });
  $(".user").click(function (e) { 
	    $('iframe').attr('src','../view/jsp/user.html'); 
	  });
  $("#attendencerecords").click(function (e) { 
	    $('iframe').attr('src','../view/jsp/attendencerecords.jsp'); 
	  });
  $("#loadleavetype").click(function (e) { 
	    $('iframe').attr('src','../view/jsp/loadleavetype.jsp'); 
	  });
  $(".LeaveEdit").click(function (e) { 
	    $('iframe').attr('src','../LeaveEditServlet'); 
	  });
});

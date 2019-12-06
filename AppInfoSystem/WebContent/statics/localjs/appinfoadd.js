$(function(){  
	//动态加载二级分类列表
	$("#categoryLevel1").change(function(){
		var categoryLevel1 = $("#categoryLevel1").val();
		findCategoryList($("#categoryLevel2"),categoryLevel1);
		$("#categoryLevel3").html("");
		var options = "<option value=\"\">--请选择--</option>";
		$("#categoryLevel3").html(options);
	});
	//动态加载三级分类列表
	$("#categoryLevel2").change(function(){
		var categoryLevel2 = $("#categoryLevel2").val();
		findCategoryList($("#categoryLevel3"),categoryLevel2);
	});
	$("#APKName").bind("blur",function(){
		//ajax后台验证--APKName是否已存在
		$.ajax({
			type:"POST",//请求类型
			url:local+"dev/app/apkNameExist.do",//请求的url
			data:{APKName:$("#APKName").val()},//请求参数
			success:function(data){
				if(data == true){//账号不可用，错误提示
					alert("该APKName已存在，不能使用！");
				}
			},
			error:function(data,type, err){//当访问时候，404，500 等非200的错误状态码
				alert("请求错误！\n错误参数：\n"+data+"\n"+type+"\n"+err);
			}
		});
	});
});
      
      
      
function findCategoryList(obj,pid){
	if(pid != '' && pid != null){
		$.ajax({
			type:"POST",//请求类型
			url:local+"app/category/categorylevellist.do",//请求的url
			data:{pid:pid},//请求参数
			dataType:"json",//ajax接口（请求url）返回的数据类型
			success:function(data){//data：返回数据（json对象）
				obj.html("");
				var options = "<option value=\"\">--请选择--</option>";
				for(var i = 0; i < data.length; i++){
					options += "<option value=\""+data[i].id+"\">"+data[i].categoryName+"</option>";
				}
				obj.html(options);
				return true;
			},
			error:function(a,b,c){//当访问时候，404，500 等非200的错误状态码
				alert("加载下一级分类列表失败\n错误信息：\n"+a+"\n"+b+"\n"+c);
				obj.html("");
				var options = "<option value=\"\">--请选择--</option>";
				obj.html(options);
			}
		});
	}else{
		obj.html("");
		var options = "<option value=\"\">--请选择--</option>";
		obj.html(options);
	}
}

function selectImage(th){
	 var file = th.files[0];
    var url = "";
    if(window.createObjectURL!=undefined)
    {
        url = window.createObjectURL(file);
    }
    else if(window.URL!=undefined)
    {
       url = window.URL.createObjectURL(file);
    }
    else if (window.webkitURL != undefined)
    {
       url = window.webkitURL.createObjectURL(file);
    }
    $("#appImg").attr("src", url);
}
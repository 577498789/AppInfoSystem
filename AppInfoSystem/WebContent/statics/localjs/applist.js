$("#queryCategoryLevel1").change(function(){
	var queryCategoryLevel1 = $("#queryCategoryLevel1").val();
	findCategoryList($("#queryCategoryLevel2"),queryCategoryLevel1);
	$("#queryCategoryLevel3").html("");
	var options = "<option value=\"\">--请选择--</option>";
	$("#queryCategoryLevel3").html(options);
});
$("#queryCategoryLevel2").change(function(){
	var queryCategoryLevel2 = $("#queryCategoryLevel2").val();
	findCategoryList($("#queryCategoryLevel3"),queryCategoryLevel2);
});
$(document).on("click",".checkApp",function(){
	var obj = $(this);
	var status = obj.attr("status");
	var vid = obj.attr("versionid");
	if(status == "1" && vid != "" && vid != null){//待审核状态下才可以进行审核操作
		window.location.href=local+"backend/app/goExamineApp"+ obj.attr("appinfoid")+".do";
	}else if(vid != "" || vid != null){
		alert("该APP应用没有上传最新版本,不能进行审核操作！");
	}else if(status != "1"){
		alert("该APP应用的状态为：【"+obj.attr("statusname")+"】,不能进行审核操作！");
	}
});



	

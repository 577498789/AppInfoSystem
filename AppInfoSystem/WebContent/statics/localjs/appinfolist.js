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


$(document).on("click",".addVersion",function(){
	var obj = $(this);
	window.location.href=local+"dev/app/version/goAddAppVersion.do?id="+obj.attr("appinfoid");
});
$(document).on("click",".modifyVersion",function(){
	var obj = $(this);
	var status = obj.attr("status");
	var versionid = obj.attr("versionid");
	var appinfoid = obj.attr("appinfoid");
	if(status == "1" || status == "3"){//待审核、审核未通过状态下才可以进行修改操作
		if(versionid == null || versionid == ""){
			alert("该APP应用无版本信息，请先增加版本信息！");
		}else{
			window.location.href=local+"dev/app/version/goModifyAppVersion.do?versionId="+ versionid + "&appId="+ appinfoid;
		}
	}else{
		alert("该APP应用的状态为：【"+obj.attr("statusname")+"】,不能修改其版本信息，只可进行【新增版本】操作！");
	}
});
$(document).on("click",".modifyAppInfo",function(){
	var obj = $(this);
	var status = obj.attr("status");
	if(status == "1" || status == "3"){//待审核、审核未通过状态下才可以进行修改操作
		window.location.href=local+"dev/app/goModifyAppInfo"+ obj.attr("appinfoid")+".do";
	}else{
		alert("该APP应用的状态为：【"+obj.attr("statusname")+"】,不能修改！");
	}
});

$(document).on("click",".saleSwichOpen,.saleSwichClose",function(){
	var obj = $(this);
	var appinfoid = obj.attr("appinfoid");
	var saleSwitch = obj.attr("saleSwitch");
	var saleSwitch2;
	var statusString;
	var statusString2;
	var modifyStatusId;
	if("open" === saleSwitch){
		saleSwitch2="close";
		statusString="上架";
		statusString2="下架";
		modifyStatusId=4;
	}else if("close" === saleSwitch){
		saleSwitch2="open";
		statusString="下架";
		statusString2="上架";
		modifyStatusId=5;
	}
	if(confirm("你确定要"+statusString+"您的APP应用【"+obj.attr("appsoftwarename")+"】吗？")){
		$.post(local+"dev/app/upperOrLowerShelf.do","id="+appinfoid+"&status="+modifyStatusId,function(data){
			if(data="1"){
				obj.attr("appinfoid",modifyStatusId);
				obj.attr("saleSwitch",saleSwitch2);
				obj.html(statusString2);
				obj.parent().parent().parent().parent().prev().prev().prev().find("span").html("已"+statusString);
				alert("恭喜您，软件【"+obj.attr("appsoftwarename")+"】的【"+statusString+"】操作成功");
			}else{
				alert("对不起，软件【"+obj.attr("appsoftwarename")+"】的【"+statusString+"】操作失败");
			}
		});
	}
});
$(document).on("click",".viewApp",function(){
	var obj = $(this);
	window.location.href=local+"dev/app/showAppInfo"+ obj.attr("appinfoid")+".do";
});
$(document).on("click",".deleteApp",function(){
	var obj = $(this);
	if(confirm("你确定要删除APP应用【"+obj.attr("appsoftwarename")+"】及其所有的版本吗？")){
		$.ajax({
			type:"POST",
			url:local+"dev/app/delAppInfo.do",
			data:{id:obj.attr("appinfoid")},
			success:function(data){
				if(data == true){//删除成功：移除删除行
					alert("删除成功");
					var records = $("#datatable-responsive tr").length;
					var pageNo = $("#pageNoNo").html();
					if(records==2&&pageNo>1){
						pageNo-=1
					}
					alert(pageNo)
					changeDevPage(pageNo);
				}else if(data == false){//删除失败
					alert("对不起，删除AAP应用【"+obj.attr("appsoftwarename")+"】失败");
				}
			},
			error:function(data){
				alert("对不起，删除失败");
			}
		});
	}
});

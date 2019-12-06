function examineApp(status){
	var appId = $("input[name=id]").val();
	var appName = $("input[name=softwareName]").val();
	$.post(local+"backend/app/examineApp.do","appId="+appId+"&status="+status,function(data){
		if(data="1"){
			alert("恭喜您，软件【"+appName+"】的【审核】操作成功");
			location=local+"backend/app/goAppInfoList.do";
		}else{
			alert("对不起，软件【"+appName+"】的【审核】操作失败");
		}
	});
}
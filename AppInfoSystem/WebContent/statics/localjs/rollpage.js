function page_nav(frm,num){
		frm.pageIndex.value = num;
		frm.submit();
}
function changePage(pageNo){
	$.post("/AppInfoSystem/dev/changePage.do","pageNo="+pageNo,function(data){
		$("#datatable-responsive_wrapper").html(data);
	});
}
function selectAppByInfo(){
	var info = $("#selectInfo").serialize();
	$.post("/AppInfoSystem/dev/findAppinfoByInfo.do",info,function(data){
		$("#datatable-responsive_wrapper").html(data);
	});
}

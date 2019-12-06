function page_nav(frm,num){
		frm.pageIndex.value = num;
		frm.submit();
}
function changeDevPage(pageNo){
	$.post(local+"dev/app/changePage.do","pageNo="+pageNo,function(data){
		$("#datatable-responsive_wrapper").html(data);
	});
}
function changeBackendPage(pageNo){
	$.post(local+"backend/app/changePage.do","pageNo="+pageNo,function(data){
		$("#datatable-responsive_wrapper").html(data);
	});
}
function selectDevAppByInfo(){
	var info = $("#selectInfo").serialize();
	$.post(local+"dev/app/findAppinfoByInfo.do",info,function(data){
		$("#datatable-responsive_wrapper").html(data);
	});
}
function selectBackendAppByInfo(){
	var info = $("#selectInfo").serialize();
	$.post(local+"backend/app/findAppinfoByInfo.do",info,function(data){
		$("#datatable-responsive_wrapper").html(data);
	});
}

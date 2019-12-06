$(function() {
	$("#back").on("click", function() {
		window.history.back();
	});
	// 上传APK文件---------------------
	var downloadLink = $("#downloadLink").val();
	var id = $("#id").val();
	var apkFileName = $("#apkFileName").val();
	$("#uploadfile").show();	
	$("#apkFile").append(
			"<p>" + apkFileName + "&nbsp;&nbsp;<a href=\"" + downloadLink
					+ "?m=" + Math.random() + "\" >下载</a> &nbsp;&nbsp;"
					+ "</p>");
});

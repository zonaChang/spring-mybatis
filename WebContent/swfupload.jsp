<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
	<head>
		<title>SWFUpload 多文件上传示例</title>
		<meta http-equiv="content-type" content="text/html; charset=gbk">
		<link rel="stylesheet" type="text/css" href="sources/swfupload/css/default.css">
		<script type="text/javascript" src="sources/swfupload/jslib/swfupload.js"></script>
		<script type="text/javascript" src="sources/swfupload/jslib/swfupload.queue.js"></script>
		<script type="text/javascript" src="sources/swfupload/jslib/fileprogress.js"></script>
		<script type="text/javascript" src="sources/swfupload/jslib/handlers.js" charset="utf-8"></script>
		<script type="text/javascript">
		var swfUpload;
		window.onload = function() {
			var settings = {
					flash_url : "sources/swfupload/jslib/swfupload.swf",
					upload_url: "http://localhost/file/operate/swf/uploadFile?jsessionid=<%=request.getSession().getId()%>",
					post_params: {"":""},
					file_size_limit : "200MB",
					file_types : "*.*",
					file_post_name: "uploadFile",
					file_types_description : "All Files",
					file_upload_limit : 50,
					file_queue_limit : 0,
					custom_settings : {
						progressTarget : "fsUploadProgress",
						cancelButtonId : "btnCancel"
					},
					debug: true,//是否显示调试的textarea
					
					// Button settings
					button_image_url: "images/TestImageNoText_65x29.png",
					button_width: "65",
					button_height: "29",
					button_placeholder_id: "spanButtonPlaceHolder",
					button_text: '<span class="theFont">浏  览  文  件</span>',
					button_text_style: ".theFont { font-size: 12; }",
					button_text_left_padding: 12,
					button_text_top_padding: 3,

					// The event handler functions are defined in handlers.js
					file_queued_handler : fileQueued,
					file_queue_error_handler : fileQueueError,
					file_dialog_complete_handler : fileDialogComplete,
					upload_start_handler : uploadStart,
					upload_progress_handler : uploadProgress,
					upload_error_handler : uploadError,
					upload_success_handler : uploadSuccess,
					upload_complete_handler : uploadComplete,
					queue_complete_handler : queueComplete
			};
			//自定义属性，是否停止上传
			swfUpload = new SWFUpload(settings);
			swfUpload.stopped = false;
	     };

	     function fileDialogComplete(numberselected, numberqueued) {
		     if (swfUpload.getStats().files_queued > 0) {
		    	 document.getElementById("btnCancel").disabled = false;
		     }
	     }


	     function queueComplete(numberselected, numberqueued) {
			//alert(numberselected + "-" + numberqueued);
	     }

	     function upload() {
	    	 if (swfUpload.getStats().files_queued > 0) {
	    		//document.getElementById("btnCancel").disabled = true;
	    	 	swfUpload.startUpload();
	    	 } else {
	    		 alert("请选择要上传的文件!");
	    	 }
	     }
	     
	     function stop() {
	     	if (swfUpload) {
				swfUpload.stopUpload();
			}
	     }
	</script>
	</head>
	<body>
		<div id="content">
			<h2></h2>
			<form id="form1" action="" method="post" enctype="multipart/form-data">
				<p></p>
				<div class="fieldset flash" id="fsUploadProgress">
					<span class="legend">上传文件列表</span>
				</div>
				<div id="divMovieContainer">
					<input id="filenamelist" type="hidden" name="filenamelist" />
					<span id="spanButtonPlaceHolder"></span>
					<input type="button" value="上  传" onclick="upload();" style="margin-left: 2px; font-size: 8pt; height: 29px;" />
					<input type="button" value="停  止" onclick="stop();" style="display: none; margin-left: 2px; font-size: 8pt; height: 29px;" />
					<input id="btnCancel" type="button" value="取消所有" onclick="swfUpload.cancelQueue();" disabled="disabled" style="margin-left: 2px; font-size: 8pt; height: 29px;" />
					<input type="button" onclick="javaScript:window.close();" name="bt" style="margin-left: 2px; font-size: 8pt; height: 29px;" value="关  闭" />
				</div>
			</form>
		</div>
	</body>
</html>
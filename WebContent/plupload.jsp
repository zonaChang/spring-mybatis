<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Plupload使用指南</title>
    <!-- 首先需要引入plupload的源代码 -->
    <script type="text/javascript" src="sources/js/jquery-1.8.3.min.js"></script>
    <script src="sources/plupload/plupload.full.min.js"></script>
    <style>
	body{ font-size: 12px;}
	body,p,div{ padding: 0; margin: 0;}
	.wraper{ padding: 30px 0;}
	.btn-wraper{ text-align: center;}
	.btn-wraper input{ margin: 0 10px;}
	#file-list{margin: 20px auto;}
	#file-list li{ margin-bottom: 10px; float: left; list-style:none;}
	.file-name{ line-height: 30px;}
	.progress{ height: 4px; font-size: 10px; line-height: 4px; background: orange; width: 0;}
	.tip1{text-align: center; font-size:14px; padding-top:10px;}
    .tip2{text-align: center; font-size:12px; padding-top:10px; color:#b00}
    .catalogue{ position: fixed; _position:absolute; _width:200px; left: 0; top: 0; border: 1px solid #ccc;padding: 10px; background: #eee}
    .catalogue a{ line-height: 30px; color: #0c0}
    .catalogue li{ padding: 0; margin: 0; list-style: none;}
	</style>
	<script type="text/javascript">
		$(function(){
			$("#uploadfile").removeAttr("style");
			$("body").removeAttr("style");
			$("#browse").removeAttr("style");
		});
	</script>
</head>
<body>
	
    <!-- 这里我们只使用最基本的html结构：一个选择文件的按钮，一个开始上传文件的按钮(甚至该按钮也可以不要) -->
    <p id="uploadfile">
        <button id="browse">选择文件</button>
        <button id="start_upload">开始上传</button>
    </p>
    
    <div>
		<ul id="file-list">

		</ul>
	</div>
    <script>

    //实例化一个plupload上传对象
    var uploader = new plupload.Uploader({
        browse_button : 'browse', //触发文件选择对话框的按钮，为那个元素id
        url : '/file/operate/plupload/uploadFile', //服务器端的上传页面地址
        flash_swf_url : 'sources/plupload/js/Moxie.swf', //swf文件，当需要使用swf方式进行上传时需要配置该参数
        silverlight_xap_url : 'sources/plupload/js/Moxie.xap', //silverlight文件，当需要使用silverlight方式进行上传时需要配置该参数
        filters: {
        	//只允许上传图片和zip文件, 在文件选择弹框中会根据以下配置自动限制显示的文件
        	  mime_types : [ 
        	    { title : "Image files", extensions : "jpg,gif,png" }, 
        	    { title : "Zip files", extensions : "zip" },
        	    { title : "txt files", extensions : "txt" },
        	  ],
        	  max_file_size : '400kb', //最大只能上传400kb的文件
        	  prevent_duplicates : true //不允许选取重复文件
        	}
    });    

    //在实例对象上调用init()方法进行初始化
    uploader.init();
    
	// 上传文件所在li的id前缀
    var imgliPrefix = "file-";
	
    //绑定各种事件，并在事件监听函数中做你想做的事
    uploader.bind('FilesAdded',function(uploader,files){
    	for(var i = 0, len = files.length; i<len; i++){
			var file_name = files[i].name; //文件名
			//构造html来更新UI
			var html = '<li id="'+imgliPrefix+files[i].id +'"><p class="file-name">' + file_name + '</p><p class="progress"></p><a  href="javascript:;" style="display:block; background:gray;" class="removeFile" fileBlockId="'+files[i].id+'">删除</a></li>';
			$(html).appendTo('#file-list');
			!function(i){
				previewImage(files[i],function(imgsrc){
					$('#'+imgliPrefix+files[i].id).append('<img src="'+ imgsrc +'" />');
				})
		    }(i);
		}
    });
    
    // 上传进度
    uploader.bind('UploadProgress',function(uploader,file){
    	$("#"+imgliPrefix+file.id).find(".progress").each(function(){
    			$(this).text(file.percent+"%");
    			if(file.percent == 100){
    				$(this).parent().remove();
    			}
    	});
    });

    // 开始上传
    document.getElementById('start_upload').onclick = function(){
        //调用实例对象的start()方法开始上传文件，当然你也可以在其他地方调用该方法
        if($("#file-list li").length >  0){
	        uploader.start(); 
        } else{
        	alert("请选择文件。。。");
        }
        
    }
	
    // 移除其中一项待上传的图片
    $("#file-list").delegate(".removeFile", "click", function(){
    	var temp = -1;
    	var file = null;
    	for(var i=0, len=uploader.files.length; i < len; i++){
    		if(uploader.files[i].id == $(this).attr("fileBlockId")){
    			temp = i;
    			file = uploader.files[i];
    			break;
    		}
    	}
    	// uploader.splice(temp, 1); //从temp开始删除， 删除1个文件，第二个参数是要删除的文件数量
    	// uploader.removeFile(file); //使用file对象删除
    	uploader.removeFile($(this).attr("fileBlockId")) //使用file.id 删除
    	$(this).parent().remove();
    });
    
    // 队列中的其中一个完成了上传
    uploader.bind("FileUploaded", function(uploader,file,responseObject){
    	if(responseObject.status == "200"){
    		$("#"+imgliPrefix+file.id).parent().remove();
    	}
    });
    
    // 所有文件上传完成
    uploader.bind("UploadComplete", function(uploader,files){
    	alert("共上传"+files.length+"个文件");
    });
	
 	//plupload中为我们提供了mOxie对象
	//有关mOxie的介绍和说明请看：https://github.com/moxiecode/moxie/wiki/API
	function previewImage(file,callback){//file为plupload事件监听函数参数中的file对象,callback为预览图片准备完成的回调函数
		if(!file || !/image\//.test(file.type)) return; //确保文件是图片
		if(file.type=='image/gif'){//gif使用FileReader进行预览,因为mOxie.Image只支持jpg和png
			var fr = new mOxie.FileReader();
			fr.onload = function(){
				callback(fr.result);
				fr.destroy();
				fr = null;
			}
			fr.readAsDataURL(file.getSource());
		}else{
			var preloader = new mOxie.Image();
			preloader.onload = function() {
				preloader.downsize( 300, 300 );//先压缩一下要预览的图片,宽300，高300
				var imgsrc = preloader.type=='image/jpeg' ? preloader.getAsDataURL('image/jpeg',80) : preloader.getAsDataURL(); //得到图片src,实质为一个base64编码的数据
				callback && callback(imgsrc); //callback传入的参数为预览图片的url
				preloader.destroy();
				preloader = null;
			};
			preloader.load( file.getSource() );
		}	
	}
    
	$("#uploadfile").removeAttr("style");
	$("body").removeAttr("style");
	$("#browse").removeAttr("style");
    </script>
    
</body>
</html>
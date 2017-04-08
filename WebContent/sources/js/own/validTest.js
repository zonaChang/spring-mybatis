$(function(){
	$("#submit").click(function(){
		$.ajax({
			url:"/test/valid",
			data: {
					"name":$("#name").val(),
					"age":$("#age").val()
					},
			dataType:"json",
			success:function(data){
				alert(data);
			}
		});
	});
})
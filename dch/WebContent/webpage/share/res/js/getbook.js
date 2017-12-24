
/*
$('.fand').change(function() {
	alert("5");
	//var path=$("#uploadFile").val();
	//$(".inputdiv").css("background-image","url('"+path+"')");
});


*/

function change() {  
	//$(".inputdiv").css({"background-image":"url('webpage/share/res/png/hhh.png')"});
	var file = document.getElementById("uploadFile");
	var file = file.files[0];
    var reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = function(e){
    	$(".inputdiv").css({"background-image":"url('"+this.result+"')"});
    	//$(".inputdiv").css({"background-color":"#acb9c1"});
        //var pic = document.getElementById("img");
        //pic.src=this.result;
    }
}


function getbook() {  
    //var image0 = $("input[name='file_temporaryImage']").val();  
    //判断上传控件中是否选择了图片  
    var image = $("#uploadFile").val();  
    if ($.trim(image) == "") {  
        alert("请选择图片！");  
        return;  
    }  
    $("#shclDefault").css({"display":"block"});
    //提交请求处理的url  
    var actionUrl = "GetBook";  
    //开始ajax操作  
    $("#getbook").ajaxSubmit({  
        
            type: "POST",//提交类型  
            url: actionUrl,//请求地址
            timeout: 10000,
            data: { "action": "TemporaryImage" },//请求数据  
            success: function (data) {//请求成功后的函数  
            	$("#shclDefault").css({"display":"none"});
            	var obj = eval ("(" + data + ")");
            	if(obj.state=="error")alert(obj.reason);
            	else{
	                $(".inputdiv").css("background-image","url('http://"+obj.data[0].png+"')");
	                $("a.lititle").html(obj.data[0].title);
	                $("a.liauthor").html(obj.data[0].author);
	                $("a.lipriace").html(obj.data[0].priace);
	                $("a.lipublicc").html(obj.data[0].publicc);
	                $("a.lipublicc").append(obj.data[0].publictime);
	                $(".upcontent").css({width:"80%","background-image":"none"});
	                $(".center").css({width:"750px"});
	                $("ul.bookinformation").css({display:"inline-block"});
	                $(".get").css({display:"inline-block","margin":"80px 190px"});
            	}
            },  
            error: function (data) {$("#shclDefault").css({"display":"none"}); alert("error"); },//请求失败的函数  
            async: true  
       
    });  
    
}  
function upbook() {  
	var actionUrl = "UpBook";
	$("#upbook").ajaxSubmit({  
        
        type: "POST",//提交类型  
        url: actionUrl,//请求地址
        timeout: 10000,
        data: { "action": "TemporaryImage" },//请求数据  
        success: function (data) {//请求成功后的函数  
        	var obj = eval ("(" + data + ")");
        	if(obj.state=="error")alert(obj.reason);
        	else {alert("上传成功");history.go(0);}
        },  
        error: function (data) { alert("error"); },//请求失败的函数  
        async: true  
   
}); 
   
}






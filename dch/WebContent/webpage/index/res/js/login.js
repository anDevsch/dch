;(function ($) {
			$(document).ready(function(){
			
					$("button.login").click(function(){
						var hhheee=$("html").height()+"px";
						var wwweee=$("#header").width()+"px";
						//alert(hhheee);
						$(".other").css({display:"block",height:hhheee,width:wwweee});
						$("#fang").css({"display":"block"});
					});

					$("button.logret").click(function(){
						$(".other").css({display:"none"});
						$("#fang").css({display:"none"});
					});

		  
		});
})(jQuery);
		

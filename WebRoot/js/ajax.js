$(function(){
	$(".next_page").click(function(){
		$.post("http://localhost:8080/translate/FileServlet",function(data,textStatus){
			
			$("#div").html(data);
			var $span = $("#text div span");
			$span.addClass("inline");
			$span.mouseover(function(){
				$(this).addClass("word-selcet");
			}).mouseout(function(){
				$(this).removeClass("word-selcet");
			}).click(word_click)
			
		});
		
	});
})
var word_clicked = false;
function word_click(){
	if(word_clicked==true) return;
	word_clicked = true;
	$.post("http://localhost:8080/translate/ExplainServlet",{word:$(this).html()},function(data,textStatus){
		word_clicked = false;
		$("#tran").html(data);
		
		$("#tran a").addClass("star");
	})
}
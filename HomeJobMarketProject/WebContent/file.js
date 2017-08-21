$(function(){
    $("#div2").hide();
    $("#sec").on("click", function(){
    	
        $("#div1, #div2").toggle();
    });
  $("#frst").on("click", function(){
    	
        $("#div2, #div1").toggle();
    });
});
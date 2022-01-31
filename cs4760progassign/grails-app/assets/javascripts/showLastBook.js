// Show time - Simple Ajax
console.log("Hello showLastBook");
$(document).ready( function(){
    console.log("In document ready");
    $('#book').load("/cs4760progassign/home/showLatestBook");
    $('#bookLink').click(function(){
        $('#book').load(this.href);
        return false;
    });
});
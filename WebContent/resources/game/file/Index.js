// JavaScript Document
$(function () {
    erMenu();
});


function erMenu() {
    $(".navLi").mouseover(function() {
        $(this).find(".ermenu").show();
    });
    $(".navLi").mouseleave(function() {
        $(this).find(".ermenu").hide();
    });
}
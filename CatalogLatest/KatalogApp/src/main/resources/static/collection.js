function openNav() {
    document.getElementById("mySidenav").style.width = "14%";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
}

var posY;

$(document).mousemove( function(e) {
   posY = e.pageY;
    $('.button').css({'top': posY});
});
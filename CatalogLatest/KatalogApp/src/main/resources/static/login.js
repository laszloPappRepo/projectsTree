
$(function(){
  $("#pass").on({
   mouseenter: function(){
    $(this).attr('src','../static/incognito.png');
  },
  mouseleave: function(){
    $(this).attr('src','../static/ewok.png');
  }
  });
});
// login page
$(".email-signup").hide();
$("#signup-box-link").click(function(){
  $(".email-login").fadeOut(100);
  $(".email-signup").delay(100).fadeIn(100);
  $("#login-box-link").removeClass("active");
  $("#signup-box-link").addClass("active");
});
$("#login-box-link").click(function(){
  $(".email-login").delay(100).fadeIn(100);;
  $(".email-signup").fadeOut(100);
  $("#login-box-link").addClass("active");
  $("#signup-box-link").removeClass("active");
});


// send-bird
var nickname = '';

$('#user_nickname').change(function() {
  nickname = $('#user_nickname').val().replace(/ /gi, '');
});

$('#btn_start').click(function() {
  if (nickname.isEmpty()) {
    alert('Please enter user nickname');
    return;
  }

//console.log(nickname);
//console.log(encodeURI(nickname));
//console.log(encodeURIComponent(nickname));
//console.log(encodeURI(encodeURIComponent(nickname)));

  window.location.href = 'chat.html?nickname=' + encodeURI(encodeURIComponent(nickname));
});

$(document).ready(function() {
  $('#user_nickname').val('');
  $('#user_nickname').focus();
});
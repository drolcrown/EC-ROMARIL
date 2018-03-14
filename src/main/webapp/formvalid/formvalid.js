var validtel = false;
jQuery(document).ready(function($) {
    "use strict";
  
    //Contact
    $('form.contactForm').submit(function() {
      var f = $(this).find('.form-group'),
        ferror = false,
        emailExp = /^[a-z0-9._-]+@[a-z]+.[a-z]+.br/ig;
        
      f.children('input').each(function() { // run all inputs
  
        var i = $(this); // current input
        var rule = i.attr('data-rule');
  
        if (rule !== undefined) {
          var ierror = false; // error flag for current input
          var pos = rule.indexOf(':', 0);
          if (pos >= 0) {
            var exp = rule.substr(pos + 1, rule.length);
            rule = rule.substr(0, pos);
          } else {
            rule = rule.substr(pos + 1, rule.length);
          }
  
          switch (rule) {
            case 'required':
              if (i.val() === '') {
                ferror = ierror = true;
              }
              break;
  
            case 'minlen':
              if (i.val().length < parseInt(exp)) {
                ferror = ierror = true;
              }
                break;

            case 'matricula':
            if(i.val()[0]  !== 'c' && i.val()[0] !== 'e' && i.val()[0] !== 'f'){
                  ferror = ierror = true;
            }else{
                var matr = i.val().substring(1, i.val().length);
                if(isNaN(matr)){
                  ferror = ierror = true;
                }
            }
                break;

            case 'nome':
            var nomeExp = i.val().match(nomeExp);
            nomeExp = new RegExp("^[a-z ]+","ig");
            if (!nomeExp.test(i.val())) {
              ferror = ierror = true;
            }
               break; 
            
            case 'email':
              if (!emailExp.test(i.val())){
                ferror = ierror = true;
              }
                break;

            case 'unidade':
              var unidadeExp = i.val().match(unidadeExp);
              unidadeExp = new RegExp("^[a-z ]+","ig");
                if (!unidadeExp.test(i.val())) {
                  ferror = ierror = true;
                }
                  break;

            // case 'telefone':
            // if(validtel){
            //     var telefoneExp = i.val().match(telefoneExp);
            //     telefoneExp = new RegExp("^[(-0-9]+","ig");
            //       if (!telefoneExp.test(i.val())) {
            //           ferror = ierror = true;
            //         }
            //     }
            //      break;
  
            case 'checked':
              if (!i.attr('checked')) {
                ferror = ierror = true;
              }
                break;
  
            case 'regexp':
              exp = new RegExp(exp);
              if (!exp.test(i.val())) {
                ferror = ierror = true;
              }
                break;
          }
          i.next('.validation').html((ierror ? (i.attr('data-msg') !== undefined ? i.attr('data-msg') : 'wrong Input') : '')).show('blind');
        }
      });
      f.children('textarea').each(function() { // run all inputs
  
        var i = $(this); // current input
        var rule = i.attr('data-rule');
  
        if (rule !== undefined) {
          var ierror = false; // error flag for current input
          var pos = rule.indexOf(':', 0);
          if (pos >= 0) {
            var exp = rule.substr(pos + 1, rule.length);
            rule = rule.substr(0, pos);
          } else {
            rule = rule.substr(pos + 1, rule.length);
          }
  
          switch (rule) {
            case 'required':
              if (i.val() === '') {
                ferror = ierror = true;
              }
              break;
  
            case 'minlen':
              if (i.val().length < parseInt(exp)) {
                ferror = ierror = true;
              }
              break;
          }
          i.next('.validation').html((ierror ? (i.attr('data-msg') != undefined ? i.attr('data-msg') : 'wrong Input') : '')).show('blind');
        }
      });
      if (ferror) return false;
      else var str = $(this).serialize();
      $.ajax({
        type: "POST",
        url: "contactform/contactform.php",
        data: str,
        success: function(msg) {
          // alert(msg);
          if (msg == 'OK') {
            $("#sendmessage").addClass("show");
            $("#errormessage").removeClass("show");
            $('.contactForm').find("input, textarea").val("");
          } else {
            $("#sendmessage").removeClass("show");
            $("#errormessage").addClass("show");
            $('#errormessage').html(msg);
          }
  
        }
      });
      return false;
    });
  });
  
// ocultar div telefone 
function showDiv() {
  var ocultar = document.getElementById("telefone");
    if(ocultar.style.display === "block"){
      ocultar.style.display = "none";
      if(validtel){
        document.getElementById('validOculto').textContent = '';
      }
      validtel = false;
     }else{
      ocultar.style.display = "block";
      validtel = true;
     }
 }

//mascara
 function mascara(o,f){
  v_obj=o
  v_fun=f
  setTimeout("execmascara()",1)
}
function execmascara(){
  v_obj.value=v_fun(v_obj.value)
}
function mtel(v){
  v=v.replace(/\D/g,"");             //Remove tudo o que não é dígito
  v=v.replace(/^(\d{2})(\d)/g,"($1) $2"); //Coloca parênteses em volta dos dois primeiros dígitos
  v=v.replace(/(\d)(\d{4})$/,"$1-$2");    //Coloca hífen entre o quarto e o quinto dígitos
  return v;
}
function id( el ){
return document.getElementById( el );
}
window.onload = function(){
id('telefone').onkeyup = function(){
  mascara( this, mtel );
}
}

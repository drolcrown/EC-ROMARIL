(function () {
    var Message;
    Message = function (arg) {
        this.text = arg.text, this.message_side = arg.message_side;
        this.draw = function (_this) {
            return function () {
                var $message;
                $message = $($('.message_template').clone().html());
                $message.addClass(_this.message_side).find('.text').html(_this.text);
                $('.messages').append($message);
                return setTimeout(function () {
                    return $message.addClass('appeared');
                }, 0);
            };
        }(this);
        return this;
    };
    $(function () {
        var getMessageText, message_side, sendMessage;
        message_side = 'right';
        getMessageText = function () {
            var $message_input;
            $message_input = $('.message_input');
            return $message_input.val();
        };
        sendMessage = function (text, bool) {
            var $messages, message;
            if (text.trim() === '') {
                return;
            }
            $('.message_input').val('');
            $messages = $('.messages'); //.messagem 
            if(!bool){
                message_side = message_side === 'left' ? 'left' : 'left';
            }else{
                message_side = message_side === 'right' ? 'right' : 'right';
            }
            message = new Message({
                text: text,
                message_side: message_side
            });
            
            message.draw();
            return $messages.animate({ scrollTop: $messages.prop('scrollHeight') }, 300);
        }; 
        
        $('.post_add').submit(function (e) {
            return sendMessage(getMessageText(), true);
        });

        sendMessage('Olá, sou o Safadão.' , false);
        setTimeout(function () {
            return sendMessage('Oi Safadão, poderia me ajudar com o chat?', true);
        }, 1000);
        return setTimeout(function () {
            return sendMessage('Sim, vamos lá!', false);
        }, 2000);
     
    });
}.call(this));

$(document).ready(function() {
    // console.log($('#mensagem').css("height") = "500px");

    var tamanho = document.getElementById('mensagem');
    var rodape = document.getElementById('rodape');
    let altura = screen.height * 0.67;
    if(altura > 500){
        if(altura > 800){
            tamanho.style.paddingTop = 40 + 'px';
            rodape.style.paddingTop = 50 + 'px';
        }else{
            tamanho.style.paddingTop = 20 + 'px';
            rodape.style.paddingTop = 40 + 'px'; 
        }
        altura+= altura * 0.25;
    }else{
        altura+= altura * 0.18;
    }
    tamanho.style.height = (altura) + "px";
});
    
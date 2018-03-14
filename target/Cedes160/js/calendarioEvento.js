var placeAtiv = false;
var eventos = [], outro;
var cont = 0;
var data = new Date();
var meses = ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho',
    'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'
];

// $(document).ready(function() {
//     mostraEventos();
// });

function acionaEventos() {
    if (!placeAtiv) {
        adicionarPlaceholders();
    }
    mostrarCalendario();
    mostrarEventos();
}

function adicionarPlaceholders() {
    var dia = data.getDate(),
        mes = data.getMonth() + 1;

    if (data.getDate() < 10) {
        dia = '0' + dia;
    }
    if (data.getMonth() < 10) {
        mes = '0' + mes;
    }
    document.getElementById('dataInicio').placeholder =
        dia + '/' + mes + '/' + data.getFullYear();
    document.getElementById('dataFim').placeholder = '31/12/' + data.getFullYear();
    placeAtiv = true;
}

function mostrarCalendario() {
    $('#dataInicio').datepicker({
        format: "dd/mm/yyyy",
        language: "pt-BR",
        startDate: '-1000d'
    });
    $('#dataFim').datepicker({
        format: "dd/mm/yyyy",
        language: "pt-BR",
        startDate: '-1000d'
    });
}


function mostrarEventos(listaEventos) {
    var evento = document.getElementById('carousel');
    var numEvento = document.getElementById('numEventos');

    eventos = listaEventos;
    numEvento.textContent = 'Numero de eventos encontrados: ' + eventos.length;
    if (!eventos.length > 0) {
        adicionarPrevNext(false);
        evento.innerHTML = "<div id='semEvento'> <h1>Nao Existem Eventos</h1> </div>";
    }else {
        if (eventos.length === 1) {
            adicionarPrevNext(false);
            // evento.removeChild(document.getElementById('semEvento'));
            adicionarEventos(eventos[0]);
        }
       if (eventos.length > 1) {
           adicionarPrevNext(true);
           adicionarEventos(eventos[0]);
           adicionarEventos(eventos[1]);

           // for(i = 0; i < eventos.length; i++) {
           //     adicionarEventos(eventos[i]);
           // }
       }
    }
}

function adicionarPrevNext(bool) {
    var prev = document.getElementById('prev');
    var next = document.getElementById('next');

    if(bool){
        prev.style.display = 'block';
        next.style.display = 'block';
    }else{
        prev.style.display = 'none';
        next.style.display = 'none';
    }
}

function verificarData(dataFim) {
    var dia = dataFim.substring(0, 2);
    var mes = dataFim.substring(3, 5) - 1;
    var ano = dataFim.substring(6, 10);

    if(ano > data.getFullYear()){
        return true;
    }
    if(ano === data.getFullYear()){
        if(mes > data.getMonth()){
            return true;
        }
        if(mes === data.getMonth()){
            if(dia >= data.getDay()){
                return true;
            }
        }
    }

    return false;
}

function adicionarEventos(eventoBd) {

    var evenPas  = ("<div class='section'>" +
        "<a href='#' class='list-group-item list-group-item-action flex-column align-items-start'>" +
            "<div class='cartaoPast d-flex w-100 justify-content-between'>" +
                "<img src='img/eventos/calendar.svg' height='100'>" +
                "<h5 class='mb-1'>Nome evento</h5>" +
                "<small class='text-muted'>3 days ago</small>" +
            "</div>" +
            "<p class='mb-1'>Descrição do evento.</p>" +
            "<small class='text-muted'></small>" +
        "</a><hr>"+
    "</div>");

    verificarData(eventoBd);
    // if(eventoBd.dataFim){
        //Criando o cartão passado
        var eventoPass = document.getElementById('eventosPassados');
        var item = document.createElement('div');
        // item.innerHTML = evenPas;
        // eventoPass.appendChild(item);
        eventoPass.appendChild(evenPas);
    // }

    eventos.push({
        indice: eventoBd.id,
        nomeEvento: eventoBd.nome,
        descricao: eventoBd.descricao,
        dataInicio: eventoBd.dataInicio,
        dataFim:  eventoBd.dataFim,
        estado: eventoBd.estado,
        municipio: eventoBd.municipio,
    });

    // //Criando o cartão
    // var evento = document.getElementById('eventosFuturos');
    // var carouselItem = document.createElement('div');
    // var cartao = document.createElement('div');
    // cartao.className = "cartao";
    // var carouselContainer = document.createElement('div');
    // carouselContainer.className = "carousel-container";
    // var carouselContent = document.createElement('div');
    // carouselContent.className = "carousel-content";
    // var quebraLinha = document.createElement('br');
    //
    // if (evento.children.length === 0) {
    //     carouselItem.className = "carousel-item active";
    // } else {
    //     carouselItem.className = "carousel-item";
    // }
    // // Criando o objeto dentro do carrousel
    // evento.appendChild(carouselItem);
    // carouselItem.appendChild(cartao);
    // carouselItem.appendChild(carouselContainer);
    // carouselItem.appendChild(carouselContent);
    // carouselContent.appendChild(quebraLinha);
}

function dataPorExtenso(data) {
    var dia = data.substring(0, 2);
    var mes = data.substring(3, 5) - 1;
    var ano = data.substring(6, 10);
    return dia + ' de ' + meses[mes] + ' de ' + ano;
}

function pesquisarEvento(dataI, dataF, estado, municipio) {
    var dataInicio = document.getElementById('dataInicio').value;
    var dataFim = document.getElementById('dataFim').value;
    var event = null;

    for (i = 0; i < eventos.length; i++) {
        if (estado === eventos[i].estado || estado === 0) {
            if (municipio === eventos[i].municipio || municipio === 0) {
                if (dataF <= dataFim && dataI >= dataInicio) {
                    event = eventos[i];
                    break;
                }
            }
        }
    }
    if (event === null) {
        alert("Evento Não Encontrado");
    } else {
        return event;
    }
    // (dataFim === dataFim.placeholder || dataInicio === dataInicio.placeholder)
}

function validarData() {
    var dataI = document.getElementById('dataInicio');
    var dataF = document.getElementById('dataFim');
    if (!dataInicio.checkValidity()) {
        document.getElementById("dataInicio").innerHTML = dataInicio.validationMessage;
        return false;
    } else {
        document.getElementById("dataInicio").innerHTML = "Input OK";
        return true;
    }

    if (!dataFim.checkValidity()) {
        document.getElementById("dataFim").innerHTML = dataFim.validationMessage;
        return false;
    } else {
        document.getElementById("dataFim").innerHTML = "Input OK";
        return true;
    }
}

function buscarEventos() {
   return jQuery.ajax({
       type: 'GET',
       url: "rest/eventos/todos",
       dataType: "json",
   }).done(function (data) {
       mostrarEventos(data);
   });
}

function adicionarEventoBD() {
    var nome = document.getElementById('nomeEvento').value;
    var dataI = document.getElementById('dataInicio').value;
    var dataF = document.getElementById('dataFim').value;
    var desc = document.getElementById('descricaoEvento').value;
    jQuery.ajax({
        type: 'POST',
        url: "rest/eventos/salvar",
        dataType: "json",
        data: {
            nome: nome,
            dataInicio: dataI,
            dataFim: dataF,
            estado: "",
            municipio: "",
            descricao: desc
        }
    }).done(function(data){});
}


function excluirEvento(nome, dataI, dataF, est, mun) {
    jQuery.ajax({
        type: 'DELETE',
        url: "rest/eventos/excluir",
        dataType: "json",
        data: {
            nome: nome,
            dataInicio: dataI,
            dataFim: dataF,
            estado: est,
            municipio: mun,
        }
    }).done(function(data){});
}

function teste() {
    var id = document.getElementById('dataInicio');
    console.log(id.value);
}


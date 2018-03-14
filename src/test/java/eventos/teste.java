package eventos;

import DAO.EventoDAO;
import Modelos.Evento;

import java.util.Date;

public class teste {
    public static void main(String[] args){
        Date data = new Date();
        Date dataF = new Date(118,1,3);

        Evento evento = new Evento("Rafa2", data.toString(), dataF.toString(), "da", "go", "");

        EventoDAO eventoDAO = new EventoDAO();
        eventoDAO.salvar(evento);
//        Evento evento = eventoDAO.consultarPorId(Evento.class, 7L);

//        System.out.println(evento.getId());
//        eventoDAO.excluir(evento);
    }
}

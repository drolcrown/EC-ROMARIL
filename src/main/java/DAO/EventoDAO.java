package DAO;

import Modelos.Evento;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by RSouza on 01/03/18.
 */
public class EventoDAO extends DaoGenerico<Evento> {
    public List<Evento> recuperarEvento(String nome, String tipo){
        Query query = getEntityManager()
                .createQuery("SELECT evento FROM Evento AS evento WHERE evento.tipo = :tipo");
        query.setParameter(tipo, nome);

        return query.getResultList();
    }

    public List<Evento> recuperarTodos(){
        Query query = getEntityManager().createQuery("SELECT evento FROM Evento AS evento");

        return query.getResultList();
    }

}

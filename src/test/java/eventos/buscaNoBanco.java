package eventos;

import Modelos.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class buscaNoBanco {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("cedes160");
        EntityManager manager = factory.createEntityManager();

        //cuidado, use o import javax.persistence.Query
        Query query = manager.createQuery("select t from Evento as t where t.nome = :nome");
        query.setParameter("nome", "Rafa2");

        List<Evento> lista = query.getResultList();
        System.out.println(lista);

        for (Evento t : lista) {
            System.out.println(t.getNome());
        }

        manager.close();
    }
}
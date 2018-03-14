package DAO;

import Modelos.EntidadeGenerica;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoGenerico <T extends EntidadeGenerica> {

    public EntityManager getEntityManager(){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("cedes160");

        return fabrica.createEntityManager();
    }

    public T salvar(T entidade){
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            if(entidade.getId() == null){
                em.persist(entidade);
            }else{
                if(!em.contains(entidade)){
                    if(em.find(entidade.getClass(), entidade.getId()) == null){
//                        throw new Exception("Erro ao Atualizar Entidade");
                    }
                }
                entidade = em.merge(entidade);
            }
            em.getTransaction().commit();
        }finally {
            em.close();
        }
        return entidade;
    }

    public void excluirPorId(Class<T> classe, Long id){
        EntityManager em = getEntityManager();
        T entidade = em.find(classe, id);
        excluir(entidade);
    }

    public void excluir(T entidade){
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            em.remove(em.find(entidade.getClasseEntidade(), entidade.getId()));
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    public T consultarPorId(Class<T> classe, Long id){
        EntityManager em = getEntityManager();
        T entidade = null;

        try {
            entidade = em.find(classe, id);
        }finally {
            em.close();
        }
        return entidade;
    }

//    public T alterar(T entidade){
//        EntityManager em = getEntityManager();
//
//        try {
//            entidade = em.merge(entidade);
//        }finally {
//            em.close();
//        }
//        return entidade;
//    }
}

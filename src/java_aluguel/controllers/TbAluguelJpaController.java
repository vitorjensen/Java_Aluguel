/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_aluguel.controllers;

import java.io.Serializable;
import java.util.List;
import java_aluguel.entities.TbAluguel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author vitor
 */
public class TbAluguelJpaController implements Serializable {
    private EntityManagerFactory emf = null;
    
    public TbAluguelJpaController(EntityManagerFactory factory)
    {
        this.emf = factory;
    }
    
     public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
     public List<TbAluguel> findTbAluguelEntities()
     {
         EntityManager em = getEntityManager();
         try{
              CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
              cq.select(cq.from(TbAluguel.class));
          return em.createQuery(cq).getResultList();
        } finally {
            em.close();
        }
     }
     //Função para INSERT na base de dados de aluguel
     public void create(TbAluguel aluguel)
     {
         EntityManager em = null;
         try
         {
             em = getEntityManager();
             em.getTransaction().begin();
             em.persist(aluguel);
             em.getTransaction().commit();
         }catch(Exception ex){
             if(em != null && em.getTransaction().isActive())
             {
                 em.getTransaction().rollback();
             }
             throw ex;
         }finally
         {
             if(em != null)
             {
                 em.close();
             }
         }
         
     }
     
     //Função Edit dentro da controller para passar para view
     public void edit(TbAluguel aluguel) throws Exception{
         EntityManager em = getEntityManager();
         try{
             em.getTransaction().begin();
             aluguel = em.merge(aluguel);
             em.getTransaction().commit();
         }catch(Exception ex)
         {
             em.getTransaction().rollback();
             throw new Exception("Erro ao utilizar o aluguel: " + ex.getMessage());
         }finally{
             em.close(); 
         }
         
     }
     
    public TbAluguel findAluguel(int id) {
    EntityManager em = getEntityManager();
    try {
        return em.find(TbAluguel.class, id);
    } finally {
        em.close();
    }
}
     public void destroy(Integer AluCodigo) throws Exception
     {
         EntityManager em = null;
         try{
              em = getEntityManager();
            em.getTransaction().begin();
            TbAluguel aluguel;
            try{
                aluguel = em.getReference(TbAluguel.class, AluCodigo);
                aluguel.getAluCodigo();
            }catch (EntityNotFoundException enfe){
                throw new Exception("Aluguel com ID: " + AluCodigo + " não encontrado.", enfe);
         }
             em.remove(aluguel);
            em.getTransaction().commit();
     }finally{
             if(em != null)
            {
                em.close();
            }
         }
     }
}

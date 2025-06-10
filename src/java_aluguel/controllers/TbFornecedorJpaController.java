/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_aluguel.controllers;

import java.util.List;
import java_aluguel.entities.TbFornecedor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author vitor
 */
public class TbFornecedorJpaController {
      private EntityManagerFactory emf = null;
      
      public TbFornecedorJpaController(EntityManagerFactory factory){
          this.emf = factory;
      }
      
      public EntityManager getEntityManager()
      {
           return emf.createEntityManager();
      }
      
      //Método para retornar todos os fornecedores
      public List<TbFornecedor> findTbFornecedorEntities()
      {
          EntityManager em = getEntityManager();
          try{
              CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
              cq.select(cq.from(TbFornecedor.class));
              return em.createQuery(cq).getResultList();
          }finally {
            em.close();
        }
}
       public void create(TbFornecedor fornecedor) {
        EntityManager em = null;
        try {
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(fornecedor);
        em.getTransaction().commit();
        } catch (Exception ex) {
        if (em != null && em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        throw ex;
        } finally {
        if (em != null) {
            em.close();
        }
    }
}
       public void edit(TbFornecedor fornecedor)throws Exception{
           EntityManager em = null;
           try{
               em = getEntityManager();
               em.getTransaction().begin();
               fornecedor = em.merge(fornecedor);
               em.getTransaction().commit();
           }catch(Exception ex)
           {
               if(em != null && em.getTransaction().isActive())
            {
                em.getTransaction().rollback();
            }
            throw ex;
           }finally{
            if(em != null)
            {
                em.close();
        }
       }
       }
       public void destroy(Integer ForCodigo)throws Exception
               {
                    EntityManager em = null;
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            TbFornecedor fornecedor;
            try{
                fornecedor = em.getReference(TbFornecedor.class, ForCodigo);
                fornecedor.getForCodigo();
            }catch (EntityNotFoundException enfe){
                throw new Exception("Cliente com ID: " + ForCodigo + " não encontrado.", enfe);
            }
            em.remove(fornecedor);
            em.getTransaction().commit();
        }finally{
            if(em != null)
            {
                em.close();
            }
        }
     }
}

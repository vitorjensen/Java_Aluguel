/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_aluguel.controllers;

import java.util.List;
import java_aluguel.entities.TbVendedor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author vitor
 */
public class TbVendedorJpaController {
 private EntityManagerFactory emf = null;

    public TbVendedorJpaController(EntityManagerFactory factory) {
        this.emf = factory;
    }
    
     public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
     
     
     //Método CREATE para INSERT de dados
     public void create(TbVendedor vendedor)
     {
         EntityManager em = null;
         try{
             em = getEntityManager();
             em.getTransaction().begin();
             em.persist(vendedor);
             em.getTransaction().commit();
         }catch(Exception ex)
         {
             if (em != null && em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
              throw ex;
         }finally {
        if (em != null) {
            em.close();
        }
    }
     }
     
     //Método EDIT para dados de vendedor 
     public void edit(TbVendedor vendedor) throws Exception
     {
          EntityManager em = null;
         try{
             em = getEntityManager();
            em.getTransaction().begin();
            vendedor = em.merge(vendedor);
            em.getTransaction().commit();
         }catch(Exception ex){
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
    public void destroy(Integer VenCodigo) throws Exception{
        EntityManager em = null;
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            TbVendedor vendedor;
            try{
                vendedor = em.getReference(TbVendedor.class, VenCodigo);
                vendedor.getVenCodigo();
            }catch (EntityNotFoundException enfe){
                throw new Exception("Cliente com ID: " + VenCodigo + " não encontrado.", enfe);
            }
            em.remove(vendedor);
            em.getTransaction().commit();
        }finally{
            if(em != null)
            {
                em.close();
            }
        }
    }
         // Método para retornar todos os Vendedores
    public List<TbVendedor> findTbVendedorEntities() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TbVendedor.class));
            return em.createQuery(cq).getResultList();
        } finally {
            em.close();
        }
    }
    public TbVendedor findTbVendedor(int id)
    {
      EntityManager em = getEntityManager();
        try
        {
            return em.find(TbVendedor.class, id);
        }finally{
            em.close();
        } 
    }
}

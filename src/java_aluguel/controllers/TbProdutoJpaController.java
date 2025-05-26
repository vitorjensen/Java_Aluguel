/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_aluguel.controllers;
import java.util.List;
import java_aluguel.entities.TbProduto;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author vitor
 */
public class TbProdutoJpaController {
     private EntityManagerFactory emf = null;

    public TbProdutoJpaController(EntityManagerFactory factory) {
        this.emf = factory;
    }
    
     public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
     
     public List<TbProduto> findTbProdutoEntities()
     {
         EntityManager em = getEntityManager();
         try{
             CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
             cq.select(cq.from(TbProduto.class));
             return em.createQuery(cq).getResultList();
         }finally{
             em.close();
         }
     }
     
     //Função para trazer o relacionamento entre TbAluguel e TbProduto (ID, Descrição...)
      public TbProduto findTbProduto(int id)
    {
        EntityManager em = getEntityManager();
        try
        {
            return em.find(TbProduto.class, id);
        }finally{
            em.close();
        }
    }
}

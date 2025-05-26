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
}

package java_aluguel.controllers;

import java.util.List;
import java_aluguel.entities.TbCliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;

public class TbClienteJpaController {

    private EntityManagerFactory emf = null;

    public TbClienteJpaController(EntityManagerFactory factory) {
        this.emf = factory;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Método para retornar todos os clientes
    public List<TbCliente> findTbClienteEntities() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TbCliente.class));
            return em.createQuery(cq).getResultList();
        } finally {
            em.close();
        }
    }
    //Função Create dentro da controller para passar para view
    public void create(TbCliente cliente) {
    EntityManager em = null;
    try {
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(cliente);
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
    //Função Edit dentro da controller para passar para view
    public void edit(TbCliente cliente) throws Exception{
        EntityManager em = null;
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            cliente = em.merge(cliente);
            em.getTransaction().commit();
        } catch (Exception ex)
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
  //Criando método na controller para realizar o "destroy"
    public void destroy(Integer CliCodigo) throws Exception{
        EntityManager em = null;
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            TbCliente cliente;
            try{
                cliente = em.getReference(TbCliente.class, CliCodigo);
                cliente.getCliCodigo();
            }catch (EntityNotFoundException enfe){
                throw new Exception("Cliente com ID: " + CliCodigo + " não encontrado.", enfe);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        }finally{
            if(em != null)
            {
                em.close();
            }
        }
    }
}

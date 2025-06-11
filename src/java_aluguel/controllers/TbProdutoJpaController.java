/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_aluguel.controllers;
import java.util.Date;
import java.util.List;
import java_aluguel.entities.TbProduto;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import static javax.swing.UIManager.get;

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
     
     public TbProduto findProduto(int id) {
    EntityManager em = getEntityManager();
    try {
        return em.find(TbProduto.class, id);
    } finally {
        em.close();
    }
     }
     
      //Função para INSERT na base de dados de aluguel
     public void create(TbProduto produto)
     {
         EntityManager em = null;
         try
         {
             em = getEntityManager();
             em.getTransaction().begin();
             em.persist(produto);
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
     //Criando método na controller para realizar o "destroy"
    public void destroy(Integer ProCodigo) throws Exception{
        EntityManager em = null;
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            TbProduto produto;
            try{
                produto = em.getReference(TbProduto.class, ProCodigo);
                produto.getProCodigo();
            }catch (EntityNotFoundException enfe){
                throw new Exception("Cliente com ID: " + ProCodigo + " não encontrado.", enfe);
            }
            em.remove(produto);
            em.getTransaction().commit();
        }finally{
            if(em != null)
            {
                em.close();
            }
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
      public List<Object[]> buscarEntreDatas(Date dataInicio, Date dataFinal)
      {
       EntityManager em = getEntityManager();
       try{
           String sql = "SELECT p.pro_codigo, p.pro_foto, p.pro_descricao, p.pro_qtde, a.qtde_locado " +
                   "FROM tb_produto p " +
                   "INNER JOIN (" +
                   " SELECT al.pro_codigo, SUM(al.alu_qtde) AS qtde_locado " +
                   " FROM tb_aluguel al " +
                   " WHERE al.alu_status <> 'RESERVADO' " +
                   " AND ( " +
                   "        (al.alu_data_inicial BETWEEN ?1 AND ?2) " +
                   " OR " +
                   "  (al.alu_data_inicial > al.alu_data_final AND al.alu_data_final BETWEEN ?1 AND ?2) " +
                    "     ) " +
                    "   GROUP BY al.pro_codigo " +
                   ") a ON a.pro_codigo = p.pro_codigo";
           Query query  = em.createNativeQuery(sql);
           query.setParameter(1, dataInicio);
           query.setParameter(2, dataFinal);
           
           return query.getResultList();
           
       }finally{
           em.close();
       }
      }
}

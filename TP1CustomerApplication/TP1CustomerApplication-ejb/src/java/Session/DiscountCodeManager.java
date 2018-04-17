/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entities.DiscountCode;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class DiscountCodeManager {
    @PersistenceContext(unitName = "TP1CustomerApplication-ejbPU")
    private EntityManager em;
    
     public List<DiscountCode> getDiscountCodes() {  
        Query query = em.createNamedQuery("DiscountCode.findAll");  
        return query.getResultList();  
    } 

    public void persist(Object object) {
        em.persist(object);
    }
    public DiscountCode getDiscountCodeByDiscountCode(char code) {  
        Query query = em.createNamedQuery("DiscountCode.findByDiscountCode");  
        query.setParameter("discountCode", "" + code);  
        return (DiscountCode) query.getSingleResult();  
 } 
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}

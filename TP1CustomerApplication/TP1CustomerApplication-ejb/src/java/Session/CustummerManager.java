/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entities.Customer;
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
public class CustummerManager {
    @PersistenceContext(unitName = "TP1CustomerApplication-ejbPU")
    private EntityManager em;

    public List<Customer> getAllCustomer() {
     Query query = em.createNamedQuery("Customer.findAll");  
        return query.getResultList();  
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public Customer update(Customer customer) {
            return em.merge(customer);
    }
 public Customer getCustomer(int idCustomer) {  
        return em.find(Customer.class, idCustomer);  
    }  
    public void persist(Object object) {
        em.persist(object);
    }
}

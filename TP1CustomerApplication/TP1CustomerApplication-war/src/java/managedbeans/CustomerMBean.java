/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import Session.CustummerManager;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import entities.Customer; 
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Administrator
 */
@ManagedBean
@ViewScoped
public class CustomerMBean implements Serializable{
    private  List <Customer> customerList;
    
    @EJB
    private CustummerManager customerManager;
      public CustomerMBean() {
    }
      
  
    /*public List <Customer> getCustomerList(){
    return customerManager.getAllCustomer();
    }*/
   public Collection <Customer> getCustomer(){
    return customerManager.getAllCustomer();
    }
    
     public String showDetails(int customerId) {  
        return "CustomerDetails?idCustomer=" + customerId;    }  
     
}  
    /**
     * Creates a new instance of CustomerMBean
     */
  
    


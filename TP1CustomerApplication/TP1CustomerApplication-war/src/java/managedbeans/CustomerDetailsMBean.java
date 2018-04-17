/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import Session.CustummerManager;
import Session.DiscountCodeManager;
import entities.Customer;
import entities.DiscountCode;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

/**
 *
 * @author Administrator
 */
@ManagedBean
@ViewScoped
public class CustomerDetailsMBean implements Serializable{
  private int idCustomer;  
  private Customer customer; 
  @EJB  
private CustummerManager customerManager;  
    @EJB  
private DiscountCodeManager discountCodeManager; 

  
private Converter discountCodeConverter = new Converter() {  
  
    @Override  
    public Object getAsObject(FacesContext context, UIComponent component, String value) {  
        return new ConverterException("On verra la conversion String->Objet plus tard...");  
    }  
    @Override  
    public String getAsString(FacesContext context, UIComponent component, Object value) {  
        DiscountCode dc = (DiscountCode) value;  
        return dc.getDiscountCode()+" : "+dc.getRate()+"%";   
    }  
};  
  
  
    /**
     * Creates a new instance of CustomerDetailsMBean
     */
    public CustomerDetailsMBean() {
    }
  
  
  public int getIdCustomer() {  
    return idCustomer;  
  }  
  
  public void setIdCustomer(int idCustomer) {  
    this.idCustomer = idCustomer;  
  }  
  
  /** 
   * Renvoie les détails du client courant (celui dans l'attribut customer de 
   * cette classe), qu'on appelle une propriété (property) 
   */  
  public Customer getDetails() {  
    return customer;  
  }  
  
  /** 
   * Action handler - met à jour la base de données en fonction du client passé 
   * en paramètres, et renvoie vers la page qui affiche la liste des clients. 
   */  
  public String update() {  
      
   customer = customerManager.update(customer);
return "CustomerList?faces-redirect=true";
  }  
  
  
  
  /** 
   * Action handler - renvoie vers la page qui affiche la liste des clients 
   */  
  public String list() {
        System.out.println("###LIST###");
        return "CustomerList?faces-redirect=true";
    }
    
  
  public void loadCustomer() {  
    this.customer = customerManager.getCustomer(idCustomer);  
  }  
  

      
public Converter getDiscountCodeConverter() {  
    return discountCodeConverter;  
}  
  
public List<DiscountCode> getAllDiscountCodes() {  
    return discountCodeManager.getDiscountCodes();  
} 
  
}  


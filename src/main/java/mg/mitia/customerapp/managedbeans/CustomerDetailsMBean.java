/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.mitia.customerapp.managedbeans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import mg.mitia.customerapp.entities.Customer;
import mg.mitia.customerapp.session.CustomerManager;

/**
 *
 * @author Raoel
 */
@Named
@ViewScoped
public class CustomerDetailsMBean implements Serializable{
    private int idCustomer;
    private Customer customer;
    @EJB
    private CustomerManager customerManager;
    
    public int getIdCustomer(){
        return idCustomer;
    }
    public void setIdCustomer(int idCustomer){
        this.idCustomer = idCustomer;
    }
    public Customer getDetails(){
        return customer;
    }
    public String update(){
        customer = customerManager.update(customer);
        return "CustomerList";
    }
    public void loadCustomer(){
        this.customer = customerManager.getCustomer(idCustomer);
    }
}

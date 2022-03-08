/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package mg.mitia.customerapp.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mg.mitia.customerapp.entities.Customer;

/**
 *
 * @author Raoel
 */
@Stateless
public class CustomerManager {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    public void persist(Object customer) {
      em.persist(customer);
    }
    public List<Customer> getAllCustomers() {  
      Query query =  em.createNamedQuery("Customer.findAll");
      return query.getResultList();  
    }  
        
    public Customer update(Customer customer) {
      return em.merge(customer);  
    }     
}

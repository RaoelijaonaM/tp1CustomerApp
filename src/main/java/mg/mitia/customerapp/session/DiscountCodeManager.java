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
import mg.mitia.customerapp.entities.DiscountCode;

/**
 *
 * @author Raoel
 */
@Stateless
public class DiscountCodeManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;
    
   public List<DiscountCode> getAllDiscountCodes(){
        Query query = em.createNamedQuery("DiscountCode.findAll");
        return query.getResultList();
    }
   public DiscountCode findById(String discountCode){
       return em.find(DiscountCode.class, discountCode);
   }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(DiscountCode discountCode) {
      em.persist(discountCode);
    }
}

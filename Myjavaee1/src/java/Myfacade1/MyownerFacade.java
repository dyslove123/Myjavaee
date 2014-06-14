/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Myfacade1;

import Myentitybean1.Myowner;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrator
 */
@Stateless
public class MyownerFacade extends AbstractFacade<Myowner> {
    @PersistenceContext(unitName = "Myjavaee1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public Myowner findbyname(String name)
    {
        return (Myowner)getEntityManager().createNamedQuery("Myowner.findByName").setParameter("name", name).getSingleResult();
    }

    /**
     *
     * @param aaa
     * @param range
     * @return
     */
    public List<Myowner> findbylikeandown(Myowner aaa,int[] range)
    {
        return (List<Myowner>)getEntityManager().createNamedQuery("Myowner.findByOwn1").setFirstResult(range[0]).setMaxResults(range[1] - range[0] + 1)
                .setParameter("own1",aaa.getLike1() ).getResultList();
  
    }
    public MyownerFacade() {
        super(Myowner.class);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Myfacade1;

import Myentitybean1.Mylogin;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrator
 */
@Stateless
public class MyloginFacade extends AbstractFacade<Mylogin> {
    @PersistenceContext(unitName = "Myjavaee1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public Mylogin findbyname(String name)
    {
         return (Mylogin) getEntityManager().createNamedQuery("Mylogin.findByName").setParameter("name", name)
                 .getSingleResult();    
    }
    public MyloginFacade() {
        super(Mylogin.class);
    }
    
}

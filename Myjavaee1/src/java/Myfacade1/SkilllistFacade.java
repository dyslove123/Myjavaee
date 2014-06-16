/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Myfacade1;

import Myentitybean1.Skilllist;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrator
 */
@Stateless
public class SkilllistFacade extends AbstractFacade<Skilllist> {
    @PersistenceContext(unitName = "Myjavaee1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SkilllistFacade() {
        super(Skilllist.class);
    }
    
}

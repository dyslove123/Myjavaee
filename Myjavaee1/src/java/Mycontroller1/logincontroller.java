package Mycontroller1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Mycontroller1.util.JsfUtil;
import Myentitybean1.Mylogin;
import Myentitybean1.Myowner;
import Myfacade1.MyloginFacade;
import Myfacade1.MyownerFacade;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
@ManagedBean
@RequestScoped
public class logincontroller {

    @PersistenceContext
EntityManager em;
    /**
     * Creates a new instance of logincontroller
     */
    private Mylogin current;
    private Myowner own;
    @EJB
    private MyloginFacade ejbFacade;
     @EJB
    private MyownerFacade ofa;
        public Mylogin getSelected() {
        if (current == null) {
            current = new Mylogin();
          
        }
        return current;
    }
        
        public Mylogin getlogin()
        {
                
                
                HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                Mylogin now=new Mylogin();
                
                now.setName(session.getAttribute("name").toString());
                now.setMykey(session.getAttribute("key").toString());
                
                return now;
  
        }
        
        
      
        public String login()
        {
            Mylogin login = null;
            
//            if(ejbFacade.findbyname(current.name).getMykey()==null)
//                return "false";
            if(login== null)
            {
                 login=new Mylogin();
            }
            if(current.getName()==null)
            {
             JsfUtil.addSuccessMessage("currentnamenull");
                 return "false";
            }
//             login=ejbFacade.findbyname(current.getName());
            Mylogin login2 = (Mylogin)
            em.createNamedQuery("Mylogin.findByName").
            setParameter("name",current.getName()).getSingleResult();
            if(login2.getMykey().equals(current.getMykey()))
            {   
                JsfUtil.addSuccessMessage(current.getName()+" login success");
                HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                session.setAttribute("login",true);
                session.setAttribute("name",current.getName());
                session.setAttribute("key",current.getMykey());
                
                
            }
              else
              {
                JsfUtil.addSuccessMessage(current.getName()+"login false");
              }
             return "index";
//               JsfUtil.addSuccessMessage(login.getName());
//            if(login.equals(current.getMykey()))
//            return "success";
//            else
//            return "false";
        }
       public String logout()
        {
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            if(session.getAttribute("login")==null||(boolean)session.getAttribute("login")==false)
                JsfUtil.addSuccessMessage("尚未登录");
           else
            {session.invalidate();
            JsfUtil.addSuccessMessage("logout success");}
            
            return "index";
        }
    public logincontroller() {
    }
    
}

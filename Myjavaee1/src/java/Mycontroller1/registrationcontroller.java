/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mycontroller1;

import Mycontroller1.util.JsfUtil;
import Myentitybean1.Headpicture;
import Myentitybean1.Mylogin;
import Myentitybean1.Myowner;
import Myfacade1.HeadpictureFacade;
import Myfacade1.MyloginFacade;
import Myfacade1.MyownerFacade;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
@ManagedBean
@RequestScoped
public class registrationcontroller {
    @EJB
    private MyloginFacade login;
    private Mylogin create;
    @EJB
    private MyownerFacade ofa;
    @EJB
    HeadpictureFacade picfa;
 
    Headpicture headpic;
    /**
     * Creates a new instance of registrationcontroller
     */
     public Mylogin getSelected() {
        if (create == null) {
            create = new Mylogin();
         
        }
        return create;
    }
    public registrationcontroller() {
    }
     public String prepareCreate() {
        create = new Mylogin();
        
        return "registration1";
    }
    public String createown()
    {
        login.create(create);
        Myowner now=new Myowner();
        now.setName(create.getName());
        ofa.create(now);
        Headpicture pic=new Headpicture();
        pic.setName(create.getName());
        this.picfa.create(pic);
        
        JsfUtil.addSuccessMessage(create.getName()+"correct");
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.setAttribute("login",true);
        session.setAttribute("name",create.getName());
        session.setAttribute("key",create.getMykey());
        return "index";
                
       
    }
}

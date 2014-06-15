package Mycontroller1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Mycontroller1.util.JsfUtil;
import Myentitybean1.Mylogin;
import Myentitybean1.Myowner;
import Myfacade1.MyownerFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Administrator
 */
@ManagedBean
@RequestScoped
@Named("mylikeandowncontroller")
public class Mylikeandowncontroller {

    private Myowner current;
    private List<Myowner>listown;
    @EJB
    private MyownerFacade ofa; 
    private Mylogin login;
    /**
     * Creates a new instance of Mylikeandowncontroller
     */
    public Myowner getSelected() {
        if (current == null) {
            current = new Myowner();
        }
        return current;
    }
    public Mylikeandowncontroller() {
    }
    public void create()
    {
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        current.setName(session.getAttribute("name").toString());
        ofa.create(current);
        JsfUtil.addSuccessMessage("create success");
    }
    public String preedit()
    {
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        if((boolean)session.getAttribute("login")==true)
        {
            if (current == null) {
            current = new Myowner();
        }
            
            current = ofa.findbyname(session.getAttribute("name").toString());
            JsfUtil.addSuccessMessage("preedit success");
            return "editown";
        }
        else  JsfUtil.addErrorMessage("preedit false");
        return "index";
    }
    public String edit()
    {
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        current.setName( session.getAttribute("name").toString());  
        ofa.edit(current);
        JsfUtil.addSuccessMessage("edit success");
        return "index";
        
            
            
    }
}

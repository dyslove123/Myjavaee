/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mystatefulsessionbean;

import Myentitybean1.Mylogin;
import javax.ejb.Stateful;

/**
 *
 * @author Administrator
 */
@Stateful
public class NewSessionBean {
    private Mylogin login;
    public Mylogin getLogin()
    {
        return login;
    }
    public void setLogin(Mylogin login)
    {
        this.login=login;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}

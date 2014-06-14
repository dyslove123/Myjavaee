/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Myentitybean1;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "MYLOGIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mylogin.findAll", query = "SELECT m FROM Mylogin m"),
    @NamedQuery(name = "Mylogin.findByName", query = "SELECT m FROM Mylogin m WHERE m.name = :name"),
    @NamedQuery(name = "Mylogin.findByMykey", query = "SELECT m FROM Mylogin m WHERE m.mykey = :mykey")})
public class Mylogin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "MYKEY")
    private String mykey;

    public Mylogin() {
    }

    public Mylogin(String name) {
        this.name = name;
    }

    public Mylogin(String name, String mykey) {
        this.name = name;
        this.mykey = mykey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMykey() {
        return mykey;
    }

    public void setMykey(String mykey) {
        this.mykey = mykey;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mylogin)) {
            return false;
        }
        Mylogin other = (Mylogin) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Myentitybean1.Mylogin[ name=" + name + " ]";
    }
    
}

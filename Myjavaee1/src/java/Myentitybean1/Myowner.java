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
@Table(name = "MYOWNER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Myowner.findAll", query = "SELECT m FROM Myowner m"),
    @NamedQuery(name = "Myowner.findByName", query = "SELECT m FROM Myowner m WHERE m.name = :name"),
    @NamedQuery(name = "Myowner.findByLike1", query = "SELECT m FROM Myowner m WHERE m.like1 = :like1"),
    @NamedQuery(name = "Myowner.findByLike2", query = "SELECT m FROM Myowner m WHERE m.like2 = :like2"),
    @NamedQuery(name = "Myowner.findByLike3", query = "SELECT m FROM Myowner m WHERE m.like3 = :like3"),
    @NamedQuery(name = "Myowner.findByOwn1", query = "SELECT m FROM Myowner m WHERE m.own1 = :own1"),
    @NamedQuery(name = "Myowner.findByOwn2", query = "SELECT m FROM Myowner m WHERE m.own2 = :own2"),
    @NamedQuery(name = "Myowner.findByOwn3", query = "SELECT m FROM Myowner m WHERE m.own3 = :own3")})
public class Myowner implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NAME")
    private String name;
    @Size(max = 10)
    @Column(name = "LIKE1")
    private String like1;
    @Size(max = 10)
    @Column(name = "LIKE2")
    private String like2;
    @Size(max = 10)
    @Column(name = "LIKE3")
    private String like3;
    @Size(max = 10)
    @Column(name = "OWN1")
    private String own1;
    @Size(max = 10)
    @Column(name = "OWN2")
    private String own2;
    @Size(max = 10)
    @Column(name = "OWN3")
    private String own3;

    public Myowner() {
    }

    public Myowner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLike1() {
        return like1;
    }

    public void setLike1(String like1) {
        this.like1 = like1;
    }

    public String getLike2() {
        return like2;
    }

    public void setLike2(String like2) {
        this.like2 = like2;
    }

    public String getLike3() {
        return like3;
    }

    public void setLike3(String like3) {
        this.like3 = like3;
    }

    public String getOwn1() {
        return own1;
    }

    public void setOwn1(String own1) {
        this.own1 = own1;
    }

    public String getOwn3() {
        return own3;
    }

    public void setOwn3(String own3) {
        this.own3 = own3;
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
        if (!(object instanceof Myowner)) {
            return false;
        }
        Myowner other = (Myowner) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Myentitybean1.Myowner[ name=" + name + " ]";
    }

    public String getOwn2() {
        return own2;
    }

    public void setOwn2(String own2) {
        this.own2 = own2;
    }
    
}

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
@Table(name = "HEADPICTURE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Headpicture.findAll", query = "SELECT h FROM Headpicture h"),
    @NamedQuery(name = "Headpicture.findByName", query = "SELECT h FROM Headpicture h WHERE h.name = :name"),
    @NamedQuery(name = "Headpicture.findByRoot", query = "SELECT h FROM Headpicture h WHERE h.root = :root")})
public class Headpicture implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NAME")
    private String name;
    @Size(max = 200)
    @Column(name = "ROOT")
    private String root;

    public Headpicture() {
    }

    public Headpicture(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
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
        if (!(object instanceof Headpicture)) {
            return false;
        }
        Headpicture other = (Headpicture) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Myentitybean1.Headpicture[ name=" + name + " ]";
    }
    
}

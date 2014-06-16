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
@Table(name = "SKILLLIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Skilllist.findAll", query = "SELECT s FROM Skilllist s"),
    @NamedQuery(name = "Skilllist.findBySkillname", query = "SELECT s FROM Skilllist s WHERE s.skillname = :skillname"),
    @NamedQuery(name = "Skilllist.findByWant", query = "SELECT s FROM Skilllist s WHERE s.want = :want"),
    @NamedQuery(name = "Skilllist.findByOwn", query = "SELECT s FROM Skilllist s WHERE s.own = :own")})
public class Skilllist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SKILLNAME")
    private String skillname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WANT")
    private long want;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OWN")
    private long own;

    public Skilllist() {
    }

    public Skilllist(String skillname) {
        this.skillname = skillname;
    }

    public Skilllist(String skillname, long want, long own) {
        this.skillname = skillname;
        this.want = want;
        this.own = own;
    }

    public String getSkillname() {
        return skillname;
    }

    public void setSkillname(String skillname) {
        this.skillname = skillname;
    }

    public long getWant() {
        return want;
    }

    public void setWant(long want) {
        this.want = want;
    }

    public long getOwn() {
        return own;
    }

    public void setOwn(long own) {
        this.own = own;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (skillname != null ? skillname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Skilllist)) {
            return false;
        }
        Skilllist other = (Skilllist) object;
        if ((this.skillname == null && other.skillname != null) || (this.skillname != null && !this.skillname.equals(other.skillname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return skillname;
    }
    
}

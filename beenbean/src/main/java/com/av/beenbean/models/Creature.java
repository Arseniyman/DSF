package com.av.beenbean.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author arseniy
 */
@Entity
@Table(name = "creature", catalog = "sandbox", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Creature.findAll", query = "SELECT c FROM Creature c"),
    @NamedQuery(name = "Creature.findById", query = "SELECT c FROM Creature c WHERE c.id = :id"),
    @NamedQuery(name = "Creature.findByName", query = "SELECT c FROM Creature c WHERE c.name = :name"),
    @NamedQuery(name = "Creature.findByHealth", query = "SELECT c FROM Creature c WHERE c.health = :health")})
public class Creature implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "health")
    private int health;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User userId;

    public Creature() {
    }

    public Creature(Long id) {
        this.id = id;
    }

    public Creature(Long id, String name, int health) {
        this.id = id;
        this.name = name;
        this.health = health;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Creature)) {
            return false;
        }
        Creature other = (Creature) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Creature[ id=" + id + " ]";
    }
    
}

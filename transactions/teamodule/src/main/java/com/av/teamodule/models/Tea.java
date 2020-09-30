package com.av.teamodule.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author arseniy
 */
@Entity
@Table(name = "tea")
public class Tea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    @Size(min = 1, max = 75)
    private String name;
    @Temporal(TemporalType.DATE)
    @Column(name = "year_of_collection")
    private Date yearOfCollection;

    public Tea() {
    }

    public Tea(String name, Date yearOfCollection) {
        this.name = name;
        this.yearOfCollection = yearOfCollection;
    }

    public Tea(Long id, String name, Date yearOfCollection) {
        this.id = id;
        this.name = name;
        this.yearOfCollection = yearOfCollection;
    }
    
    public Date getYearOfCollection() {
        return yearOfCollection;
    }

    public void setYearOfCollection(Date yearOfCollection) {
        this.yearOfCollection = yearOfCollection;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Tea)) {
            return false;
        }
        Tea other = (Tea) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tea[ name=" + name + " ]";
    }
    
}
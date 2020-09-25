package com.av.beenbean.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PostRemove;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author arseniy
 */
@Entity
@Table(name = "battle")
public class Battle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "end_of_battle")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endOfBattle;
    @Column(name = "start_of_battle")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startOfBattle;
    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;
    @ManyToMany(mappedBy = "battles")
    private List<User> participants;

    public Battle(Long id, Date endOfBattle, Date startOfBattle, Location location) {
        this.id = id;
        this.endOfBattle = endOfBattle;
        this.startOfBattle = startOfBattle;
        this.location = location;
    }

    public Battle(Long id) {
        this.id = id;
    }
    
    public Battle() {
    }

    public Date getEndOfBattle() {
        return endOfBattle;
    }

    public void setEndOfBattle(Date endOfBattle) {
        this.endOfBattle = endOfBattle;
    }

    public Date getStartOfBattle() {
        return startOfBattle;
    }

    public void setStartOfBattle(Date startOfBattle) {
        this.startOfBattle = startOfBattle;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @PostRemove
    public void printRemoveSmt() {
        System.out.println("Battle model has been removed");
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
        if (!(object instanceof Battle)) {
            return false;
        }
        Battle other = (Battle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Battle[ id=" + id + " ]";
    }
    
}
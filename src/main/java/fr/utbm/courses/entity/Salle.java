/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.courses.entity;

/**
 *
 * @author lbessone
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "salle", uniqueConstraints={@UniqueConstraint(columnNames={"id"})})

public class Salle implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private String id;
    
    @Column(name = "roomNumber", nullable = false)
    private String roomNumber;

    @Column(name = "building", nullable = false)
    private String building;
    
    @Column(name = "level", nullable = false)
    private int level;

//    @OneToOne
//    @JoinColumn(name = "salle_site")
//    private Site site;
//        
    public Salle() {
    }

    public Salle(String id, String roomNumber, String building, int level) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.building = building;
        this.level = level;
    }

//    public Salle(String id, String roomNumber, String building, int level, Site site) {
//        this.id = id;
//        this.roomNumber = roomNumber;
//        this.building = building;
//        this.level = level;
//        this.site = site;
//    }

    
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getId() {
        return id;
    }

    public String getBuilding() {
        return building;
    }

    public int getLevel() {
        return level;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Salle{" + "id=" + id + ", building=" + building + ", level=" + level + '}';
    }
    
    
}

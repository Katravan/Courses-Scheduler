/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.courses.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author lbessone
 */
@Entity
@Table(name = "room", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})

public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;
    
        
    @Column(name="roomNumber", nullable=false)
    private String roomNumber;
    
    @Column(name="building", nullable=false)
    private String building;
    
    @Column(name="level", nullable=false)
    private String level;

    @OneToOne
    @JoinColumn(name = "site_id")
    private Site site;
    
    public Room() {
    }

    public Room(Integer id, String roomNumber, String building, String level) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.building = building;
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getBuilding() {
        return building;
    }

    public String getLevel() {
        return level;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Salle{" + "id=" + id + ", roomNumber=" + roomNumber + ", building=" + building + ", level=" + level + '}';
    }
    
    
}

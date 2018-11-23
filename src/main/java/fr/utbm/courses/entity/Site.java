/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.courses.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author lbessone
 */
@Entity
@Table(name = "site", uniqueConstraints={@UniqueConstraint(columnNames={"id"})})

public class Site implements java.io.Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false, unique=true)
    private Integer id;
    
    @Column(name="city", nullable=false, unique=true)
    private String city;

    public Site(int id, String city) {
        this.id = id;
        this.city = city;
    }

    public Site() {
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Site{" + "id=" + id + ", city=" + city + '}';
    }
    
    
}

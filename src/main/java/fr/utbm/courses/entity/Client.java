/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.courses.entity;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author lbessone
 */
@Entity
@Table(name = "client", uniqueConstraints={@UniqueConstraint(columnNames={"id"})})

public class Client implements java.io.Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false, unique=true)
    private Integer id;
    
    @Column(name="lastname", nullable=false)
    private String lastname;
    
    @Column(name="firstname", nullable=false)
    private String firstname;
    
    @Column(name="address", nullable=false)
    private String address;
    
    @Column(name="phone", nullable=false)
    private String phone;
    
    @Column(name="email", nullable=false)
    private String email;
    
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "CLIENT_COURSE", 
        joinColumns = { @JoinColumn(name = "client_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "course_id") }
    )
    Set<Course> course;
    
    public Client() {
    }

    public Client(int id, String lastname, String firstname, String address, String phone, String email) {
        this.course = new HashSet<>();
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public Client(Object object, String string, String string0, String string1, String string2, String string3, CourseSession courseSession) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", address=" + address + ", phone=" + phone + ", email=" + email + '}';
    }
    
    
}

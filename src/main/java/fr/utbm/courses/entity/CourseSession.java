/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.courses.entity;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import fr.utbm.courses.entity.Salle;
import fr.utbm.courses.entity.Course;

/**
 *
 * @author lbessone
 */
@Entity
@Table(name = "course_session", uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class CourseSession implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "startdate", nullable = false)
    private Date startdate;

    @Column(name = "enddate", nullable = false)
    private Date enddate;

    @Column(name = "maximum", nullable = true)
    private int max;

    @OneToOne
    @JoinColumn(name = "course_code")
    private Course course;
//    
//    @OneToOne
//    @JoinColumn(name = "salle_id")
//    private Salle salle;

    public CourseSession() {
    }

    public CourseSession(int id, Date startdate, Date enddate, int max) {
        this.id = id;
        this.startdate = startdate;
        this.enddate = enddate;
        this.max = max;
    }

    public CourseSession(Integer id, Date startdate, Date enddate, int max, Course course) {
        this.id = id;
        this.startdate = startdate;
        this.enddate = enddate;
        this.max = max;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public Date getStartdate() {
        return startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public int getMax() {
        return max;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "CourseSession{" + "id=" + id + ", startdate=" + startdate + ", enddate=" + enddate + ", max=" + max + '}';
    }
    
    
    
    
}

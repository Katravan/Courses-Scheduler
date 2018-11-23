/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.courses.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.utbm.courses.entity.Course;
import fr.utbm.courses.repository.CourseDao;
import fr.utbm.courses.repository.Dbservice;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Valentin Bourdier
 */

@Path("/courses")
public class CourseAPI {
    
   private CourseDao courseStorer = null;
   private ObjectMapper mapper = null;
   
   public CourseAPI() {
       this.courseStorer = new Dbservice();
       this.mapper = new ObjectMapper();
   }
   
  @GET
  @Path("/list")
  @Produces(MediaType.APPLICATION_JSON)
  public String getAllCourses() {
      List<Course> courses = courseStorer.getCoursesAvailables();
       try {
           String res = mapper.writeValueAsString(courses);
           return res;
       } catch (JsonProcessingException ex) {
           Logger.getLogger(SalleAPI.class.getName()).log(Level.SEVERE, null, ex);
           return "{}";
       }
  }
    
}

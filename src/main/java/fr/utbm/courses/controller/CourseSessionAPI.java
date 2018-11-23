/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.courses.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.utbm.courses.entity.CourseSession;
import fr.utbm.courses.repository.Dbservice;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import fr.utbm.courses.repository.CourseSessionDao;

/**
 *
 * @author Valentin Bourdier
 */

@Path("/sessions")
public class CourseSessionAPI {
    
   private CourseSessionDao courseSessionStorer = null;
   private ObjectMapper mapper = null;
   
   public CourseSessionAPI() {
       this.courseSessionStorer = new Dbservice();
       this.mapper = new ObjectMapper();
   }
   
  @GET
  @Path("/list")
  @Produces(MediaType.APPLICATION_JSON)
  public String getAllCourseSessions() {
      List<CourseSession> courseSessions = courseSessionStorer.getCourseSessionsAvailables();
       try {
           String res = mapper.writeValueAsString(courseSessions);
           return res;
       } catch (JsonProcessingException ex) {
           Logger.getLogger(RoomAPI.class.getName()).log(Level.SEVERE, null, ex);
           return "{}";
       }
  }
  
  @GET
  @Path("/search/{ filter }")
  @Produces(MediaType.APPLICATION_JSON)
  public String getAllCourseSessionsWithFilter(@PathParam( "filter" ) String filter) {
      List<CourseSession> courseSessions = courseSessionStorer.filterCourseSessionsAvailables(filter);
       try {
           String res = mapper.writeValueAsString(courseSessions);
           return res;
       } catch (JsonProcessingException ex) {
           Logger.getLogger(RoomAPI.class.getName()).log(Level.SEVERE, null, ex);
           return "{}";
       }
  }
  
  @GET
  @Path("/location/{ locationId }")
  @Produces(MediaType.APPLICATION_JSON)
  public String getCourseSessionsForLocation(@PathParam( "locationId" ) String locationId) {
       List<CourseSession> courseSessions = courseSessionStorer.filterLocationSourceSessions(Integer.parseInt(locationId));
       try {
           String res = mapper.writeValueAsString(courseSessions);
           return res;
       } catch (JsonProcessingException ex) {
           Logger.getLogger(RoomAPI.class.getName()).log(Level.SEVERE, null, ex);
           return "{}";
       }
  }
  
  @GET
  @Path("/date/{ date }")
  @Produces(MediaType.APPLICATION_JSON)
  public String getCourseSessionsForDate(@PathParam( "date" ) String date) {
       List<CourseSession> courseSessions = courseSessionStorer.filterDateSourceSessions(date);
       try {
           String res = mapper.writeValueAsString(courseSessions);
           return res;
       } catch (JsonProcessingException ex) {
           Logger.getLogger(RoomAPI.class.getName()).log(Level.SEVERE, null, ex);
           return "{}";
       }
  }
    
}

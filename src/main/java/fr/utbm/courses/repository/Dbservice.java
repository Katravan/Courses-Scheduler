/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.courses.repository;

import fr.utbm.courses.entity.Client;
import fr.utbm.courses.entity.Course;
import fr.utbm.courses.entity.CourseSession;
import fr.utbm.courses.entity.Salle;
import fr.utbm.courses.util.HibernateUtil;
import java.util.List;
import javax.faces.view.Location;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 *
 * @author lbessone
 */
public class Dbservice implements ClientDao, CourseDao, CourseSessionDao, SalleDao{
    private final static Logger logger = Logger.getLogger(Dbservice.class);
    
    private SessionFactory sessionFactory = null;
    
    public Dbservice() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public Integer createClient(Client client) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        session.save(client);
        
        session.getTransaction().commit();
        
        logger.info("Sucessfully save client '" + client +"' into database");
        
        return client.getId();
    }
    
    @Override
    public List<Salle> getRecordsSalle() {
        Session session = sessionFactory.openSession();

        List<Salle> salles = session.createQuery("from Location").list();

        logger.info("Successfully got all locations (n=" + salles.size() + ")");

        return salles;
    }

    @Override
    public List<Course> getCoursesAvailables() {
        Session session = sessionFactory.openSession();
        
        List<Course> courses = session.createQuery("from Course").list();
        
        logger.info("Successfully got all courses (n=" + courses.size() + ")");
        
        return courses;    
    }

    @Override
    public List<CourseSession> getCourseSessionsAvailables() {
        Session session = sessionFactory.openSession();
        
        List<CourseSession> courseSessions = session.createQuery("from CourseSession").list();
        
        logger.info("Successfully got all courses sessions (n=" + courseSessions.size() + ")");
        
        return courseSessions;  
    }

    @Override
    public List<CourseSession> filterCourseSessionsAvailables(String filter) {
        Session session = sessionFactory.openSession();
        
        String hql = "from CourseSession WHERE course.title like :filter";
        Query query = session.createQuery(hql);
        query.setParameter("filter", "%" + filter + "%");
        List<CourseSession> courseSessions = query.list();
        
        logger.info("Successfully got all courses sessions filter by '" + filter + "' (n=" + courseSessions.size() + ")");
        
        return courseSessions;  
    }

    @Override
    public List<CourseSession> filterDateSourceSessions(String date) {
        Session session = sessionFactory.openSession();
        
        String hql = "from CourseSession WHERE start_date = :date";
        Query query = session.createQuery(hql);
        query.setParameter("date", date);
        List<CourseSession> courseSessions = query.list();
        
        logger.info("Successfully got all courses sessions filter for date '" + date + "' (n=" + courseSessions.size() + ")");
        
        return courseSessions;      }

    @Override
    public List<CourseSession> filterLocationSourceSessions(Integer locationId) {
        Session session = sessionFactory.openSession();
        
        String hql = "from CourseSession WHERE location_id = :locationId";
        Query query = session.createQuery(hql);
        query.setParameter("locationId", locationId);
        List<CourseSession> courseSessions = query.list();
        
        logger.info("Successfully got all courses sessions filter for location nÂ°'" + locationId + "' (n=" + courseSessions.size() + ")");
        
        return courseSessions;      
    }

@Override
    public CourseSession getCourseSession(Integer id) {
        Session session = sessionFactory.openSession();
        
        CourseSession courseSession = (CourseSession) session.get(CourseSession.class, id);
        
        logger.info("Successfully get from database CourseSession '" + courseSession + "'");
        
        return courseSession;     
    }


}

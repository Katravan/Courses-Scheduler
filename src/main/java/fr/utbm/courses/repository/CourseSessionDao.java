/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.courses.repository;

import fr.utbm.courses.entity.CourseSession;
import java.util.List;

/**
 *
 * @author lbessone
 */
public interface CourseSessionDao {
    public List<CourseSession> getCourseSessionsAvailables();
    public List<CourseSession> filterCourseSessionsAvailables(String filter);
    public List<CourseSession> filterDateSourceSessions(String date);
    public List<CourseSession> filterLocationSourceSessions(Integer locationId);
    public CourseSession getCourseSession(Integer id);

}

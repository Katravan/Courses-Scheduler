/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.courses.repository;

import fr.utbm.courses.entity.Course;
import java.util.List;

/**
 *
 * @author lbessone
 */
public interface CourseDao {
            public List<Course> getCoursesAvailables();

}

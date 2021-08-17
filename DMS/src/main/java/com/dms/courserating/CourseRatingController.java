package com.dms.courserating;

import com.dms.course.abstractfactory.CourseAbstractFactory;
import com.dms.courserating.abstractfactory.CourseRatingAbstractFactory;
import com.dms.course.Course;
import com.dms.course.interfaces.ICourseDAO;
import com.dms.courserating.interfaces.ICourseRatingModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CourseRatingController {

    private static final String USER_LOGGEDIN = "loggedIn";
    private static final String IS_USER_LOGGEDIN = "yes";
    private static final String GET_USERNAME = "username";
    private static final String HOME_PAGE = "homepage";
    private static final String RATING_PAGE = "Rating";
    private static final String COURSE_RATING_SUCCESS = "courseRatingSuccessful";
    private static final String COURSE_RATING_FAIL = "courseRatingFail";

    CourseAbstractFactory courseAbstractFactory = CourseAbstractFactory.instance();
    ICourseDAO iCourseDAO = courseAbstractFactory.createCourseDAO();
    CourseRatingAbstractFactory courseRatingAbstractFactory = CourseRatingAbstractFactory.instance();
    ICourseRatingModel iCourseRatingModel = courseRatingAbstractFactory.createCourseRatingModel();

    @RequestMapping(value = "/rating", method = RequestMethod.GET)
    public String rating(Model model, HttpServletRequest request) throws Exception {

        HttpSession session = request.getSession();

        if (StringUtils.equals((CharSequence) session.getAttribute(USER_LOGGEDIN), IS_USER_LOGGEDIN)) {
            ArrayList<Course> coursesList = iCourseDAO.getCourses();
            model.addAttribute("courseList", coursesList);
            return RATING_PAGE;
        } else {
            return HOME_PAGE;
        }

    }

    @RequestMapping(value = "/postRating/{courseId}", method = RequestMethod.POST)
    public String postRating(HttpServletRequest request, @RequestParam("rating") String rating,
                             @PathVariable(name = "courseId") int courseId) throws Exception {
        int rateGiven = Integer.parseInt(rating);
        boolean ratingFlag;
        HttpSession session = request.getSession();

        if (StringUtils.equals((CharSequence) session.getAttribute(USER_LOGGEDIN), IS_USER_LOGGEDIN)) {
            String userName = (String) session.getAttribute(GET_USERNAME);
            ratingFlag = iCourseRatingModel.postCourseRating(courseId, userName, rateGiven);

            if (ratingFlag) {
                return COURSE_RATING_SUCCESS;
            } else {
                return COURSE_RATING_FAIL;
            }

        } else {
            return HOME_PAGE;
        }

    }
}

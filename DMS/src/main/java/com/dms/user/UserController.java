package com.dms.user;

import com.dms.user.abstarctfactory.UserAbstractFactory;
import com.dms.user.interfaces.IUserModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@Controller
public class UserController {
    private static final String ADMIN_PAGE = "admin";
    private static final String REDIRECT_ADMIN_PAGE = "redirect:/admin";
    private static final String ERROR_PAGE = "error";
    private static final String USER_LOGGED_IN = "loggedIn";
    private static final String YES = "yes";

    UserAbstractFactory userAbstractFactory = UserAbstractFactory.instance();
    IUserModel iUserModel = userAbstractFactory.createUser();

    @GetMapping(value = "/admin")
    public ModelAndView userList(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        String loggedIn = (String) session.getAttribute(USER_LOGGED_IN);
        if (StringUtils.equals(loggedIn,YES)) {
            List<IUserModel> userList = iUserModel.showUserList();
            ModelAndView model = new ModelAndView(ADMIN_PAGE);
            model.addObject("list", userList);
            return model;
        }
        return new ModelAndView(ERROR_PAGE);
    }

    @GetMapping(value = "/{username}/approve")
    public ModelAndView approveUser(@PathVariable String username) throws SQLException {
        iUserModel.approveUser(username);
        return new ModelAndView(REDIRECT_ADMIN_PAGE);
    }

    @GetMapping(value = "/{username}/remove")
    public ModelAndView removeUser(@PathVariable String username) throws SQLException {
        iUserModel.removeUser(username);
        return new ModelAndView(REDIRECT_ADMIN_PAGE);
    }
}

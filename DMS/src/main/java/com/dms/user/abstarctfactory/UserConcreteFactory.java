package com.dms.user.abstarctfactory;

import com.dms.user.UserModel;
import com.dms.user.UserDAO;
import com.dms.user.interfaces.IUserModel;
import com.dms.user.interfaces.IUserDAO;

public class UserConcreteFactory extends UserAbstractFactory{

    public IUserModel createUser() {
        return new UserModel(new UserDAO());
    }

    public IUserDAO createUserDAO() {
        return new UserDAO();
    }
}

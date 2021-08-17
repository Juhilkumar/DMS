package com.dms.user.abstarctfactory;

import com.dms.user.interfaces.IUserModel;
import com.dms.user.interfaces.IUserDAO;

public abstract class UserAbstractFactory {
    private static UserAbstractFactory uniqueInstance = null;

    public static UserAbstractFactory instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new UserConcreteFactory();
        }
        return uniqueInstance;
    }

    public abstract IUserModel createUser();
    public abstract IUserDAO createUserDAO();
}

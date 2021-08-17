package com.dms.user.abstractfactory;

import com.dms.user.UserDAOMock;
import com.dms.user.UserModel;
import com.dms.user.interfaces.IUserModel;

public class UserConcreteFactoryTest extends UserAbstractFactoryTest{

    public IUserModel createUser() {
        return new UserModel(new UserDAOMock());
    }

}

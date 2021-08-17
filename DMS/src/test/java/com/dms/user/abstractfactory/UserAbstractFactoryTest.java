package com.dms.user.abstractfactory;

import com.dms.user.interfaces.IUserModel;

public abstract class UserAbstractFactoryTest {
    private static UserAbstractFactoryTest uniqueInstance = null;

    public static UserAbstractFactoryTest instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new UserConcreteFactoryTest();
        }
        return uniqueInstance;
    }

    public abstract IUserModel createUser();
}

package com.dms.updateinformation.abstractfactory;

import com.dms.updateinformation.UpdateInformationDAOMock;
import com.dms.updateinformation.interfaces.IUpdateInformationModel;

public abstract class UpdateInformationAbstractFactoryTest {
    private static UpdateInformationAbstractFactoryTest uniqueInstance = null;

    public abstract UpdateInformationDAOMock updateInformationDAOMock();
    public abstract IUpdateInformationModel iUpdateInformationModel();

    public static UpdateInformationAbstractFactoryTest instance(){
        if(null == uniqueInstance){
            uniqueInstance = new UpdateInformationConcreteFactoryTest();
        }
        return uniqueInstance;
    }
}
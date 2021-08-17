package com.dms.updateinformation.abstractfactory;

import com.dms.updateinformation.UpdateInformationDAOMock;
import com.dms.updateinformation.UpdateInformationModel;
import com.dms.updateinformation.interfaces.IUpdateInformationModel;

public class UpdateInformationConcreteFactoryTest extends UpdateInformationAbstractFactoryTest{
    public UpdateInformationDAOMock updateInformationDAOMock() {
        return new UpdateInformationDAOMock();
    }

    public IUpdateInformationModel iUpdateInformationModel() {
        return new UpdateInformationModel(updateInformationDAOMock());
    }
}

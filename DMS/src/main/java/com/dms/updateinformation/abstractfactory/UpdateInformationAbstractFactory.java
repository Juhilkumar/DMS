package com.dms.updateinformation.abstractfactory;

import com.dms.authentication.interfaces.IPasswordVerify;
import com.dms.authentication.interfaces.IValidation;
import com.dms.updateinformation.UpdateInformationDAO;
import com.dms.updateinformation.interfaces.IUpdateInformationModel;

public abstract class UpdateInformationAbstractFactory {
    private static UpdateInformationAbstractFactory uniqueInstance = null;
    public abstract UpdateInformationDAO updateInformationDAO();
    public abstract IUpdateInformationModel iUpdateInformationModel();
    public abstract IPasswordVerify passwordVerify();
    public abstract IValidation createValidation();

    public static UpdateInformationAbstractFactory instance(){
        if(null == uniqueInstance){
            uniqueInstance = new UpdateInformationConcreteFactory();
        }
        return uniqueInstance;
    }
}
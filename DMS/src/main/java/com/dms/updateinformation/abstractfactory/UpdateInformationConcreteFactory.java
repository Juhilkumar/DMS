package com.dms.updateinformation.abstractfactory;

import com.dms.authentication.PasswordValidator;
import com.dms.authentication.PasswordVerify;
import com.dms.authentication.interfaces.IPasswordVerify;
import com.dms.authentication.interfaces.IValidation;
import com.dms.updateinformation.UpdateInformationDAO;
import com.dms.updateinformation.UpdateInformationModel;
import com.dms.updateinformation.interfaces.IUpdateInformationModel;

public class UpdateInformationConcreteFactory extends UpdateInformationAbstractFactory{
    public UpdateInformationDAO updateInformationDAO() {
        return new UpdateInformationDAO();
    }

    public IUpdateInformationModel iUpdateInformationModel() {
        return new UpdateInformationModel(updateInformationDAO());
    }

    public IPasswordVerify passwordVerify() {
        return new PasswordVerify();
    }

    public IValidation createValidation() {
        return new PasswordValidator();
    }
}
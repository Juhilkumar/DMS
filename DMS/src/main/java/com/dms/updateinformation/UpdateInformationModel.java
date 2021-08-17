package com.dms.updateinformation;

import com.dms.updateinformation.interfaces.IUpdateInformationDAO;
import com.dms.updateinformation.interfaces.IUpdateInformationModel;
import java.sql.SQLException;
import java.util.List;

public class UpdateInformationModel implements IUpdateInformationModel {
    private final IUpdateInformationDAO iUpdateInformationDAO;
    public UpdateInformationModel(IUpdateInformationDAO iUpdateInformationDAO) {
        this.iUpdateInformationDAO = iUpdateInformationDAO;
    }

    public List<String> getDetails(String username) throws SQLException {
        return this.iUpdateInformationDAO.getInfo(username);
    }

    public boolean updateInformation(String firstName, String lastName, long dob, String email, String password, String username) throws SQLException{
        boolean result = iUpdateInformationDAO.updateInfo(firstName,lastName,dob,email,password,username);
        return result;
    }
}
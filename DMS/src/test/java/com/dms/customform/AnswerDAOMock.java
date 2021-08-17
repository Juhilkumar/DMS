package com.dms.customform;

import com.dms.customform.interfaces.IAnswerDAO;
import com.dms.customform.interfaces.IAnswerModel;
import com.dms.customform.interfaces.IFormModel;
import com.dms.user.UserModel;
import com.dms.user.interfaces.IUserModel;
import org.apache.commons.lang3.StringUtils;

public class AnswerDAOMock implements IAnswerDAO {

    public void insertFormResponseData(IFormModel formModel, int studentId) {
        IAnswerModel iAnswerModel = new AnswerModel();
        iAnswerModel.setAnswer("I am Lazy");
        iAnswerModel.getAnswer();
    }

    public int getStudentId(String username) {
        IUserModel iUserModel = new UserModel();
        iUserModel.setUsername("Juhil");
        if (StringUtils.equals(iUserModel.getUsername(), "Juhil")) {
            return 54;
        }
        return 0;
    }
}

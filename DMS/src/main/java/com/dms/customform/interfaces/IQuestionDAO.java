package com.dms.customform.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface IQuestionDAO {
    List<IQuestionModel> getQuestionList(String formName) throws SQLException;

    void insertFormData(IFormModel formModel) throws SQLException;
}

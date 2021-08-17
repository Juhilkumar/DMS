package com.dms.customform.interfaces;

import java.sql.SQLException;

public interface IAnswerDAO {
    void insertFormResponseData(IFormModel formModel, int studentId) throws SQLException;

    int getStudentId(String username) throws SQLException;
}

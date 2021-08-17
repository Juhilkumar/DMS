package com.dms.customform.interfaces;

import java.sql.SQLException;

public interface IAnswerModel {
    int getQuestionId();

    void setQuestionId(int questionId);

    String getAnswer();

    void setAnswer(String answer1);

    void saveResponseData(IFormModel formModel, String userName) throws SQLException;
}

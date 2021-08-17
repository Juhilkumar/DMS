package com.dms.customform.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface IQuestionModel {
    String getQuestionType();

    void setQuestionType(String questionType);

    String getQuestionDescription();

    void setQuestionDescription(String questionDescription);

    String getOptionValue1();

    void setOptionValue1(String optionValue1);

    String getOptionValue2();

    void setOptionValue2(String optionValue2);

    String getOptionValue3();

    void setOptionValue3(String optionValue3);

    String getOptionValue4();

    void setOptionValue4(String optionValue4);

    String toString();

    String getQuestionId();

    void setQuestionId(String questionId);

    void saveFormData(IFormModel formModel) throws SQLException;

    List<IQuestionModel> formQuestionList(String formName) throws SQLException;
}

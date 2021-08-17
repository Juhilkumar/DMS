package com.dms.customform;

import com.dms.customform.interfaces.IFormModel;
import com.dms.customform.interfaces.IQuestionDAO;
import com.dms.customform.interfaces.IQuestionModel;

import java.sql.SQLException;
import java.util.List;

public class QuestionModel implements IQuestionModel {
    private IQuestionDAO iQuestionDAO;
    private String questionId;
    private String questionType;
    private String questionDescription;
    private String optionValue1;
    private String optionValue2;
    private String optionValue3;
    private String optionValue4;

    public QuestionModel() {

    }

    public QuestionModel(IQuestionDAO iQuestionDAO) {
        this.iQuestionDAO = iQuestionDAO;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public String getOptionValue1() {
        return optionValue1;
    }

    public void setOptionValue1(String optionValue1) {
        this.optionValue1 = optionValue1;
    }

    public String getOptionValue2() {
        return optionValue2;
    }

    public void setOptionValue2(String optionValue2) {
        this.optionValue2 = optionValue2;
    }

    public String getOptionValue3() {
        return optionValue3;
    }

    public void setOptionValue3(String optionValue3) {
        this.optionValue3 = optionValue3;
    }

    public String getOptionValue4() {
        return optionValue4;
    }

    public void setOptionValue4(String optionValue4) {
        this.optionValue4 = optionValue4;
    }

    public void saveFormData(IFormModel formModel) throws SQLException {
        iQuestionDAO.insertFormData(formModel);
    }

    public List<IQuestionModel> formQuestionList(String formName) throws SQLException {
        return iQuestionDAO.getQuestionList(formName);
    }
}

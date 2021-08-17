package com.dms.customform;

import com.dms.customform.interfaces.IAnswerDAO;
import com.dms.customform.interfaces.IAnswerModel;
import com.dms.customform.interfaces.IFormModel;

import java.sql.SQLException;

public class AnswerModel implements IAnswerModel {
    private IAnswerDAO iAnswerDAO;
    private int questionId;
    private String answer;

    AnswerModel() {

    }

    public AnswerModel(IAnswerDAO iAnswerDAO) {
        this.iAnswerDAO = iAnswerDAO;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void saveResponseData(IFormModel formModel, String userName) throws SQLException {
        int studentId = iAnswerDAO.getStudentId(userName);
        iAnswerDAO.insertFormResponseData(formModel, studentId);
    }
}

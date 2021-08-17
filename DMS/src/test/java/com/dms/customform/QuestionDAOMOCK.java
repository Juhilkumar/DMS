package com.dms.customform;

import com.dms.customform.interfaces.IFormModel;
import com.dms.customform.interfaces.IQuestionDAO;
import com.dms.customform.interfaces.IQuestionModel;

import java.util.ArrayList;
import java.util.List;

public class QuestionDAOMOCK implements IQuestionDAO {

    public List<IQuestionModel> getQuestionList(String formName) {
        IFormModel iFormModel = new FormModel();
        iFormModel.setFormName("Survey");
        IQuestionModel iQuestionModel = new QuestionModel();
        List<IQuestionModel> questionList = new ArrayList<>();
        iQuestionModel.setQuestionId("1");
        iQuestionModel.setQuestionType("2");
        iQuestionModel.setQuestionDescription("Who is your role model?");
        questionList.add(iQuestionModel);
        return questionList;
    }

    public void insertFormData(IFormModel formModel) {
        IQuestionModel iQuestionModel = new QuestionModel();
        iQuestionModel.setQuestionDescription("Who is your role model?");
        formModel.getQuestions();
    }
}

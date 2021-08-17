package com.dms.customform;

import com.dms.customform.interfaces.IAnswerModel;
import com.dms.customform.interfaces.IFormModel;
import com.dms.customform.interfaces.IQuestionModel;

import java.util.List;

public class FormModel implements IFormModel {
    private  String formName;
    private List<IQuestionModel> questions;
    private List<IAnswerModel> answers;

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public List<IQuestionModel> getQuestions() {
        return questions;
    }

    public void setQuestions(List<IQuestionModel> questions) {
        this.questions = questions;
    }

    public List<IAnswerModel> getAnswers() {
        return answers;
    }

    public void setAnswers(List<IAnswerModel> answers) {
        this.answers = answers;
    }

}

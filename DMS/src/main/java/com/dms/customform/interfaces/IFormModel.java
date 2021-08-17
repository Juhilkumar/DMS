package com.dms.customform.interfaces;

import java.util.List;

public interface IFormModel {
    String getFormName();

    void setFormName(String formName);

    List<IQuestionModel> getQuestions();

    void setQuestions(List<IQuestionModel> questions);

    List<IAnswerModel> getAnswers();

    void setAnswers(List<IAnswerModel> answers);

    String toString();
}

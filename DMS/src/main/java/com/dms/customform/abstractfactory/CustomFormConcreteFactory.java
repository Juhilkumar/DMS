package com.dms.customform.abstractfactory;

import com.dms.customform.*;
import com.dms.customform.interfaces.*;

public class CustomFormConcreteFactory extends CustomFormAbstractFactory {

    public IFormModel createFormModel() {
        return new FormModel();
    }

    public IQuestionModel createQuestionModel() {
        return new QuestionModel(new QuestionDAO());
    }

    public IAnswerModel createAnswerModel() {
        return new AnswerModel(new AnswerDAO());
    }
}

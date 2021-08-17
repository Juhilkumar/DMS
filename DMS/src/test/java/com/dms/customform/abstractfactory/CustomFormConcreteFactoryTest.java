package com.dms.customform.abstractfactory;

import com.dms.customform.*;
import com.dms.customform.interfaces.IAnswerModel;
import com.dms.customform.interfaces.IFormModel;
import com.dms.customform.interfaces.IQuestionModel;

public class CustomFormConcreteFactoryTest extends CustomFormAbstractFactoryTest{
    public IFormModel createFormModelTest() {
        return new FormModel();
    }

    public IQuestionModel createQuestionModelTest() {
        return new QuestionModel(new QuestionDAOMOCK());
    }

    public IAnswerModel createAnswerModelTest() {
        return new AnswerModel(new AnswerDAOMock());
    }
}

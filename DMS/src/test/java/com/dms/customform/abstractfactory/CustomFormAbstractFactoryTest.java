package com.dms.customform.abstractfactory;

import com.dms.customform.interfaces.IAnswerModel;
import com.dms.customform.interfaces.IFormModel;
import com.dms.customform.interfaces.IQuestionModel;

public abstract class CustomFormAbstractFactoryTest {
    private static CustomFormAbstractFactoryTest uniqueInstance = null;

    public static CustomFormAbstractFactoryTest instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new CustomFormConcreteFactoryTest();
        }
        return uniqueInstance;
    }

    public abstract IFormModel createFormModelTest();
    public abstract IQuestionModel createQuestionModelTest();
    public abstract IAnswerModel createAnswerModelTest();
}

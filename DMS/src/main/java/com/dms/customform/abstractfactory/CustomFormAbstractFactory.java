package com.dms.customform.abstractfactory;

import com.dms.customform.interfaces.*;

public abstract class CustomFormAbstractFactory {
    private static CustomFormAbstractFactory uniqueInstance = null;

    public static CustomFormAbstractFactory instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new CustomFormConcreteFactory();
        }
        return uniqueInstance;
    }

    public abstract IFormModel createFormModel();
    public abstract IQuestionModel createQuestionModel();
    public abstract IAnswerModel createAnswerModel();
}

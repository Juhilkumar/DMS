package com.dms.customform;

import com.dms.customform.abstractfactory.CustomFormAbstractFactoryTest;
import com.dms.customform.abstractfactory.CustomFormConcreteFactoryTest;
import com.dms.customform.interfaces.IAnswerModel;
import com.dms.customform.interfaces.IFormModel;
import com.dms.customform.interfaces.IQuestionModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class FormModelTest {
    CustomFormAbstractFactoryTest customFormAbstractFactoryTest;
    IFormModel iFormModel;

    @BeforeEach
    void init() {
        customFormAbstractFactoryTest = CustomFormConcreteFactoryTest.instance();
        iFormModel = customFormAbstractFactoryTest.createFormModelTest();
    }

    @Test
    void getFormName() {
        String answer = "Survey";
        iFormModel.setFormName(answer);
        Assertions.assertNotNull(iFormModel.getFormName());
        Assertions.assertEquals(answer, iFormModel.getFormName());
    }

    @Test
    void setFormName() {
        String answer = "F1";
        iFormModel.setFormName(answer);
        Assertions.assertNotNull(iFormModel.getFormName());
        Assertions.assertEquals(answer, iFormModel.getFormName());
    }

    @Test
    void getQuestions() {
        IQuestionModel iQuestionModel = customFormAbstractFactoryTest.createQuestionModelTest();
        List<IQuestionModel> questionList = new ArrayList<>();
        iQuestionModel.setQuestionId("1");
        iQuestionModel.setQuestionType("2");
        iQuestionModel.setQuestionDescription("Who is your role model?");
        questionList.add(iQuestionModel);
        iFormModel.setQuestions(questionList);
        Assertions.assertNotNull(iFormModel.getQuestions().get(0));
        Assertions.assertEquals(questionList, iFormModel.getQuestions());
    }

    @Test
    void setQuestions() {
        IQuestionModel iQuestionModel = customFormAbstractFactoryTest.createQuestionModelTest();
        List<IQuestionModel> questionList = new ArrayList<>();
        iQuestionModel.setQuestionId("8");
        iQuestionModel.setQuestionType("3");
        iQuestionModel.setQuestionDescription("What is your gender?");
        questionList.add(iQuestionModel);
        iFormModel.setQuestions(questionList);
        Assertions.assertNotNull(iFormModel.getQuestions().get(0));
        Assertions.assertEquals(questionList, iFormModel.getQuestions());
    }

    @Test
    void getAnswers() {
        IAnswerModel iAnswerModel = customFormAbstractFactoryTest.createAnswerModelTest();
        List<IAnswerModel> answerList = new ArrayList<>();
        iAnswerModel.setQuestionId(27);
        iAnswerModel.setAnswer("Male");
        answerList.add(iAnswerModel);
        iFormModel.setAnswers(answerList);
        Assertions.assertNotNull(iFormModel.getAnswers().get(0));
        Assertions.assertEquals(answerList, iFormModel.getAnswers());
    }

    @Test
    void setAnswers() {
        IAnswerModel iAnswerModel = customFormAbstractFactoryTest.createAnswerModelTest();
        List<IAnswerModel> answerList = new ArrayList<>();
        iAnswerModel.setQuestionId(27);
        iAnswerModel.setAnswer("Female");
        answerList.add(iAnswerModel);
        iFormModel.setAnswers(answerList);
        Assertions.assertNotNull(iFormModel.getAnswers().get(0));
        Assertions.assertEquals(answerList, iFormModel.getAnswers());
    }
}
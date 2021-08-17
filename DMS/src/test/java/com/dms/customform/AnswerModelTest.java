package com.dms.customform;

import com.dms.customform.abstractfactory.CustomFormAbstractFactoryTest;
import com.dms.customform.abstractfactory.CustomFormConcreteFactoryTest;
import com.dms.customform.interfaces.IAnswerModel;
import com.dms.customform.interfaces.IFormModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.mockito.Mockito.*;

class AnswerModelTest {
    CustomFormAbstractFactoryTest customFormAbstractFactoryTest;
    IAnswerModel iAnswerModel;
    AnswerModel answerModel = mock(AnswerModel.class);

    @BeforeEach
    void init() {
        customFormAbstractFactoryTest = CustomFormConcreteFactoryTest.instance();
        iAnswerModel = customFormAbstractFactoryTest.createAnswerModelTest();
    }

    @Test
    void getQuestionId() {
        int questionId = 28;
        iAnswerModel.setQuestionId(questionId);
        Assertions.assertNotNull(iAnswerModel.getQuestionId());
        Assertions.assertEquals(questionId, iAnswerModel.getQuestionId());
    }

    @Test
    void setQuestionId() {
        int questionId = 58;
        iAnswerModel.setQuestionId(questionId);
        Assertions.assertNotNull(iAnswerModel.getQuestionId());
        Assertions.assertEquals(questionId, iAnswerModel.getQuestionId());
    }

    @Test
    void getAnswer() {
        String answer = "Something";
        iAnswerModel.setAnswer(answer);
        Assertions.assertNotNull(iAnswerModel.getAnswer());
        Assertions.assertEquals(answer, iAnswerModel.getAnswer());
    }

    @Test
    void setAnswer() {
        String answer = "Juhil";
        iAnswerModel.setAnswer(answer);
        Assertions.assertNotNull(iAnswerModel.getAnswer());
        Assertions.assertEquals(answer, iAnswerModel.getAnswer());
    }

    @Test
    void saveResponseData() throws SQLException {
        IFormModel iFormModel = customFormAbstractFactoryTest.createFormModelTest();
        IAnswerModel iAnswerModel = new AnswerModel();
        iAnswerModel.setAnswer("I am Lazy");
        iFormModel.getAnswers();
        doNothing().when(answerModel).saveResponseData(iFormModel, "Juhil");
        answerModel.saveResponseData(iFormModel, "Juhil");
        verify(answerModel, times(1)).saveResponseData(iFormModel, "Juhil");
    }
}
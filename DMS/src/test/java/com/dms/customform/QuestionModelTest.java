package com.dms.customform;

import com.dms.customform.abstractfactory.CustomFormAbstractFactoryTest;
import com.dms.customform.abstractfactory.CustomFormConcreteFactoryTest;
import com.dms.customform.interfaces.IFormModel;
import com.dms.customform.interfaces.IQuestionModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class QuestionModelTest {

    CustomFormAbstractFactoryTest customFormAbstractFactoryTest;
    IQuestionModel iQuestionModel;
    QuestionModel questionModel = mock(QuestionModel.class);

    @BeforeEach
    void init() {
        customFormAbstractFactoryTest = CustomFormConcreteFactoryTest.instance();
        iQuestionModel = customFormAbstractFactoryTest.createQuestionModelTest();
    }

    @Test
    void getQuestionId() {
        String questionId = "28";
        iQuestionModel.setQuestionId(questionId);
        Assertions.assertNotNull(iQuestionModel.getQuestionId());
        Assertions.assertEquals(questionId, iQuestionModel.getQuestionId());
    }

    @Test
    void setQuestionId() {
        String questionId = "28";
        iQuestionModel.setQuestionId(questionId);
        Assertions.assertNotNull(iQuestionModel.getQuestionId());
        Assertions.assertEquals(questionId, iQuestionModel.getQuestionId());
    }

    @Test
    void getQuestionType() {
        String questionType = "Numerical";
        iQuestionModel.setQuestionType(questionType);
        Assertions.assertNotNull(iQuestionModel.getQuestionType());
        Assertions.assertEquals(questionType, iQuestionModel.getQuestionType());
    }

    @Test
    void setQuestionType() {
        String questionType = "Numerical";
        iQuestionModel.setQuestionType(questionType);
        Assertions.assertNotNull(iQuestionModel.getQuestionType());
        Assertions.assertEquals(questionType, iQuestionModel.getQuestionType());
    }

    @Test
    void getQuestionDescription() {
        String questionDescription = "What is your favourite Game?";
        iQuestionModel.setQuestionDescription(questionDescription);
        Assertions.assertNotNull(iQuestionModel.getQuestionDescription());
        Assertions.assertEquals(questionDescription, iQuestionModel.getQuestionDescription());
    }

    @Test
    void setQuestionDescription() {
        String questionDescription = "Who was your favourite teacher at school?";
        iQuestionModel.setQuestionDescription(questionDescription);
        Assertions.assertNotNull(iQuestionModel.getQuestionDescription());
        Assertions.assertEquals(questionDescription, iQuestionModel.getQuestionDescription());
    }

    @Test
    void getOptionValue1() {
        String optionValue1 = "Haeshad sir";
        iQuestionModel.setOptionValue1(optionValue1);
        Assertions.assertNotNull(iQuestionModel.getOptionValue1());
        Assertions.assertEquals(optionValue1, iQuestionModel.getOptionValue1());
    }

    @Test
    void setOptionValue1() {
        String optionValue1 = "Harish sir";
        iQuestionModel.setOptionValue1(optionValue1);
        Assertions.assertNotNull(iQuestionModel.getOptionValue1());
        Assertions.assertEquals(optionValue1, iQuestionModel.getOptionValue1());
    }

    @Test
    void getOptionValue2() {
        String optionValue2 = "Neha mam";
        iQuestionModel.setOptionValue2(optionValue2);
        Assertions.assertNotNull(iQuestionModel.getOptionValue2());
        Assertions.assertEquals(optionValue2, iQuestionModel.getOptionValue2());
    }

    @Test
    void setOptionValue2() {
        String optionValue2 = "Nihal sir";
        iQuestionModel.setOptionValue2(optionValue2);
        Assertions.assertNotNull(iQuestionModel.getOptionValue2());
        Assertions.assertEquals(optionValue2, iQuestionModel.getOptionValue2());
    }

    @Test
    void getOptionValue3() {
        String optionValue3 = "Dhupia mam";
        iQuestionModel.setOptionValue3(optionValue3);
        Assertions.assertNotNull(iQuestionModel.getOptionValue3());
        Assertions.assertEquals(optionValue3, iQuestionModel.getOptionValue3());
    }

    @Test
    void setOptionValue3() {
        String optionValue3 = "Dhupia mam";
        iQuestionModel.setOptionValue3(optionValue3);
        Assertions.assertNotNull(iQuestionModel.getOptionValue3());
        Assertions.assertEquals(optionValue3, iQuestionModel.getOptionValue3());
    }

    @Test
    void getOptionValue4() {
        String optionValue4 = "No one";
        iQuestionModel.setOptionValue4(optionValue4);
        Assertions.assertNotNull(iQuestionModel.getOptionValue4());
        Assertions.assertEquals(optionValue4, iQuestionModel.getOptionValue4());
    }

    @Test
    void setOptionValue4() {
        String optionValue4 = "No Comments";
        iQuestionModel.setOptionValue4(optionValue4);
        Assertions.assertNotNull(iQuestionModel.getOptionValue4());
        Assertions.assertEquals(optionValue4, iQuestionModel.getOptionValue4());
    }

    @Test
    void saveFormData() throws SQLException {
        IFormModel iFormModel = customFormAbstractFactoryTest.createFormModelTest();
        IQuestionModel iQuestionModel = new QuestionModel();
        iQuestionModel.setQuestionDescription("Who is your role model?");
        iFormModel.getQuestions();
        doNothing().when(questionModel).saveFormData(iFormModel);
        questionModel.saveFormData(iFormModel);
        verify(questionModel, times(1)).saveFormData(iFormModel);
    }

    @Test
    void formQuestionList() throws SQLException {
        IQuestionModel question = customFormAbstractFactoryTest.createQuestionModelTest();
        List<IQuestionModel> questionList = new ArrayList<>();
        question.setQuestionId("1");
        question.setQuestionType("2");
        question.setQuestionDescription("Who is your role model?");
        questionList.add(question);
        Assertions.assertEquals(questionList.size(), iQuestionModel.formQuestionList("Survey").size());
    }
}
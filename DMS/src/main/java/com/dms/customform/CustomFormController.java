package com.dms.customform;

import com.dms.customform.abstractfactory.CustomFormAbstractFactory;
import com.dms.customform.interfaces.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class CustomFormController {
    private static final String USER_NAME = "username";
    private static final String CUSTOM_FORM_PAGE = "customForm";
    private static final String FORM_NAME = "formName";
    private static final String SURVEY_FORM = "Survey";
    private static final String NUMBER_OF_QUESTIONS = "q_no";
    private static final String QUESTION_TYPE = "q_type_";
    private static final String QUESTION_ID = "questionId_";
    private static final String QUESTION_DESCRIPTION = "q_desc_";
    private static final String OPTION_1_DETAIL = "_detail_value_1";
    private static final String OPTION_2_DETAIL = "_detail_value_2";
    private static final String OPTION_3_DETAIL = "_detail_value_3";
    private static final String OPTION_4_DETAIL = "_detail_value_4";
    private static final String ANSWER = "answerForQuestionId_";
    private static final String CUSTOM_FORM_SUCCESS_PAGE = "addCustomFormSuccess";
    private static final String CUSTOM_FORM_RESPONSE_PAGE = "customFormResponse";
    private static final String CUSTOM_FORM_RESPONSE_SUCCESS_PAGE = "customFormResponseSuccess";
    private static final String USER_LOGGED_IN = "loggedIn";
    private static final String YES = "yes";
    private static final String ERROR_PAGE = "error";

    CustomFormAbstractFactory customFormAbstractFactory = CustomFormAbstractFactory.instance();
    IQuestionModel iQuestionModel = customFormAbstractFactory.createQuestionModel();
    IAnswerModel iAnswerModel = customFormAbstractFactory.createAnswerModel();

    @RequestMapping(value = "/customForm")
    public String showCustomForm() {
        return CUSTOM_FORM_PAGE;
    }

    @PostMapping(value = "/processCustomForm")
    public ModelAndView processQuestionForm(@RequestParam("formName") String formName, HttpServletRequest request) throws SQLException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        IFormModel iFormModel = customFormAbstractFactory.createFormModel();
        iFormModel.setFormName(parameterMap.get(FORM_NAME)[0]);
        iFormModel.setQuestions(new ArrayList<>());
        int noOfQuestions = Integer.parseInt(parameterMap.get(NUMBER_OF_QUESTIONS)[0]);

        for (int i = 1; i <= noOfQuestions; i++) {
            IQuestionModel question = customFormAbstractFactory.createQuestionModel();
            question.setQuestionType(parameterMap.get(QUESTION_TYPE + i)[0]);
            question.setQuestionDescription(parameterMap.get(QUESTION_DESCRIPTION + i)[0]);
            if (StringUtils.equals(question.getQuestionType(), "2")) {
                question.setOptionValue1(parameterMap.get(QUESTION_DESCRIPTION + i + OPTION_1_DETAIL)[0]);
                question.setOptionValue2(parameterMap.get(QUESTION_DESCRIPTION + i + OPTION_2_DETAIL)[0]);
                question.setOptionValue3(parameterMap.get(QUESTION_DESCRIPTION + i + OPTION_3_DETAIL)[0]);
                question.setOptionValue4(parameterMap.get(QUESTION_DESCRIPTION + i + OPTION_4_DETAIL)[0]);
            }
            iFormModel.getQuestions().add(question);
        }
        iQuestionModel.saveFormData(iFormModel);
        List<IQuestionModel> questionList = iQuestionModel.formQuestionList(formName);
        ModelAndView model = new ModelAndView(CUSTOM_FORM_SUCCESS_PAGE);
        model.addObject("list", questionList);
        return model;
    }

    @RequestMapping(value = "/fillFormResponse")
    public ModelAndView showFormForResponse() throws SQLException {
        List<IQuestionModel> questionList = iQuestionModel.formQuestionList(SURVEY_FORM);
        ModelAndView model = new ModelAndView(CUSTOM_FORM_RESPONSE_PAGE);
        model.addObject("list", questionList);
        return model;
    }

    @PostMapping(value = "/processFormResponse")
    public String showFormResponseSuccess(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        String loggedIn = (String) session.getAttribute(USER_LOGGED_IN);
        String userName = (String) session.getAttribute(USER_NAME);
        if (StringUtils.equals(loggedIn, YES)) {
            Map<String, String[]> parameterMap = request.getParameterMap();
            IFormModel iFormModel = customFormAbstractFactory.createFormModel();
            iFormModel.setFormName(SURVEY_FORM);
            iFormModel.setAnswers(new ArrayList<>());
            int noOfQuestions = Integer.parseInt(parameterMap.get(NUMBER_OF_QUESTIONS)[0]);
            for (int i = 1; i <= noOfQuestions; i++) {
                IAnswerModel answer = customFormAbstractFactory.createAnswerModel();
                int questionId = Integer.parseInt(parameterMap.get(QUESTION_ID + i)[0]);
                answer.setQuestionId(questionId);
                answer.setAnswer(parameterMap.get(ANSWER + questionId)[0]);
                iFormModel.getAnswers().add(answer);
            }
            iAnswerModel.saveResponseData(iFormModel, userName);
            return CUSTOM_FORM_RESPONSE_SUCCESS_PAGE;
        }
        return ERROR_PAGE;
    }
}

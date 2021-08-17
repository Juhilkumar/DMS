package com.dms.authentication;

import com.dms.authentication.interfaces.ICaptcha;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CaptchaModel implements ICaptcha {
    private static final String OPERATION1 ="+";
    private static final String OPERATION2 ="-";
    private static final String OPERATION3 ="*";
    private static final int BOUND=10;
    int randomNumber1 ;
    int randomNumber2 ;

    String operationGenerated;
    String CaptchaInput;
    boolean CaptchaValid;
    Random rand = new Random();

    public int random1() {
        int random1 = rand.nextInt(BOUND);
        return (random1);
    }

    public int random2() {
        int random2 = rand.nextInt(BOUND);
        return (random2);
    }

    public String operation(){
        List<String> list=new ArrayList<String>();
        list.add(OPERATION1);
        list.add(OPERATION2);
        list.add(OPERATION3);
        int randomOperation = rand.nextInt(list.size());
        return(list.get(randomOperation));
    }

    public String generateCaptcha(){
        operationGenerated = operation().replace(" ", "");
        randomNumber1 =random1();
        randomNumber2 =random2();
        CaptchaInput =randomNumber1+operationGenerated+randomNumber2;
        return CaptchaInput;
    }

    public boolean captcha(String captchaOutput){
        if(operationGenerated.equals(OPERATION3)){
            CaptchaValid= multiplyOperation(captchaOutput);
        }
        else if(operationGenerated.equals(OPERATION1)){
            CaptchaValid = additionOperation(captchaOutput);
        }
        else if (operationGenerated.equals(OPERATION2)){
            CaptchaValid = substractOperation(captchaOutput);
        }
        else{
            CaptchaValid = false;
        }
        return CaptchaValid;
    }

    public boolean additionOperation(String captchaOutput){
        int output = randomNumber1+randomNumber2;
        if(output == Integer.parseInt(captchaOutput)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean substractOperation(String captchaOutput){
        int output = randomNumber1-randomNumber2;
        if(output == Integer.parseInt(captchaOutput)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean multiplyOperation(String captchaOutput){
        int output = randomNumber1*randomNumber2;
        if(output == Integer.parseInt(captchaOutput)){
            return true;
        }
        else{
            return false;
        }
    }
}





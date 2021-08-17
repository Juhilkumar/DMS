package com.dms.authentication.interfaces;

public interface ICaptcha {
    int random1();
    int random2();
    String operation();
    String generateCaptcha();
    boolean captcha(String captchaOutput);
    boolean additionOperation(String captchaOutput);
    boolean substractOperation(String captchaOutput);
    boolean multiplyOperation(String captchaOutput);

}

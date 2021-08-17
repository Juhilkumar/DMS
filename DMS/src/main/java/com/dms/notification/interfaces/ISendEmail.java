package com.dms.notification.interfaces;

public interface ISendEmail {
    boolean sendMailNotification(String recipients[],String msgSubject, String messageBody);
}

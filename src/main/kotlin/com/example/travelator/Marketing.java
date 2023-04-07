package com.example.travelator;

public class Marketing {
    public static boolean isHotmailAddress(EmailAddress emailAddress) {
        return emailAddress.getDomain().equalsIgnoreCase("hotmail.com");
    }
}

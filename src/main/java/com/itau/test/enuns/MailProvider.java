package com.itau.test.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MailProvider {

    GMAIL("@gmail.com"),
    HOTMAIL("@hotmail.com"),
    OUTLOOK("@outlook.com"),
    YAHOO("@yahoo.com");

    public final String provider;

}

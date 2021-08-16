package com.matilda.encryptdecrypt.model;

public class EncryptDecryptRequest {
    private String stringValue;
    private String key;

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

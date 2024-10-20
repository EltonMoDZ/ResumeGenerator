package br.com.eltonodev.service;

import com.deepl.api.*;

public class Translator {
    com.deepl.api.Translator translator;
    private String authKey;

    public Translator(String authKey) {
        this.authKey = authKey;  // Replace with your key
    }

    public String translate(String text) throws Exception {
        translator = new com.deepl.api.Translator(authKey);
        TextResult result =
                translator.translateText(text, null, "en-US");
        return result.getText();
    }

}
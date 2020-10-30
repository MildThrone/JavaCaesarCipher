package com.company.Cipher;

public class Encrypt {
    private String rawText = "";
    private int key;
    private String cipherText = "";

    public String encText() {
        char[] rawTextArray = rawText.toCharArray();
        //a=97, z=122, A=65, Z=90

        for (var i : rawTextArray) {
            if ((i == ' ') || !(isLetter(i))) {
                cipherText = cipherText.concat(String.valueOf(i));
                continue;
            } else if (isUpper(i)) {
                i = (char) (i + key);
                if (i > 90) {
                    i = (char) ((i % 91) + 65);
                }
            } else {
                i = (char) (i + key);
                if (i > 122) {
                    i = (char) ((i % 123) + 97);
                }
            }
            cipherText = cipherText.concat(String.valueOf(i));
        }

        return cipherText;
    }

    public void setRawText(String rawText) {
        this.rawText = rawText;
    }

    public void setKey(int key) {
        this.key = key;
    }

    private static Boolean isLetter(char a) {
        return (a >= 'A' && a <= 'Z') || (a >= 'a' && a <= 'z');
    }

    private static Boolean isUpper(char c) {
        return c >= 'A' && c <= 'Z';
    }

}

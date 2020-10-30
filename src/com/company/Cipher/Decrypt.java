package com.company.Cipher;

public class Decrypt {
    private String cipherText = "";
    private int key;
    private String rawText = "";

    public String decText() {
        char[] cipherTextArray = cipherText.toCharArray();
        //a=97, z=122, A=65, Z=90

        for (var i : cipherTextArray) {
            if ((i == ' ') || !(isLetter(i))) {
                rawText = rawText.concat(String.valueOf(i));
                continue;
            } else if (isUpper(i)) {
                i = (char) (i - key);
                if (!isLetter(i)) {
                    int x_key = 'A' - i;
                    i = (char) ('Z' + 1 - x_key);
                }
            } else if (!isUpper(i)) {
                //If lowercase
                i = (char) (i - key);
                if (!isLetter(i)) {
                    int x_key = 'a' - i;
                    i = (char) ('z' + 1 - x_key);
                }
            }
            rawText = rawText.concat(String.valueOf(i));
        }

        return rawText;
    }


    public void setCipherText(String cipherText) {
        this.cipherText = cipherText;
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

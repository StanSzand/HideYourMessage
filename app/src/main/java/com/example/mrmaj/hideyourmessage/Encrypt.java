package com.example.mrmaj.hideyourmessage;

public class Encrypt {



    public static String encrypt(String message,int key){

        String keyString = String.valueOf(key);
        String num = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String encryptedMessage = "";

        int keyLength = keyString.length();
        int messageLength = message.length();

        String[] numbers = new String[keyLength];


        for (int i = 0; i < keyLength; i++){
            char charString = keyString.charAt(i);
            numbers[i] = Character.toString(charString);
        }

        while (num.length() < messageLength){
            for (int i = 0; i < numbers.length; i++){
                num += numbers[i];
                if (num.length() == messageLength){
                    break;
                }
            }
        }

        int index;
        String letter;
        for (int i = 0; i < messageLength; i++){
            char charString = message.charAt(i);
            if (alphabet.indexOf(charString) != -1){
                char charKeyString = num.charAt(i);
                if (charKeyString == '1' || charKeyString == '3' || charKeyString == '5' || charKeyString == '7' || charKeyString == '9'){
                    int x = Character.getNumericValue(charKeyString);

                    index = alphabet.indexOf(charString);
                    index -= x;
                    if (index >= 0){
                        char lett = alphabet.charAt(index);
                        letter = String.valueOf(lett);
                    }else{
                        char lett = alphabet.charAt(alphabet.length() + index);
                        letter = String.valueOf(lett);
                    }
                    //send nudes

                    encryptedMessage += letter;
                }else{
                    int x = Character.getNumericValue(charKeyString);

                    index = alphabet.indexOf(charString);
                    index = index + x;
                    if (index > 25){
                        index -= 26;
                    }
                    if (index < 0){
                        char lett = alphabet.charAt(alphabet.length() -index);
                        letter = String.valueOf(lett);
                    }else{
                        char lett = alphabet.charAt(index);
                        letter = String.valueOf(lett);
                    }
                    encryptedMessage += letter;
                }
            }else {
                encryptedMessage += charString;
            }
        }

        return encryptedMessage;
    }

}

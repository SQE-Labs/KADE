package org.automation.utilities;

import org.openqa.selenium.By;

import java.util.Random;
import java.util.UUID;

public class RandomGenerator {

    public static void random(By path, String valueToBeSent) {
        Random objGenerator = new Random();
        for (int iCount = 0; iCount < 10; iCount++) {
            int randomNumber = objGenerator.nextInt(100);
            System.out.println("Random No : " + randomNumber);
        }
    }
    public static  String generateRandomEmail() {
        String uniqueId = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        return uniqueId + "@yopmail.com";
    }

    public static String requiredString(int n) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder s = new StringBuilder(n);
        int y;
        for (y = 0; y < n; y++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            s.append(AlphaNumericString.charAt(index));
        }
        return s.toString();
    }

    public static String requiredCharacters(int n) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder s = new StringBuilder(n);
        int y;
        for (y = 0; y < n; y++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            s.append(AlphaNumericString.charAt(index));
        }
        return s.toString();
    }

    public String requiredDigits(int n) {
        String AlphaNumericString = "1234567890";
        StringBuilder s = new StringBuilder(n);
        int y;
        for (y = 0; y < n; y++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            s.append(AlphaNumericString.charAt(index));
        }
        return s.toString();
    }

    public static String requiredNumber(int n) {
        String AlphaNumericString = "0123456789";
        StringBuilder s = new StringBuilder(n);
        int y;
        for (y = 0; y < n; y++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            s.append(AlphaNumericString.charAt(index));
        }
        return s.toString();
    }

    public static String generateRandomNumber(double min, double max) {
        Random random = new Random();
        double randomNumber = Math.round((min + (max - min) * random.nextDouble()) * 100.0) / 100.0;
        return String.format("%.2f", randomNumber);
    }
}

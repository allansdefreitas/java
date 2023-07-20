package org.example;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public String createSHAHash(final String input) throws NoSuchAlgorithmException {
        String hashtext = null;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] messageDigest =  md.digest(input.getBytes(StandardCharsets.UTF_8));
        System.out.println(messageDigest.length);

        hashtext = convertToHex(messageDigest);
        return hashtext;
    }

    private String convertToHex(final byte[] messageDigest) {
        BigInteger bigint = new BigInteger(1, messageDigest);
        String hexText = bigint.toString(16);
        while (hexText.length() < 32) {
            hexText = "0".concat(hexText);
        }
        return hexText;
    }

    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

    }
}
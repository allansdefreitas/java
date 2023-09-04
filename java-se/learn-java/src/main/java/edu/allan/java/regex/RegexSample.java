package edu.allan.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSample{
    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("w3schools", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("Visit W3Schools! lorem ipsum dolor");

        boolean matchFound = matcher.find();

        if(matchFound) {
            System.out.println("Match found");
        } else {
            System.out.println("Match not found");
        }

        Pattern pattern2 = Pattern.compile("[0-3]", Pattern.CASE_INSENSITIVE);
        Matcher matcher2 = pattern2.matcher("Visit W3Schools! lorem ipsum dolor");

        boolean matchFound2 = matcher2.find();

        if(matchFound2) {
            System.out.println("Match found");
        } else {
            System.out.println("Match not found");
        }
    }
}

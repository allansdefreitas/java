package edu.allan.java.lambda;

interface StringFunction {
    String run(String str);
}
public class LambdaSample3 {
    public static void main(String[] args) {
        StringFunction exclaim = (s) -> s + "!";
        StringFunction ask = (s) -> s + "?";
        StringFunction finalDot = (s) -> s + ".";

        printFormatted("Hello", exclaim);
        printFormatted("Hello", ask);
        printFormatted("Hello", finalDot);
    }
    public static void printFormatted(String str, StringFunction format) {
        String result = format.run(str);
        System.out.println(result);
    }
}

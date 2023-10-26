package edu.allan.model;

public class Calculator {

	
	public static int sum(int a, int b) {
		
		return a + b;
	}

	public static boolean isEven(Integer a) {
		
		if (a % 2 == 0){
			return true;
		}else {
			return false;
		}
	}
	
}

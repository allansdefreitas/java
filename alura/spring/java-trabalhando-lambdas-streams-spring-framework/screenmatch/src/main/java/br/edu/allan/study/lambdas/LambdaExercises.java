package br.edu.allan.study.lambdas;

/**
 * Interface funcional é uma interface que possui um e somente um método abstrato.
 * Sua implementação (Consumer) pode ser uma classe anônima ou um lambda.
 */
@FunctionalInterface
interface Multiplicacao {
    int multiplicar(int a, int b);
}
@FunctionalInterface
interface Primo {
    boolean verificarPrimo(int n);
}

interface Transformador {
    String transformar(String s);
}

interface Divisor {
    int dividir(int a, int b) throws ArithmeticException;
}

public class LambdaExercises {
    public static void main(String[] args) {
        Multiplicacao mult = (a, b) -> a * b;
        System.out.println(mult.multiplicar(5, 3));  
        
        Primo primo = n -> {
            if (n <= 1) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        };
        System.out.println(primo.verificarPrimo(11));  // Resultado: true
        System.out.println(primo.verificarPrimo(12));  // Resultado: false
        
        Transformador toUpperCase = s -> s.toUpperCase();
        System.out.println(toUpperCase.transformar("java")); // Esperado: "JAVA"
        
        Divisor divisor = (a, b) -> {
            if (b == 0) throw new ArithmeticException("Divisão por zero");
            return a / b;
        };
        
        try {
            System.out.println(divisor.dividir(10, 2)); // Esperado: 5
            System.out.println(divisor.dividir(10, 0)); // Esperado: Exceção
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
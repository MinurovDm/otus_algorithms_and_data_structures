package main.java.hw03_prime_numbers;

public class Exponentiation {

    static long powViaMultiply(int num, int degree) {
        long result = 1;
        for (int i = 1; i <= degree; i++) {
            result *= num;
        }
        return result;
    }
}

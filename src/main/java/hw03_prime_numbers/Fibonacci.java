package hw03_prime_numbers;

public class Fibonacci {

    static long fibonacciRecursion(int N) {
        if (N <= 1) {
            return 0;
        }
        if (N == 2) {
            return 1L;
        }
        return fibonacciRecursion(N - 1) + fibonacciRecursion(N - 2);
    }

    static long fibonacciCycle(int N) {
        if (N <= 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        int numA = 1;
        int numB = 1;

        for (int i = 2; i < N; i++) {
            int numFibonacci = numA + numB;
            numA = numB;
            numB = numFibonacci;
        }

        return numB;
    }

}

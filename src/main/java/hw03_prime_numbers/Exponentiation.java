package hw03_prime_numbers;

public class Exponentiation {

    static long powViaMultiply(int num, int degree) {
        long startTime = System.nanoTime();
        if (degree == 0) {
            return 1;
        }

        int numInFirstDegree = num;
        for (int i = 2; i <= degree; i++) {
            num *= numInFirstDegree;
        }
        System.out.println(startTime - System.nanoTime());
        return num;
    }
}

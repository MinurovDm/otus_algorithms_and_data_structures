package hw03_prime_numbers;

public class PrimeNumber {

    public static int primeNumbersBruteForce(int n) {
        int count = 0;

        if (n >= 2) {
            count++;
        }
        for (int i = 3; i <= n; i += 2) {
            if (isPrimeBruteForce(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPrimeBruteForce(int number) {
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

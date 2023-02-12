package hw_2_lucky_tickets;

public class Main {
    static int count = 0;

    public static void main(String[] args) {
        System.out.println(solveForSix());
    }

    static int solveForSix() {
        getLuckyCount(5, 0, 0);
        return count;
    }


    static void getLuckyCount(int N, int sumA, int sumB) {
        if (N == 0) {
            if (sumA == sumB) {
                count++;
            }
            return;
        }
        for (int a = 0; a <= 9; a++) {
            for (int b = 0; b <= 9; b++) {
                getLuckyCount(N-1, sumA+a, sumB+b);
            }
        }
    }
}
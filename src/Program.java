import model.*;

import java.util.Date;

public class Program {

    public static void main(String[] args) {
        IArray<Date> singleArray = new SingleArray<>();
        IArray<Date> vectorArray = new VectorArray<>();
        IArray<Date> factorArray = new FactorArray<>();
        IArray<Date> matrixArray = new MatrixArray<>();
        testAddArray(singleArray, 10_000);
        testAddArray(vectorArray, 100_000);
        testAddArray(factorArray, 100_000);
        testAddArray(matrixArray, 100_000);
    }

    private static void testAddArray(IArray<Date> data, int total) {
        long start = System.currentTimeMillis();

        for (int j = 0; j < total; j ++)
            data.add(new Date(), j);

        System.out.println(data + " testAddArray: " +
                           (System.currentTimeMillis() - start));
    }
}

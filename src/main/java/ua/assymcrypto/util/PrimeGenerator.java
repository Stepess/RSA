package ua.assymcrypto.util;

import java.math.BigInteger;
import java.util.Random;

public class PrimeGenerator {

    public static BigInteger generateRandomBigIntegerInRange(BigInteger min, BigInteger max) {
        BigInteger boundary = max.subtract(min).add(BigInteger.ONE);
        Random random = new Random(System.nanoTime());
        BigInteger result;

        do {
            result = new BigInteger(boundary.bitLength(), random).add(min);
        } while (result.compareTo(max) >= 0);

        return result;
    }

    private int generateRandomIntWithinRange(int min, int max) {
        Random random = new Random(System.nanoTime());
        return random.nextInt((max-min) + 1) + min;
    }
}

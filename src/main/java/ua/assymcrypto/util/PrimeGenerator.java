package ua.assymcrypto.util;

import java.math.BigInteger;
import java.util.Random;

public class PrimeGenerator {
    private static final int[] PRIME_NUMBERS = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
            43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139,
            149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199};

    public static boolean checkHexNumForTrialDivisionMethod(BigInteger num) {
        for (int prime: PRIME_NUMBERS) {
            if (num.mod(BigInteger.valueOf(prime)).equals(BigInteger.ZERO)) {
                return false;
            }
        }
        return true;
    }

    public static BigInteger generateRandomBigIntegerInRange(BigInteger min, BigInteger max) {
        BigInteger boundary = max.subtract(min).add(BigInteger.ONE);
        Random random = new Random(System.nanoTime());
        BigInteger result;

        do {
            result = new BigInteger(boundary.bitLength(), random).add(min);
        } while (result.compareTo(max) >= 0);

        return result;
    }

    public static boolean checkMillerRabinTest(BigInteger num, int trustLevel) {
        int counter = 0;
        BigInteger two = BigInteger.valueOf(2);
        BigInteger copyOfNum = new BigInteger(String.valueOf(num));
        copyOfNum = copyOfNum.subtract(BigInteger.ONE);

        //present out number as d*2^s
        int s = 0;
        BigInteger d;

        while (copyOfNum.mod(two).equals(BigInteger.ZERO)) {
            s++;
            copyOfNum = copyOfNum.divide(two);
        }

        while (counter < trustLevel) {
            BigInteger x = generateRandomBigIntegerInRange(BigInteger.ONE, num);
            if(x.gcd(num).compareTo(BigInteger.ONE) == 1) {
                return false;
            }
            if (isStrongPseudoPrime(num, x, copyOfNum, s)) {
                counter++;
            } else {
                return false;
            }
        }

        return true;
    }

    private static boolean isStrongPseudoPrime(BigInteger num, BigInteger base, BigInteger d, int s) {
        BigInteger two = BigInteger.valueOf(2);
        BigInteger minusOneByModuleNum = num.subtract(BigInteger.ONE);
        BigInteger temp = base.modPow(d, num);
        if (temp.equals(BigInteger.ONE) || temp.equals(minusOneByModuleNum)) {
            return true;
        }

        BigInteger xr = new BigInteger(String.valueOf(base));
        for (int r=1; r<s; r++) {
            xr = xr.modPow(two, num);
            if (xr.equals(minusOneByModuleNum)){
                return true;
            }
            if (xr.equals(BigInteger.ONE)) {
                return false;
            }
        }

        return false;
    }

    private int generateRandomIntWithinRange(int min, int max) {
        Random random = new Random(System.nanoTime());
        return random.nextInt((max-min) + 1) + min;
    }
}

package ua.assymcrypto.model;

import ua.assymcrypto.model.util.PrimeGenerator;
import ua.assymcrypto.model.util.PrimeTests;

import java.math.BigInteger;

public class RSA {
    public BigInteger[] generateKeyPair() {
        return generateKeyPair(256);
    }

    public BigInteger[] generateKeyPair(int keySize) {
        BigInteger two = BigInteger.valueOf(2);
        BigInteger[] keyPair = new BigInteger[2];

        keyPair[0] = PrimeGenerator.generateRandomPrimeIntegerWithBitLength(keySize-1);
        keyPair[1] = PrimeGenerator.generateRandomPrimeIntegerWithBitLength(keySize-1);

        BigInteger p = keyPair[0].multiply(BigInteger.valueOf(2)).add(BigInteger.ONE);
        BigInteger q = keyPair[1].multiply(BigInteger.valueOf(2)).add(BigInteger.ONE);

        int i = 2;
        while(!PrimeTests.isPrime(p)) {
            p = keyPair[0].multiply(two).multiply(BigInteger.valueOf(i)).add(BigInteger.ONE);
            i++;
        }

        int j = 2;
        while(!PrimeTests.isPrime(q)) {
            q = keyPair[1].multiply(two).multiply(BigInteger.valueOf(j)).add(BigInteger.ONE);
            j++;
        }

        keyPair[0] = p;
        keyPair[1] = q;

        return keyPair;
    }
}

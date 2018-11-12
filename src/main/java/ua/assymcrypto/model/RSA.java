package ua.assymcrypto.model;

import ua.assymcrypto.model.util.PrimeGenerator;
import ua.assymcrypto.model.util.PrimeTests;

import java.math.BigInteger;

public class RSA {
    private RSAKey key;

    public BigInteger encrypt(BigInteger plainText) {
        return plainText.modPow(key.getPublicKey().getE(), key.getPublicKey().getN());
    }

    public BigInteger decrypt(BigInteger cryptogram) {
        return cryptogram.modPow(key.getPrivateKey().getD(), key.getPublicKey().getN());
    }


    public RSAKey generateKeyPair() {
        BigInteger[] primeNums = generateKeyPrimeNumbersForKey();
        BigInteger n = primeNums[0].multiply(primeNums[1]);
        BigInteger eulersFunction = primeNums[0].subtract(BigInteger.ONE)
                .multiply(primeNums[1].subtract(BigInteger.ONE));
        BigInteger e = BigInteger.valueOf(2).pow(16).add(BigInteger.ONE);

        if (!e.gcd(eulersFunction).equals(BigInteger.ONE)) {
            System.err.println("ERROR");
            e = PrimeGenerator.generateRandomPrimeBigIntegerInRange(BigInteger.valueOf(2), eulersFunction.subtract(BigInteger.ONE));
        }

        BigInteger d = e.modInverse(eulersFunction);

        key = new RSAKey(new PrivateKey(primeNums[0], primeNums[1], d),
                new PublicKey(n, e));

        return key;
    }

    public BigInteger[] generateKeyPrimeNumbersForKey() {
        return generateKeyPrimeNumbersForKey(256);
    }

    public BigInteger[] generateKeyPrimeNumbersForKey(int keySize) {
        BigInteger two = BigInteger.valueOf(2);
        BigInteger[] numPair = new BigInteger[2];

        numPair[0] = PrimeGenerator.generateRandomPrimeIntegerWithBitLength(keySize-1);
        numPair[1] = PrimeGenerator.generateRandomPrimeIntegerWithBitLength(keySize-1);

        BigInteger p = numPair[0].multiply(BigInteger.valueOf(2)).add(BigInteger.ONE);
        BigInteger q = numPair[1].multiply(BigInteger.valueOf(2)).add(BigInteger.ONE);

        int i = 2;
        while(!PrimeTests.isPrime(p)) {
            p = numPair[0].multiply(two).multiply(BigInteger.valueOf(i)).add(BigInteger.ONE);
            i++;
        }

        int j = 2;
        while(!PrimeTests.isPrime(q)) {
            q = numPair[1].multiply(two).multiply(BigInteger.valueOf(j)).add(BigInteger.ONE);
            j++;
        }

        numPair[0] = p;
        numPair[1] = q;

        return numPair;
    }

    public void setKey(RSAKey key) {
        this.key = key;
    }

    public RSAKey getKey() {
        return key;
    }
}

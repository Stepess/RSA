package ua.assymcrypto;

import ua.assymcrypto.model.RSA;
import ua.assymcrypto.model.RSAKey;
import ua.assymcrypto.model.util.PrimeGenerator;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

public class App
{
    public static void main( String[] args )
    {
        /*BigInteger integer = new BigInteger(256, new Random());
        System.out.println(integer);
        BigInteger two = BigInteger.valueOf(2);
        System.out.println(two.pow(256));

        RSA rsa = new RSA();
        BigInteger[] pair = rsa.generateKeyPrimeNumbersForKey();
        System.out.println(Arrays.toString(pair));
        System.out.println(pair[0].toString(16));*/

        RSA rsa = new RSA();
        RSAKey key = rsa.generateKeyPair();

        System.out.println(key);

        BigInteger text = PrimeGenerator.generateRandomBigIntegerInRange(BigInteger.ZERO,
                key.getPublicKey().getN().subtract(BigInteger.ONE));

        System.out.println(text.toString(16));

        BigInteger cypher = rsa.encrypt(text);

        System.out.println(cypher.toString(16));

        BigInteger plainTextAfterDecription = rsa.decrypt(cypher);

        System.out.println(plainTextAfterDecription.toString(16));

        System.out.println(plainTextAfterDecription.equals(text));




    }
}

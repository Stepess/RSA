package ua.assymcrypto;

import ua.assymcrypto.model.RSA;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

public class App
{
    public static void main( String[] args )
    {
        BigInteger integer = new BigInteger(256, new Random());
        System.out.println(integer);
        BigInteger two = BigInteger.valueOf(2);
        System.out.println(two.pow(256));

        RSA rsa = new RSA();
        BigInteger[] pair = rsa.generateKeyPair();
        System.out.println(Arrays.toString(pair));
        System.out.println(pair[0].toString(16));

    }
}

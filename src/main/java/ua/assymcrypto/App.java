package ua.assymcrypto;

import ua.assymcrypto.util.PrimeGenerator;
import ua.assymcrypto.util.PrimeTests;
import ua.assymcrypto.util.RadixUtil;

import java.math.BigInteger;
import java.util.Random;

public class App
{
    public static void main( String[] args )
    {
        BigInteger integer = new BigInteger(256, new Random());
        System.out.println(integer);
        BigInteger two = BigInteger.valueOf(2);
        System.out.println(two.pow(256));

    }
}

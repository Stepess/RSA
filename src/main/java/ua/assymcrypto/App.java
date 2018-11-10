package ua.assymcrypto;

import ua.assymcrypto.util.PrimeGenerator;
import ua.assymcrypto.util.RadixUtil;

import java.math.BigInteger;
import java.util.Random;

public class App
{
    public static void main( String[] args )
    {
        BigInteger num = PrimeGenerator.generateRandomBigIntegerInRange(BigInteger.valueOf(13), new BigInteger("FFFFFFFFFFF", 16));
        System.out.println(num);
        BigInteger prob = BigInteger.probablePrime(65, new Random());
        System.out.println(prob);

    }
}

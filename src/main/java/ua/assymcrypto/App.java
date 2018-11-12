package ua.assymcrypto;

import ua.assymcrypto.model.PrivateKey;
import ua.assymcrypto.model.PublicKey;
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

        RSAKey rsaKey = new RSAKey(
                new PrivateKey(new BigInteger("35ac37ba4f90d5d16ca42319b9064ffe938aabb05ef01c2e8e6392644150faf693", 16),
                        new BigInteger("4220ce32003e89b430603190df6cab1049716d89e275263d55afe8437c71eb0393", 16),
                        new BigInteger("9d690870f2ff6fbfc24f3158f2cde6b81fc19180a1789cde1fc59133d9df124f6bb8b2440e8075a60c2741526f816e36101f4f4a90edf839b529e83caa671365de5", 16)),
                new PublicKey(new BigInteger("ddd4720105534393eb5cbf8b95ed6f6c27b5b6e0235e9cd308f18e2869393925e2c57312e1165f29f13da742334e7c46c29000848ae50fcec329b405adfacf04f69", 16),
                            new BigInteger("10001", 16))
        );

        RSA rsa = new RSA();
        BigInteger text = new BigInteger("123456789ABCDEF", 16);

        System.out.println(rsaKey);
        rsa.setKey(rsaKey);

        System.out.println("-----------ENCRYPT----------");
        System.out.println("Plain text = " + text.toString(16));
        BigInteger cryptogram = rsa.encrypt(text);
        System.out.println("Cryptogram = " + cryptogram.toString(16));

        System.out.println();

        System.out.println("-----------FROM SITE------------");
        BigInteger fromSite = new BigInteger("DE13D0135999C41261B857E400AEFD9F5DC11F59854261854E31BB09B45A4125213579E127F23D550529C5D00CA441194E3DBD801A5BF9B79734629B4B1792677B", 16);
        System.out.println("Number from site = " + fromSite.toString(16));
        System.out.println("Decrypted = " + rsa.decrypt(fromSite).toString(16));



    }
}

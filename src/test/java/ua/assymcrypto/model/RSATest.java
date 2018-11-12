package ua.assymcrypto.model;

import org.junit.BeforeClass;
import org.junit.Test;
import ua.assymcrypto.model.util.PrimeGenerator;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class RSATest {
    private static RSA rsa;
    private static RSAKey key;

    @BeforeClass
    public static void SetUp() {
        rsa = new RSA();
        key = rsa.generateKeyPair();
    }

    @Test
    public void WhenEncryptAndDecryptNumberThenNumberNotChange() {
        BigInteger text = new BigInteger("D2ECAC06E24E7FF6A1E769196AA35704D49392DD8AE6A0E74E331BDD5E6F7935", 16);
        BigInteger cypher = rsa.encrypt(text);
        BigInteger plainTextAfterDecryption = rsa.decrypt(cypher);
        assertEquals(text, plainTextAfterDecryption);
    }

}
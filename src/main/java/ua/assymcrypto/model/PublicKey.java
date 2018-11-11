package ua.assymcrypto.model;

import java.math.BigInteger;

public class PublicKey {
    private BigInteger n;
    private BigInteger e;

    PublicKey(PublicKey publicKey) {
        this.n = publicKey.getN().add(BigInteger.ZERO);
        this.e = publicKey.getE().add(BigInteger.ZERO);
    }

    public PublicKey(BigInteger n, BigInteger e) {
        this.n = n.add(BigInteger.ZERO);
        this.e = e.add(BigInteger.ZERO);
    }

    public BigInteger getN() {
        return n;
    }

    public BigInteger getE() {
        return e;
    }

    @Override
    public String toString() {
        return "n = " + n.toString(16) + '\n' +
                "e = " + e.toString(16) + '\n';
    }
}

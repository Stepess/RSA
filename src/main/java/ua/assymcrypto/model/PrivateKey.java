package ua.assymcrypto.model;

import java.math.BigInteger;

public class PrivateKey {
    private BigInteger p;
    private BigInteger q;
    private BigInteger d;

    PrivateKey(PrivateKey privateKey) {
        this.p = privateKey.getP().add(BigInteger.ZERO);
        this.q = privateKey.getQ().add(BigInteger.ZERO);
        this.d = privateKey.getD().add(BigInteger.ZERO);
    }

    public PrivateKey(BigInteger p, BigInteger q, BigInteger d) {
        this.p = p.add(BigInteger.ZERO);
        this.q = q.add(BigInteger.ZERO);
        this.d = d.add(BigInteger.ZERO);
    }

    public BigInteger getP() {
        return p;
    }

    public BigInteger getQ() {
        return q;
    }

    public BigInteger getD() {
        return d;
    }

    @Override
    public String toString() {
        return "p = " + p.toString(16) + '\n' +
                "q = " + q.toString(16) + '\n' +
                "d = " + d.toString(16) + '\n';
    }
}



package ua.assymcrypto.model;

public class RSAKey {
    private PrivateKey privateKey;
    private PublicKey publicKey;

    public RSAKey(PrivateKey privateKey, PublicKey publicKey) {
        this.privateKey = new PrivateKey(privateKey);
        this.publicKey = new PublicKey(publicKey);
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    @Override
    public String toString() {
        return "RSAKey{" + '\n' +
                "privateKey: " + '\n' + privateKey +
                "publicKey: " + '\n' + publicKey +
                '}';
    }
}

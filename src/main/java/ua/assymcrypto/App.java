package ua.assymcrypto;

import ua.assymcrypto.model.*;

import java.math.BigInteger;

public class App {
    public static void main(String[] args) {
        final BigInteger p = new BigInteger("35ac37ba4f90d5d16ca42319b9064ffe938aabb05ef01c2e8e6392644150faf693", 16);
        final BigInteger q = new BigInteger("4220ce32003e89b430603190df6cab1049716d89e275263d55afe8437c71eb0393", 16);
        final BigInteger d = new BigInteger("9d690870f2ff6fbfc24f3158f2cde6b81fc19180a1789cde1fc59133d9df124f6bb8b2440e8075a60c2741526f816e36101f4f4a90edf839b529e83caa671365de5", 16);
        final BigInteger n = new BigInteger("ddd4720105534393eb5cbf8b95ed6f6c27b5b6e0235e9cd308f18e2869393925e2c57312e1165f29f13da742334e7c46c29000848ae50fcec329b405adfacf04f69", 16);
        final BigInteger e = new BigInteger("10001", 16);

        RSAKey rsaKey = new RSAKey(new PrivateKey(p, q, d), new PublicKey(n, e));

        RSA rsa = new RSA();
        BigInteger text = new BigInteger("123456789ABCDEF", 16);

        System.out.println(rsaKey);
        rsa.setKey(rsaKey);

        System.out.println("-----------ENCRYPT----------");
        System.out.println("Plain text = " + text.toString(16));
        BigInteger cryptogram = rsa.encrypt(text);
        System.out.println("Cryptogram = " + cryptogram.toString(16));

        System.out.println("-----------FROM SITE------------");
        BigInteger cryptogramFromSite = new BigInteger("DE13D0135999C41261B857E400AEFD9F5DC11F59854261854E31BB09B45A4125213579E127F23D550529C5D00CA441194E3DBD801A5BF9B79734629B4B1792677B", 16);
        System.out.println("Number from site = " + cryptogramFromSite.toString(16));
        System.out.println("Decrypted = " + rsa.decrypt(cryptogramFromSite).toString(16));

        System.out.println("-----------SIGNATURE------------");
        BigInteger signature = rsa.sign(text);
        System.out.println("Signature = " + signature.toString(16));

        System.out.println("-----------VERIFYING------------");
        System.out.println(rsa.verify(text, signature));

        System.out.println("-----------SEND KEY-------------");

        BigInteger message = new BigInteger("0123456789abcdef", 16);
        BigInteger serverPublicKeyN = new BigInteger("CC082D191438C81210162EFFD542E68F37D2EE3F57B5EF8615D5976F6F80A80CFAE3BFF470033AAF96C11628D45C106B291BE4DD4E5302059BB0AC166890CBFA5B8BCFC6ADDDAA3C82D9F1B0889375CD1900F7CDC8B87815058F57C84A8B8588CD9C0EEB484A9374F3B6E2931578FA5F8E5B6766EB19D6AD979598C142815351", 16);
        BigInteger serverPublicKeyE = new BigInteger("10001", 16);
        SignedMessage sM = rsa.sendKey(message, serverPublicKeyE, serverPublicKeyN);

        System.out.println(sM);

        System.out.println("-----------RECEIVE KEY----------");//done
        BigInteger sentKey = new BigInteger("0B17BBE1FCF7DF3262E967C4D2D7F5E20E201A9315C698C36D7BD076DBE67AEDAFE951BD02349AE1B7BD500AD9C7A38710E6169F216279174ECDB2D69971705BBCD8", 16);
        BigInteger keySignature = new BigInteger("08E22B21A6C88969EED5C2C6110A8F8BD581F055F7A0FEDAD109FB170FD199276BC6BCB794CF725B72985B961F00D621C3F7AC7F9348C1FDD836283A5FA90258F9", 16);

        BigInteger serverN = new BigInteger("8D7AAD010F9655E37050FA919F97FC43DB60CDAC51E5ACD4920DFFF33BEE2D5D4571F2AD5E0157DFE889F79031D59E91C18EEC6FF4FB5866357B28341480FD5B", 16);
        BigInteger serverE = new BigInteger("10001", 16);

        SignedMessage signedMessage = new SignedMessage(sentKey, keySignature);
        BigInteger key = rsa.receiveKey(signedMessage, serverE, serverN);
        System.out.println(key.toString(16));
    }
}

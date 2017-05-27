package com.luoding.encryption;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Security;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.util.Arrays;

/**
 * author: ding.luo
 * 椭圆曲线加密的一个测试例子
 * time: 17-3-30 上午11:35
 */
public class EncryptionTest {

    static {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    }

    public static void main(String[] args) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC",
                "BC");
        keyPairGenerator.initialize(256, new SecureRandom());

        KeyPair kp = keyPairGenerator.generateKeyPair();

        ECPublicKey publicKey = (ECPublicKey) kp.getPublic();
        ECPrivateKey privateKey = (ECPrivateKey) kp.getPrivate();

        System.out.println(kp.getPrivate());
        System.out.println(kp.getPublic());

        Cipher encrypter = Cipher.getInstance("ECIES", "BC");
        Cipher decrypter = Cipher.getInstance("ECIES", "BC");
        encrypter.init(Cipher.ENCRYPT_MODE, publicKey);
        decrypter.init(Cipher.DECRYPT_MODE, privateKey);

        String text = "";
        for (int i = 0; i < 1; i++) {
            text += "This is a test!@#$This is a test!@#$This is a test!@#This is a test!@#$This is a test!@#$This is a test!@#This is a test!@#$This is a test!@#$This is a test!@#";
        }
        byte[] e = encrypter.doFinal(text.getBytes("UTF-8"));

        System.out.println("Encrypted: " + Arrays.toString(e));

        System.out.println("Encrypted, length = " + e.length);

        byte[] de = decrypter.doFinal(e);
        String result = new String(de, "UTF-8");

        System.out.println("Decrypted :" + result);
        if (result.equals(text)) {
            System.out.println("OK!");
        }

        String str = "luoding CardNo";
        System.out.println(Integer.parseInt(str));
    }
}

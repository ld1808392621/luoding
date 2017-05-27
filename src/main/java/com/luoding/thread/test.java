package com.luoding.thread;


import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * author: ding.luo
 * time: 17-3-6 上午11:19
 */
public class test {

    static {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    }

    public static void main(String [] args) throws InterruptedException {

        AtomicInteger integer;
        Integer i1;

        ConcurrentHashMap map ;

        int h = 2147483647/2;
        int HASH_BITS = 0x7fffffff;
         h = (h ^ (h >>> 16)) & HASH_BITS;

        System.out.println(h);

        System.out.println((h ^ (h >>> 16)));

        TransferQueue transferQueue;

        try {
            test1();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }


    }

    public static void test1() throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException {

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
        for (int i = 0; i < 2; i++) {
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
    }
}

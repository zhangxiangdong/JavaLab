package me.zhang.encryption;

import org.junit.Test;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Demo {

    @Test
    public void testRsa() throws Exception {
        String value = "this is our secret";

        // 加密算法
        String algorithm = "RSA";
        // 转换模式
        String transform = "RSA/ECB/PKCS1Padding";

        // 实例化秘钥对生成器
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        // 初始化，秘钥长度512~16384位，64倍数
        keyPairGenerator.initialize(512);
        // 生成秘钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // 公钥
        PublicKey publicKey = keyPair.getPublic();
        System.out.println("RSA公钥: " + Base64.getEncoder().encodeToString(publicKey.getEncoded()));
        // 私钥
        PrivateKey privateKey = keyPair.getPrivate();
        System.out.println("RSA私钥: " + Base64.getEncoder().encodeToString(privateKey.getEncoded()));

        // ------ 测试公钥加密，私钥解密 ------
        Cipher cipher = Cipher.getInstance(transform);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] pubEncryptBytes = cipher.doFinal(value.getBytes());
        System.out.println("RSA公钥加密后数据: " + Base64.getEncoder().encodeToString(pubEncryptBytes));

        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] priDecryptBytes = cipher.doFinal(pubEncryptBytes);
        System.out.println("RSA私钥解密后数据: " + new String(priDecryptBytes));

        // ------ 测试私钥加密，公钥解密 ------
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] priEncryptBytes = cipher.doFinal(value.getBytes());
        System.out.println("RSA私钥加密后数据: " + Base64.getEncoder().encodeToString(priEncryptBytes));

        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] pubDecryptBytes = cipher.doFinal(priEncryptBytes);
        System.out.println("RSA公钥解密后数据: " + new String(pubDecryptBytes));
    }

    @Test
    public void testRsaKey() throws Exception {
        String value = "this is our star";

        // 加密算法
        String algorithm = "RSA";
        // 转换模式
        String transform = "RSA/ECB/PKCS1Padding";

        // RSA公钥BASE64字符串
        String rsaPublicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAK3fM8GDJDGun3P1fSh1NTXACMrGc0HJKuZ86/W9ipsvMD8f2iqngZtiedCEs6sPtD4cR/wjqBGNC0gMJjdIsDUCAwEAAQ==";
        // RSA私钥BASE64字符串
        String rsaPrivateKey = "MIIBVgIBADANBgkqhkiG9w0BAQEFAASCAUAwggE8AgEAAkEArd8zwYMkMa6fc/V9KHU1NcAIysZzQckq5nzr9b2Kmy8wPx/aKqeBm2J50ISzqw+0PhxH/COoEY0LSAwmN0iwNQIDAQABAkEArYeWoAvCk9M0UQcxYq+X6409OSPW5FFh/6et2BTTwQwq1AvT8o8WcY4/7no58duk9n2jEDzD6aSGUuMxN3JwAQIhAP8yH/5Vi4jjCG4szRuR6FbMjv/BL5ODyk8DfGPw7iadAiEArmt4cCDe0SPrIrKE1kwrSJT8ZjwU0MV2JgIE+Mb3MHkCIBwUPNb0PK0sJeJRhaPx8vmR+m4DqKN3jcwR2x74BIw1AiEAo8DAhT1HFEFNq/jAoFVIuc8unGlB/bO1tf9lXY+nWbkCIQCPrHfWbJApQYiSMzxfuQ0e0kNTcBUgexF4w7qENzhAcw==";

        // ------- 还原公钥 --------
        byte[] publicKeyBytes = Base64.getDecoder().decode(rsaPublicKey);
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);

        // ------- 还原私钥 --------
        byte[] privateKeyBytes = Base64.getDecoder().decode(rsaPrivateKey);
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);

        // ------- 测试加解密 --------
        Cipher cipher = Cipher.getInstance(transform);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] pubEncryptBytes = cipher.doFinal(value.getBytes());
        System.out.println("RSA公钥加密数据: " + Base64.getEncoder().encodeToString(pubEncryptBytes));

        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] priDecryptBytes = cipher.doFinal(pubEncryptBytes);
        System.out.println("RSA私钥解密数据: " + new String(priDecryptBytes));
    }

    @Test
    public void testLargeContent() throws Exception {
        StringBuilder value = new StringBuilder();
        for (int i = 0; i <= 29; i++) {
            value.append("18cm");
        }
        System.out.println("待加密内容长度: " + value.toString().length());

        // 加密算法
        String algorithm = "RSA";
        // 转换模式
        String transform = "RSA/ECB/PKCS1Padding";

        // 实例化秘钥对生成器
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        // 初始化，秘钥长度512~16384位，64倍数
        keyPairGenerator.initialize(1024);
        // 生成秘钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        // 公钥
        PublicKey publicKey = keyPair.getPublic();
        System.out.println("RSA公钥: " + Base64.getEncoder().encodeToString(publicKey.getEncoded()));

        // 私钥
        PrivateKey privateKey = keyPair.getPrivate();
        System.out.println("RSA私钥: " + Base64.getEncoder().encodeToString(privateKey.getEncoded()));

        // ------ 测试公钥加密，私钥解密 ------
        Cipher cipher = Cipher.getInstance(transform);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] pubEncryptBytes = cipher.doFinal(value.toString().getBytes());
        System.out.println("RSA公钥加密后数据: " + Base64.getEncoder().encodeToString(pubEncryptBytes));

        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] priDecryptBytes = cipher.doFinal(pubEncryptBytes);
        System.out.println("RSA私钥解密后数据: " + new String(priDecryptBytes));

        // ------ 测试私钥加密，公钥解密 ------
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] priEncryptBytes = cipher.doFinal(value.toString().getBytes());
        System.out.println("RSA私钥加密后数据: " + Base64.getEncoder().encodeToString(priEncryptBytes));

        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] pubDecryptBytes = cipher.doFinal(priEncryptBytes);
        System.out.println("RSA公钥解密后数据: " + new String(pubDecryptBytes));
    }

    @Test
    public void testLargeContent2() throws Exception {
        StringBuilder value = new StringBuilder();
        for (int i = 0; i <= 29; i++) {
            value.append("18cm");
        }
        System.out.println("待加密内容长度: " + value.toString().length());

        // 加密算法
        String algorithm = "RSA";

        // 实例化秘钥对生成器
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        // 初始化，秘钥长度512~16384位，64倍数
        keyPairGenerator.initialize(1024);
        // 生成秘钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // 公钥
        PublicKey publicKey = keyPair.getPublic();
        System.out.println("RSA公钥: " + Base64.getEncoder().encodeToString(publicKey.getEncoded()));
        // 私钥
        PrivateKey privateKey = keyPair.getPrivate();
        System.out.println("RSA私钥: " + Base64.getEncoder().encodeToString(privateKey.getEncoded()));

        // ------ 测试公钥加密，私钥解密 ------
        String pubEncrypt= RsaUtil.encrypt(publicKey, value.toString());
        System.out.println("RSA公钥加密后数据: " + pubEncrypt);

        String priDecrypt = RsaUtil.decrypt(privateKey, pubEncrypt);
        System.out.println("RSA私钥解密后数据: " + priDecrypt);

    }

}

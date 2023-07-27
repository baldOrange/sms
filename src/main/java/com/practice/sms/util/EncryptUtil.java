package com.practice.sms.util;

import java.security.*;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 *
 * @author zyd on 2023/5/2 1:10
 */
public class EncryptUtil {
    public static PublicKey generatePublicKey(String modulus, String exponent) throws Exception {
        // 将模数和指数转换为大整数类型
        java.math.BigInteger modulusBigInt = new java.math.BigInteger(modulus);
        java.math.BigInteger exponentBigInt = new java.math.BigInteger(exponent);

        // 创建RSAPublicKeySpec对象
        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(modulusBigInt, exponentBigInt);

        // 使用KeyFactory根据KeySpec生成公钥对象
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);

        return publicKey;
    }


    public static String convertToPEMFormat(PublicKey publicKey) throws Exception {
        // 获取公钥的字节数组
        byte[] publicKeyBytes = publicKey.getEncoded();

        // 创建X509EncodedKeySpec对象
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);

        // 使用KeyFactory根据KeySpec重新生成公钥对象
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey regeneratedPublicKey = keyFactory.generatePublic(keySpec);

        // 将公钥对象按照PEM格式进行编码
        String pemFormat = "-----BEGIN PUBLIC KEY-----\n" +
                Base64.getMimeEncoder().encodeToString(regeneratedPublicKey.getEncoded()) +
                "\n-----END PUBLIC KEY-----";

        return pemFormat;
    }


    public static void main(String[] args) throws Exception {
        String modulus = "21814724247134019819290151925150349759105459638148080264056476103178184236150489301657629130361803574053057107138561114979524615846981130603010621278717333618288918198749949321383413093967964664412959314064132166641055562969665011510666085259379470930194406254063299342715637045320697495312206199976510422941900028404168320961151634495239065845108439090027343060910730176443508119882879561706200155011387224601299037771426667935060871309282723956526708793611784523476879169398149573677108372425587393734704921736084846938340322859518646865764448076417866225469906766995366078525200957582746310955780408129587374991319";
        String exponent = "65537";

        PublicKey publicKey = generatePublicKey(modulus, exponent);
        String pemFormat = convertToPEMFormat(publicKey);
        System.out.println(pemFormat);
    }

}
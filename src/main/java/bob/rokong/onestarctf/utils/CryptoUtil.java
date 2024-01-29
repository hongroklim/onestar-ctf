package bob.rokong.onestarctf.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import jakarta.annotation.Nullable;

@Component
public class CryptoUtil {
    private static final Logger log = LoggerFactory.getLogger(CryptoUtil.class);

    private static final String HASH_ALGORITHM = "SHA-256";
    private static final String ENC_ALGORITHM = "AES/CBC/PKCS5Padding";

    @Value("${ctf.aesKey}")
    public String KEY = "AAAAAAAAAAAAAKEYAAAAAAAAAAAAAAAA";
    private String IV = KEY.substring(0, 16);

    @Nullable
    public synchronized String sha256(String input) {
        if (input == null || "".equals(input)) return null;
        try {
            // Get message digest
            MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
            // Digest
            md.update(input.getBytes());
            byte[] bytes = md.digest();

            // To String
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            log.error("sha256.fail", e);
            return null;
        }
    }

    @Nullable
    public String encrypt(String value) {
        if (value == null || "".equals(value)) return null;
        try {
            Cipher cipher = Cipher.getInstance(ENC_ALGORITHM);
            SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(), "AES");
            IvParameterSpec ivParamSpec = new IvParameterSpec(IV.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec);

            byte[] encrypted = cipher.doFinal(value.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            log.error("aes.enc.fail", e);
            return null;
        }
    }

    @Nullable
    public String decrypt(String encryptedValue) {
        if (encryptedValue == null || "".equals(encryptedValue)) return null;
        try {
            Cipher cipher = Cipher.getInstance(ENC_ALGORITHM);
            SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(), "AES");
            IvParameterSpec ivParamSpec = new IvParameterSpec(IV.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParamSpec);

            byte[] decodedBytes = Base64.getDecoder().decode(encryptedValue);
            byte[] decrypted = cipher.doFinal(decodedBytes);
            return new String(decrypted, StandardCharsets.UTF_8);
        } catch (Exception e) {
            log.error("aes.dec.fail", e);
            return null;
        }
    }
}

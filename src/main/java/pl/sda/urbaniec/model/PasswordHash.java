package pl.sda.urbaniec.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHash {
    static String generateHash(final String passwordToHash) {
        String generatedPassword = null;
        try {
            final MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passwordToHash.getBytes());
            final byte[] bytes = md.digest();
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (final NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
}

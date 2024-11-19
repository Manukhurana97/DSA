# DSA



## Material

Recursion: https://youtu.be/Mr9MVpSoTGk, https://www.youtube.com/playlist?list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9
1. **Arrays**: https://www.youtube.com/playlist?list=PLUcsbZa0qzu3yNzzAxgvSgRobdUUJvz7p
2. **String**  : 
3. **Stack**: Aditya verma : https://www.youtube.com/c/AdityaVermaTheProgrammingLord/playlists (playlist)
4. **Binary Search**: Aditya verma: https://www.youtube.com/c/AdityaVermaTheProgrammingLord/playlists (playlist)
5. **Heap**: Aditya verma : https://www.youtube.com/c/AdityaVermaTheProgrammingLord/playlists (playlist)
6. **Hashmap**: Anuj Bhaiya : https://www.youtube.com/results?search_query=anuj+bhaiya++hashing
7. **Graph**: Take u forward (playlist)
8. **Tree**:  Take u forward (Playlist)
9. **DP**: Aditya verma : https://www.youtube.com/watch?v=nqowUJzG-iM&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&ab_channel=AdityaVerma  (playlist)
10. **ALGO Refrence**: https://www.youtube.com/watch?v=0IAPZzGSbME&list=PLDN4rrl48XKpZkf03iYFl-O29szjTrs_O&ab_channel=AbdulBari
11. **Binary Search**: https://www.youtube.com/watch?v=GU7DpgHINWQ



## Practice


Practice channel: https://www.youtube.com/c/NeetCode/playlists
DP Practice:
- Top 20 Questions: https://www.geeksforgeeks.org/top-20-dynamic-programming-interview-questions/
- Practice Qns on Dp section-wise on leetcode:  https://leetcode.com/discuss/general-discussion/662866/DP-for-Beginners-Problems-or-Patterns-or-Sample-Solutions,                                                         https://leetcode.com/discuss/general-discussion/1050391/must-do-dynamic-programming-problems-category-wise
  https://leetcode.com/discuss/general-discussion/458695/Dynamic-Programming-Patterns


**Further**: https://docs.google.com/document/d/1TK2_ij3oBDy_cqRuXVf3EEWBrLCmoQ7vRiW_zwKrX4A/edit

Help: https://algo.monster/flowchart



```

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EmailEncryptionUtility {

    private static final String ENCRYPTION_ALGORITHM = "AES";
    private static final String HMAC_ALGORITHM = "HmacSHA256";

    // Encrypt the email with HMAC for tamper-proofing
    public static String encrypt(String email, SecretKey encryptionKey, SecretKey hmacKey) throws Exception {
        // Encrypt the email
        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, encryptionKey);
        byte[] encryptedBytes = cipher.doFinal(email.getBytes());

        // Compute HMAC for the encrypted data
        Mac mac = Mac.getInstance(HMAC_ALGORITHM);
        mac.init(hmacKey);
        byte[] hmac = mac.doFinal(encryptedBytes);

        // Combine encrypted data and HMAC, then Base64 encode
        byte[] combined = new byte[encryptedBytes.length + hmac.length];
        System.arraycopy(encryptedBytes, 0, combined, 0, encryptedBytes.length);
        System.arraycopy(hmac, 0, combined, encryptedBytes.length, hmac.length);

        return Base64.getEncoder().encodeToString(combined);
    }

    // Decrypt the email and verify HMAC
    public static String decrypt(String input, SecretKey encryptionKey, SecretKey hmacKey) throws Exception {
        // Decode Base64
        byte[] combined = Base64.getDecoder().decode(input);

        // Separate encrypted data and HMAC
        int hmacLength = Mac.getInstance(HMAC_ALGORITHM).getMacLength();
        int encryptedLength = combined.length - hmacLength;

        byte[] encryptedBytes = new byte[encryptedLength];
        byte[] receivedHmac = new byte[hmacLength];

        System.arraycopy(combined, 0, encryptedBytes, 0, encryptedLength);
        System.arraycopy(combined, encryptedLength, receivedHmac, 0, hmacLength);

        // Verify HMAC
        Mac mac = Mac.getInstance(HMAC_ALGORITHM);
        mac.init(hmacKey);
        byte[] calculatedHmac = mac.doFinal(encryptedBytes);

        if (!MessageDigest.isEqual(receivedHmac, calculatedHmac)) {
            throw new SecurityException("Tampered or corrupted encrypted email detected!");
        }

        // Decrypt the email
        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, encryptionKey);
        return new String(cipher.doFinal(encryptedBytes));
    }

    // Generate a key (for demonstration; in production, store keys securely)
    public static SecretKey generateKey(String algorithm, int keySize) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(algorithm);
        keyGen.init(keySize);
        return keyGen.generateKey();
    }

    public static void main(String[] args) {
        try {
            // Generate encryption and HMAC keys
            SecretKey encryptionKey = generateKey(ENCRYPTION_ALGORITHM, 256);
            SecretKey hmacKey = generateKey(HMAC_ALGORITHM, 256);

            String email = "user@example.com";
            System.out.println("Original Email: " + email);

            // Encrypt the email
            String encryptedEmail = encrypt(email, encryptionKey, hmacKey);
            System.out.println("Encrypted Email: " + encryptedEmail);

            // Decrypt the email (valid case)
            String decryptedEmail = decrypt(encryptedEmail, encryptionKey, hmacKey);
            System.out.println("Decrypted Email: " + decryptedEmail);

            // Simulate tampering
            String tamperedEmail = encryptedEmail.substring(0, encryptedEmail.length() - 1) + "X";
            try {
                decrypt(tamperedEmail, encryptionKey, hmacKey);
            } catch (SecurityException e) {
                System.err.println("Error: " + e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


```


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



``
        
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.KeySpec;
import java.util.Base64;

public class EmailEncryptionUtility {

    private static final String ENCRYPTION_ALGORITHM = "AES";
    private static final String HMAC_ALGORITHM = "HmacSHA256";
    private static final String KDF_ALGORITHM = "PBKDF2WithHmacSHA256";

    private static final String MASTER_SECRET = "SuperSecureMasterSecret"; // Never expose this!
    private static final byte[] SALT = "UniqueSaltValue".getBytes(); // Ensure this is unique but consistent

    // Derive a key using PBKDF2
    private static SecretKey deriveKey(String input, int keyLength, String purpose) throws Exception {
        String combinedInput = input + "|" + purpose; // Use input and purpose to create unique keys
        KeySpec spec = new PBEKeySpec(MASTER_SECRET.toCharArray(), SALT, 10000, keyLength);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(KDF_ALGORITHM);
        byte[] keyBytes = factory.generateSecret(spec).getEncoded();
        return new SecretKeySpec(keyBytes, ENCRYPTION_ALGORITHM);
    }

    // Encrypt the email
    public static String encrypt(String email, String uniqueIdentifier) throws Exception {
        SecretKey encryptionKey = deriveKey(uniqueIdentifier, 256, "ENCRYPTION");
        SecretKey hmacKey = deriveKey(uniqueIdentifier, 256, "HMAC");

        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, encryptionKey);
        byte[] encryptedBytes = cipher.doFinal(email.getBytes());

        Mac mac = Mac.getInstance(HMAC_ALGORITHM);
        mac.init(hmacKey);
        byte[] hmac = mac.doFinal(encryptedBytes);

        byte[] combined = new byte[encryptedBytes.length + hmac.length];
        System.arraycopy(encryptedBytes, 0, combined, 0, encryptedBytes.length);
        System.arraycopy(hmac, 0, combined, encryptedBytes.length, hmac.length);

        return Base64.getEncoder().encodeToString(combined);
    }

    // Decrypt the email
    public static String decrypt(String input, String uniqueIdentifier) throws Exception {
        SecretKey encryptionKey = deriveKey(uniqueIdentifier, 256, "ENCRYPTION");
        SecretKey hmacKey = deriveKey(uniqueIdentifier, 256, "HMAC");

        byte[] combined = Base64.getDecoder().decode(input);
        int hmacLength = Mac.getInstance(HMAC_ALGORITHM).getMacLength();
        int encryptedLength = combined.length - hmacLength;

        byte[] encryptedBytes = new byte[encryptedLength];
        byte[] receivedHmac = new byte[hmacLength];

        System.arraycopy(combined, 0, encryptedBytes, 0, encryptedLength);
        System.arraycopy(combined, encryptedLength, receivedHmac, 0, hmacLength);

        Mac mac = Mac.getInstance(HMAC_ALGORITHM);
        mac.init(hmacKey);
        byte[] calculatedHmac = mac.doFinal(encryptedBytes);

        if (!MessageDigest.isEqual(receivedHmac, calculatedHmac)) {
            throw new SecurityException("Tampered or corrupted encrypted email detected!");
        }

        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, encryptionKey);
        return new String(cipher.doFinal(encryptedBytes));
    }

    public static void main(String[] args) {
        try {
            String email = "user@example.com";
            String uniqueIdentifier = "user123"; // Can be user ID, email, etc.

            String encryptedEmail = encrypt(email, uniqueIdentifier);
            System.out.println("Encrypted Email: " + encryptedEmail);

            String decryptedEmail = decrypt(encryptedEmail, uniqueIdentifier);
            System.out.println("Decrypted Email: " + decryptedEmail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
    


```


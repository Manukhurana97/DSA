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
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EmailEncryptionUtility {

    private static final String ALGORITHM = "AES";

    // Encrypt the email
    public static String encrypt(String email, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(email.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Decrypt the email
    public static String decrypt(String input, SecretKey key) throws Exception {
        if (isEncrypted(input)) {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decodedBytes = Base64.getDecoder().decode(input);
            return new String(cipher.doFinal(decodedBytes));
        }
        return input; // Return input as is if not encrypted
    }

    // Check if the email is encrypted
    public static boolean isEncrypted(String input) {
        try {
            // Try decoding base64; if it fails, it is not encrypted
            Base64.getDecoder().decode(input);
            return true;
        } catch (IllegalArgumentException e) {
            return false; // Not a valid base64-encoded string
        }
    }

    // Generate a key (for demonstration; in production, use a securely stored key)
    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(256); // AES-256
        return keyGen.generateKey();
    }

    public static void main(String[] args) {
        try {
            SecretKey key = generateKey();

            String email = "user@example.com";
            System.out.println("Original Email: " + email);

            // Encrypt the email
            String encryptedEmail = encrypt(email, key);
            System.out.println("Encrypted Email: " + encryptedEmail);

            // Decrypt the email
            String decryptedEmail = decrypt(encryptedEmail, key);
            System.out.println("Decrypted Email: " + decryptedEmail);

            // Handle non-encrypted email
            String plainEmail = "anotheruser@example.com";
            String result = decrypt(plainEmail, key);
            System.out.println("Result for Non-Encrypted Email: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```


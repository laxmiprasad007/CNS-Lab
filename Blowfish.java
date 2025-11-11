import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;
import java.io.*;

public class BlowFishSimple {
    public static void main(String[] args) throws Exception {
        String key = "MySecretKey";
        SecretKeySpec sk = new SecretKeySpec(key.getBytes("UTF8"), "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter text: ");
        String input = br.readLine();

        cipher.init(Cipher.ENCRYPT_MODE, sk);
        byte[] encrypted = cipher.doFinal(input.getBytes("UTF8"));
        String enc = Base64.getEncoder().encodeToString(encrypted);

        cipher.init(Cipher.DECRYPT_MODE, sk);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(enc));
        String dec = new String(decrypted);

        System.out.println("\nEncrypted: " + enc);
        System.out.println("Decrypted: " + dec);
    }
}

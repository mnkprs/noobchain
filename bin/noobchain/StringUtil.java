//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package noobchain;

import com.google.gson.GsonBuilder;
import java.security.MessageDigest;

public class StringUtil {
    public StringUtil() {
    }

    public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for(int i = 0; i < hash.length; ++i) {
                String hex = Integer.toHexString(255 & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }

                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception var6) {
            throw new RuntimeException(var6);
        }
    }

    public static String getJson(Object o) {
        return (new GsonBuilder()).setPrettyPrinting().create().toJson(o);
    }

    public static String getDificultyString(int difficulty) {
        return (new String(new char[difficulty])).replace('\u0000', '0');
    }
}

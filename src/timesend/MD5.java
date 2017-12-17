package timesend;
import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5 {
  public static String buildSecret(String s){
    String filler = "md5_secret_";
    s = filler + s + Math.random();
    try{
       MessageDigest m=MessageDigest.getInstance("MD5");
       m.update(s.getBytes(),0,s.length());
       return new BigInteger(1,m.digest()).toString(16);
    }catch(Exception e){
       return s;
    }
  }
}

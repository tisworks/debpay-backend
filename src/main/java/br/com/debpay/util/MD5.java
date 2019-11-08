package br.com.debpay.util;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;

public class MD5 {
  public static String hash(String input, String salt) {
    try {
      var str = input + salt;
      var md = MessageDigest.getInstance("MD5");
      md.update(str.getBytes());
      return DatatypeConverter.printHexBinary(md.digest()).toUpperCase();
    } catch (Exception e) {
      // Only chance of error is if the Hash algorithm is changed for something invalid,
      // so we just consider that this won't happen. I hope.
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(1);
    }
    return "";
  }
}

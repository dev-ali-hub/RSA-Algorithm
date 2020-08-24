import java.math.BigInteger;
import java.security.SecureRandom;
public class EncryptDecrypt {
  private BigInteger n, d, e;
  private int bitlen = 1024;
  public EncryptDecrypt(BigInteger newn, BigInteger newe) {
    n = newn;
    e = newe;
  }
  public EncryptDecrypt(int bits) {
    bitlen = bits;
    SecureRandom r = new SecureRandom();
    BigInteger p = new BigInteger(bitlen / 2, 100, r);
    BigInteger q = new BigInteger(bitlen / 2, 100, r);
    n = p.multiply(q);
    BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q
        .subtract(BigInteger.ONE));
    e = new BigInteger("3");
    while (m.gcd(e).intValue() > 1) {
      e = e.add(new BigInteger("2"));}
    d = e.modInverse(m);
  }
  public synchronized String encrypt(String message) {
    return (new BigInteger(message.getBytes())).modPow(e, n).toString();
  }
  public synchronized BigInteger encrypt(BigInteger message) {
    return message.modPow(e, n);
  }
  public synchronized String decrypt(String message) {
    return new String((new BigInteger(message)).modPow(d, n).toByteArray());
  }
  public synchronized BigInteger decrypt(BigInteger message) {
    return message.modPow(d, n);
  }
}


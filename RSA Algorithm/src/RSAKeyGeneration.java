import java.math.BigInteger ;
import java.util.Random ;
public class RSAKeyGeneration
{
int primeSize ;
BigInteger p, q ;
BigInteger N ;
BigInteger r ;
BigInteger E, D ;
String nt,dt,et;
public RSAKeyGeneration( int primeSize )
{
this.primeSize = primeSize ;
generatePrimeNumbers() ;
generatePublicPrivateKeys() ;
}
public void generatePrimeNumbers()
{
p = new BigInteger( primeSize, 10, new Random() ) ;
do
{
q = new BigInteger( primeSize, 10, new Random() ) ;
}
while( q.compareTo( p ) == 0 ) ;
}
public void generatePublicPrivateKeys()
{
N = p.multiply( q ) ;
r = p.subtract( BigInteger.valueOf( 1 ) ) ;
r = r.multiply( q.subtract( BigInteger.valueOf( 1 ) ) ) ; 
do
{
E = new BigInteger( 2 * primeSize, new Random() ) ;
}
while( ( E.compareTo( r ) != -1 ) || ( E.gcd( r ).compareTo( BigInteger.valueOf( 1 ) ) != 0 ) ) ;
D = E.modInverse( r ) ;

}
public BigInteger getp()
{
return( p ) ;
}
public BigInteger getq()
{
return( q ) ;
}
public BigInteger getr()
{
return( r ) ;
}
public BigInteger getN()
{
return( N ) ;
}
public BigInteger getE()
{
return( E ) ;
}
public BigInteger getD()
{
return( D ) ;
}
}
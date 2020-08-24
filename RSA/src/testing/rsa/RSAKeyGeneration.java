/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testing.rsa;

import java.math.BigInteger ;
import java.util.Random ;
import java.io.* ;
import java.io.*;
import java.util.*;
import java.sql.*;

public class RSAKeyGeneration
{
/**
* Bit length of each prime number.
*/
int primeSize ;

/**
* Two distinct large prime numbers p and q.
*/
BigInteger p, q ;
BigInteger N ;
BigInteger r ;
BigInteger E, D ;

String nt,dt,et;
public RSAKeyGeneration( int primeSize )
{

this.primeSize = primeSize ;

// Generate two distinct large prime numbers p and q.
generatePrimeNumbers() ;

// Generate Public and Private Keys.
generatePublicPrivateKeys() ;

}

/**
* Generate two distinct large prime numbers p and q.
*/
public void generatePrimeNumbers()
{
p = new BigInteger( primeSize, 10, new Random() ) ;

do
{
q = new BigInteger( primeSize, 10, new Random() ) ;
}
while( q.compareTo( p ) == 0 ) ;
}

/**
* Generate Public and Private Keys.
*/
public void generatePublicPrivateKeys()
{
// N = p * q
N = p.multiply( q ) ;

// r = ( p – 1 ) * ( q – 1 )
r = p.subtract( BigInteger.valueOf( 1 ) ) ;
r = r.multiply( q.subtract( BigInteger.valueOf( 1 ) ) ) ; //(p-1)(q-1)

// Choose E, coprime to and less than r
do
{
E = new BigInteger( 2 * primeSize, new Random() ) ;
}
while( ( E.compareTo( r ) != -1 ) || ( E.gcd( r ).compareTo( BigInteger.valueOf( 1 ) ) != 0 ) ) ;

// Compute D, the inverse of E mod r
D = E.modInverse( r ) ;

}

/**
* Get prime number p.
*
* @return Prime number p.
*/
public BigInteger getp()
{
return( p ) ;
}

/**
* Get prime number q.
*
* @return Prime number q.
*/
public BigInteger getq()
{
return( q ) ;
}

/**
* Get r.
*
* @return r.
*/
public BigInteger getr()
{
return( r ) ;
}

/**
* Get modulus N.
*
* @return Modulus N.
*/
public BigInteger getN()
{
return( N ) ;
}

/**
* Get Public exponent E.
*
* @return Public exponent E.
*/
public BigInteger getE()
{
return( E ) ;
}

/**
* Get Private exponent D.
*
* @return Private exponent D.
*/
public BigInteger getD()
{
return( D ) ;
}

/**
* KeyGeneration Main program for Unit Testing.
*/
public static void main( String[] args ) throws IOException
{
RSAKeyGeneration akg = new RSAKeyGeneration(8);
BigInteger publicKeyB = akg.getE();
BigInteger privateKeyB = akg.getD();
BigInteger randomNumberB = akg.getN();
String publicKey = publicKeyB.toString();
String privateKey = privateKeyB.toString();
String randomNumber = randomNumberB.toString();
System.out.println("Public Key (E,N): "+publicKey+","+randomNumber);
System.out.println("Private Key (D,N): "+privateKey+","+randomNumber);

}

}
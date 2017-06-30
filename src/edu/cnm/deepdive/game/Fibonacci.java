/**
 * 
 */
package edu.cnm.deepdive.game;

import java.math.BigInteger;
import java.util.Iterator;

/**
 * Implement a non-recursive {@link java.lang.Iterable} verson of the 
 * Fibonacci sequence.
 * @author Yolanda Philgreen
 *
 */
public class Fibonacci implements Iterable<BigInteger> {

  public static final long LIMIT = 10_000_000_000L;
  
  /**
   * @param args command line arguments (ignored).
   * Tests fibonacci sequence iterable in an enhanced for loop.
   * 
   */
  public static void main(String[] args) {
    BigInteger limit = BigInteger.valueOf(10_000_000_000L);
    Fibonacci fib = new Fibonacci();
    for(BigInteger current : fib) {
       if (current.compareTo(limit) > 0) {
         break;
       }
       System.out.printf("%,d%n",current);
    }
  }

  @Override
  public Iterator<BigInteger> iterator() {
    return new Iter();
    
  }

 private class Iter implements Iterator<BigInteger> {

   
   private BigInteger current = BigInteger.ONE;
   private BigInteger previous = BigInteger.valueOf(-1);
   
   
  @Override
  public boolean hasNext() {
    
    return true;
  }

  @Override
  public BigInteger next() {
    BigInteger next = current.add(previous);
    previous = current;
    current = next;
    return next;
  }
   
 }
  
  
}

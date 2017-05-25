/*
/* Java Programing
/*
*/

import java.util.Scanner;

public class Samples {
  public static void main(String[] args) {    
    System.out.println("Some Java samples");
    // fun with strings and concatenation
    String to_be_displayed = "to"+"be"+"displayed";
    int howmany = 3;
    to_be_displayed = to_be_displayed+" with "+howmany+" cats";
    System.out.println(to_be_displayed);
    
    // fun with arrays
    int[] primes = new int[3];
    int[] primes2 = {2,3,5};
    System.out.println(primes[1]);
    System.out.println(primes2[1]);
    
    // bit shifts
    int origin = 100;
    int doubleorigin;
    int halfdoubleorigin;
    doubleorigin = origin<<1;
    if (doubleorigin == origin*2) {
      System.out.println("bit shift left multiplies by 2");
    }
    halfdoubleorigin = doubleorigin>>1;
    if (halfdoubleorigin == doubleorigin/2) {
      System.out.println("bit shift right divides by 2");
    }
    
    // first while loop
    String loopedon = "How long are we7 going through that? Until we hit 7 at mark 15!";
    int index = 0;
    //note that index will never go out of bound because the first condition is evaluated first and then expression is short circuited
    while ((index < loopedon.length()) && (loopedon.charAt(index) != '7'))
      index++;
    if (index == 15)
      System.out.println("We hit 7 at index 15.");
    
    // classic for loop
    int[] datatosum = {1,4,5,10}; // sum should be 20
    int totalsum = 0;
    for (int i=0; i < datatosum.length; i++)
      totalsum += datatosum[i];
    if (totalsum == 20)
      System.out.println("classic for loop is right");
    
    // java for-each loop
    totalsum = 0;
    for (int val : datatosum)
      totalsum += val;
    if (totalsum == 20)
      System.out.println("foreach for loop is right");
    
    // user inputs inline with control on input
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an integer: ");
    while (!input.hasNextInt()) {
      input.nextLine();
      System.out.print("Invalid Input. Re-enter an integer: ");
    }
    int intInput = input.nextInt(); // protects from type missmatch
    System.out.println("You entered: "+intInput);
    
    // powerfull StringBuilder string operations
    String buildStr = "This !str,ing ha;s se:ver'al n,on a-z char;a,ct.ers.";
    //this should remove all punctuation
    System.out.println(buildStr.replaceAll("[.;:,!']", ""));
  }
}
    
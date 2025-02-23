// Code using Scanner Class , see how scanner class works
import java.util.Scanner; 
class ScannerTest
{ 
     public static void main(String args[]) 
     { 
         Scanner scn = new Scanner(System.in); 
         System.out.println("Enter an integer"); 
         int a = scn.nextInt(); 
         System.out.print("Enter a String"); 
         String b = scn.nextLine();
         System.out.printf("You have entered:- "
                 + a + " " + "and name as " + b); 
        scn.close();
     } 
}
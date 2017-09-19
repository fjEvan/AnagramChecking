// 2017.9.13  Anagram checking  Jiao Feng(Evan) 

import java.util.Scanner;  

public class AnagramChecking
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      
      String s1; 
      String s2; 
      System.out.println("Hello, this is an anagram checking program." +
                         "\nEnter two words and " +
                         "I'll tell you whether they are anagrams." +
                         "\nType \"q\" and \"q\" to quit the program.");
                              
      do    // loop until user types two 'q's
      {   
         System.out.println("\nEnter two words:");
         s1 = input.next();
         s2 = input.next();
         if(s1.length() != s2.length()) // not anagrams if length's not same
            System.out.println("No, they're not anagrams!!");
         else
         {
            if(check(s1, s2) == true) 
               System.out.println("Yes, they're anagrams!");
            else
               System.out.println("No, they're not anagrams!");
         }
      }while(!s1.equals("q"));
      
      System.out.println("Successfully quitted.");
   }
   
   public static boolean check(String a, String b)
   {
      int k = 0;
      for(int i=0; i < a.length(); i++) // checking string a
      {
         boolean found = false;
         for(int j=k; j < b.length(); j++) // traversing letters in string b
         {              
            if(a.charAt(i) == b.charAt(j))   // to find a matching letter
            {
               k++;
               b = swap(b, i, j);  // swap corresponding letter to the same place as in string a
               found = true;      // found a matching letter
               break;            // go checking next letter in string a
            }
         }
         if(found == false)  return false;   // couldn't find a matching letter in string b
      }
      return true;  
   }
   
   // swap specified characters in a string
   public static String swap(String s, int a, int b) 
   {
      int i = a;
      int j = b;
      
      if(a == b)  return s; 
      else if(a >b)  
      {
         i = b;
         j = a;
      } 
      
      String x = s.substring(0,i) + s.charAt(j) +
                 s.substring(i+1,j) + s.charAt(i) + s.substring(j+1);
      
      return x;
   }
}

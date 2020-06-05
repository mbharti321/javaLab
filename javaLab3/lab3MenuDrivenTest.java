
/**
 * LAB EXERCISE – 5/6/2020
 * Write a menu driven program to implement following 
 *   1. Write a method that takes two strings and checks whether 
 *      they are anagrams of each other Two words are anagrams if they 
 *      contain the same letters and the same number of each letter. 
 *      For example, “stop” is an anagram of “pots”.
 *   2. Write a method called “isAbecedarian” that takes a String and 
 *      returns a boolean indicating whether the word is abecedarian. 
 *      A word is said to be “abecedarian” if the letters in the word 
 *      appear in alphabetical order. For example, abdest, agnosy, befist
 *   3. Write a method called “isDoubloon” that takes a string and checks 
 *      whether it is a doubloon. A word is said to be a “doubloon” if 
 *      every letter that appears in the word appears exactly twice. 
 *      For example coco, noon
 * 
 */

import java.util.*;

class MenuDriven{
    Scanner scan = new Scanner(System.in);
    
    public String getString(){
        System.out.print("Enter the string : ");
        String myString = scan.next();
        return myString;
    }
    
    int getChoice(){
        
        System.out.println("\n\n1. Check Anagram");
        System.out.println("2. Check Abecedarian");
        System.out.println("3. Check Doubloon");
        System.out.println("4. Exit.");
        System.out.println("Please enter one of given choice : ");
        return scan.nextInt();
    }
    
    /*
     *  method that takes two strings and checks whether 
     * they are anagrams of each other Two words are anagrams if they 
     * contain the same letters and the same number of each letter. 
     * For example, “stop” is an anagram of “pots”.
     */
    boolean isAnagram(String str1, String str2){
        boolean result = false;
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        if(str1.length() != str2.length()){
            return result;
        }
        
        char[] str1Char = str1.toCharArray();
        char[] str2Char = str2.toCharArray();
        
        Arrays.sort(str1Char);
        Arrays.sort(str2Char);
        
        // str1 = new String(str1Char);
        // str2 = new String(str2Char);
        
        if(Arrays.equals(str1Char, str2Char)){
            result = true;
        }
        return result;
    }
    
    /*
     *  method called “isAbecedarian” that takes a String and 
     *  returns a boolean indicating whether the word is abecedarian. 
     *  A word is said to be “abecedarian” if the letters in the word 
     *  appear in alphabetical order. For example, abdest, agnosy, befist
     */
    boolean isAbecedarian(String str1){
        boolean result = false;
        str1 = str1.toLowerCase();
        
        char[] str1Char = str1.toCharArray();
        char[] tempStr1 = str1.toCharArray();
        
        Arrays.sort(str1Char);
        
        if(Arrays.equals(str1Char, tempStr1)){
            result = true;
        }
        return result;
    }
    
    /*
     *  method called “isDoubloon” that takes a string and checks 
     * whether it is a doubloon. A word is said to be a “doubloon” if 
     * every letter that appears in the word appears exactly twice. 
     * For example coco, noon
     */
    boolean isDoubloon(String str1){
        str1 = str1.toLowerCase();
        if(str1.length() % 2 != 0){
            return false;
        }
        
        char[] str1Char = str1.toCharArray();
        Arrays.sort(str1Char);
        
        for(int i = 0; i < str1.length() - 1; i += 2){
            if(str1Char[i] != str1Char[i + 1]){
                return false;
            }
        }
        return true;
    }
    

    void checkAnagram(){
        String string1 = getString();
        String string2 = getString();
        System.out.println("\nAre \"" + string1 + "\" and \"" + string2 + "\"  anagram ? = " + isAnagram(string1, string2));
    }
    
   
    void checkAbecedarian(){
        String string1 = getString();
        System.out.println("\nIs \"" + string1 + "\" an abecedarian? = " + isAbecedarian(string1));
    }
    
    void checkDoubloon(){
        String string1 = getString();
        System.out.println("\nIs \"" + string1 + "\" a Doubloon? =  " + isDoubloon(string1));
    }
}


public class lab3MenuDrivenTest {
    public static void main(String[] args){
        MenuDriven menuObj = new MenuDriven();
        
        while(true){
            int choice = menuObj.getChoice();
            if(choice <= 0){  
                System.out.println("Invalid negative Input!!!! \n Please input valid choice(1-3)......");
                continue;
            }
            
            switch(choice){
                case 1: menuObj.checkAnagram();
                        break;
                case 2: menuObj.checkAbecedarian();
                        break; 
                case 3: menuObj.checkDoubloon();
                        break;
                case 4: System.exit(0);
                        break;
                default: System.out.println("Invalid Input!!!! \n Please input valid choice(1-3)......");
            }
                        
        }
    }

}

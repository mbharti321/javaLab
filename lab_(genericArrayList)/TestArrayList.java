/**************************************************************************************
Write a class called TestArrayList which will have the following.
 Create an Array list of Strings, write method
    · “Switch” which will switch alternate words in the array list. If the size of the 
         array list is odd leave the last element in it’s original position.
    · “Hide” which will hide the characters of a string whose length is divisible by 2 by “#”
    
Create an array list of integers and write a method “removeunfairnumber” which will remove 
a number if it is less than the number to its left.
*****************************************************************************************/


import java.util.*;
public class TestArrayList{
    static ArrayList<String> Switch(ArrayList<String> words){
        int j;
        for(int i = 0;i<words.size()-1;i+=2){
            j=i+1;
            Collections.swap(words,i,j);
        }
        return words;
    }
    
    static ArrayList<String> Hide(ArrayList<String> words){
        int j;
        for(int i = 0;i<words.size();i++) {
            if(words.get(i).length() % 2 == 0){
                words.set(i,"#");
            }
        }
            return words;
        
    }
    
    static ArrayList<Integer> removeUnfairNumber(ArrayList<Integer> numbers) {
        for(int i = 1;i<numbers.size();i++){
            if(numbers.get(i) < numbers.get(i-1)){
                numbers.remove(i);
            }
            //else if(numbers.get(numbers.size()-1) < numbers.get(numbers.size()-2)){
            //    numbers.remove(numbers.size()-1);
            //}
        }
        return numbers;
    }
    
    
    static void display(ArrayList words){
        for(int i=0;i<words.size();i++){
            System.out.print(words.get(i) + " ");
        }
        System.out.println("");
    }
    
    public static void main(String[] args){
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<String> words2 = new ArrayList<String>();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        
        words.add("abcd");
        words.add("apple");
        words.add("car");
        words.add("69882");
        words.add("Orchid");
    
        
        words2 =Switch(words);
        System.out.println("\nAfter Swapping : ");
        display(words2);
        
        words2 =Hide(words);
        System.out.println("\nAfter Hiding : ");
        display(words2);
    
        numbers.add(5);
        numbers.add(4);
        numbers.add(7);
        numbers.add(3);
        numbers.add(6);
    
        numbers = removeUnfairNumber(numbers);
        System.out.println("\nAfter removing Unfair Numbers : ");
        display(numbers);
        /*
         * for(int i = 0;i<numbers.size();i++){
         *     System.out.println(numbers.get(i));
         *  }
         */
    }
}

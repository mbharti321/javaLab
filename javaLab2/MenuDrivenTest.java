
/**
 * Menu driven program for :
 * 1. Replace Zero with largest odd num
 * 2. Replace numbers with the num multiple of 5
 * 3. Accept an array and return a Boolean value True if array contains, 
 *      somewhere, three increasing adjacent numbers like 5,6,7. 
 *       Consider the following example 
 *       [1, 4, 5, 6, 2] → true
 * @author (Manish Bharti) 
 * 
 */

import java.util.*;

class MenuDriven{
    Scanner scan = new Scanner(System.in);
    
    public int[] getArray(){
        System.out.print("Enter the size of array : ");
        
        int arraySize = scan.nextInt();
        int[] array = new int[arraySize];
        
        System.out.println("\nEnter all " + arraySize +" elements of array : ");
        for(int i = 0; i < arraySize; i += 1){
            array[i] = scan.nextInt();
        }
        return array;
    }
    
    int getChoice(){
        
        System.out.println("\n\n1. Replace Zero with largest odd num.");
        System.out.println("2. Replace numbers with the num multiple of 5.");
        System.out.println("3. Exit.");
        System.out.println("Please enter one of given choice : ");
        return scan.nextInt();
    }
    
    /*
    Accept an array and return an array where each zero value in the array is replaced 
    by the largest odd number to the right of zero in the array. If there is no odd number  
    to the right of zero leave zero as it is. Consider the example
    [0, 5, 0, 3] → [5, 5, 3, 3] 
    */
    void replaceZeroWithLargestOdd(){
        int[] array = getArray();
        int arraySize = array.length;
        
        System.out.println("\nElements of array before replacing : ");
        for(int i = 0; i < arraySize; i += 1){
            System.out.print(array[i] + " ");
        }
        
        
        for(int i = 0; i < arraySize; i += 1){
            if(array[i] == 0){
                //if the no is last element
                if(i == arraySize - 1){
                    break;
                }
                //int largestOdd = -99999;//assigining some sooo lower odd value
                int largestOdd = -99999;
                //for findingg largest odd right to the current element
                for(int j = i + 1; j < arraySize; j += 1){
                    if(array[j] % 2 != 0){
                        if(array[j] > largestOdd){
                            largestOdd = array[j];
                        }
                    }
                }
                //updating 0 with largest odd
                if(largestOdd != -99999){
                    array[i] = largestOdd;
                }
            }
        }
        
        System.out.println("\nElements of array after replacing : ");
        for(int i = 0; i < arraySize; i += 1){
            System.out.print(array[i] + " ");
        }
        
    }
    
    
    /*
     * Accept an array and for each multiple of 5 in the given array, change all the values
     * following it to that multiple till you encounter another multiple of 5.Consider the 
     * following example [2, 10, 3, 4, 20, 7] → [2, 10, 10, 10, 20, 20]
     */
    void ReplaceNumberWithMultipleOf5(){
        int[] array = getArray();
        int arraySize = array.length;
        
        System.out.println("\nElements of array before replacing : ");
        for(int i = 0; i < arraySize; i += 1){
            System.out.print(array[i] + " ");
        }
        
        //int largestOdd = -99999;//assigining some sooo lower odd value
        for(int i = 0; i < arraySize; i += 1){
            if(array[i] % 5 == 0){
                //if the no is last element
                // if(i == arraySize -1){
                    // break;
                // }
                int currentMultiple = array[i];
                i += 1;//updating i index so that updation happens from next element
                while((i < arraySize) && (array[i] % 5 != 0)){
                    array[i] = currentMultiple;
                    i += 1;
                }
                
                //if i is less than arraySize that means program encounter
                //the array element which is divisible by 5. so we need 
                //to decrement the incremented  i count . if we don't decrement here, 
                //the i will be incremented by 2 as i gets incremented in for loop also
                //and thet will cause the skiping one element checking
                i -= 1;
                // if(i < arraySize){
                    // i -= 1;
                // }
            }
        }
        
        System.out.println("\nElements of array after replacing : ");
        for(int i = 0; i < arraySize; i += 1){
            System.out.print(array[i] + " ");
        }
    }
    
    /*Accept an array and return a Boolean value True if array contains, 
    * somewhere, three increasing adjacent numbers like 5,6,7. 
    * Consider the following example 
    * [1, 4, 5, 6, 2] → true
    */
    void isThreeIncreasingAdjacent(){
        int[] array = getArray();
        int arraySize = array.length;
        
        System.out.println("\nElements of array before replacing : ");
        for(int i = 0; i < arraySize; i += 1){
            System.out.print(array[i] + " ");
        }
        
        boolean result = false;
        
        for(int i = 0; i < arraySize - 2; i += 1){
            if((array[i] + 1 == array[i + 1]) && (array[i + 1] + 1== array[i + 2])){
                result = true;
            }
        }
        System.out.println("Is Three Increasing Adjacent : " + result);
    }
    
}


public class MenuDrivenTest {
    public static void main(String[] args){
        MenuDriven menuObj = new MenuDriven();
        
        while(true){
            int choice = menuObj.getChoice();
            if(choice <= 0){  
                System.out.println("Invalid negative Input!!!! \n Please input valid choice(1-3)......");
                continue;
            }
            
            switch(choice){
                case 1: menuObj.replaceZeroWithLargestOdd();
                        break;
                case 2: menuObj.ReplaceNumberWithMultipleOf5();
                        break; 
                case 3: menuObj.isThreeIncreasingAdjacent();
                        break;
                case 4: System.exit(0);
                        break;
                default: System.out.println("Invalid Input!!!! \n Please input valid choice(1-3)......");
            }
                        
        }
    }

}

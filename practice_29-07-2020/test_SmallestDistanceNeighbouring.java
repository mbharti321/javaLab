/**
 * 1.	
 * Implement a Java function that finds two neighbouring numbers in an array
 * with the smallest distance to each other. The function should return the index
 * of the first number.
 * In the sequence 4 8 6 1 2 9 4 the minimum distance is 1 (between 1 and 2).
 * The function should return the index 3 (of number 1).
 * 
 * @author (Me😊) 
 * @version (a version number or a date)
 */
import java.util.*;

class SmallestDistanceNeighbouring{
    Scanner scan = new Scanner(System.in);
    
    int smallestDistanceIndex(int[] arr){
        int index = 0;
        int minimumDistance = 0;
        for(int i = 0; i < arr.length - 1; i++){
            if(0 == i){
                minimumDistance = Math.abs(arr[i] - arr[i + 1]);
                continue;
            }
            
            if(Math.abs(arr[i] - arr[i + 1]) < minimumDistance){
                minimumDistance = Math.abs(arr[i] - arr[i + 1]);
                index = i;
            }
        }
        return index;
    }
    
    public int[] getArray(){
        System.out.print("Enter the size of array : ");
        
        int arraySize = scan.nextInt();
        int[] array = new int[arraySize];
        
        System.out.println("\nEnter all " + arraySize +" element(s) of array : ");
        for(int i = 0; i < arraySize; i += 1){
            array[i] = scan.nextInt();
        }
        return array;
    }
}

public class test_SmallestDistanceNeighbouring {
    public static void main(String agrs[]){
        SmallestDistanceNeighbouring obj = new SmallestDistanceNeighbouring();
        int[] arr = obj.getArray();
        int index = obj.smallestDistanceIndex(arr);
        System.out.println("\nThe desired index : " + index);        
    }
}

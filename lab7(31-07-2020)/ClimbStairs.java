/******************************************************************************
“ClimbStairs” is a recursive method which gives the possible 
number of ways to climb stairs considering that the user can climb 1 or 2 steps
at a time. The method takes in a single integer value ‘n’ as parameter, which 
is the number of stairs. For example:
If n=4 there are 5 ways of climbing the stairs
  1,1,1,1   2,1,1   1,2,1   1,1,2   2,2
ClimbStairs(4) will return an integer value 5.
*******************************************************************************/

public class ClimbStairs
{ 
    static int  possibleCount = 0;
    static void stepCheck(int n, String stepString){
        if( n == 0){
            System.out.println(stepString);
            possibleCount += 1;
        }
        if(n < 0){
            return;
        }
        stepCheck(n - 1, stepString + " 1");
        stepCheck(n - 2, stepString + " 2");
    }
    
	public static void main(String[] args) {
		int n = 4; //user input
		String stepString = "";
		stepCheck(n, stepString);
   		System.out.println("Total possible way of climbing the given stairs : " + possibleCount);
	}
}

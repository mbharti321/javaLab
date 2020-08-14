import java.util.*;
public class MyCmdPgm{
	public static int Climbstairs(int n){
		
		if(n<=1)
			return n;
			
		return Climbstairs(n - 1) + Climbstairs(n - 2);	
	}
	
	public static int Climb(int s){
		return Climbstairs(s+1);
	}
	
	public static String MagicSigil(String str,int n){
		String res = "";
		for(int i = 1; i < n ; i++){
			int j;
			for(j = i + 1 ; j < n ; j++){
				
				if(str.charAt(i) == str.charAt(j) || str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u' || str.charAt(i) == ' ' ){
				break;
				}
			}
			if(j==n)
				res = res + str.charAt(i);
			
		}
		return res;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		for(String str : args ){
			int argument = Integer.parseInt(str);
			switch(argument){
				case 1: 
					 System.out.println("Enter the String");
					 String s = sc.nextLine();
					 int d = s.length();
					 String a = MagicSigil(s,d);
					 String b = a.toUpperCase();
					 System.out.println("The magic Sigil is " + b);
		             break;
				case 2:
					 System.out.println("Enter the number of stairs");
					 int n = sc.nextInt();
					 System.out.println("The number of ways are " + Climb(n));
					 break;
			}
		}
	}
}

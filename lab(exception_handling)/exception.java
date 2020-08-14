import java.util.*;
import java.lang.*;
class MyException extends Exception{
	MyException(String s){
		super(s);
	}
}
class MyImplementation{
	public int CountTheLetters(String str) throws MyException{
		int l = str.length();
		int i=0;
		for(i=0;i<l;i++){
			boolean c = Character.isLetter(str.charAt(i));
			if(c == false){
				throw new MyException("String Invalid");
			}
		}
		return i;
	}
	public double arithematicOp(String s) throws MyException{
		int l = s.length();
		double a=0.0,b=0.0;
		String ca=" ",cb=" ";
		char op=' ';
		double res;
		for(int j =0;j<l;j++){
			char m = s.charAt(j);
			if(!(Character.isDigit(m) || isOperator(m) || m==' ')){
				throw new MyException("Invalid Arithmetic Expression...");
			}
			if(isOperator(m)){
			 ca = s.substring(0,j);
		     cb = s.substring(j+1,l);
			op = m;
			}
		}
		try{
		a = Double.parseDouble(ca);
		b = Double.parseDouble(cb);
		}
		catch(NumberFormatException ex){
			System.out.println("Caught the exception!!");
			System.out.println("Insufficient operands!!");
		}
		if (op == '+'){
			 res = a + b;
			 return res;
		}
		else if(op == '-'){
			res = a - b;
			return res;
		}
		else if(op == '*'){
			res = a * b;
			return res;
		}
		else if(op == '/'){
			res = a / b;
			return res;
		}
		else{
			res = a % b;
			return res;
		}
	}
	public boolean isOperator(char c){
		if(c=='+' || c=='-' || c=='*' || c=='/' || c=='%')
			return true;
		else
			return false;
	}
}
public class sample1{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		MyImplementation obj = new MyImplementation();
		System.out.println("Enter the string: ");
		String s1 = sc.nextLine();
		try{
			int num = obj.CountTheLetters(s1);
			System.out.println("Number of letters is "+num);
		}
		catch(MyException ex){
			System.out.println("Caught the exception!!");
			System.out.println(ex.getMessage());
		}
		System.out.println("Enter an arithmetic operation: ");
		String exp = sc.nextLine();
		try{
			double r = obj.arithematicOp(exp);
			System.out.println("Result is "+r);
		}
		catch(MyException ex){
			System.out.println("Caught the exception!!");
			System.out.println(ex.getMessage());
		}
		}
	}

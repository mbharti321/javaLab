import java.util.*;

class MyException extends Exception{
	MyException(String s){
		super(s);
	}
}


class ValidateCreditCard{
	long ccnumber;
	boolean validity = false;
	//constructor
	ValidateCreditCard(long ccnumber){
		this.ccnumber = ccnumber;
	}
	
	public void checkccnumber(){
		long tempccNum = this.ccnumber;
		//converting long into string
		String ccNumString = tempccNum + "";
		int len = ccNumString.length();
		//exception handeling
		try{
			if(len < 14 || len > 19){
				// System.out.println("Invalid Card");
				throw new MyException("Invalid Card");
				
			}
		}
		catch(MyException ex){
			System.out.println(ex.getMessage());
			return;
		}
		
		// getting last degit of card number
		long lastdigit = tempccNum % (long)10;
		// System.out.println(lastdigit);
		
		// getting the string other than last digit
		ccNumString = ccNumString.substring(0, len-1);
		
		//getting reverse of the string
		StringBuilder NumString = new StringBuilder();
		NumString.append(ccNumString);
		NumString = NumString.reverse();
		String revccNumString  = NumString.toString();
		// System.out.println(revccNumString);
		
		
		int totalSum = 0;
		
		for(int i = 0; i < revccNumString.length(); i++){
			
			char charDigit = revccNumString.charAt(i);
			int digit = Integer.parseInt(String.valueOf(charDigit));
			//if the digit position is even
			if(i % 2 != 0){
				totalSum += digit;
			}
			//if the digit position is odd
			else{
				digit *= 2;//doubling
				if (digit > 9){//if the resulted doubled is two digit number
					int digitOne = digit % 10;
					digit = 1 + digitOne;//adding first digit and second digit
				}
				
				totalSum += digit;
			}
		}
		
		
		//getting the last digit of total sum
		int sumUnitDigit = totalSum % 10;
		
		
		//if the last digit of card num is 
		//equal to (10 - sums' last digit) 
		//then the card is valid
		if (lastdigit == 10 - sumUnitDigit){
			this.validity = true;
		}
		
		
		System.out.println("The credit card details are :");
		System.out.println("The number is " + this.ccnumber + " and it's validity is " + this.validity);
		
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		long ccnumber = scan.nextLong();
		//creating object
		ValidateCreditCard card = new ValidateCreditCard(ccnumber);
		
		card.checkccnumber();
		
	}
}

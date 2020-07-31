public class MagicSigil
{ 
	static void magicSigil(String inputStrig){
		String tempString = "";

		inputStrig = inputStrig.toUpperCase();//converting into uppercase

		for(int i = 0; i < inputStrig.length(); i++){
		    char currentChar = inputStrig.charAt(i);

		    //if the letter is not vowel or whitespace
		    if("AEIOU ".indexOf(currentChar) == -1){
			int tempIndex = tempString.indexOf(currentChar);
			//if the character is already there in tempString
			if(tempIndex != -1){ 
			    //remove the character
			    tempString = tempString.substring(0,tempIndex) + tempString.substring(tempIndex + 1);
			}
			//concanate the current letter to tempString
			tempString += currentChar;
		    }
		}
		System.out.println(tempString);
	}
    
	public static void main(String[] args) {
		String inputStrig = "i am healthy";//user input
		magicSigil(inputStrig);
	}
}

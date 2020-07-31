public class Main
{ 
    static void magicSigil(String inputStrig){
        String tempString = "";
        
        inputStrig = inputStrig.toUpperCase();
        
        for(int i = 0; i < inputStrig.length(); i++){
            char currentChar = inputStrig.charAt(i);
            
            if("AEIOU ".indexOf(currentChar) == -1){
                int tempIndex = tempString.indexOf(currentChar);
                if(tempIndex != -1){
                    tempString = tempString.subString(0,tempIndex) + tempString.subString(tempIndex + 1);
                }
                tempString += currentChar;
            }
        }
        System.out.println(tempString);
    }
    
	public static void main(String[] args) {
		String inputStrig = "Hello how are you?";
		magicSigil(inputStrig);
	}
}
